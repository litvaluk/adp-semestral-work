package cz.litvaluk.fit.adp.game.abstractfactory;

import cz.litvaluk.fit.adp.game.model.gameobjects.Position;
import cz.litvaluk.fit.adp.game.model.gameobjects.enemy.RealisticEnemy;
import cz.litvaluk.fit.adp.game.model.gameobjects.missile.RealisticMissile;

public class RealisticGameObjectFactory implements AbstractGameObjectFactory {

    @Override
    public RealisticMissile createMissile(Position position) {
        return new RealisticMissile(position);
    }

    @Override
    public RealisticEnemy createEnemy(Position position) {
        return new RealisticEnemy(position);
    }

}
