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
public class Cavalo extends Peca{

    public String simboloCavalo;
    public String nomeCavalo;
    
    private void setSimbolo(String simboloCavalo){
        simboloCavalo = "r";
    }
    
    private void setNomeTorre(String nomeCavalo){
        String newCavalo;
        newCavalo = simboloCavalo.toUpperCase();
        if (newCavalo.equals("T")){
            nomeCavalo = simboloCavalo;
        }
    }
    
    @Override
    public String getSimbolo() {
        return simboloCavalo;
    }
    @Override
    public String getNome() {
        return nomeCavalo;
    }

    @Override
    public boolean setPosicao(Posicao posicao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    
}
