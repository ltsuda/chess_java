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
public class Rainha extends Peca{

    public Rainha(boolean brancas) {
        super(brancas);
    }

    Rainha(boolean b, Posicao posicao) {
        super(b, posicao);
    }

    @Override
    public String getNome() {
        return "Rainha";
    }

    @Override
    public boolean validaMovimento(Posicao posicao, boolean captura) {
        if (posicao.x > 7 || posicao.y > 7 || posicao.x < 0 || posicao.y < 0) {
        return false;
        }
        
        if (((Math.abs(this.posicao.y - posicao.y) == 0 || Math.abs(this.posicao.x - posicao.x) == 0)) 
                    || (this.posicao.y - posicao.y) == Math.abs(this.posicao.x - posicao.x))
        {
                    return true;
        }

    return false;
    }

    @Override
    public char getSimbolo() {
        if (this.brancas == true){
            return 'q';
        }
        else {
            return 'Q';
        }
    }
  
}
