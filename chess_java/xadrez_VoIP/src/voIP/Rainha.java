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
public class Rainha extends Peca{
    
    public String simboloRainha;
    public String nomeRainha;
    
    private void setSimbolo(String simboloRainha){
        simboloRainha = "r";
    }
    
    private void setNomeTorre(String nomeRainha){
        String newRainha;
        newRainha = simboloRainha.toUpperCase();
        if (newRainha.equals("T")){
            nomeRainha = simboloRainha;
        }
    }
    
    @Override
    public String getSimbolo() {
        return simboloRainha;
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
