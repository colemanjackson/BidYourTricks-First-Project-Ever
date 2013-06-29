package bidYourTricks;


/**
 * A class representing a player playing bid your tricks.
 * @author Coleman Jackson
 *
 */
public class BidPlayer {
	/**
	 * the score of the user
	 */
	private int score;
	/**
	 * the name of the user
	 */
	private String name;
	
	/**
	 * the bid of the user
	 */
	private int bid;
	
	/**
	 * the boolean representing if the player is set or not
	 */
	private boolean isSet = false;

	/**
	 * A constructor which only creates a player with a name and default scores
	 * and bids of zero
	 * 
	 * @param name
	 *            name of player
	 */
	public BidPlayer(String name) {
		this.score = 0;
		this.name = name;
		bid = 0;
		isSet = false;
	}

	/**
	 * A constructor which creates a player object complete with a score and bid
	 * 
	 * @param name
	 *            name of player
	 * @param score
	 *            score of player
	 */
	public BidPlayer(String name, int score) {
		this.name = name;
		this.score = score;
		bid = 0;
		isSet = false;
	}

	/**
	 * updates the bid of the current player.
	 * 
	 * @param newBid
	 */
	public void updateBid(int newBid) {
		if (newBid <= 7) {
			bid = newBid;
		}

	}

	/**
	 * only called if bid is made, updates score based on what the bid was.
	 * 
	 * @param newScore
	 */
	public void updateScore() {
		if (!isSet) {
			if (bid == 0) {
				score += 5;
			} else
				score += 10 + bid;
		}

		else
			return;
	}

	/**
	 * returns the name of the player
	 * 
	 * @return the name of the player
	 */
	public String getName() {
		return name;
	}

	/**
	 * returns the score of the player
	 * 
	 * @return the score of the player
	 */
	public int getScore() {
		return score;
	}

	/**
	 * updates whether the player is set or not
	 * 
	 * @param set
	 *            a boolean which is true if the player is set and false
	 *            otherwise
	 * 
	 */
	public void updateIsSet(boolean set) {
		isSet = set;
	}

	/**
	 * returns true if set, and false otherwise
	 * 
	 * @return returns a boolean representing set value
	 */
	public boolean isPlayerSet() {
		return isSet;
	}
}
