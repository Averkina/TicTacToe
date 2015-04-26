public class Player {

	private char figure;
	private String namePlayer;

	public Player(char figure, String namePlayer) {
		setFigure(figure);
		setNamePlayer(namePlayer);
	}

	public void setFigure(char figure) {
		this.figure = figure;
	}

	public char getFigure() {
		return figure;
	}

	public String getNamePlayer() {
		return namePlayer;
	}

	public void setNamePlayer(String namePlayer) {
		this.namePlayer = namePlayer;
	}

	public BoardSell turn(BoardSell sell) {
		// sell.x;
		// sell.y;

		return sell;
	}

	public void win(Player player) {
		System.out.println("Player win: " + player.getNamePlayer());
	}

	public void loss(Player player) {
		System.out.println("Player loss: " + player.getNamePlayer());
	}

	public void draw(Player player) {
		System.out.println("Draw!!! " + player.getNamePlayer());
	}

	public void updateGame(Game game) {

	}

}
