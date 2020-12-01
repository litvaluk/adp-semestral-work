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
        return new RealisticEnemy(new Position(randomX, randomY));
    }

}
