package hufs.ces.card;

import javafx.scene.image.ImageView;

public class Card {
	public static final int CLUB = 0;
	public static final int DIAMOND = 1;
	public static final int HEART = 2;
	public static final int SPADE = 3;
	
	private boolean open = false;
	private int suit;
	private int rank;
	private CardImages cardImages = CardImages.getInstance();

	public Card(){
		this(SPADE, 1);
	}
	public Card(int suit, int rank){
		this(suit, rank, false);
	}
	public Card(int suit, int rank, boolean open){
		this.open = open;
		this.suit = suit;
		this.rank = rank;
	}
	public ImageView getImage(){
		if (isOpen())
			return new ImageView(cardImages.getCardImage(suit, rank));
		else
			return new ImageView(cardImages.getBackImage());
	}
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	public int getSuit() {
		return suit;
	}
	public int getRank() {
		return rank;
	}
}
