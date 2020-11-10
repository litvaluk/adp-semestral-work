package cz.litvaluk.fit.adp.game.controller;

import cz.litvaluk.fit.adp.game.model.GameModel;

import java.util.List;

public class GameController {

    private GameModel model;

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
                default:
                    //nothing
            }
        }
    }

}
