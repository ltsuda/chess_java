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

    @Override
    public String getNome() {
        return "Peao";
    }

    @Override
    public boolean setPosicao(Posicao posicao) {
        if (posicao.x > 7 || posicao.y > 7 || posicao.x < 0 || posicao.y < 0) {
        return false;
        }
        
        switch (simbolo){
            case 'P':
            if (this.posicao.x == 1 &&
                (posicao.x - this.posicao.x == 1 ||
                posicao.x - this.posicao.x == 2) &&
                posicao.y == this.posicao.y &&
                captura == 0)
            {
                return true;
            }

            if (this.posicao.x < 7 &&
                posicao.x - this.posicao.x == 1 &&
                posicao.y == this.posicao.y &&
                captura == 0)
            {
                return true;
            }

            if (Math.abs(this.posicao.y - posicao.y) == 1 &&
                Math.abs(this.posicao.x - posicao.x) == 1 &&
                captura == 1)
            {
                return true;
            }
            break;

        case 'p':
            if (this.posicao.x == 6 &&
                (this.posicao.x - posicao.x == 1 ||
                 this.posicao.x - posicao.x == 2) &&
                posicao.y == this.posicao.y &&
                captura == 0)
            {
                return true;
            }

            if (this.posicao.x > 1 &&
                this.posicao.x - posicao.x == 1 &&
                posicao.y == this.posicao.y &&
                captura == 0)
            {
                return true;
            }

            if (Math.abs(this.posicao.y - posicao.y) == 1 &&
                Math.abs(this.posicao.x - posicao.x) == 1 &&
                captura == 1)
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
