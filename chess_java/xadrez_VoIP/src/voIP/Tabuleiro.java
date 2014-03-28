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
	private final  Peca[][] tabuleiro = new Peca[TAMANHO_TABULEIRO][TAMANHO_TABULEIRO];
	
        
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
        
//            public Movimento mover(Posicao origem, Posicao destino){
//         
//       if(tab.getCasa(origem) == null){
////       Nao tem que retornar mesangem que origem esta vazia ? comofaz
//           validado = false;
//           mensagem = "Nao existe peca na posicao de origem";
//           return movimento;
////       acho que o .brancas esta errado, 
////           so que nao sei como comparar tab.getCasa(destino).getSimbolo() com o simbolo de origem, 
////           eu tava comparando isso mas acho que ia comparar qual char era e nao o lado da peca (uppcase/lowercasse ou brancas = true/false).
//       } else if (tab.getCasa(destino) == null || tab.getCasa(destino).brancas != tab.getCasa(origem).brancas)
//       {
//           validado = true;
//       }
//       if(validado)
//       {
//           if (pecaM.setPosicao(origem) == true)
//           {
////               Criar instancia da classe movimento: Movimento moveOK = new Movimento(??????,??????)  )):
////               nao é asssim que move peca de origem para destino (?)
//               tab.setCasa(pecaM, destino);
//           }
//           validado = false;
//       }
////       Nao sei o que retornar porque nao instanciei a classe com as info validadas (nao entendi comofaz ;-;) consegue arrumar durante trampo?
//        return movimento;
//    }

	
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
