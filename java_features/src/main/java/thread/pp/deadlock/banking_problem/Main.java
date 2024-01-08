package thread.pp.deadlock.banking_problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank();
        List<Account> accounts = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            accounts.add(new Account(i, random.nextInt(100, 150)));
        }

        int total = 0;

        for (Account account: accounts) {
            System.out.println(account.getId() + " : " + account.getAmount());
            total += account.getAmount();
        }

        System.out.println("Total Before Banking " + total);

        Thread w = new Thread(new BankWorker(accounts.get(0), accounts.get(1), 10, bank));
        w.start();
        Thread a = new Thread(new Auditor(accounts, bank));
        a.start();
    }
}
