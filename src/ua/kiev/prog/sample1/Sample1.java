package ua.kiev.prog.sample1;

/**
 * Created on 29.03.2019.
 *
 * @author Aleks Sidorenko (alek.sidorenko1979@gmail.com).
 * @version 1$.
 * @since 0.1.
 */
class Test1 extends Thread {
    @Override
    public void run() {
        System.out.println("Hi I'm " + this.getClass().getName());
    }
}

class Test2 implements Runnable {
    @Override
    public void run() {
        System.out.println("Hi I'm " + this.getClass().getName());
    }
}

public class Sample1 {
    public static void main(String[] args) {
        // #1
        Test1 thread1 = new Test1();
        thread1.setDaemon(true);
        thread1.setPriority(Thread.MAX_PRIORITY); //1 - 10
        thread1.start();

        // #2
        Thread thread2 = new Thread(new Test2());
        thread2.start();

        // #3
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hi I'm " + this.getClass().getName());
            }
        });
        thread3.start();

        System.out.println("Finish.");
    }
}
