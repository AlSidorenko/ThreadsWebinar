package ua.kiev.prog.sample5;

/**
 * Created on 30.03.2019.
 *
 * @author Aleks Sidorenko (alek.sidorenko1979@gmail.com).
 * @version id$.
 * @since 0.1.
 */
public class Transaction extends Thread {

    private Account account;
    private int withdraw;

    public Transaction(Account account, int withdraw) {
        this.account = account;
        this.withdraw = withdraw;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(System.currentTimeMillis() % 300);
        } catch (InterruptedException e) {
            return;
        }

        synchronized (account) {
            int total = account.getMoney();
            if (total >= withdraw) {
                account.setMoney(total - withdraw);
            }
        }
    }
}
