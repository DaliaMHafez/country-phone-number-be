package com.jumia;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.jumia.model.Customer;

class JumiaSpringbootApplicationTests extends AbstractTest{
	@Test
	void contextLoads() {
	}

	@Test
	public void getAllCustomers() throws Exception {
	   String uri = "/api/customers";
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
		  .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	   String content = mvcResult.getResponse().getContentAsString();
	   Customer[] customerlist = super.mapFromJson(content, Customer[].class);
	   assertTrue(customerlist.length > 0);
	}
	@Test
	public void addCustomer() throws Exception {
	   String uri = "/api/customers";
	   Customer customer = new Customer();
	   customer.setId(1);
	   customer.setName("Dalia");
	   customer.setPhone("(237) 699209115");
	   String inputJson = super.mapToJson(customer);
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
		  .contentType(MediaType.APPLICATION_JSON_VALUE)
		  .content(inputJson)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	}

	@Test
	public void updateCustomer() throws Exception {
	   String uri = "/api/customers/1";
	   Customer customer = new Customer();
	   customer.setName("Daliaaaa");
	   customer.setPhone("(237) 691816558");
	   String inputJson = super.mapToJson(customer);
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
		  .contentType(MediaType.APPLICATION_JSON_VALUE)
		  .content(inputJson)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	}
	// commented because it actualy delets data
	// @Test
	// public void deleteCustomer() throws Exception {
	//    String uri = "/api/customers/1";
	//    MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
	//    int status = mvcResult.getResponse().getStatus();
	//    assertEquals(200, status);
	// }
}
