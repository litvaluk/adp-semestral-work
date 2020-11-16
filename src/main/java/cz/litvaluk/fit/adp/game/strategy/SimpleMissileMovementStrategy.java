package cz.litvaluk.fit.adp.game.strategy;

import cz.litvaluk.fit.adp.game.model.gameobjects.Vector;
import cz.litvaluk.fit.adp.game.model.gameobjects.missile.AbstractMissile;

public class SimpleMissileMovementStrategy implements MissileMovementStrategy {

    @Override
    public void updatePosition(AbstractMissile missile) {
        double startingVelocity = missile.getStartingVelocity();
        double startingAngleRad = Math.PI * missile.getStartingAngle() / 180;
        long time = missile.getAge() / 10000000L / 2;

        int dX = (int)(-startingVelocity*time*Math.cos(-startingAngleRad));
        int dY = (int)(startingVelocity*time*Math.sin(startingAngleRad));

        missile.move(new Vector(dX, dY));
    }

}
