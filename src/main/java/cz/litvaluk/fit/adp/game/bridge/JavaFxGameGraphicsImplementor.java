package cz.litvaluk.fit.adp.game.bridge;

import cz.litvaluk.fit.adp.game.model.gameobjects.Position;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.transform.Rotate;

public class JavaFxGameGraphicsImplementor implements GameGraphicsImplementor {

    private GraphicsContext gc;

    public JavaFxGameGraphicsImplementor(GraphicsContext gc) {
        this.gc = gc;
    }

    @Override
    public void drawImage(String path, Position position, double angle) {
        drawImage(new Image(path), position, angle);
    }

    @Override
    public void drawText(String text, Position position, String fontFamily, double fontSize) {
        gc.setFont(new Font(fontFamily, fontSize));
        gc.setFill(Color.BLACK);
        gc.fillText(text, position.getX(), position.getY());
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
    public void clear() {
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
    }

}
