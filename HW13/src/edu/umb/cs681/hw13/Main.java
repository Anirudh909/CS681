package edu.umb.cs681.hw13;

public class Main {
    public static void main(String[] args) throws Exception {

        ThreadSafeBankAccount2 threadSafeBankAccount2 = new ThreadSafeBankAccount2();
        WithdrawRunnable withdrawRunnable = new WithdrawRunnable(threadSafeBankAccount2);
        DepositRunnable depositRunnable = new DepositRunnable(threadSafeBankAccount2);

        Thread deposit1 = new Thread(withdrawRunnable);
        Thread withdraw1 = new Thread(depositRunnable);

        Thread deposit2 = new Thread(withdrawRunnable);
        Thread withdraw2 = new Thread(depositRunnable);

        Thread deposit3 = new Thread(withdrawRunnable);
        Thread withdraw3 = new Thread(depositRunnable);

        Thread deposit4 = new Thread(withdrawRunnable);
        Thread withdraw4 = new Thread(depositRunnable);

        Thread deposit5 = new Thread(withdrawRunnable);
        Thread withdraw5 = new Thread(depositRunnable);


        deposit1.start();
        withdraw1.start();

        deposit2.start();
        withdraw2.start();

        deposit3.start();
        withdraw3.start();

        deposit4.start();
        withdraw4.start();

        deposit5.start();
        withdraw5.start();

        withdrawRunnable.setDone();
        depositRunnable.setDone();

        deposit1.interrupt();
        withdraw1.interrupt();

        deposit2.interrupt();
        withdraw2.interrupt();

        deposit3.interrupt();
        withdraw3.interrupt();

        deposit4.interrupt();
        withdraw4.interrupt();

        deposit5.interrupt();
        withdraw5.interrupt();


        try {
            deposit1.join();
            deposit2.join();
            deposit3.join();
            deposit4.join();
            deposit5.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
