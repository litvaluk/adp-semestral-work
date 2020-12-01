package cz.litvaluk.fit.adp.game.strategy.missile;

import cz.litvaluk.fit.adp.game.config.GameConfig;
import cz.litvaluk.fit.adp.game.model.gameobjects.Vector;
import cz.litvaluk.fit.adp.game.model.gameobjects.missile.AbstractMissile;

public class RealisticMissileMovementStrategy implements MissileMovementStrategy {

    @Override
    public void updatePosition(AbstractMissile missile) {
        double velocity = missile.getStartingVelocity();
        double angle = Math.PI * missile.getStartingAngle() / 180;
        double timeInSec = missile.getAge() / 1000000000.0;

        double dX = GameConfig.FORCE_MODIFIER * velocity * Math.cos(angle);
        double dY = -(GameConfig.FORCE_MODIFIER * velocity * Math.sin(angle) - GameConfig.GRAVITY * timeInSec);

        double unadjustedAngle = Math.atan(dX/dY) * 180/Math.PI;
        missile.setAngle(dY > 0 ? unadjustedAngle + 270 : unadjustedAngle + 90);

        missile.move(new Vector((int) dX, (int) dY));
    }

}
