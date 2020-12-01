package cz.litvaluk.fit.adp.game.controller;

import cz.litvaluk.fit.adp.game.command.cannon.CannonAimDownCommand;
import cz.litvaluk.fit.adp.game.command.cannon.*;
import cz.litvaluk.fit.adp.game.command.save.QuickLoadCommand;
import cz.litvaluk.fit.adp.game.command.save.QuickSaveCommand;
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
                    model.registerCommand(new MoveCannonUpCommand(model));
                    break;
                case "DOWN":
                    model.registerCommand(new MoveCannonDownCommand(model));
                    break;
                case "SPACE":
                    model.registerCommand(new CannonShootCommand(model));
//                    model.cannonShoot();
                    break;
                case "LEFT":
                    model.registerCommand(new CannonAimUpCommand(model));
//                    model.cannonAimUp();
                    break;
                case "RIGHT":
                    model.registerCommand(new CannonAimDownCommand(model));
//                    model.cannonAimDown();
                    break;
                case "PERIOD":
                    model.registerCommand(new CannonIncreaseForceCommand(model));
//                    model.cannonIncreaseForce();
                    break;
                case "COMMA":
                    model.registerCommand(new CannonDecreaseCommand(model));
//                    model.cannonDecreaseForce();
                    break;
                case "S":
                    model.registerCommand(new SwitchCannonModelCommand(model));
//                    model.switchCannonMode();
                    System.out.println("Mode switched");
                    break;
                case "F5":
                    model.registerCommand(new QuickSaveCommand(model));
//                    model.quickSave();
                    System.out.println("Game saved");
                    break;
                case "F6":
                    model.registerCommand(new QuickLoadCommand(model));
//                    model.quickLoad();
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
