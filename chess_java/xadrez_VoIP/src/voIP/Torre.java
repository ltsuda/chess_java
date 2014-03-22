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
    
    public String simboloTorre;
    public String nomeTorre;
    
    private void setSimbolo(String simboloTorre){
        simboloTorre = "t";
    }
    
    private void setNomeTorre(String nomeTorre){
        String newTorre;
        newTorre = simboloTorre.toUpperCase();
        if (newTorre.equals("T")){
            nomeTorre = simboloTorre;
        }
    }
    @Override
    public String getNome() {
        return nomeTorre;
    }

    @Override
    public String getSimbolo() {
        return simboloTorre;
    }
    
    @Override
    public boolean setPosicao(Posicao posicao) {
        // PORQUEEEEE QUE FALA QUE EH REDUNDANTE ?
        if (posicao.x > 7 || posicao.y > 7 || posicao.x < 0 || posicao.y < 0) {
        return false;
        }
        
//        switch (simbolo){
//            case 't':
//            case 'T':
//                Aqui ele verifica a posicao destino - origem, mas eu so tenho origem... ou nao ?
//                if (Math.abs(posicao.y - ))
//        }
//        
    return true;
    }
}
