package ua.kiev.prog.sample8;

/**
 * Created on 30.03.2019.
 *
 * @author Aleks Sidorenko (alek.sidorenko1979@gmail.com).
 * @version Id$.
 * @since 0.1.
 */
public class BadCounter implements Counter {

    private volatile int x;

    @Override
    public void increment() {
        x++;
    }

    @Override
    public String toString() {
        return "BadCounter{" +
                "x=" + x +
                '}';
    }
}
