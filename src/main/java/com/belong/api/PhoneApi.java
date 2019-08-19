package com.belong.api;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface PhoneApi {

	public List<String> getAllPhones();

	public List<String> getAllPhones(String customerId);

	public ResponseEntity<String> activatePhone(ActivationDetails details);

}
