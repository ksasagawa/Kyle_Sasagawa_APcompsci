/**
 * This class provides a convenient way to test shuffling methods.
 */
public class Shuffler {

	/**
	 * The number of consecutive shuffle steps to be performed in each call
	 * to each sorting procedure.
	 */
	private static final int SHUFFLE_COUNT = 1;


	/**
	 * Tests shuffling methods.
	 * @param args is not used.
	 */
	public static void main(String[] args) {
		System.out.println("Results of " + SHUFFLE_COUNT +
								 " consecutive perfect shuffles:");
		int[] values1 = {0, 1, 2, 3};
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			perfectShuffle(values1);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values1.length; k++) {
				System.out.print(" " + values1[k]);
			}
			System.out.println();
		}
		System.out.println();

		System.out.println("Results of " + SHUFFLE_COUNT +
								 " consecutive efficient selection shuffles:");
		int[] values2 = {0, 1, 2, 3};
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			selectionShuffle(values2);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values2.length; k++) {
				System.out.print(" " + values2[k]);
			}
			System.out.println();
		}
		System.out.println();
	}


	/**
	 * Apply a "perfect shuffle" to the argument.
	 * The perfect shuffle algorithm splits the deck in half, then interleaves
	 * the cards in one half with the cards in the other.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static void perfectShuffle(int[] values) {
		Card[] cards = new Card[52];
		String[] ranks = new String[]{"ace","king","queen","jack","10","9","8","7","6","5","4","3","2"};
		String[] suits = new String[]{"Hearts","Spades","Clubs","Diamonds"};
		int[] value = new int[]{11,10,10,10,10,9,8,7,6,5,4,3,2};
		for(int i = 0; i < ranks.length;i++)
		{
			for(int x = 0; x < suits.length;i++)
			{
				cards[x]=(new Card(ranks[i],suits[x],value[i]));
			}
		}
		Card[] shuffled = new Card[52];
		int k = 0;
		for(int j = 0; j < 25; j++)
		{
			shuffled[j]= cards[k];
			k+=2;
		}
		k = 1;
		for(int j = 26;j < 51; j++)
		{
			shuffled[j]= cards[k];
			k+=2;
		}
	}

	/**
	 * Apply an "efficient selection shuffle" to the argument.
	 * The selection shuffle algorithm conceptually maintains two sequences
	 * of cards: the selected cards (initially empty) and the not-yet-selected
	 * cards (initially the entire deck). It repeatedly does the following until
	 * all cards have been selected: randomly remove a card from those not yet
	 * selected and add it to the selected cards.
	 * An efficient version of this algorithm makes use of arrays to avoid
	 * searching for an as-yet-unselected card.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static void selectionShuffle(int[] values) {
		Card[] cards = new Card[52];
		String[] ranks = new String[]{"ace","king","queen","jack","10","9","8","7","6","5","4","3","2"};
		String[] suits = new String[]{"Hearts","Spades","Clubs","Diamonds"};
		int[] value = new int[]{11,10,10,10,10,9,8,7,6,5,4,3,2};
		for(int i = 0; i < ranks.length;i++)
		{
			for(int x = 0; x < suits.length;i++)
			{
				cards[x]=(new Card(ranks[i],suits[x],value[i]));
			}
		}
		for(int k = 51; 51>1; k--)
		{
			Card rc = new Card();
			int r  = ((int)(Math.random()*k));
			rc = cards[r];
			cards[r] = cards[k];
			cards[k] = rc;
		}
	}
}
