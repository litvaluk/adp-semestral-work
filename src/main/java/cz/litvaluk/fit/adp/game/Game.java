package cz.litvaluk.fit.adp.game;

import java.util.List;
import cz.litvaluk.fit.adp.game.config.GameConfig;
import cz.litvaluk.fit.adp.game.controller.GameController;
import cz.litvaluk.fit.adp.game.model.GameModel;
// in future, use Bridge to remove this dependency
import cz.litvaluk.fit.adp.game.view.GameView;
import javafx.scene.canvas.GraphicsContext;

public class Game {

    private GameController controller;
    private GameModel model;
    private GameView view;
    private GraphicsContext gc;

    public void init() {
        model = new GameModel();
        view = new GameView(model);
        controller = view.getController();
    }



    public void processPressedKeys(List<String> pressedKeysCodes) {
        controller.processPressedKeys(pressedKeysCodes);
    }

    public void update() {
        // nothing yet
    }

    public void setGraphicsContext(GraphicsContext gc) {
        view.setGraphicsContext(gc);
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