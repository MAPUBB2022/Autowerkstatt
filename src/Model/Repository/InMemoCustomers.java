package Model.Repository;

import Model.Customer;

import java.util.ArrayList;
import java.util.List;

public class InMemoCustomers {
    private List<Customer> customers;

    public InMemoCustomers(){this.customers=new ArrayList<>();}

    public List<Customer> getCustomers(){return this.customers;}

    public void addCustomer(Customer customer){this.customers.add(customer);}

    public void removeCustomer(Customer customer){this.customers.remove(customer);}
}
