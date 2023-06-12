package com.dev3.service;

import com.dev3.dao.CustomerDao;
import com.dev3.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    //need to inject customer dao
    @Autowired
    private CustomerDao customerDao;

    @Override
    @Transactional
    public List<Customer> getCustomers() {

        return customerDao.getCustomers();

    }

    @Override
    @Transactional
    public void saveCustomer(Customer theCustomer) {

        customerDao.saveCustomerDao(theCustomer);

    }

    @Override
    @Transactional
    public Customer getCustomer(int theId) {
        return customerDao.getCustomer(theId);
    }

    @Override
    @Transactional
    public void deleteCustomer(int theId) {
        customerDao.deleteCustomer(theId);
    }

    @Override
    public List<Customer> searchCustomers(String theSearchName) {
        return customerDao.searchCustomers(theSearchName);
    }
}
