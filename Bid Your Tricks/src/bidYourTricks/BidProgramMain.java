package bidYourTricks;

import java.util.ArrayList;

public class BidProgramMain {
	
	public static int numPlayers;
	public static void main(String[] args) {

		int countDown = 7;
		int countUp = 1;
		ArrayList<BidPlayer> arrOfPlayers = new ArrayList<BidPlayer>();

		System.out.println("  Bid Your Tricks Game Tracker (Alpha Build)");
		System.out.println("---------------------------------");

		// gets the number of players who will be playing the game.
		numPlayers = BidLogic.numberOfPlayers();

		// add the players to the arrayList.
		BidLogic.namePlayers(arrOfPlayers, numPlayers);

		for (int i = 1; i < BidLogic.NUMBER_OF_TURNS + 1; i++) { //counter for 
			System.out.println();
			if (countDown >= 1) {
				System.out.println("Deal " + countDown);
				countDown--;
			} else {
				System.out.println("Deal " + countUp);
				countUp++;
			}
			
			System.out.println("-------------------");
			System.out.println();
			BidLogic.bidUpdate(arrOfPlayers); //updates the bids for the next hand
			System.out.println();
			BidLogic.holdTime(); //holds until everyone finishes their hands.
			System.out.println();
			BidLogic.setUpdate(arrOfPlayers);

			System.out.println();
			for (int p = 0; p < arrOfPlayers.size(); p++) {
				System.out.println("Score for " + arrOfPlayers.get(p).getName()
						+ ": " + arrOfPlayers.get(p).getScore());
				System.out.println("---------------------------");
			}
		}

		System.out.println();
		for (int i = 0; i < arrOfPlayers.size(); i++) {
			System.out.println("FINAL SCORE FOR "
					+ arrOfPlayers.get(i).getName() + ": "
					+ arrOfPlayers.get(i).getScore());
			System.out.println("-------------------------");
		}
	}

}
