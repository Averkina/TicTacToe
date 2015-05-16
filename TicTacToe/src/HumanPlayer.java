import java.util.Scanner;

public class HumanPlayer implements PlayerInterface {

	private char figure;
	private String namePlayer;
	private ArbitratorInterface arbitrator;

	public HumanPlayer(char figure, String namePlayer) {
		setFigure(figure);
		setNamePlayer(namePlayer);

	}

	@Override
	public void makeMove(Game game) {
		System.out.println("Player, make to move:");
		int x = 0;
		int y = 0;
		boolean flag = false;
		while (!flag) {
			Scanner sc = new Scanner(System.in);
			int inputNumber = sc.nextInt();
			if (1 <= inputNumber && 9 >= inputNumber) {
				Integer[] coordinates = game.numpad.get(inputNumber);
				x = coordinates[0];
				y = coordinates[1];
				if (x < 0 || x > 2 || y < 0 || y > 2) {
					System.out
							.println("Such cell doesn't exist. Choose another, please! It can be 0, 1 or 2.");
					flag = false;
				} else if (!game.isNotEmptyCell(x, y)) {
					game.board[x][y] = getFigure();
					flag = true;
				} else {
					System.out
							.println("This sell is occupy. Choose another, please!");
					flag = false;
				}
			} else {
				System.out
						.println("You entered incorrect value. It can be from 1 to 9. Choose another, please!");
				flag = false;
			}
		}
		game.printBoard();
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

	@Override
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
