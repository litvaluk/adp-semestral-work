package cz.litvaluk.fit.adp.game.model.gameobjects.cannon;

import cz.litvaluk.fit.adp.game.config.GameConfig;
import cz.litvaluk.fit.adp.game.model.gameobjects.GameObject;
import cz.litvaluk.fit.adp.game.model.gameobjects.Position;
import cz.litvaluk.fit.adp.game.model.gameobjects.Vector;

public class Cannon extends GameObject {

    public Cannon(Position position) {
        this.position = position;
    }

    public void moveUp() {
        move(new Vector(0, -GameConfig.MOVE_STEP));
    }

    public void moveDown() {
        move(new Vector(0, GameConfig.MOVE_STEP));
    }

}
