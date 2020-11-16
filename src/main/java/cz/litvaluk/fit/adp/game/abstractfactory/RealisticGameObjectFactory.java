package cz.litvaluk.fit.adp.game.abstractfactory;

import cz.litvaluk.fit.adp.game.model.gameobjects.Position;
import cz.litvaluk.fit.adp.game.model.gameobjects.enemy.RealisticEnemy;
import cz.litvaluk.fit.adp.game.model.gameobjects.missile.AbstractMissile;
import cz.litvaluk.fit.adp.game.model.gameobjects.missile.RealisticMissile;

public class RealisticGameObjectFactory implements AbstractGameObjectFactory {

    @Override
    public AbstractMissile createMissile(Position position, double startingVelocity, double startingAngle) {
        return new RealisticMissile(position, startingVelocity, startingAngle);
    }

    @Override
    public RealisticEnemy createEnemy(Position position) {
        return new RealisticEnemy(position);
    }

}
