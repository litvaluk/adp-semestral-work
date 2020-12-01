package cz.litvaluk.fit.adp.game.model.gameobjects.enemy;

import cz.litvaluk.fit.adp.game.model.gameobjects.Position;
import cz.litvaluk.fit.adp.game.strategy.enemy.SimpleEnemyMovementStrategy;

import java.util.concurrent.ThreadLocalRandom;

public class SimpleEnemy extends AbstractEnemy {

    public SimpleEnemy(Position position) {
        this.position = position;
        this.enemyDirection = EnemyDirection.getRandomEnemyDirection();
        this.directionSwitchTime = System.nanoTime();
        this.directionChangeInterval = getRandomDirectionChangeInterval();
        this.speed = 0;
        this.enemyMovementStrategy = new SimpleEnemyMovementStrategy();
        this.imagePath = ThreadLocalRandom.current().nextInt(2) == 0 ? "images/enemy1.png" : "images/enemy2.png";
    }

}
