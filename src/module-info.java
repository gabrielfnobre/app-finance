/* 
 * COMO USAR EXPORTS E REQUIRES NOS MÓDULOS JAVA
 * 
 * Veja a explicação dos comandos que utilizamos abaixo para os nossos requires e exports dentro dos
 * nossos módulos para fazer a integração por através do modulepath.
 * 
 * Detalhe importante, um módulo que recebe pacotes de outro módulo
 * 
 * INFORMAÇÃO IMPORTANTE!!!
 * Não vamos conseguir usar os exports e requires adequadamente se não fizermos a inclusão dos módu-
 * los que desejamos usar no modulepath do nosso projeto.
 * 
 * */

module app.finance { //o bloco module serve para identificar o nosso módulo pelo nome e para conter nossos requires e exports dentro dele;
	requires java.base; //O java.base (módulo que tem as principais funções do java) não precisa ser requerido, mas fizemos a título de exemplo;
	requires app.calculator; //Aqui fizemos a requisição de todos os pacotes disponíveis dentro do módulo; 
}

/* Vá até o module-info do pacote "app-calculator" para ver como fizemos a implementação do módulo neste pacote, para ver seus requires e expor-
 * ts;
 */