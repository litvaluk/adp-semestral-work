package cz.litvaluk.fit.adp.game.model.gameobjects.enemy;

import cz.litvaluk.fit.adp.game.config.GameConfig;
import cz.litvaluk.fit.adp.game.model.gameobjects.TimeableGameObject;
import cz.litvaluk.fit.adp.game.strategy.enemy.EnemyMovementStrategy;
import cz.litvaluk.fit.adp.game.visitor.GameObjectVisitor;

import java.util.concurrent.ThreadLocalRandom;

public abstract class AbstractEnemy extends TimeableGameObject {

    protected EnemyDirection enemyDirection;
    protected long directionSwitchTime;
    protected long directionChangeInterval;
    protected int speed;
    protected EnemyMovementStrategy enemyMovementStrategy;
    protected String imagePath;

    @Override
    public void acceptVisitor(GameObjectVisitor visitor) {
        visitor.visitEnemy(this);
    }

    public void changeDirectionRandom() {
        enemyDirection = EnemyDirection.getRandomEnemyDirection();
        directionSwitchTime = System.nanoTime();
        directionChangeInterval = getRandomDirectionChangeInterval();
    }

    public void changeDirectionInverse() {
        enemyDirection = EnemyDirection.getInverseEnemyDirection(enemyDirection);
        directionSwitchTime = System.nanoTime();
        directionChangeInterval = getRandomDirectionChangeInterval();
    }

    public EnemyDirection getDirection() {
        return enemyDirection;
    }

    public long getDirectionTime() {
        return System.nanoTime() - directionSwitchTime;
    }

    public void move() {
        enemyMovementStrategy.updatePosition(this);
    }

    public String getImagePath() {
        return imagePath;
    }

    public long getDirectionChangeInterval() {
        return directionChangeInterval;
    }

    public int getSpeed() {
        return speed;
    }

    protected long getRandomDirectionChangeInterval() {
        return ThreadLocalRandom.current()
                .nextLong(GameConfig.ENEMY_DIRECTION_INTERVAL_MIN * 1000000000L,
                        GameConfig.ENEMY_DIRECTION_INTERVAL_MAX * 1000000000L);
    }

    protected int getRandomSpeed() {
        return ThreadLocalRandom.current().nextInt(GameConfig.ENEMY_SPEED_INTERVAL_MIN,
                GameConfig.ENEMY_SPEED_INTERVAL_MAX + 1);
    }

    public boolean isOutOfBounds() {
        return position.getX() > GameConfig.ENEMY_MAX_X
                || position.getX() < GameConfig.ENEMY_MIN_X
                || position.getY() > GameConfig.ENEMY_MAX_Y
                || position.getY() < GameConfig.ENEMY_MIN_Y;
    }

}
