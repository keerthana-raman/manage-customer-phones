package com.belong.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class RegisteredCustomers {
	
	
	//Singleton Instance
	private static List<Customer> registeredCustomers;
	
	static {
		registeredCustomers = new ArrayList<>();
	}
	
	private RegisteredCustomers() {
	}
	
	public static List<Customer> getRegisterdCustomers() {
		return registeredCustomers;
	}
	
	public static Optional<Customer> getCustomerFromRegisteredList(String customerId) {
		return getRegisterdCustomers().stream()
				.filter(customer -> customer.getCustomerId().equals(customerId))
				.findFirst();
	}
	
	public static void activatePhoneNumber(String customerId, String customerName, String phoneType, String phoneNumber) {
		Customer customer = getOrRegisterCustomer(customerId, customerName);
		Phone phone = new Phone(phoneNumber, phoneType);
		customer.setPhone(phone);	
	}
	
	
	
	private static Customer getOrRegisterCustomer(String customerId, String fullName) {
		Optional<Customer> customer = getCustomerFromRegisteredList(customerId);
		if(customer.isPresent()) {
			return customer.get();
		}
		else {
			Customer registeredCustomer = new Customer(customerId, fullName);
			addCustomer(registeredCustomer);
			return registeredCustomer;
		}
		
	}
	
	private static void addCustomer(Customer customer) {
		registeredCustomers.add(customer);
	}
	

}
