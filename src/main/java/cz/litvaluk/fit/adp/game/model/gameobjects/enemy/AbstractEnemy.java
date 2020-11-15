package cz.litvaluk.fit.adp.game.model.gameobjects.enemy;

import cz.litvaluk.fit.adp.game.model.gameobjects.GameObject;
import cz.litvaluk.fit.adp.game.visitor.GameObjectVisitor;

public abstract class AbstractEnemy extends GameObject {

    @Override
    public void acceptVisitor(GameObjectVisitor visitor) {
        // TODO
    }

}
