package cz.litvaluk.fit.adp.game.controller;

import cz.litvaluk.fit.adp.game.model.AbstractGameModel;

import java.util.List;

public class GameController {

    private final AbstractGameModel model;

    public GameController(AbstractGameModel model) {
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
                case "LEFT":
                    model.cannonAimUp();
                    break;
                case "RIGHT":
                    model.cannonAimDown();
                    break;
                case "PERIOD":
                    model.cannonIncreaseForce();
                    break;
                case "COMMA":
                    model.cannonDecreaseForce();
                    break;
                case "S":
                    model.switchCannonMode();
                    System.out.println("Mode switched");
                    break;
                case "F5":
                    model.quickSave();
                    System.out.println("Game saved");
                    break;
                case "F6":
                    model.quickLoad();
                    System.out.println("Game loaded");
                    break;
                case "ESCAPE":
                    System.exit(0);
                    break;
                default:
                    //nothing
            }
        }
    }

}
