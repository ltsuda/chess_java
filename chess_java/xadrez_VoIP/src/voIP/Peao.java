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
 * subClasse de Peca que armazena as caracteristicas do Peao
 */

public class Peao extends Peca{

	//Cria construtor Peao com parametro boolean brancas
	/**
	 * @param brancas
	 */
    public Peao(boolean brancas) {
        super(brancas);
    }
    
    //Cria construtor Peao com parametros boolean b e Posicao posicao
    /**
     * @param b
     * @param posicao
     */
    Peao(boolean b, Posicao posicao) {
        super(b, posicao);
    }

    //Retorna string com nome da peca
    /**
     * @Override
     * @return "Peao"
     */
    public String getNome() {
        return "Peao";
    }

    //Valida o movimento especifico da peca Peao nos limites do tabuleiro
    /**
     * @Override
     * @param posicao
     * @param captura
     */
    public boolean validaMovimento(Posicao posicao, boolean captura) {
        if (posicao.x > 7 || posicao.y > 7 || posicao.x < 0 || posicao.y < 0) {
        return false;
        }
        
        switch (getSimbolo()){
            case 'P':
            if (this.posicao.y == 1 &&
                (posicao.y - this.posicao.y == 1 ||
                posicao.y - this.posicao.y == 2) &&
                posicao.x == this.posicao.x &&
                captura == false)
            {
                return true;
            }

            if (this.posicao.y < 7 &&
            	posicao.y - this.posicao.y == 1 &&
                posicao.x == this.posicao.x &&
                captura == false)
            {
                return true;
            }

            if (Math.abs(this.posicao.x - posicao.x) == 1 &&
                Math.abs(this.posicao.y - posicao.y) == 1 &&
                captura == true)
            {
                return true;
            }
            break;

        case 'p':
            if (this.posicao.y == 6 &&
                (this.posicao.y - posicao.y == 1 ||
                 this.posicao.y - posicao.y == 2) &&
                posicao.x == this.posicao.x &&
                captura == false)
            {
                return true;
            }

            if (this.posicao.y > 1 &&
                this.posicao.y - posicao.y == 1 &&
                posicao.x == this.posicao.x &&
                captura == false)
            {
                return true;
            }

            if (Math.abs(this.posicao.x - posicao.x) == 1 &&
                Math.abs(this.posicao.y - posicao.y) == 1 &&
                captura == true)
            {
                return true;
            }
            break;
            default: 
            	break;
        }
        
    return false;
    }

    //Retorna o simbolo de acordo com o lado da peca, branca ou preta (branca = false)
    /**
     * @Override
     * @return 'p' or 'P'
     */
    public char getSimbolo() {
        if (this.brancas == true){
            return 'p';
        }
        else {
            return 'P';
        }
    }
  
}
