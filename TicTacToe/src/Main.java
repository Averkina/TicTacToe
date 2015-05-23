public class Main {

	public static void main(String[] args) throws Throwable {
		Lobby lobby = new Lobby();

		PlayerInterface computerPlayer = new ComputerPlayer('x', "Maria");
		PlayerClient pcComputer = new PlayerClient(computerPlayer);
		computerPlayer.setArbitrator(pcComputer);

		// PlayerInterface humanPlayer = new ComputerPlayer('o', "Maria2");
		PlayerInterface humanPlayer = new HumanPlayer('o', "Valery");
		PlayerClient pcHuman = new PlayerClient(humanPlayer);
		humanPlayer.setArbitrator(pcHuman);

	}
}
