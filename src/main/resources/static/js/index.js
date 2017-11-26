function analiseSenha(valor) {
	
	/*  Variavel que recebe o valor do input e transforma em um array */
	
	var senha = valor.split("");

	/*	Variaveis de inicialização */
	
	var contNumero = 0, contCaracter = 0, contLetra = 0, contLetraLow = 0, contLetraUp = 0, contConsecNumero = 0, contSymbols = 0;
	var score = 0, complexidade = 0;
	var somenteNumero = 0, somenteLetra = 0, somenteLetraUp = 0, somenteLetraLow = 0;
	var scoreNumero = 0, scoreLetraLow = 0, scoreLetraUp = 0;
	
	/*	Análise de tipos */
	
	for (var i = 0; i < senha.length; i++) {
		
		if (senha[i].match(/\s/)) {
			contCaracter++;
		} else if (senha[i].match(/[0-9]/)) {
			contCaracter++;
			contNumero++;
		} else if (senha[i].match(/[a-z]/)) {
			contCaracter++;
			contLetra++;
			contLetraLow ++;
		} else if (senha[i].match(/[A-Z]/)) {
			contCaracter++;
			contLetra++;
			contLetraUp ++;
		} else {
			contCaracter++;
			contSymbols++;
		}
		if(i == senha.length-1 && senha[i] != " ") {
			if(contNumero == senha.length) {
				somenteNumero = -contNumero;
			} else if(contLetra == senha.length) {
				somenteLetra = -contLetra;
			} else if(contNumero != senha.length) {
				scoreNumero = contNumero*4;
			}
		}
		if(contLetraLow > 0 && contLetraUp > 0) {
			scoreLetraLow = (contCaracter - contLetraLow) * 2;
			scoreLetraUp = (contCaracter - contLetraUp) * 2;
		} else if(contLetraLow > 0 && contNumero > 0) {
			scoreLetraLow = (contCaracter - contLetraLow) * 2;
		} else if(contLetraUp > 0 && contNumero > 0) {
			scoreLetraUp = (contCaracter - contLetraUp) * 2;
		}
	}
	var scoreCaracter = contCaracter*4;
	var scoreSymbols = contSymbols*6;
	
	score = scoreNumero + scoreCaracter + somenteLetra + somenteNumero + scoreLetraLow + scoreLetraUp + scoreSymbols;
	
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
	
	/*	Definindo o score e a complexidade */

	document.getElementById("percent").innerHTML = score + "%";
	document.getElementById("rate").innerHTML = complexidade;
	document.getElementsByClassName("gradiente")[0].style.backgroundPosition = "-" + (score*2) + "px";
	document.getElementsByClassName("gradiente")[1].style.backgroundPosition = "-" + (score*2) + "px";
	
}