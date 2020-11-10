package cz.litvaluk.fit.adp.game;

import java.util.List;
import cz.litvaluk.fit.adp.game.config.GameConfig;
import cz.litvaluk.fit.adp.game.model.Position;
// in future, use Bridge to remove this dependency
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Game {

    private Position logoPos;

    public void init() {
        logoPos = new Position((GameConfig.MAX_X/2) - 128, (GameConfig.MAX_Y/2) - 128);
    }

    public void processPressedKeys(List<String> pressedKeysCodes) {
        for(String code : pressedKeysCodes) {
            switch(code) {
                case "UP":
                    logoPos.setY(logoPos.getY() - 10);
                    break;
                case "DOWN":
                    logoPos.setY(logoPos.getY() + 10);
                    break;
                case "LEFT":
                    logoPos.setX(logoPos.getX() - 10);
                    break;
                case "RIGHT":
                    logoPos.setX(logoPos.getX() + 10);
                    break;
                default: 
                    //nothing
            }
        }
    }

    public void update() {
        // nothing yet
    }

    public void render(GraphicsContext gc) {
        gc.drawImage(new Image("icons/fit-icon-256x256.png"), logoPos.getX(), logoPos.getY());
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