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
 * Classe que armazena as caracteristicas e o estado do Tabuleiro
 */

import java.util.ArrayList;
 
public class Tabuleiro {
	
	//Atributos
	public final int TAMANHO_TABULEIRO = 8;
	
	// Matriz 8x8 de Pecas
	private final   Peca[][] tabuleiro = new Peca[TAMANHO_TABULEIRO][TAMANHO_TABULEIRO];
	        
       	
	/**
	 * Construtor de Tabuleiro. Recebe lista de pecas para serem posicionadas no tabuleiro.
     * @param listaPecas
	 */
	public Tabuleiro(ArrayList<Peca> listaPecas) {
		for (int x = 0; x < TAMANHO_TABULEIRO; x++) {
			for (int y = 0; y < TAMANHO_TABULEIRO; y++) {
				tabuleiro[x][y] = null; 
			}
		}
		for (Peca p : listaPecas) {
			tabuleiro[p.getPosicao().x][p.getPosicao().y] = p;
		}
	}
	
	//Metodo que retorna a peca na posicao do tabuleiro
	/**
	 * Retorna a peca na posicao (x,y) do tabuleiro
     * @param pos
	 * @return peca na posicao (x, y)
	 */
	public Peca getCasa(Posicao pos){ 
		return tabuleiro[pos.x][pos.y];
	}
	
	//Metodo que seta a peca em uma posicao (casa) no tabuleiro
	/**
	 * coloca uma Peca na casa indicada.
     * @param peca
     * @param posPeca
	 */
	public void setCasa(Peca peca, Posicao posPeca)
        {	
            tabuleiro[posPeca.x][posPeca.y] = peca;
            if (peca != null) peca.setPosicao(posPeca);
	}
        
    /*Metodo que implementa a validacao dos movimentos, recebendo a posicao de origem, destino e variavel brancas para auxiliar a identificar o lado branco e preto
     * - Verifica se existe peca na origem do movimento e retorna mensagem se nao existir peca na origem
     * - Verifica se que existe peca no destino e se for do mesmo lado, retorna mensagem se a peca for do mesmo lado
     * - Verifica se a peca de origem pode realizar o movimento requisitado ou nao e retorna mensagem se o movimento for falso
     * - Verifica que a peca requisitada para movimentar nao eh do lado do peca atual e retorna mensagem
     * - Verifica se o movimento que nao existe peca no destino, move a peca e retorna mensagem informando que moveu
     * - Verifica se a peca destino existe, se o movimento eh validado e realiza a captura da peca, se for a peca Rei, retorna para finalizar o jogo
     */
	/**
     * Implementa verificacao dos movimentos validos
     * @param origem
     * @param destino
     * @param brancas
     * @return mov
     */
	public Movimento mover(Posicao origem, Posicao destino, boolean brancas) 
     {
        Peca pecaOrigem = this.getCasa(origem);
        Peca pecaDestino = this.getCasa(destino);

        Movimento mov = null;
        if (pecaOrigem == null) 
        {
            mov = new Movimento(false, "Nāo existe peça na origem");
        } 
        else if (pecaDestino != null && pecaDestino.branca() == pecaOrigem.branca()) 
        {
            mov = new Movimento(false, "A peça de destino é uma peça do mesmo lado");
            return mov;
        } 
        else if (pecaOrigem.validaMovimento(destino, false) == false)
        {
            mov = new Movimento(false, "A peça escolhida nāo realiza esse movimento");
        }
        else if (brancas != pecaOrigem.branca())
        {
           mov = new Movimento(false, "A peça escolhida não é sua.");

        }
        else if (pecaDestino == null)
        {
            mov = new Movimento(true, "Peca movida.");
            this.setCasa(pecaOrigem, destino);
            this.setCasa(null, origem);
        }
        else if (pecaDestino != null && pecaOrigem.validaMovimento(destino, true))
        {
            mov = new Movimento(true, "A peca \"" + pecaDestino.getSimbolo() + "\" foi capturada.");
            this.setCasa(pecaOrigem, destino);
            this.setCasa(null, origem);
            mov.fim = pecaDestino.getNome().equals("Rei");
        }
        return mov;
    }

	/**
	 * Método que redesenha o estado atual do tabuleiro. É responsavel pelo desenho da tabela 
	 * presente no desenho da interface, na imagem acima.
	 */
	public void draw() {
               
                // Linhas:
		for(int x = 0; x < TAMANHO_TABULEIRO; x++){
    		System.out.println("  |---|---|---|---|---|---|---|---|"); 
    		System.out.print(TAMANHO_TABULEIRO - x + " |");

    		// Colunas:
   			for(int y = 0; y < TAMANHO_TABULEIRO; y++){
                                Posicao posT = new Posicao(y, x);    

        			if(getCasa(posT) == null)
            			System.out.print("   |");
        			else
            			System.out.print(" " + getCasa(posT).getSimbolo() + " |");
    		}
			System.out.println("");
		}
		System.out.println("  |---|---|---|---|---|---|---|---|");
		System.out.println("    A   B   C   D   E   F   G   H  \n");
		System.out.println("CMD: ");
	}
}
