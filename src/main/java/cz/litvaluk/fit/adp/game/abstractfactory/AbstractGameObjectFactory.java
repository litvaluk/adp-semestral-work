package cz.litvaluk.fit.adp.game.abstractfactory;

import cz.litvaluk.fit.adp.game.model.gameobjects.enemy.AbstractEnemy;
import cz.litvaluk.fit.adp.game.model.gameobjects.missile.AbstractMissile;
import cz.litvaluk.fit.adp.game.model.gameobjects.Position;

public interface AbstractGameObjectFactory {

    AbstractMissile createMissile(Position position, double startingVelocity, double startingAngle);
    AbstractEnemy createEnemy(Position position);
    AbstractEnemy createEnemyAtRandomPosition();

    AbstractEnemy createEnemyCopy(AbstractEnemy enemy);
    AbstractMissile createMissileCopy(AbstractMissile abstractMissile);

}
