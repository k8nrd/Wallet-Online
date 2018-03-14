package com.k8nrd.controllerTest;


import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.k8nrd.controller.TransactionController;
import com.k8nrd.domains.IncomeCathegory;
import com.k8nrd.domains.IncomeDTO;
import com.k8nrd.services.AppUserService;
import com.k8nrd.services.TransactionService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ControllerTests {
	
	
	@Mock
	private TransactionService ts;
	
	@Mock
	private AppUserService ap;
		
	@InjectMocks
	private TransactionController tc;
	
	@Autowired
	private OAuthHelper authHelper;
	private MockMvc mockMvc;
	
    @Autowired
    private FilterChainProxy springSecurityFilterChain;

    @Before
    public void startMocks(){
    	MockitoAnnotations.initMocks(this);
         mockMvc = MockMvcBuilders
                .standaloneSetup(tc)
                .alwaysDo(print())
                .apply(SecurityMockMvcConfigurers.springSecurity(springSecurityFilterChain))
                .build();

         
        
    }
	@Test
	public void testTest() throws Exception {
		mockMvc.perform(get("/list/all").with(this.authHelper.addBearerToken("test")))
		.andExpect(status().isOk());
		verify(this.ts, times(1)).getUserTransactionList("test");
	}
	
	@Test
	public void saveIncomePostTest() throws IOException, Exception {
		IncomeDTO inc = new IncomeDTO();
		inc.setInfo("test");
		inc.setPrice(new BigDecimal(23));
		inc.setCathegory(IncomeCathegory.DONATION);
		inc.setFlag(true);
		inc.setDate(new GregorianCalendar());
		
		mockMvc.perform(post("/add/income").with(this.authHelper.addBearerToken("test"))
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(TestUtils.convertObjectToJsonBytes(inc)))
				.andExpect(status().isOk());
		
		verify(this.ts, times(1)).addUserTransactionIncome("test", inc);
	}

}
