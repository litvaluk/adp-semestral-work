package cz.litvaluk.fit.adp.game.model.gameobjects.missile;

import cz.litvaluk.fit.adp.game.model.gameobjects.Position;
import cz.litvaluk.fit.adp.game.strategy.RealisticMissileMovementStrategy;

public class RealisticMissile extends AbstractMissile {

    public RealisticMissile(Position position, double startingVelocity, double startingAngle) {
        this.position = position;
        this.missileMovementStrategy = new RealisticMissileMovementStrategy();
        this.startingVelocity = startingVelocity;
        this.startingAngle = startingAngle;
        this.angle = startingAngle;
    }

}
