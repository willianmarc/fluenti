package com.willian.portal_suporte.dto;
import java.math.BigDecimal;
import com.willian.portal_suporte.entity.Plano;

public class PlanoDTO {
	private Long id;
	private String nomePlano;
	private Integer limiteMensagens;
	private BigDecimal valorMensal;
	private boolean ativo;
	
	public PlanoDTO() {}
	
	public PlanoDTO(Plano plano) {
		this.id =plano.getId();
		this.nomePlano=plano.getNomePlano();
		this.limiteMensagens =plano.getLimiteMensagens();
		this.valorMensal =plano.getValorMensal();
		this.ativo=plano.isAtivo();
	}

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
