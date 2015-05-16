public class Main {

	public static void main(String[] args) throws Throwable {

		HumanPlayer humanPlayer = new HumanPlayer('o', "Valery");
		ComputerPlayer computerPlayer = new ComputerPlayer('x', "Maria");
		Arbitrator arbitrator = new Arbitrator(humanPlayer, computerPlayer);
		arbitrator.startGame();
	}
}
