package thread.pp.deadlock.banking_problem;

public class BankWorker implements Runnable {
    private final Account src, dest;
    private final int amount;
    private final Bank bank;

    public BankWorker(Account src, Account dest, int amount, Bank bank) {
        this.src = src;
        this.dest = dest;
        this.amount = amount;
        this.bank = bank;
    }

    @Override
    public void run() {
        bank.transfer(src, dest, amount);
        System.out.println("Account # " + src.getId() + " transferred amount " + amount + " to " + dest.getId());
    }
}
