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
}
