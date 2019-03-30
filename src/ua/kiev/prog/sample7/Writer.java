package ua.kiev.prog.sample7;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created on 30.03.2019.
 *
 * @author Aleks Sidorenko (alek.sidorenko1979@gmail.com).
 * @version Id$.
 * @since 0.1.
 */
public class Writer extends Thread {

    private final Document doc;
    private final String path;

    public Writer(Document doc, String path) {
        this.doc = doc;
        this.path = path;
    }

    @Override
    public void run() {

        synchronized (doc) {
            while (!doc.isReady()) {
                try {
                    doc.wait();
                } catch (InterruptedException e) {
                    return;
                }
            }
        }

        System.out.println("Writing document to " + path);

        try (FileOutputStream fos = new FileOutputStream(path)) {
            fos.write(doc.getData());
            System.out.println("Done: " + path);
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
