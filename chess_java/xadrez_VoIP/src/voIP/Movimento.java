/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package voIP;

/**
 *
 * @author ltsuda
 */
public class Movimento {
    
    private boolean validado;
    private String mensagem;
    private Peca pecaM;
    private Tabuleiro tab;
    private Movimento movimento;
            
    
    public Movimento(boolean validado,String mensagem){
    }

    public boolean getValidado(){
        return validado;
    }
    
    public String getMensagem(){
        return mensagem;
    }
    
    public Movimento mover(Posicao origem, Posicao destino){
         
       if(tab.getCasa(origem) == null){
//       Nao tem que retornar mesangem que origem esta vazia ? comofaz
           validado = false;
           mensagem = "Nao existe peca na posicao de origem";
           return movimento;
//       acho que o .brancas esta errado, 
//           so que nao sei como comparar tab.getCasa(destino).getSimbolo() com o simbolo de origem, 
//           eu tava comparando isso mas acho que ia comparar qual char era e nao o lado da peca (uppcase/lowercasse ou brancas = true/false).
       } else if (tab.getCasa(destino) == null || tab.getCasa(destino).brancas != tab.getCasa(origem).brancas)
       {
           validado = true;
       }
       if(validado)
       {
           if (pecaM.setPosicao(origem) == true)
           {
//               Criar instancia da classe movimento: Movimento moveOK = new Movimento(??????,??????)  )):
//               nao é asssim que move peca de origem para destino (?)
               tab.setCasa(pecaM, destino);
           }
           validado = false;
       }
//       Nao sei o que retornar porque nao instanciei a classe com as info validadas (nao entendi comofaz ;-;) consegue arrumar durante trampo?
        return movimento;
    }

}
