import java.util.ArrayList;

public class Bank {
    private ArrayList<Customer> allCustomers = new ArrayList<>();

    public void addCustomer(Customer customer){
        allCustomers.add(customer);
    }
    public void removeCustomer(Customer customer){
        allCustomers.remove(customer);
    }
    public Customer getCustomer(String pin){
        Customer foundCustomer = null;
        for(Customer customer : allCustomers){
            if(customer.getPin().equals(pin)){
                foundCustomer = customer;
                break;
            }
        }
        return foundCustomer;
    }
    public StringBuilder getAllCustomers(){
        StringBuilder customerStringBuilder = new StringBuilder();
        for(Customer customer : allCustomers){
            customerStringBuilder.append(customer.toString());
        }
        return customerStringBuilder;
    }
}
