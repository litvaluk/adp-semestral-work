package cz.litvaluk.fit.adp.game.model.gameobjects;

import cz.litvaluk.fit.adp.game.visitor.GameObjectVisitable;

public abstract class GameObject implements GameObjectVisitable {

    protected Position position;

    protected void move(Vector vector) {
        position = position.add(vector);
    }

    public Position getPosition() {
        return position;
    }

}
