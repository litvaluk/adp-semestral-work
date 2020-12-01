package cz.litvaluk.fit.adp.game.model;

import cz.litvaluk.fit.adp.game.abstractfactory.AbstractGameObjectFactory;
import cz.litvaluk.fit.adp.game.abstractfactory.SimpleGameObjectFactory;
import cz.litvaluk.fit.adp.game.command.AbstractGameCommand;
import cz.litvaluk.fit.adp.game.config.GameConfig;
import cz.litvaluk.fit.adp.game.memento.Caretaker;
import cz.litvaluk.fit.adp.game.model.gameobjects.GameObject;
import cz.litvaluk.fit.adp.game.model.gameobjects.Position;
import cz.litvaluk.fit.adp.game.model.gameobjects.cannon.Cannon;
import cz.litvaluk.fit.adp.game.model.gameobjects.missile.AbstractMissile;
import cz.litvaluk.fit.adp.game.model.gameobjects.ui.info.Info;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class GameModel extends AbstractGameModel {

    private AbstractGameObjectFactory gameObjectFactory;
    private final Cannon cannon;
    private final List<AbstractMissile> missiles;
    private final Info info;
    private int score;
    private Object quickSave;

    private Queue<AbstractGameCommand> unexecutedCommands = new LinkedBlockingQueue<>();
    private Stack<AbstractGameCommand> executedCommands = new Stack<>();

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

    @Override
    public List<GameObject> getGameObjects() {
        List<GameObject> gameObjects = new ArrayList<>();
        gameObjects.add(cannon);
        gameObjects.addAll(missiles);
        gameObjects.add(info);
        return gameObjects;
    }

    @Override
    public void update() {
        executeCommands();
        moveMissiles();
        destroyMissiles();
        updateInfo();
    }

    private void executeCommands() {
        while (!unexecutedCommands.isEmpty()) {
            AbstractGameCommand cmd = unexecutedCommands.poll();
            cmd.execute();
            executedCommands.push(cmd);
        }
    }

    private void updateInfo() {
        info.update(cannon.getForce(), cannon.getAngle(), score, GameConfig.GRAVITY, cannon.getShootingModeName());
    }

    @Override
    public void moveCannonUp() {
        cannon.moveUp();
        notifyObservers();
    }

    @Override
    public void moveCannonDown() {
        cannon.moveDown();
        notifyObservers();
    }

    @Override
    public void cannonAimUp() {
        cannon.aimUp();
        notifyObservers();
    }

    @Override
    public void cannonAimDown() {
        cannon.aimDown();
        notifyObservers();
    }

    @Override
    public void cannonIncreaseForce() {
        cannon.increaseForce();
        notifyObservers();
    }

    @Override
    public void cannonDecreaseForce() {
        cannon.decreaseForce();
        notifyObservers();
    }

    @Override
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

    @Override
    public void switchCannonMode() {
        cannon.switchMode();
        updateInfo();
        notifyObservers();
    }

    @Override
    public void quickSave() {
        quickSave = Caretaker.getInstance().createMemento();
    }

    @Override
    public void quickLoad() {
        Caretaker.getInstance().setMemento(quickSave);
        updateInfo();
        notifyObservers();
    }

    private class Memento {
        private int score;
    }

    @Override
    public Object createMemento() {
        Memento memento = new Memento();
        memento.score = score;
        return memento;
    }

    @Override
    public void setMemento(Object memento) {
        Memento m = (Memento) memento;
        score = m.score;
    }

    @Override
    public void registerCommand(AbstractGameCommand cmd) {
        unexecutedCommands.add(cmd);
    }

    @Override
    public void undoLastCommand() {
        if (executedCommands.isEmpty()) {
            return;
        }
        executedCommands.pop().revert();
        notifyObservers();
    }

}
