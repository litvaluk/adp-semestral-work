package cz.litvaluk.fit.adp.game.model.gameobjects.missile;

import cz.litvaluk.fit.adp.game.model.gameobjects.TimeableGameObject;
import cz.litvaluk.fit.adp.game.visitor.GameObjectVisitor;

public abstract class AbstractMissile extends TimeableGameObject {

    public abstract void move();

    @Override
    public void acceptVisitor(GameObjectVisitor visitor) {
        visitor.visitMissile(this);
    }

}
