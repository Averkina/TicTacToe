public class Arbitrator implements ArbitratorInterface {

	PlayerInterface player1;
	PlayerInterface player2;

	Arbitrator(PlayerInterface player1, PlayerInterface player2) {
		this.player1 = player1;
		this.player2 = player2;
	}

	Boolean endGame = false;
	Boolean activePlayer1 = true;
	private static final char figurePlayer1 = 'x';
	private static final char figurePlayer2 = 'o';

	public void whoWin(Game game, int i, int j) {
		if (game.board[i][j] == figurePlayer1) {
			player1.win();
			player2.loss();
		} else {
			player2.win();
			player1.loss();
		}
	}

	public void checkBoard(Game game) {

		for (int i = 0; i < 3; i++) {
			if (game.board[0][i] == game.board[1][i]
					&& game.board[1][i] == game.board[2][i]
					&& game.board[0][i] != Game.EMPTY) {
				endGame = true;
				whoWin(game, 0, i);
				break;
			}
			if (game.board[i][0] == game.board[i][1]
					&& game.board[i][1] == game.board[i][2]
					&& game.board[i][0] != Game.EMPTY) {
				endGame = true;
				whoWin(game, i, 0);
				break;
			}
		}

		if (game.board[0][0] == game.board[1][1]
				&& game.board[1][1] == game.board[2][2]
				&& game.board[1][1] != Game.EMPTY) {
			endGame = true;
			whoWin(game, 0, 0);
		}
		if (game.board[0][2] == game.board[1][1]
				&& game.board[1][1] == game.board[2][0]
				&& game.board[1][1] != Game.EMPTY) {
			endGame = true;
			whoWin(game, 1, 1);
		}
	}

	public void turn(Game game) {
		if (activePlayer1) {
			activePlayer1 = false;
			player1.makeMove(game);
		} else {
			activePlayer1 = true;
			player2.makeMove(game);
		}
	}

	public void checkFinish(Game game) {
		checkBoard(game);
		if (!endGame) {
			if (game.hasEmptyCell()) {
				turn(game);
			} else {
				player1.draw();
				player2.draw();
				endGame = true;
			}
		}
	}

	@Override
	public void updateBoardAfterPlayerTurn(Game game) {
		checkFinish(game);
	}

	@Override
	public void startGame() {
		player1.setFigure(figurePlayer1);
		player2.setFigure(figurePlayer2);
		checkFinish(new Game());
	}

}
