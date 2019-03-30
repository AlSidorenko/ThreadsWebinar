package ua.kiev.prog.sample9;

import java.math.BigInteger;
import java.util.concurrent.ExecutionException;
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
public class Sample9 {

    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        try {
            Future<BigInteger> future = service.submit(new Calculator(500));
            BigInteger result = null;

            try {
                result = future.get();

                System.out.println("Result = " + result);
            } catch (InterruptedException | ExecutionException e) {
                System.out.println(e);
            }
        } finally {
            service.shutdown();
        }
    }
}
