package cz.litvaluk.fit.adp.game.model.gameobjects.ui.info;

import cz.litvaluk.fit.adp.game.model.gameobjects.GameObject;
import cz.litvaluk.fit.adp.game.model.gameobjects.Position;
import cz.litvaluk.fit.adp.game.visitor.GameObjectVisitor;

public class Info extends GameObject {

    public Info(Position position) {
        this.position = position;
    }

    @Override
    public void acceptVisitor(GameObjectVisitor visitor) {
        // TODO
    }

}
