package cz.litvaluk.fit.adp.game.strategy.enemy;

import cz.litvaluk.fit.adp.game.model.gameobjects.enemy.AbstractEnemy;

public class SimpleEnemyMovementStrategy implements EnemyMovementStrategy {

    @Override
    public void updatePosition(AbstractEnemy enemy) {
        // do nothing (stand still)
    }

}
