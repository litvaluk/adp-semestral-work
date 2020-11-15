package cz.litvaluk.fit.adp.game.strategy;

import cz.litvaluk.fit.adp.game.config.GameConfig;
import cz.litvaluk.fit.adp.game.model.gameobjects.Vector;
import cz.litvaluk.fit.adp.game.model.gameobjects.missile.AbstractMissile;

public class SimpleMissileMovementStrategy implements MissileMovementStrategy {

    @Override
    public void updatePosition(AbstractMissile missile) {
        missile.move(new Vector(GameConfig.MOVE_STEP, 0));
    }

}
