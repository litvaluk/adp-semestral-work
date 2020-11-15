package cz.litvaluk.fit.adp.game.model.gameobjects;

public abstract class GameObject {

    protected Position position;

    protected void move(Vector vector) {
        position = position.add(vector);
    }

    public Position getPosition() {
        return position;
    }

}
