package com.willian.portal_suporte.dto;

import java.time.LocalDateTime;
import com.willian.portal_suporte.entity.ClientePlanos;

public class ClientePlanosDTO {
	private Long id;
	private LocalDateTime dataInicio;
	private LocalDateTime dataFim;
	private Long clienteId;
	private Long planoId;

	public ClientePlanosDTO() {

	}

	public ClientePlanosDTO(ClientePlanos clientePlanos) {
		this.id = clientePlanos.getId();
		this.clienteId = clientePlanos.getCliente().getId();
		this.planoId = clientePlanos.getPlano().getId();
		this.dataInicio = clientePlanos.getDataInicio();
		this.dataFim = clientePlanos.getDataFim();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDateTime dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDateTime getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDateTime dataFim) {
		this.dataFim = dataFim;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public Long getPlanoId() {
		return planoId;
	}

	public void setPlanoId(Long planoId) {
		this.planoId = planoId;
	}

}
