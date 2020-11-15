package cz.litvaluk.fit.adp.game.model.gameobjects.collision;

import cz.litvaluk.fit.adp.game.model.gameobjects.LifetimeLimitedGameObject;
import cz.litvaluk.fit.adp.game.model.gameobjects.Position;

public class Collision extends LifetimeLimitedGameObject {

    public Collision(Position position) {
        this.position = position;
    }

}
