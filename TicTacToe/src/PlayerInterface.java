public interface PlayerInterface {

	char getFigure();

	String getNamePlayer();

	void setArbitrator(ArbitratorInterface arbitrator);

	void setFigure(char figure);

	void setNamePlayer(String namePlayer);

	void makeMove(Game game);

	void win();

	void loss();

	void draw();

}
