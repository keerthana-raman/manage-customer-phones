package com.belong.service;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { CustomerPhoneService.class})
public class CustomerPhoneServiceTest {
	
    @Autowired 
    private CustomerPhoneService phoneService;
    
    @Test
    public void testActivatePhone() {
    	phoneService.activatPhone("Luke Mason", "23221", "34345454", "OFFICE");
    	List<String> phones = phoneService.getPhoneForACustomer("23221");
    	assertTrue(phones.size() == 1);
    	assert(phones.get(0)).equals("34345454");
    	
    }
    
    @Test
    public void testGetAllPhones() {
    	phoneService.activatPhone("Mary Queen", "32432", "21213456", "MOBILE");
    	List<String> phones = phoneService.getAllPhones();
    	assertTrue(phones.size() == 2);
    	assert(phones.get(0)).equals("34345454");
    	assert(phones.get(1)).equals("21213456");
    }
    
    @Test
    public void testGetPhoneForNonRegisteredId() {
    	List<String> phones = phoneService.getPhoneForACustomer("54654");
    	assertTrue(phones.size() == 0);
    }   

}
