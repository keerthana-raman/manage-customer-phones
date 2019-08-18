package com.belong.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.belong.entity.Customer;
import com.belong.entity.Phone;
import com.belong.service.CustomerPhoneService;

@RestController
@RequestMapping("/customer-phone")
public class CustomerPhoneApiImpl implements PhoneApi {
	
	@Autowired
	CustomerPhoneService phoneService;
	
	@GetMapping("/all")
	public List<String> getAllPhones() {
		return phoneService.getAllPhones();
		
	}
	
	@GetMapping("/{customerId}")
	public List<String> getAllPhones(@PathVariable("customerId") String customerId) {
		return phoneService.getPhoneForACustomer(customerId);
		
	}
	
	@PostMapping(path = "/activate", consumes = "application/json", produces = "application/json")
	public void activatePhone(@RequestBody ActivationDetails details) {
		phoneService.activatPhone(details.getCustomerName(), details.getCustomerId(), 
				details.getPhoneNumber(), details.getPhoneType());
		
		
	}

}
