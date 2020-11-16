package cz.litvaluk.fit.adp.game.state;

import cz.litvaluk.fit.adp.game.model.gameobjects.cannon.Cannon;

public class DoubleShootingMode implements ShootingMode {

    @Override
    public void shoot(Cannon cannon) {
        cannon.aimUp();
        cannon.simpleShoot();
        cannon.aimDown();
        cannon.aimDown();
        cannon.simpleShoot();
        cannon.aimUp();
    }

    @Override
    public ShootingMode nextMode() {
        return new SingleShootingMode();
    }

}
