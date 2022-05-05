package lesson24.synchronization;

public class SomeAccount {
    private int balance;

    public int getBalance() {
        return balance;
    }

    /* lesson24.synchronization метод блокирует монитор объекта, у которого вызывается метод*/

    public /*synchronized*/ void upBalance (int count) {
        balance += count;
    }
}
