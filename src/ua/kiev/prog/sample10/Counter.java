package ua.kiev.prog.sample10;

import java.util.concurrent.Callable;

/**
 * Created on 30.03.2019.
 *
 * @author Aleks Sidorenko (alek.sidorenko1979@gmail.com).
 * @version Id$.
 * @since 0.1.
 */
public class Counter implements Callable<Long> {

    private final int[] array;
    private final int from;
    private final int to;

    public Counter(int[] array, int from, int to) {
        this.array = array;
        this.from = from;
        this.to = to;
    }

    @Override
    public Long call() throws Exception {
        long res = 0;
        for (int i = from; i < to; i++) {
            res += array[i];
        }
        return res;
    }
}
