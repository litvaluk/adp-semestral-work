package cz.litvaluk.fit.adp.game.model;

import cz.litvaluk.fit.adp.game.abstractfactory.AbstractGameObjectFactory;
import cz.litvaluk.fit.adp.game.abstractfactory.SimpleGameObjectFactory;
import cz.litvaluk.fit.adp.game.config.GameConfig;
import cz.litvaluk.fit.adp.game.model.gameobjects.GameObject;
import cz.litvaluk.fit.adp.game.model.gameobjects.Position;
import cz.litvaluk.fit.adp.game.model.gameobjects.cannon.Cannon;
import cz.litvaluk.fit.adp.game.model.gameobjects.missile.AbstractMissile;
import cz.litvaluk.fit.adp.game.observer.Subject;

import java.util.ArrayList;
import java.util.List;

public class GameModel extends Subject {

    private AbstractGameObjectFactory gameObjectFactory;
    private final Cannon cannon;
    private final List<AbstractMissile> missiles;

    public GameModel() {
        gameObjectFactory = new SimpleGameObjectFactory();
        cannon = new Cannon(new Position(GameConfig.CANNON_X, GameConfig.CANNON_Y), gameObjectFactory);
        missiles = new ArrayList<>();
    }

    public List<GameObject> getGameObjects() {
        List<GameObject> gameObjects = new ArrayList<>();
        gameObjects.add(cannon);
        gameObjects.addAll(missiles);
        return gameObjects;
    }

    public void update() {
        moveMissiles();
        destroyMissiles();
    }

    public void moveCannonUp() {
        cannon.moveUp();
        notifyObservers();
    }

    public void moveCannonDown() {
        cannon.moveDown();
        notifyObservers();
    }

    public void cannonShoot() {
        missiles.add(cannon.shoot());
        notifyObservers();
    }

    private void moveMissiles() {
        for(AbstractMissile missile : missiles) {
            missile.move();
        }
        if(!missiles.isEmpty()) {
            notifyObservers();
        }
    }

    private void destroyMissiles() {
        missiles.removeIf(this::isOutOfScreen);
    }

    private boolean isOutOfScreen(GameObject gameObject) {
        return gameObject.getPosition().getX() > GameConfig.MAX_X
                || gameObject.getPosition().getY() > GameConfig.MAX_Y;
    }

}
