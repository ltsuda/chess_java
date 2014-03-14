package br.edu.metrocamp.chess;

/** 
 * Peca deve representar uma peça do Xadrez.
 * 
 * Disciplina: Programacao Orientada a Objetos
 * @author Prof. MSc. Giulliano Paes Carnielli
 */
 
public class Peca {
	private int coord_x;
	private int coord_y;
	private char simbolo;

	/**
	 * @return the coord_x
	 */
	public int getCoord_x() {
		return coord_x;
	}

	/**
	 * @param coord_x the coord_x to set
	 */
	public void setCoord_x(int coord_x) {
		this.coord_x = coord_x;
	}

	/**
	 * @return the coord_y
	 */
	public int getCoord_y() {
		return coord_y;
	}

	/**
	 * @param coord_y the coord_y to set
	 */
	public void setCoord_y(int coord_y) {
		this.coord_y = coord_y;
	}

	/**
	 * @return the simbolo
	 */
	public char getSimbolo() {
		return simbolo;
	}
}
