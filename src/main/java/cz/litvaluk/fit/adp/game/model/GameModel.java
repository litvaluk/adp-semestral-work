package cz.litvaluk.fit.adp.game.model;

import cz.litvaluk.fit.adp.game.abstractfactory.AbstractGameObjectFactory;
import cz.litvaluk.fit.adp.game.abstractfactory.SimpleGameObjectFactory;
import cz.litvaluk.fit.adp.game.config.GameConfig;
import cz.litvaluk.fit.adp.game.model.gameobjects.Position;
import cz.litvaluk.fit.adp.game.model.gameobjects.cannon.Cannon;
import cz.litvaluk.fit.adp.game.observer.Subject;

public class GameModel extends Subject {

    private Cannon cannon;
    private AbstractGameObjectFactory gameObjectFactory;

    public GameModel() {
        gameObjectFactory = new SimpleGameObjectFactory();
        cannon = new Cannon(new Position(GameConfig.CANNON_X, GameConfig.CANNON_Y));
    }

    public Position getCannonPosition() {
        return cannon.getPosition();
    }

    public void moveCannonUp() {
        cannon.moveUp();
        notifyObservers();
    }

    public void moveCannonDown() {
        cannon.moveDown();
        notifyObservers();
    }

}
