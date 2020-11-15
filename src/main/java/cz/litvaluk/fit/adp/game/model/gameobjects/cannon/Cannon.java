package cz.litvaluk.fit.adp.game.model.gameobjects.cannon;

import cz.litvaluk.fit.adp.game.abstractfactory.AbstractGameObjectFactory;
import cz.litvaluk.fit.adp.game.config.GameConfig;
import cz.litvaluk.fit.adp.game.model.gameobjects.GameObject;
import cz.litvaluk.fit.adp.game.model.gameobjects.Position;
import cz.litvaluk.fit.adp.game.model.gameobjects.Vector;
import cz.litvaluk.fit.adp.game.model.gameobjects.missile.AbstractMissile;

public class Cannon extends GameObject {

    AbstractGameObjectFactory gameObjectFactory;

    public Cannon(Position position, AbstractGameObjectFactory gameObjectFactory) {
        this.position = position;
        this.gameObjectFactory = gameObjectFactory;
    }

    public void moveUp() {
        move(new Vector(0, -GameConfig.MOVE_STEP));
    }

    public void moveDown() {
        move(new Vector(0, GameConfig.MOVE_STEP));
    }

    public AbstractMissile shoot() {
        return gameObjectFactory.createMissile(position.add(new Vector(10, 0)));
    }

}
