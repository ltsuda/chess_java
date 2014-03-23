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

    @Override
    public String getNome() {
        return "Rainha";
    }

    @Override
    public boolean setPosicao(Posicao posicao) {
        if (posicao.x > 7 || posicao.y > 7 || posicao.x < 0 || posicao.y < 0) {
        return false;
        }
        
        switch (simbolo){
            case 'q':
            case 'Q':
                if (((Math.abs(posicao.y - this.posicao.y) == 0 || Math.abs(posicao.x - this.posicao.x) == 0)) 
                    || (Math.abs(posicao.y - this.posicao.y) == Math.abs(posicao.x - this.posicao.x)))
                {
                    return true;
                }
                break;
            default:
            break;
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
