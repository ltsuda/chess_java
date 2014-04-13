package voIP;

/*
*Projeto: Jogo de Xadrez
*Disciplina: Estrutura de Dados 5o Semestre
*Grupo: VoIP
*Integrantes:
* -	Cassio Otavio Ferreira Perbelini Castilho
* -	Cesar Martins
* -	Felipe Batista Suardi
* -	Jaqueline Campaci Silva
* -	Leonardo Henrique Tsuda
* -	Murilo Nata Komirchuk de Jesus
*/

/**
 * Classe com atributos/metodos para realizar um movimento
 */

public class Movimento {
    
    //Atributos
    private final boolean validado;
    private final String mensagem;
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
