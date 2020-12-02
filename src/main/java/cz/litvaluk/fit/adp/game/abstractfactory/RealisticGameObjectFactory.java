package cz.litvaluk.fit.adp.game.abstractfactory;

import cz.litvaluk.fit.adp.game.config.GameConfig;
import cz.litvaluk.fit.adp.game.model.gameobjects.Position;
import cz.litvaluk.fit.adp.game.model.gameobjects.enemy.AbstractEnemy;
import cz.litvaluk.fit.adp.game.model.gameobjects.enemy.RealisticEnemy;
import cz.litvaluk.fit.adp.game.model.gameobjects.missile.AbstractMissile;
import cz.litvaluk.fit.adp.game.model.gameobjects.missile.RealisticMissile;

import java.util.concurrent.ThreadLocalRandom;

public class RealisticGameObjectFactory implements AbstractGameObjectFactory {

    @Override
    public AbstractMissile createMissile(Position position, double startingVelocity, double startingAngle) {
        return new RealisticMissile(position, startingVelocity, startingAngle);
    }

    @Override
    public RealisticEnemy createEnemy(Position position) {
        return new RealisticEnemy(position);
    }

    @Override
    public AbstractEnemy createEnemyAtRandomPosition() {
        int randomX = ThreadLocalRandom.current().nextInt(GameConfig.ENEMY_MIN_X, GameConfig.ENEMY_MAX_X);
        int randomY = ThreadLocalRandom.current().nextInt(GameConfig.ENEMY_MIN_Y, GameConfig.ENEMY_MAX_Y);
        return createEnemy(new Position(randomX, randomY));
    }

    @Override
    public AbstractEnemy createEnemyCopy(AbstractEnemy enemy) {
        AbstractEnemy newEnemy = new RealisticEnemy(enemy);
        newEnemy.addToBornAt(-enemy.getAge());
        return newEnemy;
    }

    @Override
    public AbstractMissile createMissileCopy(AbstractMissile missile) {
        AbstractMissile newMissile = createMissile(new Position(missile.getPosition().getX(),
                missile.getPosition().getY()),
                missile.getStartingVelocity(),
                missile.getStartingAngle());
        newMissile.addToBornAt(-missile.getAge());
        return newMissile;
    }

}
