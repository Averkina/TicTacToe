import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class PlayerServer implements PlayerInterface {

	public static final int PORT = 8002;
	private ServerGame serverSend;
	private Socket socket;

	PlayerServer(Socket socket) {
		this.serverSend = new ServerGame();
		this.socket = socket;
		Thread t = new Thread(serverSend);
		t.start();
		System.out.println("START SERVER");
	}

	private class ServerGame implements Runnable {
		private InputStream inStream;
		private OutputStream outStream;
		private PrintWriter out;
		private Scanner scaner;

		@Override
		public void run() {

			try {

				try {
					inStream = socket.getInputStream();
					outStream = socket.getOutputStream();
					out = new PrintWriter(outStream);
					scaner = new Scanner(inStream);
					while (scaner.hasNextLine()) {
						String line = scaner.nextLine();
						if (line.startsWith("updateBoardAfterPlayerTurn")) {
							String gameString = line.substring(26);
							Game game = new Game(gameString);
							arbitrator.updateBoardAfterPlayerTurn(game);
							game.printBoard();
						}
					}
				} finally {
					socket.close();
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

	private ArbitratorInterface arbitrator;
	private char figure;
	private String namePlayer;

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
		serverSend.send("setFigure " + figure);
	}

	@Override
	public void setNamePlayer(String namePlayer) {
		this.namePlayer = namePlayer;
		serverSend.send("setNamePlayer " + namePlayer);
	}

	@Override
	public void makeMove(Game game) {
		serverSend.send("makeMove" + game.convertToString(game));
	}

	@Override
	public void win() {
		serverSend.send("win");
	}

	@Override
	public void loss() {
		serverSend.send("loss");
	}

	@Override
	public void draw() {
		serverSend.send("draw");
	}

	@Override
	public void setArbitrator(ArbitratorInterface arbitratorInterface) {
		this.arbitrator = arbitratorInterface;
	}

}
