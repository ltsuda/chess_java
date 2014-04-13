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
 * subClasse de Peca que armazena as caracteristicas do Rei
 */

public class Rei extends Peca{
    
    //Cria construtor Rei com parametros boolean b e Posicao posicao
    /**
     * @param b
     * @param posicao
     */
    Rei(boolean b, Posicao posicao) {
        super(b, posicao);
    }
    
    //Retorna string com nome da peca
    /**
     * @Override
     * @return "Rei"
     */
    public String getNome() {
        return "Rei";
    }
    
    //Valida o movimento especifico da peca Rei nos limites do tabuleiro
    /**
     * @Override
     * @param posicao
     * @param captura
     */
    public boolean validaMovimento(Posicao posicao,  boolean captura) {
        super.validaTabuleiroMaximo(posicao);
        
        if (Math.abs(this.posicao.y - posicao.y) <= 1 && Math.abs(this.posicao.x - posicao.x) <= 1)
        {
            return true;
        }
        return false;
    }
    
    //Retorna o simbolo de acordo com o lado da peca, branca ou preta (branca = false)
    /**
     * @Override
     * @return 'k' or 'K'
     */
    public char getSimbolo() {
        if (this.brancas == true){
            return 'k';
        }
        else {
            return 'K';
        }
    }
    
}
