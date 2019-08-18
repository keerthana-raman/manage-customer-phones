package com.belong.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Customer {
	
	String fullName;
	
	String customerId;

	List<Phone> phones;
	
	public Customer(String customerId, String fullName) {
		this.customerId = customerId;
		this.fullName = fullName;
		this.phones = new ArrayList<>();
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public String getFullName() {
		return fullName;
	}

	public String getCustomerId() {
		return customerId;
	}
	
	public void setPhone(Phone phonActivate) {
		Optional<Phone> matchingPhone = this.phones.stream()
										.filter(phone -> phone.getPhoneNumber().equals(phonActivate.getPhoneNumber()))
										.findFirst();
		if(matchingPhone.isPresent()) {
			//throw Exception that activation already done
		}
		else {
			this.phones.add(phonActivate);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((phones == null) ? 0 : phones.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (phones == null) {
			if (other.phones != null)
				return false;
		} else if (!phones.equals(other.phones))
			return false;
		return true;
	}
	
	
}
