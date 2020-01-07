package com.oops.deckofcards;

import java.util.Random;

import com.oops.utility.QueueusingLinkedListUtility;

public class DeckOfCards {

	public static void main(String[] args) {
		String[] suit = { "Clubs", "Diamonds", "Hearts", "Spades" };
		String[] rank = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
		int totalDeck = suit.length * rank.length;
		String[] deck = new String[totalDeck];
		String player1 = null;
		String player2 = null;
		String player3 = null;
		String player4 = null;
		// printing total cards
		for (int i = 0; i < rank.length; i++) {
			for (int j = 0; j < suit.length; j++) {
				deck[suit.length * i + j] = rank[i] + " of " + suit[j];
			}
		}
		
		// before shuffling
		System.out.println("Cards before shuffling: ");
		for (int i = 0; i < totalDeck; i++) {
			System.out.println((int)Math.random()+deck[i]);
		}
		// After shuffling
		System.out.println("\nCards after shuffling: ");
		Random random = new Random();
		for (int i = 0; i < totalDeck; i++) {
			int r = i + random.nextInt(totalDeck - i);
			String temp = deck[r];
			deck[r] = deck[i];
			deck[i] = temp;
		}

		for (int i = 0; i < totalDeck; i++) {
			System.out.println(deck[i] + " ");
		}
		System.out.println();

		// Distribution of 9 cards each to 4 players
		System.out.println("======================");
		System.out.println("Cards of player 1: ");
		
		for (int i = 0; i < 9; i++) {
			player1 = (int)Math.random()+deck[i];
			System.out.println(player1);
			QueueusingLinkedListUtility.enqueue(player1);
		}
		System.out.println("\nCards of player 1 in queue: ");
		QueueusingLinkedListUtility.printQueue();
		for(int i = 0; i<player1.length()-1;i++)
		{
		QueueusingLinkedListUtility.dequeue();
		}
		 System.out.println();
		System.out.println("======================");
		System.out.println("Cards of player 2: ");
		for (int i = 9; i < 18; i++) {
			player2 = (int)Math.random()+deck[i];
			System.out.println(player2);
			QueueusingLinkedListUtility.enqueue(player2);
		}
		System.out.println("\nCards of player 2 in queue: ");
		QueueusingLinkedListUtility.printQueue();
		for(int i = 0; i<player2.length()-1;i++)
		{
		QueueusingLinkedListUtility.dequeue();
		}
		
		System.out.println();
		System.out.println("======================");
		System.out.println("Cards of player 3: ");
		for (int i = 18; i < 27; i++) {
			player3 = (int)Math.random()+deck[i];
			System.out.println(player3);
			QueueusingLinkedListUtility.enqueue(player3);
		}
		System.out.println("\nCards of player 3 in queue: ");
		QueueusingLinkedListUtility.printQueue();
		for(int i = 0; i<player3.length()-1;i++)
		{
		QueueusingLinkedListUtility.dequeue();
		}
		
		System.out.println();
		System.out.println("======================");
		System.out.println("Cards of player 4: ");
		for (int i = 27; i < 36; i++) {
			player4 = (int)Math.random()+deck[i];
			System.out.println(player4);
			QueueusingLinkedListUtility.enqueue(player4);
		}	
		System.out.println("\nCards of player 4 in queue: ");
		QueueusingLinkedListUtility.printQueue();
		for(int i = 0; i<player4.length()-1;i++)
		{
		QueueusingLinkedListUtility.dequeue();
		}
	}
	

}
