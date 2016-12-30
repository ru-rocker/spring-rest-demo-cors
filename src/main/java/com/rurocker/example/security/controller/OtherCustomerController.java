package com.rurocker.example.security.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rurocker.example.security.vo.Customer;

/**
 * Controller class for customer api.
 * This controller allow all CORS origin.
 * 
 * @author ru-rocker
 *
 */
@RestController
@RequestMapping("/api-cors")
public class OtherCustomerController {

	private List<Customer> customers = new ArrayList<>();

	@RequestMapping(path = "/customer", method = RequestMethod.GET)
	public List<Customer> getCustomers() {
		return customers;
	}

	@RequestMapping(path = "/customer/{id}", method = RequestMethod.GET)
	public Customer getCustomers(@PathVariable("id") String id) {
		for (Customer customer : customers) {
			if(customer.getCustomerId().equals(id)){
				return customer;
			}
		}
		return null;
	}
	
	@CrossOrigin
	@RequestMapping(path = "/customer", method = RequestMethod.POST)
	public @ResponseBody Customer createCustomer(@RequestBody Customer customer) {
		customers.add(customer);
		return customer;
	}
}
