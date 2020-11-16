package cz.litvaluk.fit.adp.game.abstractfactory;

import cz.litvaluk.fit.adp.game.model.gameobjects.Position;
import cz.litvaluk.fit.adp.game.model.gameobjects.enemy.SimpleEnemy;
import cz.litvaluk.fit.adp.game.model.gameobjects.missile.SimpleMissile;

public class SimpleGameObjectFactory implements AbstractGameObjectFactory {

    @Override
    public SimpleMissile createMissile(Position position, double startingVelocity, double startingAngle) {
        return new SimpleMissile(position, startingVelocity, startingAngle);
    }

    @Override
    public SimpleEnemy createEnemy(Position position) {
        return new SimpleEnemy(position);
    }

}
