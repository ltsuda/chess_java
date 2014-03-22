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
public abstract class Peca {
        private Posicao posicao;
//      Precisa dos atributos ? nao vai ser usado criado direto em cada subClasse?
//	private String simbolo;
//      private String nome;
      
        public  Posicao getPosicao(){
            return posicao;
        }
        
        public abstract String getNome();
      
        public abstract boolean setPosicao(Posicao posicao);
        

	public abstract String getSimbolo();
}

