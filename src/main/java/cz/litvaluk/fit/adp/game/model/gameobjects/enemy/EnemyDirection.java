package cz.litvaluk.fit.adp.game.model.gameobjects.enemy;

import java.util.List;
import java.util.Random;

public enum EnemyDirection {
    LEFT,
    UP_LEFT,
    UP,
    UP_RIGHT,
    RIGHT,
    DOWN_RIGHT,
    DOWN,
    DOWN_LEFT;

    private static final List<EnemyDirection> VALUES = List.of(values());
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static EnemyDirection getRandomEnemyDirection()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

    public static EnemyDirection getInverseEnemyDirection(EnemyDirection enemyDirection)  {
        switch (enemyDirection) {
            case UP:
                return DOWN;
            case UP_RIGHT:
                return DOWN_LEFT;
            case RIGHT:
                return LEFT;
            case DOWN_RIGHT:
                return UP_LEFT;
            case DOWN:
                return UP;
            case DOWN_LEFT:
                return UP_RIGHT;
            case LEFT:
                return RIGHT;
            case UP_LEFT:
                return DOWN_RIGHT;
            default:
                return null;
        }
    }

}
