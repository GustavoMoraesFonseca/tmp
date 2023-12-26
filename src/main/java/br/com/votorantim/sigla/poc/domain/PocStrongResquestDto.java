package br.com.votorantim.sigla.poc.domain;

import java.io.Serializable;

import lombok.Data;

/*
{
    "notification":"200b4452-8fae-4d0d-aef2-c3930f130cc6",
    "username":"11832147665"
}
 */
@Data
public class PocStrongResquestDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String notification;
	private String username;
}