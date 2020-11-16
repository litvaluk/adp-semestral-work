package cz.litvaluk.fit.adp.game.visitor;

import cz.litvaluk.fit.adp.game.model.gameobjects.Position;
import cz.litvaluk.fit.adp.game.model.gameobjects.cannon.Cannon;
import cz.litvaluk.fit.adp.game.model.gameobjects.missile.AbstractMissile;
import cz.litvaluk.fit.adp.game.model.gameobjects.ui.info.Info;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.transform.Rotate;

public class GameObjectRenderer implements GameObjectVisitor {

    private GraphicsContext gc;

    public void setGraphicsContext(GraphicsContext gc) {
        this.gc = gc;
    }

    private void drawImage(Image image, Position position) {
        drawImage(image, position, 0);
    }

    private void drawImage(Image image, Position position, double angle) {
        double pX = position.getX() + image.getWidth()/2;
        double pY = position.getY() + image.getHeight()/2;
        Rotate r = new Rotate(angle, pX, pY);
        gc.save();
        gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
        gc.drawImage(image, position.getX(), position.getY());
        gc.restore();
    }

    @Override
    public void visitCannon(Cannon cannon) {
        drawImage(new Image("images/cannon.png"), cannon.getPosition(), -cannon.getAngle());
    }

    @Override
    public void visitMissile(AbstractMissile missile) {
        drawImage(new Image("images/missile.png"), missile.getPosition());
    }

    @Override
    public void visitInfo(Info info) {
        gc.setFont(new Font(info.getFontFamily(), info.getFontSize()));
        gc.setFill(Color.BLACK);
        gc.fillText(info.toString(), info.getPosition().getX(), info.getPosition().getY());
    }

}
