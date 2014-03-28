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
        protected Posicao posicao;
	protected char simbolo;
        protected String nome;
        protected boolean brancas;
      
        public Peca(boolean brancas){
        };

        public  Posicao getPosicao(){
            return posicao;
        }
        
        public abstract String getNome();
      
        public abstract boolean setPosicao(Posicao posicao);
        
	public abstract char getSimbolo();
}

