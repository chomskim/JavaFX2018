package hufs.ces.card;

import javafx.scene.control.Button;

public class CardButton extends Button {


	private Card card = null;
	
	public CardButton(){
		super();
		card = new Card();
		this.setGraphic(card.getImage());
	}
	public CardButton(int suit, int rank){
		super();
		card = new Card(suit, rank);
		this.setGraphic(card.getImage());
	}
	public CardButton(int suit, int rank, boolean open){
		super();
		card = new Card(suit, rank, open);
		this.setGraphic(card.getImage());
	}
	public CardButton(Card card){
		super();
		this.card = card;
		this.setGraphic(card.getImage());
	}
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
		this.setGraphic(card.getImage());
	}
	public void setCardOpen(boolean open){
		this.card.setOpen(open);
		this.setGraphic(card.getImage());
	}
	public boolean isCardOpen(){
		return this.card.isOpen();
	}
}
