package cz.litvaluk.fit.adp.game.model.gameobjects.missile;

import cz.litvaluk.fit.adp.game.model.gameobjects.Position;
import cz.litvaluk.fit.adp.game.strategy.RealisticMissileMovementStrategy;

public class RealisticMissile extends AbstractMissile {

    public RealisticMissile(Position position) {
        this.position = position;
        this.missileMovementStrategy = new RealisticMissileMovementStrategy();
    }

}
