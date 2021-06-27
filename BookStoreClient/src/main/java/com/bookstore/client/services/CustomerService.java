package com.bookstore.client.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.client.repository.CustomerRepository;
import com.bookstore.model.entities.Customer;
import com.bookstore.model.enumerate.AuthProvider;
import com.bookstore.model.formdata.CustomerData;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repository;
	
	public List<Customer> getAllCustomers() {
		return repository.findAll();
	}
	
	public Customer getByEmail(String email) {
		return repository.getByEmail(email);
	}
	
	public void registerNewCustomer(String email, String name, AuthProvider provider) {
		Date createDate = new Date();
		
		Customer newCustomer = new Customer();
		
		newCustomer.setEmail(email);
		newCustomer.setFirstName(name);
		newCustomer.setEmailVerified(false);
		newCustomer.setCreateDate(createDate);
	//	newCustomer.setLastLogin(createDate);
		newCustomer.setAuthProvider(provider);
		newCustomer.setEnabled(true);
		
		repository.save(newCustomer);
	}
	
	public void registerNewCustomer(CustomerData customerData) {
		
		Customer regCustomer = new Customer();
		
		regCustomer.setEmail(customerData.getEmail());
		//regCustomer.setPassword(PasswordManager.getBCrypPassword(customerData.getPassword()));
		regCustomer.setFirstName(customerData.getFirstName());
		regCustomer.setLastName(customerData.getLastName());
		regCustomer.setCreateDate(new Date());
		regCustomer.setAuthProvider(AuthProvider.BASIC);
		
		repository.save(regCustomer);
	}
	
	public void updateCustomer(Customer customer, String name, AuthProvider provider) {
		Date loginDate = new Date();
		
		customer.setFirstName(name);
		//customer.setLastLogin(loginDate);
		
		repository.save(customer);
	}
	
	public void saveCustomer(Customer customer) {
		repository.save(customer);
	}
}
