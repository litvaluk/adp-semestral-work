package cz.litvaluk.fit.adp.game.command;

import cz.litvaluk.fit.adp.game.model.AbstractGameModel;

public abstract class AbstractGameCommand {

    protected AbstractGameModel model;
    private Object memento;

    protected abstract void simpleExecute();

    public void execute() {
        memento = model.createMemento();
        simpleExecute();
    }

    public void revert() {
        model.setMemento(memento);
    }

}
