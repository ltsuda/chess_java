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
public class Rei extends Peca{
       
    public String simboloRei;
    public String nomeRei;
    
    private void setSimbolo(String simboloRei){
        simboloRei = "r";
    }
    
    private void setNomeTorre(String nomeRei){
        String newRei;
        newRei = simboloRei.toUpperCase();
        if (newRei.equals("T")){
            nomeRei = simboloRei;
        }
    }
    
    @Override
    public String getNome() {
        return nomeRei;
    }
    
    @Override
    public String getSimbolo() {
        return simboloRei;
    }


    @Override
    public boolean setPosicao(Posicao posicao) {
        // PORQUEEEEE QUE FALA QUE EH REDUNDANTE ?
        if (posicao.x > 7 || posicao.y > 7 || posicao.x < 0 || posicao.y < 0) {
        return false;
        }
        return true;
    }



}
