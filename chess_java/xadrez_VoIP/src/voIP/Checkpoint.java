/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package voIP;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author christian
 */
public class Checkpoint implements Serializable {

    public ArrayList<Peca> getPecas() {
        return pecas;
    }

    public boolean isBrancas() {
        return brancas;
    }
    
    private ArrayList<Peca> pecas;
    private boolean brancas;
    
    public Checkpoint(ArrayList<Peca> pecas, boolean brancas)
    {
        this.pecas = pecas;
        this.brancas = brancas;
    }
    
}
