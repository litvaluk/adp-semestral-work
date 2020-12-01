package cz.litvaluk.fit.adp.game.strategy.enemy;

import cz.litvaluk.fit.adp.game.model.gameobjects.enemy.AbstractEnemy;

public interface EnemyMovementStrategy {

    void updatePosition(AbstractEnemy enemy);

}
