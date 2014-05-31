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

/**
 * Classe que armazena as caracteristicas e o estado do Tabuleiro
 */

import java.util.ArrayList;

public class Tabuleiro {
    
    //Atributos
    public final int TAMANHO_TABULEIRO = 8;
    
    // Matriz 8x8 de Pecas
    private final Peca[][] tabuleiro = new Peca[TAMANHO_TABULEIRO][TAMANHO_TABULEIRO];
    
    /**
     * Construtor de Tabuleiro. Recebe lista de pecas para serem posicionadas no tabuleiro.
     * @param listaPecas
     */
    public Tabuleiro(ArrayList<Peca> listaPecas) {
        for (int x = 0; x < TAMANHO_TABULEIRO; x++) {
            for (int y = 0; y < TAMANHO_TABULEIRO; y++) {
                tabuleiro[x][y] = null;
            }
        }
        for (Peca p : listaPecas) {
            tabuleiro[p.getPosicao().x][p.getPosicao().y] = p;
        }
    }
    
    //Metodo que retorna a peca na posicao do tabuleiro
    /**
     * Retorna a peca na posicao (x,y) do tabuleiro
     * @param pos
     * @return peca na posicao (x, y)
     */
    public Peca getCasa(Posicao pos){
        return tabuleiro[pos.x][pos.y];
    }
    
    //Metodo que seta a peca em uma posicao (casa) no tabuleiro
    /**
     * coloca uma Peca na casa indicada.
     * @param peca
     * @param posPeca
     */
    public void setCasa(Peca peca, Posicao posPeca)
    {
        tabuleiro[posPeca.x][posPeca.y] = peca;
        if (peca != null) peca.setPosicao(posPeca);
    }
    
    public void desfazerJogada(Jogada jogada)
    {
        this.setCasa(jogada.getPecaMovida(), jogada.getOrigem());
        this.setCasa(jogada.getPecaCapturada(), jogada.getDestino());
    }
    
    //Metodo que implementa a validacao dos movimentos, recebendo a posicao de origem, destino e variavel brancas para auxiliar a identificar o lado branco e preto
    /**
     * Implementa verificacao dos movimentos validos
     * @param origem
     * @param destino
     * @param brancas
     * @return mov
     */
/*Metodo que implementa a validacao dos movimentos, recebendo a posicao de origem, destino e variavel brancas para auxiliar a identificar o lado branco e preto
     * - Verifica se existe peca na origem do movimento e retorna mensagem se nao existir peca na origem
     * - Verifica se que existe peca no destino e se for do mesmo lado, retorna mensagem se a peca for do mesmo lado
     * - Verifica se a peca de origem pode realizar o movimento requisitado ou nao e retorna mensagem se o movimento for falso
     * - Verifica que a peca requisitada para movimentar nao eh do lado do peca atual e retorna mensagem
     * - Verifica se o movimento que nao existe peca no destino, move a peca e retorna mensagem informando que moveu
     * - Verifica se a peca destino existe, se o movimento eh validado e realiza a captura da peca, se for a peca Rei, retorna para finalizar o jogo
     */
	/**
     * Implementa verificacao dos movimentos validos
     * @param origem
     * @param destino
     * @param brancas
     * @return mov
     */
	public Movimento mover(Posicao origem, Posicao destino, boolean brancas) 
     {
        Peca pecaOrigem = this.getCasa(origem);
        Peca pecaDestino = this.getCasa(destino);
        boolean captura = pecaDestino != null && pecaOrigem != null && pecaDestino.branca() != pecaOrigem.branca();

        Movimento mov = null;
        if (pecaOrigem == null) 
        {
            mov = new Movimento(false, "Nāo existe peça na origem");
        }
        else if (this.existePecaNoCaminho(origem, destino))
        {
            mov = new Movimento(false, "Existe peca no caminho.");
            return mov;
        }
        else if (pecaDestino != null && pecaDestino.branca() == pecaOrigem.branca()) 
        {
            mov = new Movimento(false, "A peça de destino é uma peça do mesmo lado");
            return mov;
        } 
        else if (pecaOrigem.validaMovimento(destino, captura) == false)
        {
            mov = new Movimento(false, "A peça escolhida nāo realiza esse movimento");
        }
        else if (brancas != pecaOrigem.branca())
        {
           mov = new Movimento(false, "A peça escolhida não é sua.");

        }
        else if (pecaDestino == null)
        {
            mov = new Movimento(true, "Peca movida.");
            this.setCasa(pecaOrigem, destino);
            this.setCasa(null, origem);
        }
        else if (pecaOrigem.validaMovimento(destino, true))
        {
            mov = new Movimento(true, "A peca \"" + pecaDestino.getSimbolo() + "\" foi capturada.");
            this.setCasa(pecaOrigem, destino);
            this.setCasa(null, origem);
            mov.fim = pecaDestino.getNome().equals("Rei");
        }
        return mov;
    }

    
    /**
     * Metodo que redesenha o estado atual do tabuleiro. Eh responsavel pelo desenho da tabela
     * presente no desenho da interface, na imagem acima.
     */
    public void draw() {
        
        // Linhas:
        for(int x = 0; x < TAMANHO_TABULEIRO; x++){
            System.out.println("  |---|---|---|---|---|---|---|---|");
            System.out.print(TAMANHO_TABULEIRO - x + " |");
            
            // Colunas:
            for(int y = 0; y < TAMANHO_TABULEIRO; y++){
                Posicao posT = new Posicao(y, x);
                
                if(getCasa(posT) == null)
                    System.out.print("   |");
                else
                    System.out.print(" " + getCasa(posT).getSimbolo() + " |");
            }
            System.out.println("");
        }
        System.out.println("  |---|---|---|---|---|---|---|---|");
        System.out.println("    A   B   C   D   E   F   G   H  \n");
        System.out.println("CMD: ");
    }
    
	boolean existePecaNoCaminho(Posicao orig, Posicao dest)
	{
            Posicao origem = new Posicao(orig);
            Posicao destino = new Posicao(dest);
            Peca pecaOrigem = this.getCasa(origem);
            char simbolo = pecaOrigem.getSimbolo();
            if (simbolo == 'h' || simbolo == 'H')
            {
                return false;
            }
		int linhaOrigem = origem.x;
		int colunaOrigem = origem.y;

	    if (linhaOrigem != destino.x && colunaOrigem != destino.y)
	    {
	        int dirX = destino.y > colunaOrigem ? 1 : -1;
	        int dirY = destino.x > linhaOrigem ? 1 : -1;
	        for (int i = 1; i < Math.abs(destino.y - colunaOrigem); i++)
	        {
	            int nextX = colunaOrigem + i * dirX;
	            int nextY = linhaOrigem + i * dirY;
	            origem.x = nextX;
	            origem.y = nextY;
	            Peca pecaCaminho = this.getCasa(origem);
	            if (pecaCaminho != null)
	            {
	                return true;
	            }
	        }
	        return false;
	    }
	    else if (linhaOrigem == destino.x || colunaOrigem == destino.y)
	    {
	        int dirX = 0;
	        if (destino.y > colunaOrigem)
	            dirX = 1;
	        else if (destino.y < colunaOrigem)
	            dirX = -1;
	        else if (destino.y == colunaOrigem)
	            dirX = 0;

	        int dirY = 0;
	        if (destino.x > linhaOrigem)
	            dirY = 1;
	        else if (destino.x < linhaOrigem)
	            dirY = -1;
	        else if (destino.x == linhaOrigem)
	            dirY = 0;

	        int distance = destino.y == colunaOrigem ? destino.x - linhaOrigem : destino.y - colunaOrigem;
                
	        for (int i = 1; i < Math.abs(distance); i++)
	        {
	            int nextX = colunaOrigem + i * dirX;
	            int nextY = linhaOrigem + i * dirY;
	            origem.x = nextX;
	            origem.y = nextY;
	            Peca pecaCaminho = this.getCasa(origem);
	            if (pecaCaminho != null)
	            {
	                return true;
	            }
	        }
	        return false;
	    }
	    return true;
	}
    
    
    
}
