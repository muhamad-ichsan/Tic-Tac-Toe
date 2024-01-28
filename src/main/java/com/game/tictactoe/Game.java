package com.game.tictactoe;

import java.util.Scanner;

public class Game {

	private Board board; 
	private String currentPlayer; 
	private Scanner scanner; 

	
	public Game() {
		scanner = new Scanner(System.in); 
		currentPlayer = "X"; 
	}

	
	private int initializeBoardSize() {
		int boardSize;
		do {
			System.out.println("Enter the game board size (example: 3 for a 3x3 board): ");
			boardSize = scanner.nextInt(); 
			if (boardSize <= 0) {
				System.out.println("Board size must be greater than 0. Please enter again.");
			}
		} while (boardSize <= 0);

		return boardSize;
	}

	
	public void play() {
		char playAgain;

		do {
			int boardSize = initializeBoardSize();
			board = new Board(boardSize);
			currentPlayer = "X";
			playRound();
			System.out.println("Do you want to play again? (Y/N): ");
			playAgain = scanner.next().charAt(0);
		} while (playAgain == 'Y' || playAgain == 'y');

		System.out.println("Thank you for playing!");
		scanner.close();
	}

	
	private void playRound() {
		do {
			board.display();
			System.out.println("Player " + currentPlayer + "'s turn. Enter row and column (separated by space): ");
			int row = scanner.nextInt();
			int col = scanner.nextInt();

			if (board.makeMove(row, col, currentPlayer)) {
				if (board.checkWin(currentPlayer)) {
					board.display();
					System.out.println("Player " + currentPlayer + " wins!");
					return;
				} else if (board.isFull()) {
					board.display();
					System.out.println("The game is a draw!");
					return;
				} else {
					currentPlayer = (currentPlayer.equals("X")) ? "O" : "X";
				}
			} else {
				System.out.println("Invalid move. Try again.");
			}
		} while (true);
	}
}