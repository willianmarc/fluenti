package com.willian.portal_suporte.dto;
import java.time.LocalDateTime;
import com.willian.portal_suporte.entity.Cliente;
public class ClienteDTO {
	private Long id;
	private int codigoCliente;
	private String nomeEmpresa;
	private String email;
	private String telefone;
	private boolean ativo;
	private LocalDateTime dataCadastro;

	public ClienteDTO() {
	}

	public ClienteDTO(Cliente cliente) {
		this.id = cliente.getId();
		this.codigoCliente = cliente.getCodigoCliente();
		this.nomeEmpresa = cliente.getNomeEmpresa();
		this.email = cliente.getEmail();
		this.telefone =cliente.getTelefone();
		this.ativo = cliente.isAtivo();
		this.dataCadastro = cliente.getDataCadastro();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	

}
