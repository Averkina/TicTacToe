import java.io.IOException;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;

public class PlayerClient implements ArbitratorInterface, Observer {

	private PlayerInterface player;
	Socket socket;
	Transport transport;

	PlayerClient(PlayerInterface player) {
		try {
			this.player = player;
			socket = new Socket("127.0.0.1", PlayerServer.PORT);
			transport = new Transport(socket);
			transport.addObserver(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateBoardAfterPlayerTurn(Game game) {
		transport.send("updateBoardAfterPlayerTurn"
				+ game.convertToString(game));
	}

	@Override
	public void startGame() {
	}

	@Override
	public void update(Observable o, Object arg) {
		String line = (String) arg;
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

}
