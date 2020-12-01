package cz.litvaluk.fit.adp.game.model.gameobjects.enemy;

import cz.litvaluk.fit.adp.game.model.gameobjects.Position;
import cz.litvaluk.fit.adp.game.strategy.enemy.RealisticEnemyMovementStrategy;

import java.util.concurrent.ThreadLocalRandom;

public class RealisticEnemy extends AbstractEnemy {

    public RealisticEnemy(Position position) {
        this.position = position;
        this.enemyDirection = EnemyDirection.getRandomEnemyDirection();
        this.directionSwitchTime = System.nanoTime();
        this.directionChangeInterval = getRandomDirectionChangeInterval();
        this.speed = getRandomSpeed();
        this.enemyMovementStrategy = new RealisticEnemyMovementStrategy();
        this.imagePath = ThreadLocalRandom.current().nextInt(2) == 0 ? "images/enemy1.png" : "images/enemy2.png";
    }

}
