package ua.kiev.prog.sample12;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created on 31.03.2019.
 *
 * @author Aleks Sidorenko (alek.sidorenko1979@gmail.com).
 * @version Id$.
 * @since 0.1.
 */
class Timer implements Runnable {

    @Override
    public void run() {
        System.out.println("Tick");
    }
}

public class Sample12 {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        try {
            service.scheduleWithFixedDelay(new Timer(), 5, 3, TimeUnit.SECONDS);
            Thread.sleep(20000);
        } finally {
            service.shutdown();
        }
    }
}
