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
 * subClasse de Peca que armazena as caracteristicas do Rainha
 */

public class Rainha extends Peca{
    
    //Cria construtor Rainha com parametros boolean b e Posicao posicao
    /**
     * @param b
     * @param posicao
     */
    Rainha(boolean b, Posicao posicao) {
        super(b, posicao);
    }
    
    //Retorna string com nome da peca
    /**
     * @Override
     * @return "Rainha"
     */
    public String getNome() {
        return "Rainha";
    }
    
    //Valida o movimento especifico da peca Rainha nos limites do tabuleiro
    /**
     * @Override
     * @param posicao
     * @param captura
     */
    public boolean validaMovimento(Posicao posicao, boolean captura) {
        super.validaTabuleiroMaximo(posicao);
        
        if (((Math.abs(this.posicao.y - posicao.y) == 0 || Math.abs(this.posicao.x - posicao.x) == 0))
                || Math.abs(this.posicao.y - posicao.y) == Math.abs(this.posicao.x - posicao.x))
        {
            return true;
        }
        
        return false;
    }
    
    //Retorna o simbolo de acordo com o lado da peca, branca ou preta (branca = false)
    /**
     * @Override
     * @return 'q' or 'Q'
     */
    public char getSimbolo() {
        if (this.brancas == true){
            return 'q';
        }
        else {
            return 'Q';
        }
    }
    
}
