public class Main {

	public static void main(String[] args) throws Throwable {
		System.out.println("START MAIN");
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

		// PlayerInterface humanPlayer = new ComputerPlayer('o', "Maria2");

	}
}
