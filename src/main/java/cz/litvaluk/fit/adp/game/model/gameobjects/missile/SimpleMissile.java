package cz.litvaluk.fit.adp.game.model.gameobjects.missile;

import cz.litvaluk.fit.adp.game.config.GameConfig;
import cz.litvaluk.fit.adp.game.model.gameobjects.Position;
import cz.litvaluk.fit.adp.game.model.gameobjects.Vector;

public class SimpleMissile extends AbstractMissile {

    public SimpleMissile(Position position) {
        this.position = position;
    }

    @Override
    public void move() {
        position = position.add(new Vector(GameConfig.MOVE_STEP, 0));
    }

}
