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
	private Peca[][] tabuleiro = new Peca[TAMANHO_TABULEIRO][TAMANHO_TABULEIRO];
	
	// METODOS	
	/**
	 * Construtor de Tabuleiro. Recebe lista de pecas para serem posicionadas no tabuleiro.
	 * @param pecas
	 */
	public Tabuleiro(ArrayList<Peca> listaPecas) {
		for (int x = 0; x < TAMANHO_TABULEIRO; x++) {
			for (int y = 0; y < TAMANHO_TABULEIRO; y++) {
				tabuleiro[x][y] = null; 
			}
		}
		for (Peca p : listaPecas) {
			tabuleiro[p.getCoord_x()][p.getCoord_y()] = p;
		}
	}
	
	/**
	 * Retorna a peca na posicao (x,y) (coluna, linha) do tabuleiro
	 * @param x - coordenada x (coluna do tabuleiro: 0 - 8)
	 * @param y - coordenada y (linha do tabuleiro: 0 - 8)
	 * @return peca na posicao (x, y)
	 */
	public Peca getCasa(int x, int y){ 
		return tabuleiro[x][y];
	}
	
	/**
	 * coloca uma Peca na casa indicada.
	 * @param x - coordenada x (coluna do tabuleiro: 0 - 8)
	 * @param y - coordenada y (linha do tabuleiro: 0 - 8)
	 * @return peca na posicao (x, y)
	 */
	public void setCasa(Peca peca, int x, int y){
		tabuleiro[x][y] = peca;
	}
	
	/**
	 * M�todo que redesenha o estado atual do tabuleiro. � respons�vel pelo desenho da tabela 
	 * presente no desenho da interface, na imagem acima.
	 */
	public void draw() {
   		// Linhas:
		for(int i = 0; i < TAMANHO_TABULEIRO; i++){
    		System.out.println("  |---|---|---|---|---|---|---|---|"); 
    		System.out.print(TAMANHO_TABULEIRO - i + " |");

    		// Colunas:
   			for(int j = 0; j < TAMANHO_TABULEIRO; j++){
        			if(getCasa(i, j) == null)
            			System.out.print("   |");
        			else
            			System.out.print(" " + getCasa(i,j).getSimbolo() + " |");
    		}
			System.out.println("");
		}
		System.out.println("  |---|---|---|---|---|---|---|---|");
		System.out.println("    A   B   C   D   E   F   G   H  \n");
		System.out.println("CMD: ");
	}
}
