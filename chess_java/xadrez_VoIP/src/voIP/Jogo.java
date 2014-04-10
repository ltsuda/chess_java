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
import java.util.*;

/**
 * Classe que armazena o estado do jogo em andamento
 */

public final class Jogo {

	// ATRIBUTOS 
	// <adicione, remova ou altere os atributos de acordo com o criterio do grupo>
	
	// Lista de pecas
//	private final ArrayList<Peca> listaPecas;
	
	// Tabuleiro do jogo
	private final Tabuleiro tabuleiro;
	
	// Jogada em andamento
	// <use um atributo para armazenar a jogada atual>
	
	// Turno: pretas ou brancas
	// <Use um atributo de Jogo para controlar a vez da jogada> 

	// Mensagem: forma estruturada para enviar mensagens ao display
	// <a sugestao e ter uma classe para representar uma mensagem - a estrutura deve ser definida>
	
	// Entrada de comando
	private final Scanner leitor = new Scanner(System.in);
        private boolean brancas = true;
        private boolean finalizado = false;
        private String mensagem = "";
	
	//METODOS
	
	//Construtor
	//Jogo() - instancia/inicializa uma nova estrutura Jogo
	//		 - cria pecas e tabuleiro
	/**
	 * Construtor padrao da classe Jogo
	 */
	public Jogo(){
		
		// 1. Criar as pecas do Jogo e coloca-las na lista
		// 2. Inicializar Tabuleiro 
		tabuleiro = new Tabuleiro(criaPecasPadrao());
		// 3. Imprimir a interface inicial do Jogo
		// 4. Ficar pronto para receber comandos
		loopJogo();
	}
        
        public ArrayList criaPecasPadrao()
        {
            ArrayList<Peca> pecas = new ArrayList<>();
            
            pecas.add(new Bispo(true, new Posicao(3, 0)));
            pecas.add(new Bispo(true, new Posicao(4, 0)));
            pecas.add(new Bispo(false, new Posicao(3, 7)));
            pecas.add(new Bispo(false, new Posicao(5, 7)));
            pecas.add(new Rei(false, new Posicao(6, 7)));
            
            return pecas;
        }
	
	/**
	 * Metodo que implementa o loop principal do Jogo
	 */
	public void loopJogo() {
		do {
			// 1. Redesenha a interface
			display();
			// 2. Recebe e trata comandos do usuario
			executaJogada();
		} while(!this.finalizado);
                
                String gameOver = "As pecas " + (!brancas ? "brancas" : "pretas") + " ganharam!";
                System.out.println(gameOver);
	}
	
	/**
	 *  Desenha a interface do Jogo
	 */
	private void display() {
		System.out.println("\n\t      TABULEIRO\n");
		tabuleiro.draw();
                mensagem += "\nExecute o movimento das pecas " + (brancas ? "brancas" : "pretas");
                System.out.println(mensagem);
	}
        
        private Posicao[] parseMovimentoString(String movimento)
        {
                String move = movimento.toLowerCase();
                String row = "abcdefgh";
		String column = "87654321";
		int x1 = row.indexOf(move.charAt(0));
		int y1 = column.indexOf(move.charAt(1));
		int x2 = row.indexOf(move.charAt(2));
		int y2 = column.indexOf(move.charAt(3));
                Posicao[] posicoes = new Posicao[2];
                posicoes[0] = new Posicao(x1, y1);
                posicoes[1] = new Posicao(x2, y2);
                return posicoes;
        }
                
	
	/**
	 * Trata os comandos enviados pelos jogadores.
	 */
	private void executaJogada() {
		// Entre outras coisas, este método deve:
		// 1. Verificar se as coordenadas são válidas.
		// 2. Verificar se existe uma peça na coordenada de origem;
		// 3. Verificar se a cor da peça corresponde à vez da jogada;
		// 4. Realizar a movimentação da peça no tabuleiro;
		// 5. Verificar se existe peça na posição destino: 
		//    - Se for do adversário, registrar a captura;
		//    - Se for do próprio jogador, impedir a jogada.
            
                String move = leitor.nextLine();
                if (validaStringMovimento(move))
                {
                    Posicao[] movimento = parseMovimentoString(move);
                    Movimento movMsg = tabuleiro.mover(movimento[0], movimento[1], brancas);
                    brancas = movMsg.getValidado() ? !brancas : brancas;
                    mensagem = movMsg.getMensagem();
                    this.finalizado = movMsg.fim;
                }
                else
                {
                    mensagem = "Movimento invalido, exemplo correto: b1b5";
                }
                
	}
        
        private boolean validaStringMovimento(String move)
        {
            boolean valid = false;
            if (move.length() == 4)
            {
                String row = "abcdefgh";
		String column = "87654321";
		int x1 = row.indexOf(move.charAt(0));
		int y1 = column.indexOf(move.charAt(1));
		int x2 = row.indexOf(move.charAt(2));
		int y2 = column.indexOf(move.charAt(3));
                valid = (x1 != -1 && y1 != -1 && x2 != -1 && y2 != -1);
            }
            return valid;
        }
}
