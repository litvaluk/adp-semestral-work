package cz.litvaluk.fit.adp;

import cz.litvaluk.fit.adp.game.config.GameConfig;
import cz.litvaluk.fit.adp.game.model.gameobjects.Position;
import cz.litvaluk.fit.adp.game.model.gameobjects.enemy.AbstractEnemy;
import cz.litvaluk.fit.adp.game.model.gameobjects.missile.AbstractMissile;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class CollisionTest {

    @Test
    public void testEnemyCollidingWithMissile() {
        Position enemyPosition = new Position(25, 25);
        Position missilePosition = new Position(27, 23);

        AbstractEnemy enemy = Mockito.mock(AbstractEnemy.class);
        AbstractMissile missile = Mockito.mock(AbstractMissile.class);

        Mockito.when(enemy.getPosition()).thenReturn(enemyPosition);
        Mockito.when(enemy.isColliding(missile)).thenCallRealMethod();
        Mockito.when(missile.getPosition()).thenReturn(missilePosition);

        Assert.assertTrue(enemy.isColliding(missile));
    }

    @Test
    public void testEnemyNotCollidingWithMissile() {
        Position enemyPosition = new Position(10, 10);
        Position missilePosition = new Position(100, 100);

        AbstractEnemy enemy = Mockito.mock(AbstractEnemy.class);
        AbstractMissile missile = Mockito.mock(AbstractMissile.class);

        Mockito.when(enemy.getPosition()).thenReturn(enemyPosition);
        Mockito.when(enemy.isColliding(missile)).thenCallRealMethod();
        Mockito.when(missile.getPosition()).thenReturn(missilePosition);

        Assert.assertFalse(enemy.isColliding(missile));
    }

    @Test
    public void testEnemyOutOfBounds() {
        Position aboveBoundsPosition = new Position(GameConfig.ENEMY_MAX_X - 100, GameConfig.ENEMY_MIN_Y - 100);
        Position belowBoundsPosition = new Position(GameConfig.ENEMY_MAX_X - 100, GameConfig.ENEMY_MAX_Y + 100);
        Position rightBoundsPosition = new Position(GameConfig.ENEMY_MAX_X + 100, GameConfig.ENEMY_MAX_Y - 100);
        Position leftBoundsPosition = new Position(GameConfig.ENEMY_MIN_X - 100, GameConfig.ENEMY_MAX_Y - 100);

        AbstractEnemy enemyAboveMock = Mockito.mock(AbstractEnemy.class);
        Mockito.when(enemyAboveMock.getPosition()).thenReturn(aboveBoundsPosition);
        Mockito.when(enemyAboveMock.isOutOfBounds()).thenCallRealMethod();

        AbstractEnemy enemyBelowMock = Mockito.mock(AbstractEnemy.class);
        Mockito.when(enemyBelowMock.getPosition()).thenReturn(belowBoundsPosition);
        Mockito.when(enemyBelowMock.isOutOfBounds()).thenCallRealMethod();

        AbstractEnemy enemyRightMock = Mockito.mock(AbstractEnemy.class);
        Mockito.when(enemyRightMock.getPosition()).thenReturn(rightBoundsPosition);
        Mockito.when(enemyRightMock.isOutOfBounds()).thenCallRealMethod();

        AbstractEnemy enemyLeftMock = Mockito.mock(AbstractEnemy.class);
        Mockito.when(enemyLeftMock.getPosition()).thenReturn(leftBoundsPosition);
        Mockito.when(enemyLeftMock.isOutOfBounds()).thenCallRealMethod();

        Assert.assertTrue(enemyAboveMock.isOutOfBounds());
        Assert.assertTrue(enemyBelowMock.isOutOfBounds());
        Assert.assertTrue(enemyRightMock.isOutOfBounds());
        Assert.assertTrue(enemyLeftMock.isOutOfBounds());
    }

    @Test
    public void testEnemyInBounds() {
        Position outOfBoundsPosition = new Position(GameConfig.ENEMY_MAX_X - 100, GameConfig.ENEMY_MAX_Y - 100);
        AbstractEnemy enemyMock = Mockito.mock(AbstractEnemy.class);
        Mockito.when(enemyMock.getPosition()).thenReturn(outOfBoundsPosition);
        Mockito.when(enemyMock.isOutOfBounds()).thenCallRealMethod();
        Assert.assertFalse(enemyMock.isOutOfBounds());
    }

}
