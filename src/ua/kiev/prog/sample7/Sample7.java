package ua.kiev.prog.sample7;

/**
 * Created on 30.03.2019.
 *
 * @author Aleks Sidorenko (alek.sidorenko1979@gmail.com).
 * @version $Id$.
 * @since 0.1.
 */
public class Sample7 {
    static final String URL = "https://www.dropbox.com/s/38m1oakpbb3wkzu/Java%20Start.pdf&dl=0";

    public static void main(String[] args) {
        Document doc = new Document();
        Writer[] writers = {
                new Writer(doc, "file1.pdf"),
                new Writer(doc, "file2.pdf"),
                new Writer(doc, "file3.pdf")
        };

        for (Writer writer : writers) {
            writer.start();
        }

        Downloader downloader = new Downloader(URL, doc);
        downloader.start();
    }
}
