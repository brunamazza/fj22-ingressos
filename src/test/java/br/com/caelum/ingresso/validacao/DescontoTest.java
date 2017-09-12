package br.com.caelum.ingresso.validacao;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

import org.junit.Test;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Ingresso;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;
import br.com.caelum.ingresso.model.descontos.DescontoDeTrintaPorCentoParaBancos;
import br.com.caelum.ingresso.model.descontos.DescontoEstudante;
import br.com.caelum.ingresso.model.descontos.SemDesconto;

public class DescontoTest {
	
	@Test
	public void TesteBanco() {
		Sala sala = new Sala("Eldorado = IMax", new BigDecimal("20.5"));
		Filme filme = new Filme("Rouge One", Duration.ofMinutes(120),"SCI-FI", new BigDecimal("12.0"));
		
		Sessao sessao = new Sessao(LocalTime.now(), filme, sala);
		
		Ingresso ingresso = new Ingresso(sessao, new DescontoDeTrintaPorCentoParaBancos());
		
		BigDecimal precoEsperado = new BigDecimal("22.75");
		
		assertEquals(precoEsperado, ingresso.getPreco());
		}

	@Test
	public void TesteEstudante() {
		Sala sala = new Sala("Eldorado = IMax", new BigDecimal("20.5"));
		Filme filme = new Filme("Rouge One", Duration.ofMinutes(120),"SCI-FI", new BigDecimal("12.0"));
		
		Sessao sessao = new Sessao(LocalTime.now(), filme, sala);
		
		Ingresso ingresso = new Ingresso(sessao, new DescontoEstudante());
		
		BigDecimal precoEsperado = new BigDecimal("16.25");
		
		assertEquals(precoEsperado, ingresso.getPreco());
		}

	@Test
	public void TesteInteira() {
		Sala sala = new Sala("Eldorado = IMax", new BigDecimal("20.5"));
		Filme filme = new Filme("Rouge One", Duration.ofMinutes(120),"SCI-FI", new BigDecimal("12.0"));
		
		Sessao sessao = new Sessao(LocalTime.now(), filme, sala);
		
		Ingresso ingresso = new Ingresso(sessao, new SemDesconto());
		
		BigDecimal precoEsperado = new BigDecimal("32.5");
		
		assertEquals(precoEsperado, ingresso.getPreco());
		}

}
