package cz.litvaluk.fit.adp.game.model.gameobjects.missile;

import cz.litvaluk.fit.adp.game.model.gameobjects.TimeableGameObject;
import cz.litvaluk.fit.adp.game.strategy.MissileMovementStrategy;
import cz.litvaluk.fit.adp.game.visitor.GameObjectVisitor;

public abstract class AbstractMissile extends TimeableGameObject {

    protected MissileMovementStrategy missileMovementStrategy;
    protected double startingVelocity;
    protected double startingAngle;

    public void move() {
        missileMovementStrategy.updatePosition(this);
    }

    public double getStartingVelocity() {
        return startingVelocity;
    }

    public double getStartingAngle() {
        return startingAngle;
    }

    @Override
    public void acceptVisitor(GameObjectVisitor visitor) {
        visitor.visitMissile(this);
    }

}
