package ua.kiev.prog.sample6;

/**
 * Created on 30.03.2019.
 *
 * @author Aleks Sidorenko (alek.sidorenko1979@gmail.com).
 * @version id$.
 * @since 0.1.
 */
public class Sample6 {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account(1000);

        Transaction[] transactions = {
                new Transaction(account, 100),
                new Transaction(account, 500),
                new Transaction(account, 200),
                new Transaction(account, 50),
                new Transaction(account, 150)
        };

        for (Transaction tr : transactions) {
            tr.start();
        }

        for (Transaction tr : transactions) {
            tr.join();
        }

        System.out.println("Total left: " + account.getMoney());
    }
}
