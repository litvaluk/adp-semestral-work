package cz.litvaluk.fit.adp.game.model.gameobjects.missile;

import cz.litvaluk.fit.adp.game.model.gameobjects.TimeableGameObject;
import cz.litvaluk.fit.adp.game.strategy.MissileMovementStrategy;
import cz.litvaluk.fit.adp.game.visitor.GameObjectVisitor;

public abstract class AbstractMissile extends TimeableGameObject {

    protected MissileMovementStrategy missileMovementStrategy;

    public void move() {
        missileMovementStrategy.updatePosition(this);
    }

    @Override
    public void acceptVisitor(GameObjectVisitor visitor) {
        visitor.visitMissile(this);
    }

}
