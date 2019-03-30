package ua.kiev.prog.sample6;

/**
 * Created on 30.03.2019.
 *
 * @author Aleks Sidorenko (alek.sidorenko1979@gmail.com).
 * @version id$.
 * @since 0.1.
 */
public class Transaction extends Thread {

    private Account account;
    private int amount;

    public Transaction(Account account, int amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(System.currentTimeMillis() % 500);
        } catch (InterruptedException e) {
            return;
        }

        account.withdraw(amount);
    }
}
