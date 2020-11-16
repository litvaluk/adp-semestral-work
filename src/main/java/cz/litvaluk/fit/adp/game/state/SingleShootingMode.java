package cz.litvaluk.fit.adp.game.state;

import cz.litvaluk.fit.adp.game.model.gameobjects.cannon.Cannon;

public class SingleShootingMode implements ShootingMode {

    @Override
    public String getName() {
        return "single";
    }

    @Override
    public void shoot(Cannon cannon) {
        cannon.simpleShoot();
    }

    @Override
    public ShootingMode nextMode() {
        return new DoubleShootingMode();
    }

}
