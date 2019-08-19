package com.belong.api;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.belong.application.CustomerPhoneApplication;
import com.belong.service.CustomerPhoneService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerPhoneApiImpl.class)
@ContextConfiguration(classes = { CustomerPhoneApplication.class })
public class CustomerPhoneApiImplTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private CustomerPhoneService phoneService;

	@Autowired
	ObjectMapper objectMapper;

	@Test
	public void givenAllPhones_whenGetAllPhones_thenReturnJsonArray() throws Exception {

		List<String> phoneList = Stream.of("23242228", "34543423").collect(Collectors.toList());

		given(phoneService.getAllPhones()).willReturn(phoneList);

		mvc.perform(get("/customer-phone/all").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(2))).andExpect(jsonPath("$[0]", is("23242228")))
				.andExpect(jsonPath("$[1]", is("34543423")));
	}

	@Test
	public void givenCustomer_whenGetPhones_thenReturnJsonArray() throws Exception {

		List<String> phoneList = Stream.of("45342343").collect(Collectors.toList());

		given(phoneService.getPhoneForACustomer("334423")).willReturn(phoneList);

		mvc.perform(get("/customer-phone/334423").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1))).andExpect(jsonPath("$[0]", is("45342343")));
	}

	@Test
	public void givenActivateDetails_whenActivatePhones_thenReturnSuccess() throws Exception {

		ActivationDetails details = new ActivationDetails();
		details.setCustomerId("334423");
		details.setCustomerName("John King");
		details.setPhoneNumber("32435465");
		details.setPhoneType("MOBILE");

		mvc.perform(post("/customer-phone/activate").content(objectMapper.writeValueAsString(details))
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
	}
	
	@Test
	public void givenBadActivateDetails_whenActivatePhones_thenReturnFailure() throws Exception {

		ActivationDetails details = new ActivationDetails();
		details.setCustomerId("334423");
		details.setCustomerName("John King");
		details.setPhoneNumber("32435465");
		details.setPhoneType("DUMMY");

		mvc.perform(post("/customer-phone/activate").content(objectMapper.writeValueAsString(details))
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());
	}

}
