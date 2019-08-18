package com.belong.entity;

import com.belong.constants.PhoneTypes;

public class Phone {
	
	String phoneNumber;
	
	PhoneTypes phoneType;
	
	public Phone(String phoneNumber, String phoneType) {
		this.phoneNumber = phoneNumber;		
		this.phoneType = PhoneTypes.valueOf(phoneType);
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public PhoneTypes getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(PhoneTypes phoneType) {
		this.phoneType = phoneType;
	}

}
