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
public class Peao extends Peca{

    public Peao(boolean brancas) {
        super(brancas);
    }
    
    Peao(boolean b, Posicao posicao) {
        super(b, posicao);
    }

    @Override
    public String getNome() {
        return "Peao";
    }

    @Override
    public boolean validaMovimento(Posicao posicao, boolean captura) {
        if (posicao.x > 7 || posicao.y > 7 || posicao.x < 0 || posicao.y < 0) {
        return false;
        }
        
        switch (simbolo){
            case 'P':
            if (this.posicao.y == 1 &&
                (posicao.y - this.posicao.y == 1 ||
                posicao.y - this.posicao.y == 2) &&
                posicao.x == this.posicao.x &&
                captura == false)
            {
                return true;
            }

            if (this.posicao.y < 7 &&
                posicao.y - this.posicao.y == 1 &&
                posicao.x == this.posicao.x &&
                captura == false)
            {
                return true;
            }

            if (Math.abs(this.posicao.x - posicao.x) == 1 &&
                Math.abs(this.posicao.y - posicao.y) == 1 &&
                captura == true)
            {
                return true;
            }
            break;

        case 'p':
            if (this.posicao.y == 6 &&
                (this.posicao.y - posicao.y == 1 ||
                 this.posicao.y - posicao.y == 2) &&
                posicao.x == this.posicao.x &&
                captura == false)
            {
                return true;
            }

            if (this.posicao.y > 1 &&
                this.posicao.y - posicao.y == 1 &&
                posicao.x == this.posicao.x &&
                captura == false)
            {
                return true;
            }

            if (Math.abs(this.posicao.x - posicao.x) == 1 &&
                Math.abs(this.posicao.y - posicao.y) == 1 &&
                captura == true)
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
            return 'p';
        }
        else {
            return 'P';
        }
    }
  
}
