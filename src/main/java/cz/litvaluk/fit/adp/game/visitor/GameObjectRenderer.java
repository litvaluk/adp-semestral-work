package cz.litvaluk.fit.adp.game.visitor;

import cz.litvaluk.fit.adp.game.model.gameobjects.Position;
import cz.litvaluk.fit.adp.game.model.gameobjects.cannon.Cannon;
import cz.litvaluk.fit.adp.game.model.gameobjects.missile.AbstractMissile;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class GameObjectRenderer implements GameObjectVisitor {

    private GraphicsContext gc;

    public void setGraphicsContext(GraphicsContext gc) {
        this.gc = gc;
    }

    private void drawImage(Image image, Position position) {
        gc.drawImage(image, position.getX(), position.getY());
    }

    @Override
    public void visitCannon(Cannon cannon) {
        drawImage(new Image("images/cannon.png"), cannon.getPosition());
    }

    @Override
    public void visitMissile(AbstractMissile missile) {
        drawImage(new Image("images/missile.png"), missile.getPosition());
    }

}
