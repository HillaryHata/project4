import java.util.ArrayList;

public class Customer{
    String firstName;
    String lastName;
    String pin;
    private ArrayList<Account> custumersAccounts = new ArrayList<>();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public Customer(String firstName, String lastName, String pin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pin = pin;
    }

    public void addAccount(Account account){
        custumersAccounts.add(account);
    }
    public void removeAccount(Account account){
        custumersAccounts.remove(account);
    }
    public Account getAccount(String accountNumber){
        Account foundAccount = null;
        for(Account account: custumersAccounts){
            if(account.getAccountNumber().equals(accountNumber)){
                foundAccount = account;
                break;
            }
        }
        return foundAccount;
    }
    public StringBuilder getAllAccounts(){
        StringBuilder accountStringBuilder = new StringBuilder();
        for(Account account : custumersAccounts){
            accountStringBuilder.append(account.toString());
        }
        return accountStringBuilder;
    }
    @Override
    public String toString(){
        return String.format("Customer's name: %s %s\nCustomer's PIN: %s", firstName, lastName, pin);
    }
}

