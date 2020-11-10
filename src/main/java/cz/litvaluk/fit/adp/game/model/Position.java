package cz.litvaluk.fit.adp.game.model;

public class Position  {

	private int dimX = 0;
	private int dimY = 0;

	public Position(int posX, int posY) {
		this.dimX = posX;
		this.dimY = posY;
	}

	public int getX() {
		return dimX;
	}
    
    public int getY() {
		return dimY;
	}
    
    public void setY(int y) {
		this.dimY = y;
	}
    
    public void setX(int x) {
		this.dimX = x;
	}

}