package br.com.caelum.ingresso.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import br.com.caelum.ingresso.model.descontos.TipoDeIngresso;


@Entity
public class Ingresso {
	
	@Id
	@GeneratedValue
	private Integer id;
	@ManyToOne
	private Sessao sessao;
	@ManyToOne
	private Lugar lugar;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TipoDeIngresso getTipoDeIngresso() {
		return tipoDeIngresso;
	}

	public void setTipoDeIngresso(TipoDeIngresso tipoDeIngresso) {
		this.tipoDeIngresso = tipoDeIngresso;
	}

	private BigDecimal preco;
	@Enumerated(EnumType.STRING)
	private TipoDeIngresso tipoDeIngresso;

    /**
     * @deprecated hibernate only
     */
	
	public Ingresso() {
		
	}
	
	public Ingresso(Sessao sessao, TipoDeIngresso tipoDeIngresso, Lugar lugar) {
		this.sessao = sessao;
		this.tipoDeIngresso = tipoDeIngresso;
		this.preco = tipoDeIngresso.aplicaDesconto(sessao.getPreco());
		this.setLugar(lugar);		
		
	}

	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Lugar getLugar() {
		return lugar;
	}

	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}

}
