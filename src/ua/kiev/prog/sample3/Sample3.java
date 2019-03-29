package ua.kiev.prog.sample3;

/**
 * Created on 29.03.2019.
 *
 * @author Aleks Sidorenko (alek.sidorenko1979@gmail.com).
 * @version $.
 * @since 0.1.
 */
class TestThread3 implements Runnable {
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("Prog.kiev.ua");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}

public class Sample3 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new TestThread3());
        thread.start();

        Thread.sleep(5000);
        thread.interrupt();
    }
}
