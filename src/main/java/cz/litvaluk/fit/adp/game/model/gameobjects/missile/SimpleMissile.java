package cz.litvaluk.fit.adp.game.model.gameobjects.missile;

import cz.litvaluk.fit.adp.game.model.gameobjects.Position;
import cz.litvaluk.fit.adp.game.strategy.SimpleMissileMovementStrategy;

public class SimpleMissile extends AbstractMissile {

    public SimpleMissile(Position position, double startingVelocity, double startingAngle) {
        this.position = position;
        this.missileMovementStrategy = new SimpleMissileMovementStrategy();
        this.startingVelocity = startingVelocity;
        this.startingAngle = startingAngle;
    }

}
