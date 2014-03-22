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
    
    public String simboloBispo;
    public String nomeBispo;
    
    private void setSimbolo(String simboloBispo){
        simboloBispo = "r";
    }
    
    private void setNomeTorre(String nomeBispo){
        String newSimbolo;
        newSimbolo = simboloBispo.toUpperCase();
        if (newSimbolo.equals("T")){
            nomeBispo = simboloBispo;
        }
    }
    
    @Override
    public String getSimbolo() {
        return simboloBispo;
    }
    
    @Override
    public String getNome() {
        return nomeBispo;
    }

    @Override
    public boolean setPosicao(Posicao posicao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
