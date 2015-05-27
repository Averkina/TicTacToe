import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Lobby {

	Lobby() {
		Thread t = new Thread(new LobbyGame());
		t.start();
		System.out.println("START LOBBY");
	}

	private static class LobbyGame implements Runnable {
		@Override
		public void run() {
			try {
				ServerSocket serverSocket = new ServerSocket(PlayerServer.PORT);
				int countPlayer = 0;
				PlayerServer[] playerServers = new PlayerServer[2];
				while (countPlayer < 2) {
					Socket socket = serverSocket.accept();
					playerServers[countPlayer] = new PlayerServer(socket);
					countPlayer++;
				}
				Arbitrator arbitrator = new Arbitrator(playerServers[0],
						playerServers[1]);
				playerServers[0].setArbitrator(arbitrator);
				playerServers[1].setArbitrator(arbitrator);

				arbitrator.startGame();
				countPlayer = 0;
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}
