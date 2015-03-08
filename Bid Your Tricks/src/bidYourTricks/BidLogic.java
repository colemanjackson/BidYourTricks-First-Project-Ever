package bidYourTricks;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Methods for the Main method to run during the game tracking events
 * 
 * @author Coleman Jackson version 0.0.2
 */
public class BidLogic {
	
	/**
	 * the number of turns in the game of Bid your tricks
	 */
	public static final int NUMBER_OF_TURNS = 14;
	
	/**
	 * The scanner that takes all input and uses it for the game. This scanner does work.
	 */
	private static Scanner infoTaker = new Scanner(System.in);
	
	/**
	 * Dummy Constructor used to call the class more easily.
	 */
	public BidLogic() {

	}

	/**
	 * Gets the number of players from input given
	 * 
	 * @return an integer representing the number of players playing the game.
	 */
	public static int numberOfPlayers() {
		int numPlayers = 0; // Should not be 0 at end.

		System.out
				.print("Enter how many players will be playing (please enter a NUMBER): ");

		try {
			numPlayers = infoTaker.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("You have entered an invalid argument.");
			numPlayers = 0;
			infoTaker.next();
			numPlayers = numberOfPlayers();
								// correct answer is found, then it
								// is pushed up through the stack.
		}

		return numPlayers;
	}

	/**
	 * Names the players to make the game more personal to the users, and then
	 * adds the players to the array of players.
	 * 
	 * @param arrOfPlayers
	 *            the list of players for this particular game of
	 *            bid-your-tricks
	 * @param numPlayers
	 *            the number of players for this game.
	 */
	public static void namePlayers(ArrayList<BidPlayer> arrOfPlayers,
			int numPlayers) {
		for (int i = 1; i < numPlayers + 1; i++) {
			System.out.print("Enter the name of player " + i + " :");
			String name = infoTaker.next();
			BidPlayer player = new BidPlayer(name);
			arrOfPlayers.add(player);
		}
	}

	/**
	 * Used to update the bids of the players
	 * 
	 * @param arrOfPlayers
	 *            the array of players for the game.
	 */
	public static void bidUpdate(ArrayList<BidPlayer> arrOfPlayers) {// update
																		// bid
		for (int q = 0; q < arrOfPlayers.size(); q++) {
			int count = 0;
			int maxCount = 10000;
			int bid = 0; // zero by default to prevent errors
			while (count < maxCount) { // allows to return to the point of code
										// we need in case of a redo entry
				System.out.print("Enter the bid for "
						+ arrOfPlayers.get(q).getName() + ": ");
				try {
					bid = infoTaker.nextInt();
					break;
				} catch (InputMismatchException e) {
					System.out.println("You have entered an invalid argument.");
					infoTaker.next();
					count++;

				}

			}
			arrOfPlayers.get(q).updateBid(bid);

		}
	}

	
	/**
	 * Holds the tracker until everyone has finished the hand.
	 */
	public static void holdTime() {
		int count = 0;
		int maxVal = 10000;
		int num;
		while (count < maxVal) {
			{

				System.out
						.print("Play your hands. Enter '1' and press return when finished: ");
				try {
					num = infoTaker.nextInt();
					if (num == 1) {
						break;
					}

				} catch (InputMismatchException e) {
					count++;
					infoTaker.next();
				}
			}
		}
	}

	
	/**
	 * Updates if someone went set or not
	 * @param arrOfPlayers
	 * The array of players in this game
	 */
	public static void setUpdate(ArrayList<BidPlayer> arrOfPlayers) {

		for (int w = 0; w < arrOfPlayers.size(); w++) {
			int set = 0;
			int count = 0;
			int maxNum = 1000; // really should never be hit. Ever.
			while (count < maxNum) {
				System.out.print("Did " + arrOfPlayers.get(w).getName()
						+ " go set? Enter 1 for yes or 0 for no: ");

				try {
					set = infoTaker.nextInt();
					break;
				}

				catch (InputMismatchException e) {
					count++;
					infoTaker.next();

				}
			}
			if (set == 1) {
				arrOfPlayers.get(w).updateIsSet(true);
			}

			arrOfPlayers.get(w).updateScore();
			arrOfPlayers.get(w).updateIsSet(false);

		}
	}
}
