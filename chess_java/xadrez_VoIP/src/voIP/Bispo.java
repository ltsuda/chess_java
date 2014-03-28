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
        
        switch (simbolo){
            case 'b':
            case 'B':

                if (Math.abs(posicao.y - this.posicao.y) == Math.abs(posicao.x - this.posicao.x))
                {
                    return true;
                }
                break;
            default:
            break;
        }
    return false;
    }


}
