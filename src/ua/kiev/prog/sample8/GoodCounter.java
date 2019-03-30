package ua.kiev.prog.sample8;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created on 30.03.2019.
 *
 * @author Aleks Sidorenko (alek.sidorenko1979@gmail.com).
 * @version Id$.
 * @since 0.1.
 */
public class GoodCounter implements Counter {
    private AtomicInteger x = new AtomicInteger();

    @Override
    public void increment() {
        x.getAndIncrement();
    }

    @Override
    public String toString() {
        return "GoodCounter{" +
                "x=" + x +
                '}';
    }
}
