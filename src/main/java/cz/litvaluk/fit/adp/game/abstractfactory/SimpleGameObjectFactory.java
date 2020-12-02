package cz.litvaluk.fit.adp.game.abstractfactory;

import cz.litvaluk.fit.adp.game.config.GameConfig;
import cz.litvaluk.fit.adp.game.model.gameobjects.Position;
import cz.litvaluk.fit.adp.game.model.gameobjects.enemy.AbstractEnemy;
import cz.litvaluk.fit.adp.game.model.gameobjects.enemy.RealisticEnemy;
import cz.litvaluk.fit.adp.game.model.gameobjects.enemy.SimpleEnemy;
import cz.litvaluk.fit.adp.game.model.gameobjects.missile.AbstractMissile;
import cz.litvaluk.fit.adp.game.model.gameobjects.missile.SimpleMissile;

import java.util.concurrent.ThreadLocalRandom;

public class SimpleGameObjectFactory implements AbstractGameObjectFactory {

    @Override
    public SimpleMissile createMissile(Position position, double startingVelocity, double startingAngle) {
        return new SimpleMissile(position, startingVelocity, startingAngle);
    }

    @Override
    public SimpleEnemy createEnemy(Position position) {
        return new SimpleEnemy(position);
    }

    @Override
    public AbstractEnemy createEnemyAtRandomPosition() {
        int randomX = ThreadLocalRandom.current().nextInt(GameConfig.ENEMY_MIN_X, GameConfig.ENEMY_MAX_X);
        int randomY = ThreadLocalRandom.current().nextInt(GameConfig.ENEMY_MIN_Y, GameConfig.ENEMY_MAX_Y);
        return createEnemy(new Position(randomX, randomY));
    }

    @Override
    public AbstractEnemy createEnemyCopy(AbstractEnemy enemy) {
        AbstractEnemy newEnemy = new SimpleEnemy(enemy);
        newEnemy.addToBornAt(-enemy.getAge());
        return newEnemy;
    }

    @Override
    public AbstractMissile createMissileCopy(AbstractMissile abstractMissile) {
        AbstractMissile newMissile = createMissile(new Position(abstractMissile.getPosition().getX(),
                        abstractMissile.getPosition().getY()),
                abstractMissile.getStartingVelocity(),
                abstractMissile.getStartingAngle());
        newMissile.addToBornAt(-abstractMissile.getAge());
        return newMissile;
    }
}
