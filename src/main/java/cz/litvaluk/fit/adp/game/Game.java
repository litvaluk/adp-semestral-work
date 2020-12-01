package cz.litvaluk.fit.adp.game;

import cz.litvaluk.fit.adp.game.bridge.GameGraphicsAbstraction;
import cz.litvaluk.fit.adp.game.config.GameConfig;
import cz.litvaluk.fit.adp.game.controller.GameController;
import cz.litvaluk.fit.adp.game.memento.Caretaker;
import cz.litvaluk.fit.adp.game.model.AbstractGameModel;
import cz.litvaluk.fit.adp.game.model.GameModel;
import cz.litvaluk.fit.adp.game.proxy.GameModelProxy;
import cz.litvaluk.fit.adp.game.view.GameView;

import java.util.List;

public class Game {

    private GameController controller;
    private AbstractGameModel model;
    private GameView view;

    public void init() {
        model = new GameModelProxy(new GameModel());
        view = new GameView(model);
        controller = view.getController();
        Caretaker.getInstance().setGameModel(model);
    }

    public void processPressedKeys(List<String> pressedKeysCodes) {
        controller.processPressedKeys(pressedKeysCodes);
    }

    public void update() {
        model.update();
    }

    public void setGameGraphics(GameGraphicsAbstraction gameGraphics) {
        view.setGameGraphics(gameGraphics);
    }

    public String getWindowTitle() {
        return "Game (NI-ADP)";
    }

    public int getWindowWidth() {
        return GameConfig.MAX_X;
    }

    public int getWindowHeight() {
        return  GameConfig.MAX_Y;
    }

}