package cz.litvaluk.fit.adp;

import cz.litvaluk.fit.adp.game.config.GameConfig;
import cz.litvaluk.fit.adp.game.memento.Caretaker;
import cz.litvaluk.fit.adp.game.model.GameModel;
import org.junit.Assert;
import org.junit.Test;

public class QuickSaveTest {

    @Test
    public void testQuickSaveAndLoad() {
        GameModel gameModel = new GameModel();
        Caretaker.getInstance().setGameModel(gameModel);

        gameModel.cannonAimUp();
        gameModel.cannonAimUp();
        gameModel.cannonIncreaseForce();
        gameModel.cannonShoot();

        Assert.assertEquals(gameModel.getCannon().getAngle(),
                GameConfig.STARTING_ANGLE + 2 * GameConfig.ANGLE_STEP,
                0.001);
        Assert.assertEquals(gameModel.getCannon().getForce(),
                GameConfig.STARTING_FORCE + GameConfig.FORCE_STEP,
                0.001);
        Assert.assertEquals(gameModel.getGameObjects().size(), 3);

        gameModel.quickSave();

        gameModel.cannonAimDown();
        gameModel.cannonAimDown();
        gameModel.cannonAimDown();
        gameModel.cannonIncreaseForce();
        gameModel.update();

        gameModel.quickLoad();

        Assert.assertEquals(gameModel.getCannon().getAngle(),
                GameConfig.STARTING_ANGLE + 2 * GameConfig.ANGLE_STEP,
                0.001);
        Assert.assertEquals(gameModel.getCannon().getForce(),
                GameConfig.STARTING_FORCE + GameConfig.FORCE_STEP,
                0.001);
        Assert.assertEquals(gameModel.getGameObjects().size(), 3);
    }

}
