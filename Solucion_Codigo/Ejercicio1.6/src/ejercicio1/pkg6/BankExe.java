package ejercicio1.pkg6;

import java.util.ArrayList;
import java.util.List;

public class BankExe {

    private List<Account> accounts;

    public BankExe() {
        accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void depositMoney(String numAccount, double amount) {
        for (Account account : accounts) {
            if (account.getNumAccount().equals(numAccount)) {
                account.deposit(amount);
                return;
            }
        }
    }

    public void withdrawMoney(String numAccount, double amount) {
        for (Account account : accounts) {
            if (account.getNumAccount().equals(numAccount)) {
                account.withdraw(amount);
                return;
            }
        }
    }

    public void getBalance(String numAccount) {
        for (Account account : accounts) {
            if (account.getNumAccount().equals(numAccount)) {
                System.out.println("Balance: " + account.getBalance());
                return;
            }
        }
    }

    public void calculateInterest(String numAccount) {
        for (Account account : accounts) {
            if (account.getNumAccount().equals(numAccount) && account instanceof Saving) {
                ((Saving) account).calculateInterest();
                return;
            }
        }
    }

    public static void main(String[] args) {
        BankExe bankSystem = new BankExe();

        Account account1 = new Check("2903670573", "Emilio Peña", 1000);
        Account account2 = new Saving("2902891355", "Suanny Mayon", 500, 7);
        Account account3 = new Platinum("2920764512", "Ricardo Espinoza", 2000);

        bankSystem.addAccount(account1);
        bankSystem.addAccount(account2);
        bankSystem.addAccount(account3);

        bankSystem.depositMoney("2903670573", 25);
        bankSystem.withdrawMoney("2902891355", 66);
        bankSystem.calculateInterest("2902891355");
        bankSystem.getBalance("2920764512");

        System.out.println("Balance de Emilio Peña: " + account1.getBalance());
        System.out.println("Balance de Suanny Mayon: " + account2.getBalance());
        System.out.println("Balance de Ricardo Espinosa: " + account3.getBalance());
    }
}

class Account {

    private String numAccount;
    private String clientName;
    private double balance;

    public Account(String numAccount, String clientName, double balance) {
        this.numAccount = numAccount;
        this.clientName = clientName;
        this.balance = balance;
    }

    public String getNumAccount() {
        return numAccount;
    }

    public void setNumAccount(String numAccount) {
        this.numAccount = numAccount;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        setBalance(getBalance() + amount);
    }

    public void withdraw(double amount) {
        setBalance(getBalance() - amount);
    }
}

class Platinum extends Saving {

    public Platinum(String numAccount, String clientName, double balance) {
        super(numAccount, clientName, balance, 10);
    }
}

class Saving extends Account {

    private double interestRate;

    public Saving(String numAccount, String clientName, double balance, double interestRate) {
        super(numAccount, clientName, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount) {
        if (getBalance() - amount >= 0) {
            setBalance(getBalance() - amount);
        } else {
            System.out.println("No tiene suficiente saldo para retirar");
        }
    }

    public void calculateInterest() {
        setBalance(getBalance() + (getBalance() * interestRate / 100));
    }
}

class Check extends Account {

    public Check(String numAccount, String clientName, double balance) {
        super(numAccount, clientName, balance);
    }
}