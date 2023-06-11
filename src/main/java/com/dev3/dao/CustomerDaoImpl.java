package com.dev3.dao;

import com.dev3.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao{

    //need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Customer> getCustomers() {

        Session session =sessionFactory.openSession();
        Transaction tx =session.beginTransaction();

        String hqlQuery="from Customer";
        List<Customer> customers =  session.createQuery(hqlQuery,Customer.class).getResultList();

        for (Customer w : customers){
            System.out.println(w);
        }

        tx.commit();
        session.close();

        // return the result
        return customers;
    }
}
