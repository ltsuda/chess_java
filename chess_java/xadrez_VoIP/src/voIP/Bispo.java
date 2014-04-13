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
 * subClasse de Peca que armazena as caracteristicas do Bispo
 */

public class Bispo extends Peca{
    
    //Cria construtor Bispo com parametros boolean b e Posicao posicao
    /**
     * @param b
     * @param posicao
     */
    Bispo(boolean b, Posicao posicao) {
        super(b, posicao);
    }
    
    //Retorna o simbolo de acordo com o lado da peca, branca ou preta (branca = false)
    /**
     * @Override
     * @return 'b' or 'B'
     */
    public char getSimbolo() {
        if (this.brancas == true){
            return 'b';
        }
        else{
            return 'B';
        }
    }
    
    //Retorna string com nome da peca
    /**
     * @Override
     * @return "Bispo"
     */
    public String getNome() {
        return "Bispo";
    }
    
    
    //Valida o movimento especifico da peca bispo nos limites do tabuleiro
    /**
     * @Override
     * @param posicao
     * @param captura
     */
    public boolean validaMovimento(Posicao posicao, boolean captura) {
        super.validaTabuleiroMaximo(posicao);
        
        int xOffset = this.posicao.x - posicao.x;
        int yOffset = this.posicao.y - posicao.y;
        if (Math.abs(xOffset) == Math.abs(yOffset))
        {
            return true;
        }
        return false;
    }
    
    
}
