package voIP;

import java.io.Serializable;

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
 * Classe abstrata que armazena as caracteristicas genericas de uma Peca
 */

public abstract class Peca implements Serializable {
    
    //Atributos protected para ser acessado nas subclasses
    protected Posicao posicao;
    protected char simbolo;
    protected String nome;
    protected boolean brancas;
    protected boolean captura;
    protected final int TAB_LINHA_SUPERIOR = 7;
    protected final int TAB_LINHA_INFERIOR = 0;
    
    //Construtor com parametro boolean brancas e Posicao posicao que auxilia a criacao das pecas no tabuleiro
    /**
     * @param brancas
     * @param posicao
     */
    public Peca(boolean brancas, Posicao posicao)
    {
        this.brancas = brancas;
        this.setPosicao(posicao);
    }

    //Metodo que retorna a posicao peca
    /**
     * @return posicao
     */
    public  Posicao getPosicao(){
        return posicao;
    }
    
    //Metodo que retorna se a peca branca que auxilia no metodo de movimento para validar se a peca eh do lado branco ou preto
    /**
     * @return this.brancas
     */
    public boolean branca()
    {
        return this.brancas;
    }
    
    //Metodo para setar a posicao da peca no tabuleiro apos validar o movimento
    /**
     * @param posicao
     */
    public final void setPosicao(Posicao posicao){
        this.posicao = posicao;
    }
    
    //Metodo abstrato para implementacao especifica nas subclasses
    /**
     * @return
     */
    public abstract String getNome();
    
    //Metodo abstrato para implementacao da validacao do movimento especifico de cada subclasse peca
    /**
     * @param posicao
     * @param captura
     * @return
     */
    public abstract boolean validaMovimento(Posicao posicao, boolean captura);
    
    //Metodo abstrato para implementacao especifica nas subclasses
    /**
     * @return
     */
    public abstract char getSimbolo();
    
    protected boolean validaTabuleiroMaximo( Posicao posicao){
        if (posicao.x > TAB_LINHA_SUPERIOR || posicao.y > TAB_LINHA_SUPERIOR || posicao.x < TAB_LINHA_INFERIOR || posicao.y < TAB_LINHA_INFERIOR) {
            return true;
        }
        return false;
    }
}

