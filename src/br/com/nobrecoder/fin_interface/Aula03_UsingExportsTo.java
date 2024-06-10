package br.com.nobrecoder.fin_interface;

import br.com.nobrecoder.operations.multiple.Aula03_OperationMultiple;

/* USANDO O EXPORTS TO
 * 
 * Além dos outros métodos de requires e exports, temos também o método "exports to", esse método de
 * interação entre módulos permite que possamos exportar um pacote diretamente para um módulo espe-
 * cífico, sem que haja necessáriamente a necessidade de fazer um requires por parte do módulo de-
 * pendente.
 * 
 * Como funciona?
 * 
 * Veja no exemplo abaixo que estamos usando um método que está dentro do pacote "multiple", que é 
 * um pacote interno do pacote "operations", note no nosso "module-info.java" que não estamos fazen-
 * do requisição nenhuma desse pacote interno, ainda assim conseguimos usá-lo. Isso acontece por que
 * no "module-info.java" do pacote "operations" usamos o "exports to" para dizer ao modulepath que o
 * pacote "multiple" deveria ser exportado diretamente para o nosso pacote atual.
 * 
 * Veja a implementação na classe "Aula03_OperationMultiple" no pacote "br.com.nobrecoder.operations.
 * multiple", bem como os arquivos "module-info.java" tanto nesse pacote quanto no pacote "operati-
 * ons"...
 * 
 * */

public class Aula03_UsingExportsTo {

	public static void main(String[] args) {
		System.out.println(Aula03_OperationMultiple.multiple(3.0, 3.0, 3.0));
	}
	
}
