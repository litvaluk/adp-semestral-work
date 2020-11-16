package cz.litvaluk.fit.adp.game.strategy;

import cz.litvaluk.fit.adp.game.model.gameobjects.Vector;
import cz.litvaluk.fit.adp.game.model.gameobjects.missile.AbstractMissile;

public class SimpleMissileMovementStrategy implements MissileMovementStrategy {

    @Override
    public void updatePosition(AbstractMissile missile) {
        double startingVelocity = missile.getStartingVelocity();
        double startingAngle = missile.getStartingAngle();
        long time = missile.getAge() / 10000000L / 2;

        int dX = (int)(-startingVelocity*time*Math.cos(startingAngle));
        int dY = (int)(startingVelocity*time*Math.sin(startingAngle));

        missile.move(new Vector(dX, dY));
    }

}
