package cz.litvaluk.fit.adp.game.state;

import cz.litvaluk.fit.adp.game.model.gameobjects.cannon.Cannon;

public interface ShootingMode {

    void shoot(Cannon cannon);
    ShootingMode nextMode();

}
