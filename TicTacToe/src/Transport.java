import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Observable;
import java.util.Scanner;

public class Transport extends Observable {

	private Socket socket;
	private Transfer transfer;

	public Transport(Socket socket) {
		transfer = new Transfer();
		this.socket = socket;
		Thread t = new Thread(transfer);
		t.start();
	}

	private class Transfer implements Runnable {

		@Override
		public void run() {
			try {
				InputStream inStream = socket.getInputStream();
				Scanner scanner = new Scanner(inStream);
				OutputStream outStream = socket.getOutputStream();
				out = new PrintWriter(outStream);
				while (scanner.hasNextLine()) {
					String line = scanner.nextLine();
					setChanged();
					notifyObservers(line);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private PrintWriter out;

	public void send(String outString) {
		while (out == null) {
			Thread.yield();
		}
		out.println(outString);
		out.flush();
	}

}