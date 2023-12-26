package br.com.votorantim.sigla.poc.infrastructure.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.votorantim.sigla.poc.domain.PocStrongResponseModel;
import br.com.votorantim.sigla.poc.domain.PocStrongResquestDto;

@Component
public class PocClient {

	RestTemplate restTemplate = new RestTemplate();
	
	private static final String STRONG_CREATE_URL = "https://srv-mfaodesgcp-01/api/otp/48f5aaca-fb57-4dd8-b26a-95c57eb18933/create";
	private static final String AUTH_VALUE = "Basic c3J2X2dhdGV3YXlfbWZhb19kZXM6WzE0OjI1XSBHZXNpZWwgU29hcmVzIE5odzJWdWs2";
	
	private static HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", AUTH_VALUE);
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return headers;
	}
	
	public PocStrongResponseModel requestValidateCpfWeb(PocStrongResquestDto requestBody) throws Exception {
		var response = new ResponseEntity<PocStrongResponseModel>(HttpStatus.OK);
		
		HttpEntity<PocStrongResquestDto> request = new HttpEntity<>(requestBody, getHeaders());
		
		response = restTemplate.postForEntity(
			STRONG_CREATE_URL,
			request,
			PocStrongResponseModel.class
		);
		
		return response.getBody();
	}
}