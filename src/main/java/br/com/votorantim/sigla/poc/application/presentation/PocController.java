package br.com.votorantim.sigla.poc.application.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.votorantim.sigla.poc.application.adapter.PocService;
import br.com.votorantim.sigla.poc.domain.PocStrongResponseModel;
import br.com.votorantim.sigla.poc.domain.PocStrongResquestDto;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/poc")
public class PocController {

	@Autowired
	PocService service;
	
	@PostMapping
	@Operation(summary = "Get a book by its id")
	public ResponseEntity<PocStrongResponseModel> createPoc(
		@RequestBody PocStrongResquestDto requestBody
	) throws Exception {
		return ResponseEntity.status(HttpStatus.CREATED.value()).body(service.create(requestBody));
	}
}