public class Main {

	public static void main(String[] args) throws Throwable {

		if (args[0].equals("Lobby")) {
			Lobby lobby = new Lobby();
		} else if (args[0].equals("Computer")) {
			PlayerInterface computerPlayer = new ComputerPlayer();
			PlayerClient pcComputer = new PlayerClient(computerPlayer);
			computerPlayer.setArbitrator(pcComputer);
		} else if (args[0].equals("Human")) {
			PlayerInterface humanPlayer = new HumanPlayer();
			PlayerClient pcHuman = new PlayerClient(humanPlayer);
			humanPlayer.setArbitrator(pcHuman);
		}
	}
}
