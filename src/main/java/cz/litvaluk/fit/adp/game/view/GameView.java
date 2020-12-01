package cz.litvaluk.fit.adp.game.view;

import cz.litvaluk.fit.adp.game.bridge.GameGraphicsAbstraction;
import cz.litvaluk.fit.adp.game.controller.GameController;
import cz.litvaluk.fit.adp.game.model.AbstractGameModel;
import cz.litvaluk.fit.adp.game.model.gameobjects.GameObject;
import cz.litvaluk.fit.adp.game.observer.Observer;
import cz.litvaluk.fit.adp.game.visitor.GameObjectRenderer;

public class GameView implements Observer {

    private final AbstractGameModel model;
    private final GameController controller;
    private final GameObjectRenderer renderer;
    private GameGraphicsAbstraction gameGraphics;

    public GameView(AbstractGameModel model) {
        this.model = model;
        this.controller = new GameController(model);
        this.renderer = new GameObjectRenderer();
        this.gameGraphics = null;
        this.model.attachObserver(this);
    }

    @Override
    public void update() {
        render();
    }

    public GameController getController() {
        return controller;
    }

    public void setGameGraphics(GameGraphicsAbstraction gameGraphics) {
        this.gameGraphics = gameGraphics;
        renderer.setGameGraphics(this.gameGraphics);
        render();
    }

    public void render() {
        if (gameGraphics == null) {
            return;
        }
        gameGraphics.clear();
        for(GameObject gameObject : model.getGameObjects()) {
            gameObject.acceptVisitor(renderer);
        }
    }

}
