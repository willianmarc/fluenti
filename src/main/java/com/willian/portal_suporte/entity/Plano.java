package com.willian.portal_suporte.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name= "planos")
public class Plano {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="nome_plano")
	private String nomePlano;
	@Column(name="limite_mensagens")
	private Integer limiteMensagens;
	@Column(name="valor_mensal")
	private BigDecimal valorMensal;
	private boolean ativo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomePlano() {
		return nomePlano;
	}
	public void setNomePlano(String nomePlano) {
		this.nomePlano = nomePlano;
	}
	public Integer getLimiteMensagens() {
		return limiteMensagens;
	}
	public void setLimiteMensagens(Integer limiteMensagens) {
		this.limiteMensagens = limiteMensagens;
	}
	public BigDecimal getValorMensal() {
		return valorMensal;
	}
	public void setValorMensal(BigDecimal valorMensal) {
		this.valorMensal = valorMensal;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	
}
	