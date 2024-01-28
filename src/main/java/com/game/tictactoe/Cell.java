package com.game.tictactoe;

public class Cell {

	private String value;

	
	public Cell() {
		this.value = " ";
	}

	
	public String getValue() {
		return value;
	}

	
	public void setValue(String symbol) {
		this.value = symbol;
	}
}