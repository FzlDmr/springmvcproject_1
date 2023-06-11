package com.dev3.controller;

import com.dev3.dao.CustomerDao;
import com.dev3.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    // need to inject the customer dao
    @Autowired
    private CustomerDao customerDao;


   // @RequestMapping("/list")
   // public String listCustomers(Model theModel){
//
   //     //get customers form the dao
//
//
   //     return "list-customer";
   // }

    @RequestMapping("list")
    public String listCustomers(Model theModel){
        //get customers form the dao
        List<Customer> theCustomers = customerDao.getCustomers();

        //add the customers to the model
        theModel.addAttribute("customers",theCustomers);

        return "list-customers";
    }





}
