package cz.litvaluk.fit.adp.game.strategy;

import cz.litvaluk.fit.adp.game.config.GameConfig;
import cz.litvaluk.fit.adp.game.model.gameobjects.Vector;
import cz.litvaluk.fit.adp.game.model.gameobjects.missile.AbstractMissile;

public class RealisticMissileMovementStrategy implements MissileMovementStrategy {

    @Override
    public void updatePosition(AbstractMissile missile) {
        double velocity = missile.getStartingVelocity();
        double angle = Math.PI * missile.getStartingAngle() / 180;
        double timeInSec = missile.getAge() / 1000000000.0;

        int dX = (int) (GameConfig.FORCE_MODIFIER * velocity * Math.cos(angle));
        int dY = (int) -(GameConfig.FORCE_MODIFIER * velocity * Math.sin(angle) - GameConfig.GRAVITY * timeInSec);

        missile.move(new Vector(dX, dY));
    }

}
