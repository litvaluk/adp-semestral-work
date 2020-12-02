package cz.litvaluk.fit.adp;

import cz.litvaluk.fit.adp.game.abstractfactory.AbstractGameObjectFactory;
import cz.litvaluk.fit.adp.game.abstractfactory.SimpleGameObjectFactory;
import cz.litvaluk.fit.adp.game.config.GameConfig;
import cz.litvaluk.fit.adp.game.model.gameobjects.Position;
import cz.litvaluk.fit.adp.game.model.gameobjects.cannon.Cannon;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class CannonTest {

    @Test
    public void testChangeForce() {
        Cannon cannon = new Cannon(new Position(0, 0), Mockito.mock(AbstractGameObjectFactory.class));
        Assert.assertEquals(cannon.getForce(), GameConfig.STARTING_FORCE, 0.001);
        cannon.increaseForce();
        cannon.increaseForce();
        Assert.assertEquals(cannon.getForce(), GameConfig.STARTING_FORCE + 2 * GameConfig.FORCE_STEP, 0.001);
        cannon.decreaseForce();
        Assert.assertEquals(cannon.getForce(), GameConfig.STARTING_FORCE + GameConfig.FORCE_STEP, 0.001);
    }

    @Test
    public void testChangeAngle() {
        Cannon cannon = new Cannon(new Position(0, 0), new SimpleGameObjectFactory());
        Assert.assertEquals(cannon.getAngle(), GameConfig.STARTING_ANGLE, 0.001);
        cannon.aimUp();
        Assert.assertEquals(cannon.getAngle(), GameConfig.STARTING_ANGLE + GameConfig.ANGLE_STEP, 0.001);
        cannon.aimDown();
        cannon.aimDown();
        Assert.assertEquals(cannon.getAngle(), GameConfig.STARTING_ANGLE - GameConfig.ANGLE_STEP, 0.001);
    }

    @Test
    public void testShoot() {
        Cannon cannon = new Cannon(new Position(0, 0), new SimpleGameObjectFactory());
        Assert.assertEquals(cannon.shoot().size(), 1);
        cannon.switchMode();
        Assert.assertEquals(cannon.shoot().size(), 2);
        cannon.switchMode();
        Assert.assertEquals(cannon.shoot().size(), 1);
    }

}
