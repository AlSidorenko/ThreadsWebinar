package ua.kiev.prog.sample6;

/**
 * Created on 30.03.2019.
 *
 * @author Aleks Sidorenko (alek.sidorenko1979@gmail.com).
 * @version id$.
 * @since 0.1.
 */
public class Account {
    private int money;

    public Account(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public synchronized void withdraw(int amount) {
        if (money >= amount) {
            money -= amount;
        }
    }

    /*
    synchronized void withdraw(this) {
        if (money >= amount) {
            money -= amount;
        }
    }
     */
}
