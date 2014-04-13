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

public class Cavalo extends Peca{
    
    //Cria construtor Cavalo com parametros boolean b e Posicao posicao
    /**
     * @param b
     * @param posicao
     */
    Cavalo(boolean b, Posicao posicao) {
        super(b, posicao);
    }
    
    //Retorna string com nome da peca
    /**
     * @Override
     * @return "Cavalo"
     */
    public String getNome() {
        return "Cavalo";
    }
    
    //Valida o movimento especifico da peca cavalo nos limites do tabuleiro
    /**
     * @Override
     * @param posicao
     * @param captura
     */
    public boolean validaMovimento(Posicao posicao, boolean captura) {
        super.validaTabuleiroMaximo(posicao);
        
        if ((Math.abs(this.posicao.y - posicao.y) == 1 && Math.abs(this.posicao.x - posicao.x) == 2)
                || (Math.abs(this.posicao.y - posicao.y) == 2 && Math.abs(this.posicao.x - posicao.x) == 1))
        {
            return true;
        }
        return false;
    }
    
    //Retorna o simbolo de acordo com o lado da peca, branca ou preta (branca = false)
    /**
     * @Override
     * @return 'h' or 'H'
     */
    public char getSimbolo() {
        if (this.brancas == true){
            return 'h';
        }
        else {
            return 'H';
        }
    }
    
}
