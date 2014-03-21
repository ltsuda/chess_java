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

public class Jogo {

	// ATRIBUTOS 
	// <adicione, remova ou altere os atributos de acordo com o criterio do grupo>
	
	// Lista de pecas
	private ArrayList<Peca> listaPecas = new ArrayList<Peca>();
	
	// Tabuleiro do jogo
	private Tabuleiro tabuleiro;
	
	// Jogada em andamento
	// <use um atributo para armazenar a jogada atual>
	
	// Turno: pretas ou brancas
	// <Use um atributo de Jogo para controlar a vez da jogada> 

	// Mensagem: forma estruturada para enviar mensagens ao display
	// <a sugestao e ter uma classe para representar uma mensagem - a estrutura deve ser definida>
	private Mensagem mensagem = new Mensagem();
	
	// Entrada de comando
	private Scanner leitor = new Scanner(System.in);
	
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
		tabuleiro = new Tabuleiro(listaPecas);
		// 3. Imprimir a interface inicial do Jogo
		// 4. Ficar pronto para receber comandos
		loopJogo();
	}
	
	/**
	 * Metodo que implementa o loop principal do Jogo
	 * @param arquivo
	 */
	public void loopJogo() {
		boolean terminar = false;
		do {
			// 1. Redesenha a interface
			display();
			// 2. Recebe e trata comandos do usuario
			executaJogada();
		} while(terminar);
	}
	
	/**
	 *  Desenha a interface do Jogo
	 */
	private void display() {
		System.out.println("\n\t      TABULEIRO\n");
		tabuleiro.draw();
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
	}
}
