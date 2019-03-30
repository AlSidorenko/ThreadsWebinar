package ua.kiev.prog.sample4;

/**
 * Created on 29.03.2019.
 *
 * @author Aleks Sidorenko (alek.sidorenko1979@gmail.com).
 * @version id$.
 * @since 0.1.
 */
class TestThread4 extends Thread {

    private volatile boolean stop = false;

    @Override
    public void run() {
        while (!stop) {
            System.out.println("Prog.kiev.ua");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    public void myInterrupt() {
        stop = true;
    }
}

public class Sample4 {
    public static void main(String[] args) throws InterruptedException {
        TestThread4 thread = new TestThread4();
        thread.start();

        Thread.sleep(5000);
        thread.myInterrupt();
    }
}
