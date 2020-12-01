package cz.litvaluk.fit.adp.game.model;

import cz.litvaluk.fit.adp.game.command.AbstractGameCommand;
import cz.litvaluk.fit.adp.game.model.gameobjects.GameObject;
import cz.litvaluk.fit.adp.game.observer.Subject;

import java.util.List;

public abstract class AbstractGameModel extends Subject {

    public abstract List<GameObject> getGameObjects();

    public abstract void update();

    public abstract void registerCommand(AbstractGameCommand cmd);
    public abstract void undoLastCommand();

    public abstract void moveCannonUp();
    public abstract void moveCannonDown();
    public abstract void cannonAimUp();
    public abstract void cannonAimDown();
    public abstract void cannonIncreaseForce();
    public abstract void cannonDecreaseForce();
    public abstract void cannonShoot();
    public abstract void switchCannonMode();

    public abstract void spawnEnemies();
    public abstract void moveEnemies();
    public abstract void destroyEnemies();

    public abstract void quickSave();
    public abstract void quickLoad();

    public abstract Object createMemento();
    public abstract void setMemento(Object memento);

}
