package cz.litvaluk.fit.adp.game.model.gameobjects;

public abstract class GameObject {

    protected Position position;

    public Position getPosition() {
        return position;
    }

    public void move(Vector vector) {
        position = position.add(vector);
    }

}
