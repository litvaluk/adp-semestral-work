package cz.litvaluk.fit.adp.game.proxy;

import cz.litvaluk.fit.adp.game.command.AbstractGameCommand;
import cz.litvaluk.fit.adp.game.model.AbstractGameModel;
import cz.litvaluk.fit.adp.game.model.gameobjects.GameObject;
import cz.litvaluk.fit.adp.game.observer.Observer;

import java.util.List;

public class GameModelProxy extends AbstractGameModel {

    private final AbstractGameModel subject;

    public GameModelProxy(AbstractGameModel subject) {
        this.subject = subject;
    }

    @Override
    public List<GameObject> getGameObjects() {
        return subject.getGameObjects();
    }

    @Override
    public void update() {
        subject.update();
    }

    @Override
    public void moveCannonUp() {
        subject.moveCannonUp();
    }

    @Override
    public void moveCannonDown() {
        subject.moveCannonDown();
    }

    @Override
    public void cannonAimUp() {
        subject.cannonAimUp();
    }

    @Override
    public void cannonAimDown() {
        subject.cannonAimDown();
    }

    @Override
    public void cannonIncreaseForce() {
        subject.cannonIncreaseForce();
    }

    @Override
    public void cannonDecreaseForce() {
        subject.cannonDecreaseForce();
    }

    @Override
    public void cannonShoot() {
        subject.cannonShoot();
    }

    @Override
    public void switchCannonMode() {
        subject.switchCannonMode();
    }

    @Override
    public void quickSave() {
        subject.quickSave();
    }

    @Override
    public void quickLoad() {
        subject.quickLoad();
    }

    @Override
    public Object createMemento() {
        return subject.createMemento();
    }

    @Override
    public void setMemento(Object memento) {
        subject.setMemento(memento);
    }

    @Override
    public void registerCommand(AbstractGameCommand cmd) {
        subject.registerCommand(cmd);
    }

    @Override
    public void undoLastCommand() {
        subject.undoLastCommand();
    }

    @Override
    public boolean attachObserver(Observer observer) {
        return subject.attachObserver(observer);
    }

    @Override
    public boolean detachObserver(Observer observer) {
        return subject.detachObserver(observer);
    }

}
