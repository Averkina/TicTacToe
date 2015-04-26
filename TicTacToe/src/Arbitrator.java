public class Arbitrator {

	Player[] player = new Player[2];

	Boolean win = false;
	Game game = new Game();

	public void startGame() {
		player[0] = new Player('x', "Maria");
		player[1] = new Player('o', "Valery");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				game.board[i][j] = ' ';
			}
		}
		game.printBoard();
		checkFinish();
	}

	public void whoWin(Game game, int i, int j) {
		if (player[0].getFigure() == 'x' && game.board[i][j] == 'x') {
			player[0].win(player[0]);
			player[1].loss(player[1]);
		} else {
			player[1].win(player[1]);
			player[0].loss(player[0]);
		}
		checkFinish();
	}

	public void checkBoard(Game game) {
		for (int i = 0; i < 3; i++) {
			if (game.board[0][i] == game.board[1][i]
					&& game.board[1][i] == game.board[2][i]
					&& game.board[0][i] != '*') {
				win = true;
				whoWin(game, 0, i);
				break;
			}
			if (game.board[i][0] == game.board[i][1]
					&& game.board[i][1] == game.board[i][2]
					&& game.board[i][0] != '*') {
				win = true;
				whoWin(game, i, 0);
				break;
			}
		}

		if (game.board[0][0] == game.board[1][1]
				&& game.board[1][1] == game.board[2][2]
				&& game.board[1][1] != '*') {
			win = true;
			whoWin(game, 0, 0);
		}
		if (game.board[0][2] == game.board[1][1]
				&& game.board[1][1] == game.board[2][0]
				&& game.board[1][1] != '*') {
			win = true;
			whoWin(game, 1, 1);
		}
	}

	public void nextTurn() {

		BoardSell BoardSell = new BoardSell();
		int number = 0;
		while (!win) {
			if (checkEmptyCells(game.board)) {
				int x = 0;
				int y = 0;
				do {
					x = (int) (Math.random() * 3);
					y = (int) (Math.random() * 3);
				} while (game.board[BoardSell.x = x][BoardSell.y = y] != '*');
				game.board[BoardSell.x = x][BoardSell.y = y] = player[number]
						.getFigure();
				game.printTurn(game.board);
				player[number].updateGame(game);
				checkBoard(game);
				if (number == 0) {
					number = 1;
				} else {
					number = 0;
				}
			} else if (!win) {
				player[0].draw(player[0]);
				player[1].draw(player[1]);
				win = true;
			}
		}
	}

	public boolean checkEmptyCells(char board[][]) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == '*') {
					return true;
				}
			}
		}
		return false;
	}

	public void checkFinish() {
		if (!win) {
			nextTurn();
		}
		System.out.println("Game end");
	}
}
