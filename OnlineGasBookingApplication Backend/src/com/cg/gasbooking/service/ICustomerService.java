package com.cg.gasbooking.service;

import java.util.List;

import com.cg.gasbooking.entity.Customer;

public interface ICustomerService {
	public Customer insertCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public Customer deleteCustomer(Customer customer);
	public List<Customer>viewCustomers();
	public Customer viewCustomer(int customerId);
	public Customer validateCustomer(String username, String password);
}