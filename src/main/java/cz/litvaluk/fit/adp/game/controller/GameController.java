package cz.litvaluk.fit.adp.game.controller;

import cz.litvaluk.fit.adp.game.model.GameModel;

import java.util.List;

public class GameController {

    private final GameModel model;

    public GameController(GameModel model) {
        this.model = model;
    }

    public void processPressedKeys(List<String> pressedKeysCodes) {
        for(String code : pressedKeysCodes) {
            switch(code) {
                case "UP":
                    model.moveCannonUp();
                    break;
                case "DOWN":
                    model.moveCannonDown();
                    break;
                case "SPACE":
                    model.cannonShoot();
                    break;
                case "S":
                    model.switchCannonMode();
                    System.out.println("Mode switched!");
                    break;
                case "ESCAPE":
                    System.exit(0);
                default:
                    //nothing
            }
        }
    }

}
