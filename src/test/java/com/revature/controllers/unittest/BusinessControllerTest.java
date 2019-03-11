package com.revature.controllers.unittest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.revature.models.Business;
import com.revature.repositories.BusinessRepository;
import com.revature.services.BusinessService;

public class BusinessControllerTest {
	
    private MockMvc mockMvc;

	@Mock
	BusinessRepository br;

	@InjectMocks
	BusinessService bs;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(bs).build();

	}

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Test
	public void testGetIdValid() throws SQLException {
		int targetId = 1;

		Business eB = new Business(targetId, null, null, null, null, false, false, null, null);

		when(br.findById(targetId)).thenReturn(eB);

		Business business = bs.getBusiness(targetId);
		assertThat("Service" + "by Repo", business, is(eB));

	}
	
	@Test
	public void testGetIdInvalid() throws SQLException {
		int targetId = 1;

		Business eB = new Business(targetId, null, null, null, null, false, false, null, null);

		when(br.findById(targetId)).thenReturn(eB);

		Business business = bs.getBusiness(2);
		assertThat("Service" + "by Repo", business, is(eB));

	}
}
