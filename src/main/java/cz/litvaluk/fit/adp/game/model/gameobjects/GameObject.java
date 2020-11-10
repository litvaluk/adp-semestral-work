package cz.litvaluk.fit.adp.game.model.gameobjects;

public class GameObject {

    private Position position;

    public GameObject(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void move(Vector vector) {
        position = position.add(vector);
    }

}
