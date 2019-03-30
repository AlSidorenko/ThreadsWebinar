package ua.kiev.prog.sample11;

import ua.kiev.prog.sample10.Counter;

import java.util.Arrays;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created on 30.03.2019.
 *
 * @author Aleks Sidorenko (alek.sidorenko1979@gmail.com).
 * @version Id$.
 * @since 0.1.
 */
public class Sample11 {

    static final int THREAD_COUNT = 4;
    static final int PART_LENGTH = 10000000;

    public static void main(String[] args) {
        int[] array = new int[THREAD_COUNT * PART_LENGTH];
        Arrays.fill(array, 1);

        ExecutorService service = Executors.newFixedThreadPool(THREAD_COUNT);
        CompletionService<Long> completionService = new ExecutorCompletionService<>(service);

        int offset = 0;
        long result = 0;

        try {
            for (int i = 0; i < THREAD_COUNT; i++) {
                Counter counter = new Counter(array, offset, offset + PART_LENGTH);
                offset += PART_LENGTH;

                completionService.submit(counter);
            }

            for (int i = 0; i < THREAD_COUNT; i++) {
                try {
                    Future<Long> future = completionService.take();
                    result += future.get();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                    return;
                }
            }
            System.out.println("Result = " + result);
        } finally {
            service.shutdownNow();
        }
    }
}
