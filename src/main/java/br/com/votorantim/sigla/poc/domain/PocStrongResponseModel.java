package br.com.votorantim.sigla.poc.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/*
 * {
    "message": "Unauthorized",
    "path": "/api/otp/48f5aaca-fb57-4dd8-b26a-95c57eb18933/create",
    "transaction_id": "70cec215-2c36-4326-97db-bb2f83f00feb"
}
 */
@Data
public class PocStrongResponseModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String message;
	private String path;
	
	@JsonProperty("transaction_id")
	private String transactionId;
}