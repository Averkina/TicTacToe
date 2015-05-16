public class Player implements PlayerInterface {

	private char figure;
	private String namePlayer;

	public Player(char figure, String namePlayer) {
		setFigure(figure);
		setNamePlayer(namePlayer);
	}

	@Override
	public void setFigure(char figure) {
		this.figure = figure;
	}

	@Override
	public char getFigure() {
		return figure;
	}

	@Override
	public String getNamePlayer() {
		return namePlayer;
	}

	@Override
	public void setNamePlayer(String namePlayer) {
		this.namePlayer = namePlayer;
	}

	@Override
	public void setArbitrator(ArbitratorInterface arbitrator) {

	}

	@Override
	public void makeMove(Game game) {
		double x = 0;
		double y = 0;
		do {
			x = Math.random() * 3;
			y = Math.random() * 3;
		} while (game.isIdleSell((int) x, (int) y));
		game.board[(int) x][(int) y] = getFigure();
	}

	@Override
	public void win() {
		System.out.println("Draw player: " + getNamePlayer());

	}

	@Override
	public void loss() {
		System.out.println("Loss player: " + getNamePlayer());

	}

	@Override
	public void draw() {
		System.out.println("Draw player: " + getNamePlayer());

	}

}
