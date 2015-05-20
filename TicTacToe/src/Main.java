public class Main {

	public static void main(String[] args) throws Throwable {

		PlayerServer ps1 = new PlayerServer();
		ComputerPlayer computerPlayer = new ComputerPlayer('x', "Maria");
		Arbitrator arbitrator = new Arbitrator(ps1, computerPlayer);
		ps1.setArbitrator(arbitrator);
		computerPlayer.setArbitrator(arbitrator);

		HumanPlayer humanPlayer = new HumanPlayer('o', "Valery");
		PlayerClient pc = new PlayerClient(humanPlayer);
		humanPlayer.setArbitrator(pc);

		arbitrator.startGame();
	}
}
