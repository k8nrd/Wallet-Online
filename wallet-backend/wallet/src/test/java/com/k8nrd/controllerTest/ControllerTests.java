package com.k8nrd.controllerTest;


import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ControllerTests {
		
	@Autowired
	private WebApplicationContext wac;
	
	@Autowired
	private OAuthHelper authHelper;
	private MockMvc mockMvc;
	
	@Before
	public void setupMethod(){
		 MockitoAnnotations.initMocks(this);
	        mockMvc = MockMvcBuilders    
	                .webAppContextSetup(wac)
	                .alwaysDo(print())
	                .apply(SecurityMockMvcConfigurers.springSecurity())
	                .build();
	}
	
	@Test
	public void testTest() throws Exception {
		mockMvc.perform(get("/list/all").with(this.authHelper.addBearerToken("test")))
		.andExpect(status().isOk());
	}

}
