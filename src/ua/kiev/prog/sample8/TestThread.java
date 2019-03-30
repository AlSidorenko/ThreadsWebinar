package ua.kiev.prog.sample8;

/**
 * Created on 30.03.2019.
 *
 * @author Aleks Sidorenko (alek.sidorenko1979@gmail.com).
 * @version Id$.
 * @since 0.1.
 */
public class TestThread extends Thread {

    private final Counter counter;

    public TestThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(System.currentTimeMillis() % 100);
        } catch (InterruptedException e) {
            return;
        }
        counter.increment();
    }
}
