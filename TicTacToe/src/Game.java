public class Game {

	char board[][] = new char[3][3];

	public void printBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(board[i][j] = '*');
			}
			System.out.println(" ");
		}
		System.out.println(" ");
	}

	public void printTurn(char board[][]) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println(" ");
		}
		System.out.println(" ");
	}

	public boolean isIdleSell(int x, int y) {
		if (board[x][y] != '*') {
			return true;
		}
		return false;
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

}
