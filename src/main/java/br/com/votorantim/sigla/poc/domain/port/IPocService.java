package br.com.votorantim.sigla.poc.domain.port;

import org.springframework.stereotype.Service;

import br.com.votorantim.sigla.poc.domain.PocStrongResponseModel;
import br.com.votorantim.sigla.poc.domain.PocStrongResquestDto;

@Service
public interface IPocService {

	PocStrongResponseModel create(PocStrongResquestDto request);
}