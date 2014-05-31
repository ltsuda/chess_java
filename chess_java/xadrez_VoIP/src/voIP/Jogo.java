package voIP;

/*
*Projeto: Jogo de Xadrez
*Disciplina: Estrutura de Dados 5o Semestre
*Grupo: VoIP
*Integrantes:
* -	Cassio Otavio Ferreira Perbelini Castilho
* -	Cesar Martins
* -	Felipe Batista Suardi
* -	Jaqueline Campaci Silva
* -	Leonardo Henrique Tsuda
* -	Murilo Nata Komirchuk de Jesus
*/

import java.util.*;

/**
 * Classe que armazena o estado do jogo em andamento
 */

public final class Jogo {
    
    //ATRIBUTOS
    
    // Tabuleiro do jogo
    private final Tabuleiro tabuleiro;
    
    private final ArrayList<Peca> pecas = new ArrayList<>();
    private final ArrayList<Jogada> jogadas = new ArrayList<>();

    
    // Entrada de comando
    private final Scanner leitor = new Scanner(System.in);
    private boolean brancas = true;
    private boolean finalizado = false;
    private String mensagem = "";
    private final String row = "abcdefgh";
    private final String column = "87654321";
    
    //METODOS
    
    //Jogo() - instancia/inicializa uma nova estrutura Jogo
    //		 - cria pecas e tabuleiro
    /**
     * Construtor padrao da classe Jogo
     */
    public Jogo(){
        
        //Inicializa Tabuleiro
        tabuleiro = new Tabuleiro(criaPecasPadrao());
        loopJogo();
    }
    
    //Cria as pecas do Jogo e coloca-las na lista
    public ArrayList<Peca> criaPecasPadrao()
    {
        //true = brancas, false = pretas
        pecas.add(new Torre(false, new Posicao(0, 0)));
        pecas.add(new Torre(false, new Posicao(7, 0)));
        pecas.add(new Torre(true, new Posicao(0, 7)));
        pecas.add(new Torre(true, new Posicao(7, 7)));
        pecas.add(new Bispo(false, new Posicao(2, 0)));
        pecas.add(new Bispo(false, new Posicao(5, 0)));
        pecas.add(new Bispo(true, new Posicao(2, 7)));
        pecas.add(new Bispo(true, new Posicao(5, 7)));
        pecas.add(new Rei(false, new Posicao(4, 0)));
        pecas.add(new Rei(true, new Posicao(4, 7)));
        pecas.add(new Rainha(false, new Posicao(3, 0)));
        pecas.add(new Rainha(true, new Posicao(3, 7)));
        pecas.add(new Cavalo(false, new Posicao(1, 0)));
        pecas.add(new Cavalo(false, new Posicao(6, 0)));
        pecas.add(new Cavalo(true, new Posicao(1, 7)));
        pecas.add(new Cavalo(true, new Posicao(6, 7)));
        pecas.add(new Peao(false, new Posicao(0, 1)));
        pecas.add(new Peao(false, new Posicao(1, 1)));
        pecas.add(new Peao(false, new Posicao(2, 1)));
        pecas.add(new Peao(false, new Posicao(3, 1)));
        pecas.add(new Peao(false, new Posicao(4, 1)));
        pecas.add(new Peao(false, new Posicao(5, 1)));
        pecas.add(new Peao(false, new Posicao(6, 1)));
        pecas.add(new Peao(false, new Posicao(7, 1)));
        pecas.add(new Peao(true, new Posicao(0, 6)));
        pecas.add(new Peao(true, new Posicao(1, 6)));
        pecas.add(new Peao(true, new Posicao(2, 6)));
        pecas.add(new Peao(true, new Posicao(3, 6)));
        pecas.add(new Peao(true, new Posicao(4, 6)));
        pecas.add(new Peao(true, new Posicao(5, 6)));
        pecas.add(new Peao(true, new Posicao(6, 6)));
        pecas.add(new Peao(true, new Posicao(7, 6)));
        
        return pecas;
    }
    
    /**
     * Metodo que implementa o loop principal do Jogo
     */
    public void loopJogo() {
        do {
            //Redesenha a interface
            display();
            //Recebe e trata comandos do usuario
            executaJogada();
        } while(!this.finalizado);
        System.out.println("\n\t      TABULEIRO\n");
        tabuleiro.draw();
        String gameOver = "As pecas " + (!brancas ? "brancas" : "pretas") + " ganharam!";
        System.out.println(gameOver);
    }
    
    //Imprimi a interface inicial do Jogo
    /**
     *  Desenha a interface do Jogo
     */
    private void display() {
        System.out.println("\n\t      TABULEIRO\n");
        tabuleiro.draw();
        mensagem += "\nExecute o movimento das pecas " + (brancas ? "brancas " : "pretas ") +  "(ex: a2a4)";
        System.out.println(mensagem);
    }
    
    /**
     * Realiza parse do comando de entrada para string e valida a string
     * @param movimento
     * @return
     */
    private Posicao[] parseMovimentoString(String movimento, boolean valid)
    {
        do {
            if (movimento.length() == 4){
                int x1 = row.indexOf(movimento.charAt(0));
                int y1 = column.indexOf(movimento.charAt(1));
                int x2 = row.indexOf(movimento.charAt(2));
                int y2 = column.indexOf(movimento.charAt(3));
                valid = (x1 != -1 && y1 != -1 && x2 != -1 && y2 != -1);
                
                if (valid){
                    String move = movimento.toLowerCase();
                    Posicao[] posicoes = new Posicao[2];
                    posicoes[0] = new Posicao(x1,y1);
                    posicoes[1] = new Posicao(x2,y2);
                    return posicoes;
                }
            }
            return null;
        } while (valid == false);
    }
    
    /**
     * Trata os comandos enviados pelos jogadores.
     */
    private void executaJogada() {
        
        String move = leitor.nextLine();
        if (move.compareToIgnoreCase("undo") == 0 && jogadas.size() > 0)
        {
            int index = jogadas.size() - 1;
            tabuleiro.desfazerJogada(jogadas.get(index));
            jogadas.remove(index);
            brancas = !brancas;
            mensagem = "Jogada desfeita.";
        }
        else if (parseMovimentoString(move, false) != null)
        {
            Posicao[] movimento = parseMovimentoString(move, false);
            Peca pecaMovida = tabuleiro.getCasa(movimento[0]);
            Peca pecaCapturada = tabuleiro.getCasa(movimento[1]);
            Movimento movMsg = tabuleiro.mover(movimento[0], movimento[1], brancas);
            if (movMsg.getValidado())
            {
                Jogada jogada = new Jogada(pecaMovida, pecaCapturada, movimento[0], movimento[1]);
                jogadas.add(jogada);
            }
            brancas = movMsg.getValidado() ? !brancas : brancas;
            mensagem = movMsg.getMensagem();
            this.finalizado = movMsg.fim;
        }
        else
        {
            mensagem = "Movimento invalido, exemplo correto: b1b5";
        }
        
    }
    
}
