/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package voIP;

/**
 *
 * @author leonardohenriquetsuda
 */
import java.util.ArrayList;
 
public class Tabuleiro {
	
	// ATRITUTOS
	public final int TAMANHO_TABULEIRO = 8;
	// Matriz 8x8 de Pecas
	private final   Peca[][] tabuleiro = new Peca[TAMANHO_TABULEIRO][TAMANHO_TABULEIRO];
	        
       
	// METODOS	
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
	
	/**
	 * Retorna a peca na posicao (x,y) (coluna, linha) do tabuleiro
         * @param pos
	 * @return peca na posicao (x, y)
	 */
	public Peca getCasa(Posicao pos){ 
		return tabuleiro[pos.x][pos.y];
	}
	
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
	 * Método que redesenha o estado atual do tabuleiro. � respons�vel pelo desenho da tabela 
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
