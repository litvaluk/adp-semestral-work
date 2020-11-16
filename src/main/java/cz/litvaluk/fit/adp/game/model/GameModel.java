package cz.litvaluk.fit.adp.game.model;

import cz.litvaluk.fit.adp.game.abstractfactory.AbstractGameObjectFactory;
import cz.litvaluk.fit.adp.game.abstractfactory.SimpleGameObjectFactory;
import cz.litvaluk.fit.adp.game.config.GameConfig;
import cz.litvaluk.fit.adp.game.model.gameobjects.GameObject;
import cz.litvaluk.fit.adp.game.model.gameobjects.Position;
import cz.litvaluk.fit.adp.game.model.gameobjects.cannon.Cannon;
import cz.litvaluk.fit.adp.game.model.gameobjects.missile.AbstractMissile;
import cz.litvaluk.fit.adp.game.model.gameobjects.ui.info.Info;
import cz.litvaluk.fit.adp.game.observer.Subject;

import java.util.ArrayList;
import java.util.List;

public class GameModel extends Subject {

    private AbstractGameObjectFactory gameObjectFactory;
    private final Cannon cannon;
    private final List<AbstractMissile> missiles;
    private final Info info;
    private int score;
    private Object quickSave;

    public GameModel() {
        gameObjectFactory = new SimpleGameObjectFactory();
        cannon = new Cannon(new Position(GameConfig.CANNON_X, GameConfig.CANNON_Y), gameObjectFactory);
        missiles = new ArrayList<>();
        info = new Info(new Position(GameConfig.INFO_X, GameConfig.INFO_Y),
                GameConfig.INFO_FONT_FAMILY, GameConfig.INFO_FONT_SIZE);
        score = 0;
        quickSave = createMemento();
        updateInfo();
    }

    public List<GameObject> getGameObjects() {
        List<GameObject> gameObjects = new ArrayList<>();
        gameObjects.add(cannon);
        gameObjects.addAll(missiles);
        gameObjects.add(info);
        return gameObjects;
    }

    public void update() {
        moveMissiles();
        destroyMissiles();
        updateInfo();
    }

    private void updateInfo() {
        info.update(cannon.getForce(), cannon.getAngle(), score, GameConfig.GRAVITY, cannon.getShootingModeName());
    }

    public void moveCannonUp() {
        cannon.moveUp();
        notifyObservers();
    }

    public void moveCannonDown() {
        cannon.moveDown();
        notifyObservers();
    }

    public void cannonAimUp() {
        cannon.aimUp();
        notifyObservers();
    }

    public void cannonAimDown() {
        cannon.aimDown();
        notifyObservers();
    }

    public void cannonIncreaseForce() {
        cannon.increaseForce();
        notifyObservers();
    }

    public void cannonDecreaseForce() {
        cannon.decreaseForce();
        notifyObservers();
    }

    public void cannonShoot() {
        missiles.addAll(cannon.shoot());
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

    public void switchCannonMode() {
        cannon.switchMode();
        updateInfo();
        notifyObservers();
    }

    public void quickSave() {
        quickSave = createMemento();
    }

    public void quickLoad() {
        setMemento(quickSave);
        updateInfo();
        notifyObservers();
    }

    private class Memento {
        private int score;
    }

    public Object createMemento() {
        Memento memento = new Memento();
        memento.score = score;
        return memento;
    }

    public void setMemento(Object memento) {
        Memento m = (Memento) memento;
        score = m.score;
    }

}
