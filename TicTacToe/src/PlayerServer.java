import java.net.Socket;
import java.util.Observable;
import java.util.Observer;

public class PlayerServer implements PlayerInterface, Observer {

	public static final int PORT = 8003;
	private Transport transport;

	PlayerServer(Socket socket) {
		transport = new Transport(socket);
		transport.addObserver(this);
	}

	private ArbitratorInterface arbitrator;

	@Override
	public void setFigure(char figure) {
		transport.send("setFigure" + figure);
	}

	@Override
	public void makeMove(Game game) {
		transport.send("makeMove" + game.convertToString(game));
	}

	@Override
	public void win() {
		transport.send("win");
	}

	@Override
	public void loss() {
		transport.send("loss");
	}

	@Override
	public void draw() {
		transport.send("draw");
	}

	@Override
	public void setArbitrator(ArbitratorInterface arbitratorInterface) {
		this.arbitrator = arbitratorInterface;
	}

	@Override
	public void update(Observable o, Object arg) {
		String line = (String) arg;
		if (line.startsWith("updateBoardAfterPlayerTurn")) {
			String gameString = line.substring(26);
			Game game = new Game(gameString);
			arbitrator.updateBoardAfterPlayerTurn(game);
		}
	}

}
