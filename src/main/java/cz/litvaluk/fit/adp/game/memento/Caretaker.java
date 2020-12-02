package cz.litvaluk.fit.adp.game.memento;

import cz.litvaluk.fit.adp.game.model.AbstractGameModel;

public class Caretaker {

    private static final Caretaker INSTANCE = new Caretaker();

    private AbstractGameModel abstractGameModel;

    private Caretaker() {}

    public static Caretaker getInstance() {
        return INSTANCE;
    }

    public void setGameModel(AbstractGameModel abstractGameModel) {
        this.abstractGameModel = abstractGameModel;
    }

    public Object createMemento() {
        if(abstractGameModel != null) {
            return abstractGameModel.createMemento();
        }
        return null;
    }

    public void setMemento(Object memento) {
        if(abstractGameModel != null) {
            abstractGameModel.setMemento(memento);
        }
    }

}
