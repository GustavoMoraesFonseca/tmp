package br.com.votorantim.sigla.poc.application.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.votorantim.sigla.poc.domain.PocStrongResponseModel;
import br.com.votorantim.sigla.poc.domain.PocStrongResquestDto;
import br.com.votorantim.sigla.poc.domain.port.IPocService;
import br.com.votorantim.sigla.poc.infrastructure.client.PocClient;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PocService implements IPocService {

	@Autowired
	PocClient client;
	
	@Override
	public PocStrongResponseModel create(PocStrongResquestDto request) {
		PocStrongResponseModel pocReturn = null;
		try {
			pocReturn = client.requestValidateCpfWeb(request);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return pocReturn;
	}
}