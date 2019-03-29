package ua.kiev.prog.sample2;

/**
 * Created on 29.03.2019.
 *
 * @author Aleks Sidorenko (alek.sidorenko1979@gmail.com).
 * @version $.
 * @since 0.1.
 */
class TestThread2 extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted.");
        }
        System.out.println("Hi I'm " + this.getClass().getName());
    }
}

public class Sample2 {
    public static void main(String[] args) throws InterruptedException {

        TestThread2 thread = new TestThread2();
        thread.start();

        thread.join();
        System.out.println("Finish.");
    }
}
