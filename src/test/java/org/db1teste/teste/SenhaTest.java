package org.db1teste.teste;

import org.db1teste.classes.Pontuacao;
import org.db1teste.classes.Senha;
import org.junit.Test;

import junit.framework.Assert;

public class SenhaTest {
	
	@Test
	public void testeSomenteLetra() {
		Senha senha = new Senha();
		Pontuacao ponto = new Pontuacao();
		
		senha.setValor("aa");
		int resultado = ponto.analiseSenha(senha); 
		int esperado = 6;
		
		Assert.assertEquals(esperado, resultado);
	}
	
	@Test
	public void testeSomenteNumero() {
		Senha senha = new Senha();
		Pontuacao ponto = new Pontuacao();
		
		senha.setValor("12");
		int resultado = ponto.analiseSenha(senha); 
		int esperado = 6;
		
		Assert.assertEquals(esperado, resultado);
	}
	@Test
	public void testeLetraNumero() {
		Senha senha = new Senha();
		Pontuacao ponto = new Pontuacao();
		
		senha.setValor("a1");
		int resultado = ponto.analiseSenha(senha); 
		int esperado = 14;
		
		Assert.assertEquals(esperado, resultado);
	}
	
	@Test
	public void testeSymbols() {
		Senha senha = new Senha();
		Pontuacao ponto = new Pontuacao();
		
		senha.setValor("@");
		int resultado = ponto.analiseSenha(senha); 
		int esperado = 10;
		
		Assert.assertEquals(esperado, resultado);
	}
		
	@Test
	public void testeUpLowCaseSemMiddle() {
		Senha senha = new Senha();
		Pontuacao ponto = new Pontuacao();
		
		senha.setValor("a1A");
		int resultado = ponto.analiseSenha(senha); 
		int esperado = 24;
		
		Assert.assertEquals(esperado, resultado);
	}
	
	@Test
	public void testeUpLowCaseSemMiddle2() {
		Senha senha = new Senha();
		Pontuacao ponto = new Pontuacao();
		
		senha.setValor("B2b");
		int resultado = ponto.analiseSenha(senha); 
		int esperado = 24;
		
		Assert.assertEquals(esperado, resultado);
	}
	
	@Test
	public void testeComplexidade() {
		Senha senha = new Senha();
		Pontuacao ponto = new Pontuacao();
		
		senha.setValor("a");
		int pontoSenha = ponto.analiseSenha(senha); 
		String resultado = ponto.verificarComplexidade(pontoSenha);
		String esperado = "Muito Curta";
		
		Assert.assertEquals(esperado, resultado);
	}
//	a1A curta, a1A@b1 bom, a1A@b1@a forte, a1A@b1@a!@ muito forte

	@Test
	public void testeComplexidade2() {
		Senha senha = new Senha();
		Pontuacao ponto = new Pontuacao();
		
		senha.setValor("a1A");
		int pontoSenha = ponto.analiseSenha(senha); 
		String resultado = ponto.verificarComplexidade(pontoSenha);
		String esperado = "Curta";
		
		Assert.assertEquals(esperado, resultado);
	}
	
	@Test
	public void testeComplexidade3() {
		Senha senha = new Senha();
		Pontuacao ponto = new Pontuacao();
		
		senha.setValor("a1A@b1");
		int pontoSenha = ponto.analiseSenha(senha); 
		String resultado = ponto.verificarComplexidade(pontoSenha);
		String esperado = "Bom";
		
		Assert.assertEquals(esperado, resultado);
	}
	
	@Test
	public void testeComplexidade4() {
		Senha senha = new Senha();
		Pontuacao ponto = new Pontuacao();
		
		senha.setValor("a1A@b1@a");
		int pontoSenha = ponto.analiseSenha(senha); 
		String resultado = ponto.verificarComplexidade(pontoSenha);
		String esperado = "Forte";
		
		Assert.assertEquals(esperado, resultado);
	}
	
	@Test
	public void testeComplexidade5() {
		Senha senha = new Senha();
		Pontuacao ponto = new Pontuacao();
		
		senha.setValor("a1A@b1@a!@");
		int pontoSenha = ponto.analiseSenha(senha); 
		String resultado = ponto.verificarComplexidade(pontoSenha);
		String esperado = "Muito Forte";
		
		Assert.assertEquals(esperado, resultado);
	}

}
