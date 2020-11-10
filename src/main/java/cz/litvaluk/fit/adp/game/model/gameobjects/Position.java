package cz.litvaluk.fit.adp.game.model.gameobjects;

public class Position  {

	private final int x;
	private final int y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Position add(Vector vector) {
		return new Position(x + vector.getX(), y + vector.getY());
	}

}