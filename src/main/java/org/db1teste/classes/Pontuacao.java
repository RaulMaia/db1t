package org.db1teste.classes;

public class Pontuacao {

	// 0 a 20 muito curta
	// 20 a 40 curta
	// 40 a 60 bom
	// 60 a 80 forte
	// 80 a 100 muito forte
	
	final static int NUMERO = 4;
	final static int CARACTER = 4;
	
	public int analiseSenha(Senha senha) {
		
		String[] valor = senha.getValor().split("");
		int score = 0;
		
		int contCaracter = 0, contNumero = 0, contLetra = 0, somenteNumero = 0, somenteLetra = 0, contSymbols = 0;
		int scoreNumero = 0, scoreLetraLow = 0, scoreLetraUp = 0;
		int contLetraLow = 0, contLetraUp = 0;
		
		for (int i = 0; i < valor.length; i++) {
			
			if (valor[i].matches("\\s")) {
				contCaracter++;
			} else if (valor[i].matches("[0-9]")) {
				contCaracter++;
				contNumero++;
			} else if (valor[i].matches("[a-z]")) {
				contCaracter++;
				contLetra++;
				contLetraLow ++;
			} else if (valor[i].matches("[A-Z]")) {
				contCaracter++;
				contLetra++;
				contLetraUp ++;
			} else {
				contCaracter++;
				contSymbols++;
			}
			if(i == valor.length-1 && valor[i] != " ") {
				if(contNumero == valor.length) {
					somenteNumero = -contNumero;
				} else if(contLetra == valor.length) {
					somenteLetra = -contLetra;
				} else if(contNumero != valor.length) {
					scoreNumero = contNumero*4;
				}
			}
			if(contLetraLow  > 0 && contLetraUp > 0) {
				scoreLetraLow = (contCaracter - contLetraLow) * 2;
				scoreLetraUp = (contCaracter - contLetraUp) * 2;
			} else if(contLetraLow > 0 && contNumero > 0) {
				scoreLetraLow = (contCaracter - contLetraLow) * 2;
			} else if(contLetraUp > 0 && contNumero > 0) {
				scoreLetraUp = (contCaracter - contLetraUp) * 2;
			}
		}
		int scoreCaracter = contCaracter*4;
		int scoreSymbols = contSymbols*6;
		
		score = scoreNumero + scoreCaracter + somenteLetra + somenteNumero + scoreLetraLow + scoreLetraUp + scoreSymbols;
		
		return score;
	}
	
	public String verificarComplexidade(int score) {
		
		String complexidade = "";
		
		if (score < 0) {
			score = 0;
		} else if (score > 100) {
			score = 100; 
		}
		if (score >= 0 && score < 20) {
			complexidade = "Muito Curta";
		}
		else if (score >= 20 && score < 40) {
			complexidade = "Curta";
		}
		else if (score >= 40 && score < 60) {
			complexidade = "Bom";
		}
		else if (score >= 60 && score < 80) {
			complexidade = "Forte";
		}
		else if (score >= 80 && score < 101) {
			complexidade = "Muito Forte";
		}
		return complexidade;
	}
	
}
