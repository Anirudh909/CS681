package edu.umb.cs681.hw13;

import java.util.concurrent.atomic.AtomicBoolean;

public class DepositRunnable implements Runnable {
    public AtomicBoolean done = new AtomicBoolean(false);
    private final BankAccount account;

    public DepositRunnable(BankAccount account) {
        this.account = account;
    }

    public void setDone() {
        done.set(true);
    }

    public void run() {
        while (true) {
            if (done.get()) {
                System.out.println(Thread.currentThread().getName());
                break;
            }
            System.out.println(Thread.currentThread().getName() );
            account.deposit(300);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException exception) {

            }
        }
    }
}
