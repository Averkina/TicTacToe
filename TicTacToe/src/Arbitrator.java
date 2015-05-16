public class Arbitrator implements ArbitratorInterface {

	PlayerInterface player1;
	PlayerInterface player2;

	Arbitrator() {
	}

	Arbitrator(PlayerInterface player1, PlayerInterface player2) {
		this.player1 = player1;
		this.player2 = player2;
	}

	Boolean win = false;
	Game game = new Game();

	public void startGame() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				game.board[i][j] = ' ';
			}
		}
		game.printBoard();
		checkFinish();
	}

	public void whoWin(Game game, int i, int j) {
		if (player1.getFigure() == 'x' && game.board[i][j] == 'x') {
			player1.win();
			player2.loss();
		} else {
			player2.win();
			player1.loss();
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

		int number = 1;
		while (!win) {
			if (game.checkEmptyCells(game.board)) {
				if (number == 1) {
					player1.makeMove(game);
					number = 2;
					playerMoved(game);
				} else {
					player2.makeMove(game);
					number = 1;
					playerMoved(game);
				}
				game.printTurn(game.board);
				checkBoard(game);
			} else {
				player1.draw();
				player2.draw();
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

	@Override
	public void playerMoved(Game game) {
		// TODO Auto-generated method stub

	}
}
