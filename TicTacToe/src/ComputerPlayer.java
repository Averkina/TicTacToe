public class ComputerPlayer implements PlayerInterface {

	private char figure;
	private ArbitratorInterface arbitrator;

	public ComputerPlayer() {
	}

	@Override
	public void makeMove(Game game) {
		double x = 0;
		double y = 0;
		do {
			x = Math.random() * 3;
			y = Math.random() * 3;
		} while (game.isNotEmptyCell((int) x, (int) y));
		game.board[(int) x][(int) y] = figure;
		arbitrator.updateBoardAfterPlayerTurn(game);
	}

	public String getNamePlayer() {
		return "Computer";
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
	public void setFigure(char figure) {
		this.figure = figure;
	}

	@Override
	public void setArbitrator(ArbitratorInterface arbitratorInterface) {
		this.arbitrator = arbitratorInterface;
	}

}
