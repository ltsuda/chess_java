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
public class Bispo extends Peca{

    public Bispo(boolean brancas) {
        super(brancas);
    }

    Bispo(boolean b, Posicao posicao) {
        super(b, posicao);
    }


    @Override
    public char getSimbolo() {
        if (this.brancas == true){
            return 'b';
        }
        else{
            return 'B';
        }
    }
    
     @Override
    public String getNome() {
        return "Bispo";
    }
    

    @Override
    public boolean validaMovimento(Posicao posicao, boolean captura) {

        if (posicao.x > 7 || posicao.y > 7 || posicao.x < 0 || posicao.y < 0) {
        return false;
        }
        
        int xOffset = this.posicao.x - posicao.x;
        int yOffset = this.posicao.y - posicao.y;
        if (Math.abs(xOffset) == Math.abs(yOffset))
        {
            return true;
        }
    return false;
    }


}
