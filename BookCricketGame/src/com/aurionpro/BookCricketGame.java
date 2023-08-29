package com.aurionpro;

import java.util.Random;
import java.util.Scanner;

public class BookCricketGame {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		System.out.println("Welcome to the Book Cricket game!");

		int player1Score = 0;
		int player2Score = 0;
		int player1Turns = 0;
		int player2Turns = 0;
		int roundsLeft = 4;
		int maxPage = 300;
		String player1Name, player2Name;

		System.out.println("\nRules for the Game:");
		System.out.println("Assume a book of 300 pages");
		System.out.println("1. Player1 opens the book to read a page number (Randomly generated).");
		System.out.println(
				"2. If the page number is 87 -> 87 % 7 (%7 results in a score between 0-6) = 3 should be added to the score.");
		System.out.println(
				"3. Player 1 continues and keeps adding to the score until the page number results in a 0 score.");
		System.out.println("4. Player 2 starts the game and tries to beat Player 1's score.");
		System.out.println("5. In case of a tie, check the number of turns (player with fewer turns is the winner).");
		System.out.println("6. Show the winner of the game.");

		System.out.print("\nEnter 1 To Start Game And For Exit: ");
		int startGame = scanner.nextInt();

		if (startGame != 1) {
			System.out.println("Exiting the game.");
			return;
		}

		System.out.print("\nEnter Player 1 Name: ");
		player1Name = scanner.next();

		System.out.print("Enter Player 2 Name: ");
		player2Name = scanner.next();

		while (roundsLeft > 0) {

			System.out.println("Player: " + player1Name);

			int score1 = 0;
			int page1 = random.nextInt(maxPage) + 1;

			System.out.print("Enter 1 To Open Book: ");
			int openBook = scanner.nextInt();

			if (openBook == 1) {
				int point1 = page1 % 7;
				System.out.println("Page Number: " + page1 + "             " + "  Point: " + point1 + "              "
						+ "  score: " + point1);
				score1 = point1;
				player1Score += score1;
				player1Turns++;
			} else {
				System.out.println("Invalid input. Skipping " + player1Name);
			}

			System.out.println("Player: " + player2Name);
			int score2 = 0;
			int page2 = random.nextInt(maxPage) + 1;

			System.out.print("Enter 1 To Open Book: ");
			int openBook2 = scanner.nextInt();

			if (openBook2 == 1) {
				int point2 = page2 % 7;
				System.out.println("Page Number: " + page2 + "             " + "  point: " + point2 + "              "
						+ "  Score: " + point2);
				score2 = point2;
				player2Score += score2;
				player2Turns++;
			} else {
				System.out.println("Invalid input. Skipping " + player2Name);
			}

			roundsLeft--;

			System.out.println(player1Name + "  Total Score   " + player1Score);
			System.out.println(player1Name + "  Takes   " + player1Turns + "   Rounds");
			System.out.println(player2Name + "  Total Score   " + player2Score);
			System.out.println(player2Name + "  Takes   " + player2Turns + "   Rounds");
		}

		if (player1Score > player2Score) {
			System.out.println("\n" + player1Name + " wins!");
		} else if (player2Score > player1Score) {
			System.out.println("\n" + player2Name + " wins!");
		} else {
			if (player1Turns < player2Turns) {
				System.out.println("\nIt's a tie, but " + player1Name + " wins due to fewer turns!");
			} else if (player2Turns < player1Turns) {
				System.out.println("\nIt's a tie, but " + player2Name + " wins due to fewer turns!");
			} else {
				System.out.println("\nIt's a tie!");
			}
		}

		scanner.close();
	}
}
