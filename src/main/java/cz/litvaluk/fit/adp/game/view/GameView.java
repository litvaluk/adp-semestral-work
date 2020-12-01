package cz.litvaluk.fit.adp.game.view;

import cz.litvaluk.fit.adp.game.controller.GameController;
import cz.litvaluk.fit.adp.game.model.AbstractGameModel;
import cz.litvaluk.fit.adp.game.model.gameobjects.GameObject;
import cz.litvaluk.fit.adp.game.observer.Observer;
import cz.litvaluk.fit.adp.game.visitor.GameObjectRenderer;
import javafx.scene.canvas.GraphicsContext;

public class GameView implements Observer {

    private final AbstractGameModel model;
    private final GameController controller;
    private final GameObjectRenderer renderer;
    private GraphicsContext gc;

    public GameView(AbstractGameModel model) {
        this.model = model;
        this.controller = new GameController(model);
        this.renderer = new GameObjectRenderer();
        this.gc = null;
        this.model.attachObserver(this);
    }

    @Override
    public void update() {
        render();
    }

    public GameController getController() {
        return controller;
    }

    public void setGraphicsContext(GraphicsContext gc) {
        this.gc = gc;
        renderer.setGraphicsContext(gc);
        render();
    }

    public void render() {
        if (gc == null) {
            return;
        }
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
        for(GameObject gameObject : model.getGameObjects()) {
            gameObject.acceptVisitor(renderer);
        }
    }

}
