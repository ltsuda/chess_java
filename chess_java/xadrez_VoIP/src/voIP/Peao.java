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
    
    public String simboloPeao;
    public String nomePeao;
    
    private void setSimbolo(String simboloPeao){
        simboloPeao = "r";
    }
    
    private void setNomeTorre(String nomePeao){
        String newPeao;
        newPeao = simboloPeao.toUpperCase();
        if (newPeao.equals("T")){
            nomePeao = simboloPeao;
        }
    }
    
    @Override
    public String getSimbolo() {
        return simboloPeao;
    }
    
    @Override
    public String getNome() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean setPosicao(Posicao posicao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
