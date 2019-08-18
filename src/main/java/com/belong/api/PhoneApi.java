package com.belong.api;

import java.util.List;

public interface PhoneApi {
	
	public List<String> getAllPhones();
	public List<String> getAllPhones(String customerId);
	public void activatePhone(ActivationDetails details);

}
