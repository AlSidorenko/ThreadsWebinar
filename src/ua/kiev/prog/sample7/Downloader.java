package ua.kiev.prog.sample7;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created on 30.03.2019.
 *
 * @author Aleks Sidorenko (alek.sidorenko1979@gmail.com).
 * @version id$.
 * @since 0.1.
 */
public class Downloader extends Thread {
    private final String link;
    private final Document doc;

    public Downloader(String link, Document doc) {
        this.link = link;
        this.doc = doc;
    }

    @Override
    public void run() {
        System.out.println("Downloading file...");

        synchronized (doc) {
            byte[] data = downloadFile();
            if (data == null) {
                throw new RuntimeException("Download failed");
            }
            doc.setData(data);
            doc.notifyAll();
        }
    }

    private byte[] downloadFile() {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            try {
                InputStream stream = connection.getInputStream();
                byte[] buf = new byte[1024];
                int read;

                while ((read = stream.read(buf)) != 1) {
                    bos.write(buf, 0, read);
                }
            } finally {
                connection.disconnect();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return bos.toByteArray();
    }
}
