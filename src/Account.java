import javax.management.StringValueExp;

public class Account {
    private int balance;
    private String accountNumber;
    private static int numberOfAccounts = 1000;


    public Account(int initialDeposit) {
        this.balance = initialDeposit;
        this.accountNumber = String.format("%d",numberOfAccounts++);

    }

    public void deposit(int depositAmount){
        int newBalance = balance + depositAmount;
        balance = newBalance;
        System.out.println("You have deposited $"+ depositAmount);
        System.out.println("You now have a balance of $"+ newBalance);

    }
    public void withdraw(int withdrawAmount){
        if (withdrawAmount > balance){
            System.out.println("You have insufficient funds.");
        }else{
            balance -= withdrawAmount;
            System.out.println("You have withdrawn $" + withdrawAmount);
            System.out.println("You now have a balance of $" + balance);
        }
    }

    public String getAccountNumber(){return accountNumber;}
    public void setAccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString(){
        return String.format("Account Number: %s\nBalance: %d", accountNumber,balance);
    }


}


