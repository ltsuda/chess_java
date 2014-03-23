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
public class Torre extends Peca {

    public Torre(boolean brancas) {
        super(brancas);
    }


    @Override
    public char getSimbolo() {
        if (this.brancas == true){
            return 't';
        }
        else{
            return 'T';
        }
    }
    
     @Override
    public String getNome() {
        return "Torre";
    }
    

    @Override
    public boolean setPosicao(Posicao posicao) {

        if (posicao.x > 7 || posicao.y > 7 || posicao.x < 0 || posicao.y < 0) {
        return false;
        }
        
        switch (simbolo){
            case 't':
            case 'T':

                if (Math.abs(posicao.y - this.posicao.y) == 0 || Math.abs(posicao.x - this.posicao.x) == 0)
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
