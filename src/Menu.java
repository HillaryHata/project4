import java.util.Scanner;

public class Menu {
    Bank bank = new Bank();
    Scanner scanner = new Scanner(System.in);

    public void runMenu(){
        while (true) {
            String userInput;

            System.out.printf("\n%s MENU %s\n","*".repeat(9),"*".repeat(9));
            System.out.println("Please make a selection: \n1) Access Account \n2) Open a New Account\n3) Close All Accounts \n4) Exit \n>> ");
            userInput = scanner.next();

            if(userInput.equals("1")){
                accessAccount();
            }else if(userInput.equals("2")){
                openNewAccount();
            }else if(userInput.equals("3")){
                closeAllAccounts();
            }else if(userInput.equals("4")) {
                System.out.println("Thank you for using BSU Banking App!\nExiting...");
                break;
            }else{
                System.out.println("Invalid Entry");
            }
        }

    }
    private void accessAccount(){
        Customer customer;
        Account account;
        String userInput;

        System.out.println("Please enter your PIN: ");
        String pin = scanner.next();
        customer = bank.getCustomer(pin);

        if(customer == null){
            System.out.println("PIN is not valid");
            return;
        }else{
            System.out.println("*** Active Accounts ***");
            System.out.println(customer.getAllAccounts());
            System.out.println("\n\nPlease enter the account number of\nthe account you would like to access: ");
            String numOfAccount = scanner.next();
            account = customer.getAccount(numOfAccount);

            if(account == null){
                System.out.println("Account number invalid");
                return;
            }else{
                while (true) {
                    System.out.println("\nPlease make a selection: \n1) Make a deposit \n2) Make a withdrawal \n3) Close account \n4) Exit \n>>");
                    userInput = scanner.next();

                    if(userInput.equals("1")){
                        System.out.println("Enter the amount of deposit: ");
                        int depositAmount = Integer.parseInt(scanner.next());
                        account.deposit(depositAmount);
                        //return;
                    }else if(userInput.equals("2")){
                        System.out.println("Enter the amount of withdrawal: ");
                        int withdrawalAmount = Integer.parseInt(scanner.next());
                        account.withdraw(withdrawalAmount);
                    }else if(userInput.equals("3")) {
                        System.out.println("Account is closed.");
                        return;
                    }else if(userInput.equals("4")) {
                        return;
                    }else{
                        System.out.println("Invalid Entry");
                        break;
                    }
                }
            }
        }
    }
    private void openNewAccount(){
        String userInput;
        Customer customer;

        System.out.println("Are you a new customer?\n1) Yes \n2) No");
        userInput = scanner.next();

        if(userInput.equals("1")) {
            customer = createNewCustomer();

            System.out.println("Please enter your deposit amount: ");
            int depositAmount = Integer.parseInt(scanner.next());
            Account account = new Account(depositAmount);
            customer.addAccount(account);
            System.out.println("New Account Opened: " + account.getAccountNumber());
        }
        if(userInput.equals("2")){
            System.out.println("Please enter PIN: ");
            String pin = scanner.next();
            customer = bank.getCustomer(pin);

            if(customer == null){
                runMenu();
            }
            System.out.println("Please enter your deposit amount: ");
            int depositAmount = Integer.parseInt(scanner.next());
            Account account = new Account(depositAmount);
            customer.addAccount(account);
            System.out.println("New Account Opened: " + account.getAccountNumber());
        }
//

    }
    private Customer createNewCustomer(){
        Customer customer;

        System.out.println("Enter your first name: ");
        String firstName = scanner.next();
        System.out.println("Enter your last name: ");
        String lastName = scanner.next();
        System.out.println("Enter a 4 digit PIN: ");
        String pin = scanner.next();

        customer = new Customer(firstName, lastName, pin);
        bank.addCustomer(customer);
        return customer;
    }
    private void closeAllAccounts(){
        Customer customer;

        System.out.println("Enter your PIN: ");
        String pin = scanner.next();
        customer = bank.getCustomer(pin);

        if(customer == null){
            runMenu();
        }else{
            bank.removeCustomer(customer);
            System.out.println("You have been removed from the bank registry.");
        }
    }
}
