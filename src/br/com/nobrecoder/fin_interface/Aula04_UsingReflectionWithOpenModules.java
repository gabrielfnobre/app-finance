package br.com.nobrecoder.fin_interface;

import java.lang.reflect.Field;
import br.com.nobrecoder.operations.animal.Cat;

/* USANDO REFLECT COM MÓDULOS ABERTOS PARA ACESSAR ATRIBUTOS E MÉTODOS PRIVADOS!
 * 
 * Por através do "Reflect", uma API Java utilizada para acessar os atributos e método privados de uma classe por
 * através de outra classe, é possível não apenas ter acesso a estes atributos como também modificar os valores
 * deles.
 * 
 * Mas se tratando do sistema de módulos, seria possível acessar atributos e métodos privados de uma classe? Se
 * tentássemos acessar os atributos e métodos diretamente - apesar de termos a permissão dos módulos para acessar
 * um determinado pacote - não seria possível acessar atributos e métodos privados.
 * 
 * Para resolver essa questão, quando trabalhamos entre classes do mesmo pacote, podemos usar a reflexão para 
 * acessar os atributos e métodos privados de uma classe. Mas se tratando de módulos, mesmo que usamos a reflexão
 * e tenhamos acesso permitido as classes, se os atributos forem privados, não conseguimos ter acesso a eles a-
 * pesar de estarmos usando a reflexão.
 * 
 * Ou seja, o sistema de módulos nos garante uma segurança á mais, para que pacotes externos ao pacote de uma de-
 * terminada classe não possa alterar os atributos e métodos privados. Mas existe uma forma de conceder essa per-
 * missão, e isso acontece por através da palavra reservada "open" e "opens" nos nossos módulos.
 * 
 * Usamos a palavra "open" quando desejamos que todo um módulo tenha as suas classes disponíveis para reflexão 
 * no pacote exterior. E usamos "opens" quando desejamos que um ou mais pacotes do nosso módulo estejam disponí-
 * veis para reflexão com pacotes exteriores.
 * 
 * Vejamos um exemplo abaixo, onde mudamos o atributo "meow" (miado) de um gato para um latido...
 * 
 * */

public class Aula04_UsingReflectionWithOpenModules {

	public static void main(String[] args) {
		
		//Por através do "exports to" é possível que essa classe possa criar objetos do tipo Cat e mostrar o
		//som produzido pelo miado!
		Cat cat = new Cat();
		System.out.println(cat.getMeow());
		
		//Criamos um objeto do tipo "Field" que utiliza reflect para acessar e modificar atributos privados!
		Field field;
		
		//Acessamos o atributo "meow", tornamos ele acessível para mudanças, mudamos o miado por um latido e
		//depois fechamos a acessibilidade ao atributo privado.
		try {
			field = Cat.class.getDeclaredField("meow");
			field.setAccessible(true);
			field.set(cat, "Hau!Hau!");
			field.setAccessible(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Note que agora o miado é um latido!
		System.out.println(cat.getMeow());
		
		//Veja agora como a reflexão foi possível graças a palavra reservada "opens" no módulo do pacote "animal"
		//que está dentro do pacote "operations"...
		
	}
	
}
