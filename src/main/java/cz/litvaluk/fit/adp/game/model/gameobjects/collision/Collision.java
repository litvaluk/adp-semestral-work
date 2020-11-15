package cz.litvaluk.fit.adp.game.model.gameobjects.collision;

import cz.litvaluk.fit.adp.game.model.gameobjects.TimeableGameObject;
import cz.litvaluk.fit.adp.game.model.gameobjects.Position;

public class Collision extends TimeableGameObject {

    public Collision(Position position) {
        this.position = position;
    }

}
