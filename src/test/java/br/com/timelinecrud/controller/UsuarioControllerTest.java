package br.com.timelinecrud.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
public class UsuarioControllerTest extends TestCase{
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setUp() throws Exception {
	  mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void getAll() throws Exception{
				
		mockMvc.perform(get("/getAll"))
			.andExpect(status().isOk());
		}	
	
//	@Test
//	public void getById() throws Exception{
//				
//		mockMvc.perform(get("/getById?id=1"))
//			.andExpect(status().isOk());
//		}
	
	@Test
	public void getByName() throws Exception{
				
		mockMvc.perform(get("/getByName?nome=jose"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.nome").value("jose"));
		}

}
