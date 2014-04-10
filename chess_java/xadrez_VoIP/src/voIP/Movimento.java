/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package voIP;

/*
*Projeto: Jogo de Xadrez
*Disciplina: Estrutura de Dados 5º Semestre
*Grupo: VoIP
*Integrantes:
* -	Cássio Otávio Ferreira Perbelini Castilho
* -	César Martins
* -	Felipe Batista Suardi
* -	Jaqueline Campaci Silva
* -	Leonardo Henrique Tsuda
* -	Murilo Natã Komirchuk de Jesus
*/

/**
 * Classe com atributos/metodos para realizar um movimento
 */

public class Movimento {

	//Atributos
    private boolean validado;
    private String mensagem;
    public boolean fim;
           
    //Metodo que recebe se o movimento foi validado ou nao e a mensagem de acordo com o tipo de validacao realizada 
    /**
     * @param validado
     * @param mensagem
     */
    public Movimento(boolean validado,String mensagem){
        this.validado = validado;
        this.mensagem = mensagem;
    }
    
    //Metodo que retorna variavel validado que armazena se movimento foi validado
    /**
     * @return validado
     */
    public boolean getValidado(){
        return validado;
    }
    
    //Metodo que retorna variavel mensagem que armazena a mensagem de acordo com o tipo de validacao
    /**
     * @return mensagem
     */
    public String getMensagem(){
        return mensagem;
    }
    

}
