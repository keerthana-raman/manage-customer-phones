package com.belong.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.belong.constants.PhoneTypes;
import com.belong.service.CustomerPhoneService;

@RestController
@RequestMapping("/customer-phone")
public class CustomerPhoneApiImpl implements PhoneApi {

	@Autowired
	private CustomerPhoneService phoneService;

	@GetMapping("/all")
	public List<String> getAllPhones() {
		return phoneService.getAllPhones();

	}

	@GetMapping("/{customerId}")
	public List<String> getAllPhones(@PathVariable("customerId") String customerId) {
		return phoneService.getPhoneForACustomer(customerId);

	}

	@PostMapping(path = "/activate", consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> activatePhone(@Valid @RequestBody ActivationDetails details) {
		try {
			PhoneTypes.valueOf(details.getPhoneType());
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		phoneService.activatPhone(details.getCustomerName(), details.getCustomerId(), details.getPhoneNumber(),
				details.getPhoneType());

		return new ResponseEntity<>(HttpStatus.CREATED);

	}

}
