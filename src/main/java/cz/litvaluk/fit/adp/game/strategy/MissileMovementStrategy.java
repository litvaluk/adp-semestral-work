package cz.litvaluk.fit.adp.game.strategy;

import cz.litvaluk.fit.adp.game.model.gameobjects.missile.AbstractMissile;

public interface MissileMovementStrategy {

    void updatePosition(AbstractMissile missile);

}
