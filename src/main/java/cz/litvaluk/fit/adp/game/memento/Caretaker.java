package cz.litvaluk.fit.adp.game.memento;

import cz.litvaluk.fit.adp.game.model.GameModel;

public class Caretaker {

    public static Caretaker INSTANCE = new Caretaker();

    private GameModel gameModel;

    private Caretaker() {}

    public Caretaker getInstance() {
        return INSTANCE;
    }

    public void setGameModel(GameModel gameModel) {
        this.gameModel = gameModel;
    }

    public Object createMemento() {
        if(gameModel != null) {
            return gameModel.createMemento();
        }
        return null;
    }

    public void setMemento(Object memento) {
        if(gameModel != null) {
            gameModel.setMemento(memento);
        }
    }

}
