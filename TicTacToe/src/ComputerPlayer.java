public class ComputerPlayer implements PlayerInterface {

	private char figure;
	private String namePlayer;
	ArbitratorInterface arbitrator;

	public ComputerPlayer(char figure, String namePlayer) {
		setFigure(figure);
		setNamePlayer(namePlayer);
	}

	@Override
	public void makeMove(Game game) {
		double x = 0;
		double y = 0;
		do {
			x = Math.random() * 3;
			y = Math.random() * 3;
		} while (game.isNotEmptyCell((int) x, (int) y));
		game.board[(int) x][(int) y] = getFigure();
		arbitrator.updateBoardAfterPlayerTurn(game);
	}

	@Override
	public void win() {
		System.out.println("Player win: " + getNamePlayer());
	}

	@Override
	public void loss() {
		System.out.println("Player loss: " + getNamePlayer());
	}

	public void draw() {
		System.out.println("Draw!!! " + getNamePlayer());
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
	public void setFigure(char figure) {
		this.figure = figure;
	}

	@Override
	public void setNamePlayer(String namePlayer) {
		this.namePlayer = namePlayer;
	}

	@Override
	public void setArbitrator(ArbitratorInterface arbitratorInterface) {
		this.arbitrator = arbitratorInterface;
	}

}
