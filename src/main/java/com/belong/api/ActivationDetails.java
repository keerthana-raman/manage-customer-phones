package com.belong.api;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

@Entity
public class ActivationDetails {

	@NotEmpty(message = "Customer name required")
	String customerName;
	@NotEmpty(message = "Customer ID required")
	String customerId;
	@NotEmpty(message = "Customer phone number required")
	String phoneNumber;
	@NotEmpty(message = "Customer phone type required")
	String phoneType;

	public ActivationDetails(String customerName, String customerId, String phoneNumber, String phoneType) {
		super();
		this.customerName = customerName;
		this.customerId = customerId;
		this.phoneNumber = phoneNumber;
		this.phoneType = phoneType;
	}

	public ActivationDetails() {

	}

	public String getCustomerName() {
		return customerName;
	}

	public String getCustomerId() {
		return customerId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getPhoneType() {
		return phoneType;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

}
