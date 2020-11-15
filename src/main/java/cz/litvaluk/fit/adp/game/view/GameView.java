package cz.litvaluk.fit.adp.game.view;

import cz.litvaluk.fit.adp.game.controller.GameController;
import cz.litvaluk.fit.adp.game.model.GameModel;
import cz.litvaluk.fit.adp.game.model.gameobjects.Position;
import cz.litvaluk.fit.adp.game.observer.Observer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class GameView implements Observer {

    private final GameModel model;
    private final GameController controller;
    private GraphicsContext gc;

    public GameView(GameModel model) {
        this.model = model;
        this.controller = new GameController(model);
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
        render();
    }

    public void render() {
        if (gc == null) {
            return;
        }
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
        drawCannon();
        drawMissiles();
    }

    private void drawCannon() {
        drawImage(new Image("images/cannon.png"), model.getCannonPosition());
    }

    private void drawMissiles() {
        for(Position position : model.getMissilePositions()) {
            drawImage(new Image("images/missile.png"), position);
        }
    }

    private void drawImage(Image image, Position position) {
        gc.drawImage(image, position.getX(), position.getY());
    }

}
