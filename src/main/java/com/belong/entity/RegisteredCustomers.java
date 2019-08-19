package com.belong.entity;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class RegisteredCustomers {

	// Singleton Instance
	private static Map<String, Customer> registeredCustomers;

	static {
		registeredCustomers = new ConcurrentHashMap<>();
	}

	private RegisteredCustomers() {
	}

	public static Map<String, Customer> getRegisterdCustomers() {
		return registeredCustomers;
	}

	public static Optional<Customer> getCustomerFromRegisteredList(String customerId) {
		return Optional.ofNullable(getRegisterdCustomers().get(customerId));
	}

	public static void activatePhoneNumber(String customerId, String customerName, String phoneType,
			String phoneNumber) {
		Customer customer = getOrRegisterCustomer(customerId, customerName);
		Phone phone = new Phone(phoneNumber, phoneType);
		customer.setPhone(phone);
	}

	private static Customer getOrRegisterCustomer(String customerId, String fullName) {
		Optional<Customer> customer = getCustomerFromRegisteredList(customerId);
		if (customer.isPresent()) {
			return customer.get();
		} else {
			Customer registeredCustomer = new Customer(customerId, fullName);
			addCustomer(registeredCustomer);
			return registeredCustomer;
		}

	}

	private static void addCustomer(Customer customer) {
		registeredCustomers.put(customer.getCustomerId(), customer);
	}

}
