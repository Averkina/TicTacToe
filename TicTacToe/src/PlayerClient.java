import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class PlayerClient implements ArbitratorInterface {

	private PlayerInterface player;
	private OutputStream outStream;
	private ClientGame clientGame;
	private Socket socket;
	private Scanner scaner;
	private InputStream inStream;
	private PrintWriter out;

	PlayerClient(PlayerInterface player) {
		this.player = player;
		clientGame = new ClientGame();
		Thread t = new Thread(clientGame);
		t.start();
		System.out.println("CLIENT START");
	}

	private class ClientGame implements Runnable {

		@Override
		public void run() {
			try {
				socket = new Socket("127.0.0.1", PlayerServer.PORT);
				inStream = socket.getInputStream();
				outStream = socket.getOutputStream();
				scaner = new Scanner(inStream);
				out = new PrintWriter(outStream);
				while (scaner.hasNextLine()) {
					String line = scaner.nextLine();
					if (line.startsWith("makeMove")) {
						String gameString = line.substring(8);
						Game game = new Game(gameString);
						player.makeMove(game);
					}
					if (line.startsWith("setFigure")) {
						String figureString = line.substring(9);
						player.setFigure(figureString.charAt(0));
					}
					if (line.startsWith("win")) {
						player.win();
					}
					if (line.startsWith("loss")) {
						player.loss();
					}
					if (line.startsWith("draw")) {
						player.draw();
					}
				}
			} catch (RuntimeException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void send(String outString) {
			while (out == null) {
				Thread.yield();
			}
			out.println(outString);
			out.flush();
		}
	}

	@Override
	public void updateBoardAfterPlayerTurn(Game game) {
		clientGame.send("updateBoardAfterPlayerTurn"
				+ game.convertToString(game));
	}

	@Override
	public void startGame() {
	}

}
