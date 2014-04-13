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
 * Classe com atributos/metodos de auxilio do uso de posicoes do jogo
 */
public class Posicao {
    
    //Atributos de posicao x e y
    public int x;
    public int y;
    
    //Metodo que recebe dois parametros int e atribui aos atributos x e y para auxiliar no uso da Posicao das pecas e casas do tabuleiro no jogo
    /**
     * @param mX
     * @param mY
     */
    public Posicao(int mX, int mY){
        x = mX;
        y = mY;
    }
    
}
