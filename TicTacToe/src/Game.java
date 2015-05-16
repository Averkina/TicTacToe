import java.util.HashMap;
import java.util.Map;

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

	public final static Map<Integer, Integer[]> numpad = new HashMap<Integer, Integer[]>() {
		{
			put(1, new Integer[] { 2, 0 });
			put(2, new Integer[] { 2, 1 });
			put(3, new Integer[] { 2, 2 });
			put(4, new Integer[] { 1, 0 });
			put(5, new Integer[] { 1, 1 });
			put(6, new Integer[] { 1, 2 });
			put(7, new Integer[] { 0, 0 });
			put(8, new Integer[] { 0, 1 });
			put(9, new Integer[] { 0, 2 });
		}
	};
}
