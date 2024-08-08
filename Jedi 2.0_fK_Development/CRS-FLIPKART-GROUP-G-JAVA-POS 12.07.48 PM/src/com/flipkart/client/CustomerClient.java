package com.flipkart.client;

import com.flipkart.business.CustomerBusiness;
//client layer which call all business methods in customer application
public class CustomerClient {
    public static void main(String[] args) {
        CustomerBusiness business=new CustomerBusiness();
        business.createCustomer();
        System.out.println("delete customer by id--"+business.deleteCustomer(101));
        System.out.println("update customer by id--"+business.updateCustomer(101));
        business.listCustomer();
    }
}
