package cz.litvaluk.fit.adp.game.model.gameobjects.collision;

import cz.litvaluk.fit.adp.game.model.gameobjects.TimeableGameObject;
import cz.litvaluk.fit.adp.game.model.gameobjects.Position;
import cz.litvaluk.fit.adp.game.visitor.GameObjectVisitor;

public class Collision extends TimeableGameObject {

    public Collision(Position position) {
        this.position = position;
    }

    @Override
    public void acceptVisitor(GameObjectVisitor visitor) {
        visitor.visitCollision(this);
    }

}
