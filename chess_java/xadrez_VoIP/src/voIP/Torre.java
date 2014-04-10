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
 * subClasse de Peca que armazena as caracteristicas do Torre
 */

public class Torre extends Peca {

    //Cria construtor Torre com parametros boolean b e Posicao posicao
    /**
     * @param brancas
     */
	public Torre(boolean brancas) {
        super(brancas);
    }

    //Cria construtor Torre com parametros boolean b e Posicao posicao
	/** 
	 * @param b
	 * @param posicao
	 */
    Torre(boolean b, Posicao posicao) {
        super(b, posicao);
    }

    //Retorna o simbolo de acordo com o lado da peca, branca ou preta (branca = false)
    /**
     * @Override
     * @return 't' or 'T'
     */
    public char getSimbolo() {
        if (this.brancas == true){
            return 't';
        }
        else{
            return 'T';
        }
    }
    
    //Retorna string com nome da peca
    /**
      * @Override
      * @return "Torre"
    */
    public String getNome() {
        return "Torre";
    }
    

    //Valida o movimento especifico da peca Rainha nos limites do tabuleiro
    /**
     * @Override
     * @param posicao
     * @param captura
     */
    public boolean validaMovimento(Posicao posicao,  boolean captura) {

        if (posicao.x > 7 || posicao.y > 7 || posicao.x < 0 || posicao.y < 0) {
        return false;
        }

        if (Math.abs(this.posicao.y - posicao.y) == 0 || Math.abs(this.posicao.x - posicao.x) == 0)
        {
                    return true;
        }

    return false;
    }


}
