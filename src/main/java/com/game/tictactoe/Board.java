package com.game.tictactoe;


public class Board {

	
	private Cell[][] cells;

	
	public Board(int size) {
		cells = new Cell[size][size];
		initializeBoard();
	}

	
	private void initializeBoard() {
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[i].length; j++) {
				cells[i][j] = new Cell(); 
			}
		}
	}

	
	public void display() {
		printBorder(); 
		for (int i = 0; i < cells.length; i++) {
			System.out.print("| ");
			for (int j = 0; j < cells[i].length; j++) {
				System.out.print(cells[i][j].getValue() + " | "); 
			}
			System.out.println();
			printBorder(); 
		}
	}

	
	private void printBorder() {
		for (int i = 0; i < cells.length; i++) {
			System.out.print("+---");
		}
		System.out.println("+");
	}

	
	public boolean isFull() {
		for (Cell[] row : cells) {
			for (Cell cell : row) {
				if (cell.getValue().equals(" ")) {
					return false; 
				}
			}
		}
		return true;
	}

	
	public boolean makeMove(int row, int col, String symbol) {
		if (isValidMove(row, col) && cells[row - 1][col - 1].getValue().equals(" ")) {
			cells[row - 1][col - 1].setValue(symbol);
			return true; 
		}
		return false; 
	}

	
	public boolean checkWin(String symbol) {
		for (int i = 0; i < cells.length; i++) {
			if (checkLine(cells[i], symbol) || checkLine(getColumn(i), symbol)) {
				return true; 
			}
		}
		return checkLine(getMainDiagonal(), symbol) || checkLine(getAntiDiagonal(), symbol);
	}


	private boolean checkLine(Cell[] line, String symbol) {
		for (Cell cell : line) {
			if (!cell.getValue().equals(symbol)) {
				return false;
			}
		}
		return true; 
	}

	
	private Cell[] getColumn(int col) {
		Cell[] column = new Cell[cells.length];
		for (int i = 0; i < cells.length; i++) {
			column[i] = cells[i][col]; 
		}
		return column;
	}

	
	private Cell[] getMainDiagonal() {
		Cell[] diagonal = new Cell[cells.length];
		for (int i = 0; i < cells.length; i++) {
			diagonal[i] = cells[i][i]; 
		}
		return diagonal;
	}

	
	private Cell[] getAntiDiagonal() {
		Cell[] diagonal = new Cell[cells.length];
		for (int i = 0; i < cells.length; i++) {
			diagonal[i] = cells[i][cells.length - 1 - i]; 
		}
		return diagonal;
	}

	
	private boolean isValidMove(int row, int col) {
		return row > 0 && row <= cells.length && col > 0 && col <= cells[row - 1].length
				&& cells[row - 1][col - 1].getValue().equals(" ");
	}
}