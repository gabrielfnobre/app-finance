package br.com.nobrecoder.fin_interface;

import br.com.nobrecoder.operations.Aula02_Operations;

/* USANDO REQUIRES TRANSITIVE NOS NOSSOS MÓDULOS
 * 
 * Muitas vezes vamos precisar usar módulos que são dependentes de outros módulos, um bom exemplo é o que
 * vamos usar aqui nesta aula, onde o nosso "app-finance" precisará utilizar uma classe que está em "app-
 * calculator", que por sua vez precisará usar uma classe que está em "app-logger", nesse caso para usar 
 * a classe de app-logger teríamos que gerar uma dependência entre app-finance e app-logger, apesar de 
 * não ser necessariamente o app-finance que iria usar o app-logger diretamente.
 * 
 * Isso acabaria fazendo com que tivéssemos uma dependência ciclíca, afinal, para alguém que vê de fora, 
 * ficaria a grande dúvida: "Quem realmente necessita da dependência de "app-logger"? app-finance ou app-
 * calculator?"
 * 
 * Para resolver essa questão o Java também desenvolveu o conceito de "requires transitive", ou seja, é
 * possível passar uma dependência para um módulo que realmente necessita dela, e ao mesmo tempo, passar
 * para um módulo pai que tem dependência com o nosso módulo atual, que este módulo possuí uma dependên-
 * cia e precisará usá-la, sem a necessidade de também gerar uma dependência no módulo pai.
 * 
 * Embaralhou tudo?
 * 
 * Vamos ver isso no exemplo abaixo, onde queremos fazer o seguinte:
 * 
 * 	* Queremos que essa classe que está em "app-finance" use um método que está disponível em "app-cal-
 * 		culator" que fará o seguinte: além de somar o conjunto de números que vamos passar como parâme-
 * 		tro, também irá nos passar a informação da data de quanto a soma foi feita;
 * 
 * 	* Mas esse método que está em "app-calculator" precisará usar um método que está em outro módulo que
 * 		é o módulo "app-logger", que é responsável por pegar a data atual. Ou seja, estamos com depen-
 * 		dência entre 3 módulos. Como fazer "app-finance" executar uma classe que está em "app-logger" 
 * 		sem ter dependência com esse módulo? É ai que entra o "requires transitive"!
 * 
 * Veja abaixo como fizemos!!
 * */

public class Aula02_UsingRequiresTransitive {
	
	//Veja no arquivo "module-info.java" que temos uma dependência com o módulo de "app.calculator" mas
	//não temos uma dependência com "app.logger", porém quando executamos o programa, ele utiliza o mé-
	//todo de "app-logger" apesar de tudo!
	public static void main(String[] args) {
		System.out.println(Aula02_Operations.sumInfo(2.5, 2.5, 2.5));	
		System.out.println(Aula02_Operations.sumInfo(7, 8, 13));	
		System.out.println(Aula02_Operations.sumInfo(3, 3, 3));	
	}
}
