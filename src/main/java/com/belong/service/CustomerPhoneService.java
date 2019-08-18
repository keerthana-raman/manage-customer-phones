package com.belong.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.belong.entity.Customer;
import com.belong.entity.RegisteredCustomers;

@Service
public class CustomerPhoneService {
	
	public List<String> getAllPhones() {
		List<String> phoneNumberList = new ArrayList<String>();
		 RegisteredCustomers.getRegisterdCustomers().stream()
				.forEach(customer -> {
					customer.getPhones().stream()
						.forEach(phone -> 
						phoneNumberList.add(phone.getPhoneNumber()));
				});
		 
		 return phoneNumberList;
	}
	
	public List<String> getPhoneForACustomer(String customerId) {
		List<String> phoneList = new ArrayList<>();
		Optional<Customer> matchingCustomer = RegisteredCustomers.getCustomerFromRegisteredList(customerId);
		if(matchingCustomer.isPresent()) {
			 matchingCustomer.get().getPhones()
					.forEach(phone -> phoneList.add(phone.getPhoneNumber()));
		}
		return phoneList;
	}
	
	public void activatPhone(String customerName, String customerId,
			String phoneNumber, String phoneType) {
		 RegisteredCustomers.activatePhoneNumber(customerId, customerName, phoneType, phoneNumber);
	}

}
