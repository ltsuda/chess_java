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
	private  Peca[][] tabuleiro = new Peca[TAMANHO_TABULEIRO][TAMANHO_TABULEIRO];
	
        private Posicao posT;
        
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
	public void setCasa(Peca peca, Posicao posPeca){
		tabuleiro[posPeca.x][posPeca.y] = peca;
	}
	
	/**
	 * M�todo que redesenha o estado atual do tabuleiro. � respons�vel pelo desenho da tabela 
	 * presente no desenho da interface, na imagem acima.
	 */
	public void draw() {
                
               
                // Linhas:
		for(int x = 0; x < TAMANHO_TABULEIRO; x++){
    		System.out.println("  |---|---|---|---|---|---|---|---|"); 
    		System.out.print(TAMANHO_TABULEIRO - x + " |");

    		// Colunas:
   			for(int y = 0; y < TAMANHO_TABULEIRO; y++){
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
