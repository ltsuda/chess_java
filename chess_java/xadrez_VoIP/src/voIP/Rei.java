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
 * subClasse de Peca que armazena as caracteristicas do Rei
 */

public class Rei extends Peca{

	//Cria construtor Rei com parametro boolean brancas
    /**
     * @param brancas
     */
	public Rei(boolean brancas) {
        super(brancas);
    }
    
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
        if (posicao.x > 7 || posicao.y > 7 || posicao.x < 0 || posicao.y < 0) {
        return false;
        }

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
