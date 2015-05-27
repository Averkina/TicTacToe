public interface PlayerInterface {

	void setArbitrator(ArbitratorInterface arbitrator);

	void setFigure(char figure);

	void makeMove(Game game);

	void win();

	void loss();

	void draw();

}
