package br.com.votorantim.sigla.poc.application.presentation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.votorantim.sigla.poc.application.adapter.PocService;
import br.com.votorantim.sigla.poc.domain.PocStrongResponseModel;
import br.com.votorantim.sigla.poc.domain.PocStrongResquestDto;

@SpringBootTest
@AutoConfigureMockMvc
public class PocControllerTests {

    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private PocService mockService;
    
    private static HttpHeaders headers = new HttpHeaders();
    private static ObjectMapper objectMapper = new ObjectMapper();
    private static PocStrongResquestDto pocStrongResquestDto = new PocStrongResquestDto();
    
    @BeforeAll
    public static void setup() {
    	headers.add("Content-Type", "application/json;charset=UTF-8");
    	headers.add("Accept", "application/json;charset=UTF-8");
    }
    
    @Nested
    @DisplayName("Testes do CreateAssociado")
    class WhenCreateAssociado {
    	
    	@BeforeEach
    	public void setupCreateAssociado() {
    		pocStrongResquestDto.setUsername("11832147665");
    		pocStrongResquestDto.setNotification("200b4452-8fae-4d0d-aef2-c3930f130cc6");
    	}
    	
		@Test
		@DisplayName("Deve retornar OK, quando criar um associado")
		public void shouldReturnOk_whenCreateAssociado() throws Exception {
			
			System.out.println(mockService);
			
			PocStrongResponseModel expectedReturn = new PocStrongResponseModel();
			expectedReturn.setMessage("Unauthorized");
			expectedReturn.setPath("/api/otp/48f5aaca-fb57-4dd8-b26a-95c57eb18933/create");
			expectedReturn.setTransactionId("70cec215-2c36-4326-97db-bb2f83f00feb");
			
			String expectedReturnString = objectMapper.writeValueAsString(expectedReturn);
			
		    //when(mockService.create(pocStrongResquestDto)).thenReturn(expectedReturn);
		    
			MvcResult response = mockMvc.perform(MockMvcRequestBuilders.post("/poc")
					.headers(headers)
					.content(objectMapper.writeValueAsString(pocStrongResquestDto)))
	                .andExpect(status().isCreated())
	            .andReturn();
	
	        String actualReturn = response.getResponse().getContentAsString();
	        assertNotNull(actualReturn);
	        assertEquals(expectedReturnString, actualReturn);
		}
    }
}