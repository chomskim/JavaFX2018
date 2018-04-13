package hufs.ces.card;

import javafx.scene.image.Image;

public class CardImages {

	private Image[] cardImage = null;
	private Image backImage = null;  //  @jve:decl-index=0:

	private volatile static CardImages uniqueInstance;  //  @jve:decl-index=0:

	private CardImages(){
		initialize();
	}

	public static CardImages getInstance() {
		if (uniqueInstance == null) {
			synchronized (CardImages.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new CardImages();
				}
			}
		}
		return uniqueInstance;
	}
	private void initialize(){
		cardImage = new Image[] {
				new Image(getClass().getResourceAsStream("/images/c1.png")),
				new Image(getClass().getResourceAsStream("/images/c2.png")),
				new Image(getClass().getResourceAsStream("/images/c3.png")),
				new Image(getClass().getResourceAsStream("/images/c4.png")),
				new Image(getClass().getResourceAsStream("/images/c5.png")),
				new Image(getClass().getResourceAsStream("/images/c6.png")),
				new Image(getClass().getResourceAsStream("/images/c7.png")),
				new Image(getClass().getResourceAsStream("/images/c8.png")),
				new Image(getClass().getResourceAsStream("/images/c9.png")),
				new Image(getClass().getResourceAsStream("/images/c10.png")),
				new Image(getClass().getResourceAsStream("/images/cj.png")),
				new Image(getClass().getResourceAsStream("/images/cq.png")),
				new Image(getClass().getResourceAsStream("/images/ck.png")),
				new Image(getClass().getResourceAsStream("/images/d1.png")),
				new Image(getClass().getResourceAsStream("/images/d2.png")),
				new Image(getClass().getResourceAsStream("/images/d3.png")),
				new Image(getClass().getResourceAsStream("/images/d4.png")),
				new Image(getClass().getResourceAsStream("/images/d5.png")),
				new Image(getClass().getResourceAsStream("/images/d6.png")),
				new Image(getClass().getResourceAsStream("/images/d7.png")),
				new Image(getClass().getResourceAsStream("/images/d8.png")),
				new Image(getClass().getResourceAsStream("/images/d9.png")),
				new Image(getClass().getResourceAsStream("/images/d10.png")),
				new Image(getClass().getResourceAsStream("/images/dj.png")),
				new Image(getClass().getResourceAsStream("/images/dq.png")),
				new Image(getClass().getResourceAsStream("/images/dk.png")),
				new Image(getClass().getResourceAsStream("/images/h1.png")),
				new Image(getClass().getResourceAsStream("/images/h2.png")),
				new Image(getClass().getResourceAsStream("/images/h3.png")),
				new Image(getClass().getResourceAsStream("/images/h4.png")),
				new Image(getClass().getResourceAsStream("/images/h5.png")),
				new Image(getClass().getResourceAsStream("/images/h6.png")),
				new Image(getClass().getResourceAsStream("/images/h7.png")),
				new Image(getClass().getResourceAsStream("/images/h8.png")),
				new Image(getClass().getResourceAsStream("/images/h9.png")),
				new Image(getClass().getResourceAsStream("/images/h10.png")),
				new Image(getClass().getResourceAsStream("/images/hj.png")),
				new Image(getClass().getResourceAsStream("/images/hq.png")),
				new Image(getClass().getResourceAsStream("/images/hk.png")),
				new Image(getClass().getResourceAsStream("/images/s1.png")),
				new Image(getClass().getResourceAsStream("/images/s2.png")),
				new Image(getClass().getResourceAsStream("/images/s3.png")),
				new Image(getClass().getResourceAsStream("/images/s4.png")),
				new Image(getClass().getResourceAsStream("/images/s5.png")),
				new Image(getClass().getResourceAsStream("/images/s6.png")),
				new Image(getClass().getResourceAsStream("/images/s7.png")),
				new Image(getClass().getResourceAsStream("/images/s8.png")),
				new Image(getClass().getResourceAsStream("/images/s9.png")),
				new Image(getClass().getResourceAsStream("/images/s10.png")),
				new Image(getClass().getResourceAsStream("/images/sj.png")),
				new Image(getClass().getResourceAsStream("/images/sq.png")),
				new Image(getClass().getResourceAsStream("/images/sk.png")),
		};
		backImage = new Image(getClass().getResourceAsStream("/images/b1fv.png"));
	}
	Image getBackImage(){
		return backImage;
	}
	Image getCardImage(int suit, int rank){
		return cardImage[13*suit+rank-1];
	}
}
