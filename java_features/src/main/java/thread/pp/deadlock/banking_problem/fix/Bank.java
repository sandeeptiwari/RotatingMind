package thread.pp.deadlock.banking_problem.fix;

import thread.pp.deadlock.banking_problem.Account;

public class Bank {


    public synchronized void transfer(Account source, Account destination, int amount) {
        Account a1, a2;

        if (source.getId() < destination.getId()) {
            a1 = source;
            a2 = destination;
        } else {
            a1 = destination;
            a2 = source;
        }
        synchronized (a1) {
            synchronized (a2) {
                source.deduct(amount);
                destination.add(amount);
            }
        }

    }
}
