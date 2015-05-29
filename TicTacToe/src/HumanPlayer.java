import java.util.Scanner;

public class HumanPlayer implements PlayerInterface {

	private ArbitratorInterface arbitrator;
	private String namePlayer;
	private char figure;

	public HumanPlayer() {
		namePlayer = getNamePlayer();

	}

	@Override
	public void makeMove(Game game) {
		game.printBoard();
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
					game.board[x][y] = figure;
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

	public String getNamePlayer() {
		System.out.println("Player, enter your name, please:");
		Scanner sc = new Scanner(System.in);
		String inputName = sc.nextLine();
		return inputName;
	}

	@Override
	public void win() {
		System.out.println("Player win: " + namePlayer);
	}

	@Override
	public void loss() {
		System.out.println("Player loss: " + namePlayer);
	}

	@Override
	public void draw() {
		System.out.println("Draw!!! " + namePlayer);
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
