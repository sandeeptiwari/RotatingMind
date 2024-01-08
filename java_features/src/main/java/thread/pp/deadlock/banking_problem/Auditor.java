package thread.pp.deadlock.banking_problem;

import java.util.List;

public class Auditor implements Runnable {
    private final List<Account> accounts;
    private final Bank bank;

    public Auditor(List<Account> accounts, Bank bank) {
        this.accounts = accounts;
        this.bank = bank;
    }


    @Override
    public void run() {
        while(true) {
            synchronized (bank) {
                int sum = 0;
                for (Account account: accounts) {
                    System.out.println(account.getId() + " : " + account.getAmount());
                    sum += account.getAmount();
                }
                System.out.println("Total in Audit : " + sum);

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
