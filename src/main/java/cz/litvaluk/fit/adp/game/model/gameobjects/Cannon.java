package cz.litvaluk.fit.adp.game.model.gameobjects;

import cz.litvaluk.fit.adp.game.config.GameConfig;

public class Cannon extends GameObject {

    public Cannon(Position position) {
        super(position);
    }

    public void moveUp() {
        move(new Vector(0, -GameConfig.MOVE_STEP));
    }

    public void moveDown() {
        move(new Vector(0, GameConfig.MOVE_STEP));
    }

}
