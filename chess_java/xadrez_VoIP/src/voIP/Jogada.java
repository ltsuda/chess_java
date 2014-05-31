/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package voIP;

/**
 *
 * @author christian
 */
public class Jogada {

    public Peca getPecaMovida() {
        return pecaMovida;
    }

    public Peca getPecaCapturada() {
        return pecaCapturada;
    }

    public Posicao getOrigem() {
        return origem;
    }

    public Posicao getDestino() {
        return destino;
    }
    
    private Peca pecaMovida, pecaCapturada;
    private Posicao origem, destino;
    
    public Jogada(Peca pecaMovida, Peca pecaCapturada, Posicao origem, Posicao destino)
    {
        this.pecaMovida = pecaMovida;
        this.pecaCapturada = pecaCapturada;
        this.origem = origem;
        this.destino = destino;
    }
    
    
}
