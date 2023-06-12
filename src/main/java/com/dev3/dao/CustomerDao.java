package com.dev3.dao;

import com.dev3.entity.Customer;

import java.util.List;

public interface CustomerDao {

    public List<Customer> getCustomers();

    void saveCustomerDao(Customer theCustomer);

    Customer getCustomer(int theId);

    void deleteCustomer(int theId);
}
