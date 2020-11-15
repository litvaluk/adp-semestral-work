package cz.litvaluk.fit.adp.game.visitor;

import cz.litvaluk.fit.adp.game.model.gameobjects.cannon.Cannon;
import cz.litvaluk.fit.adp.game.model.gameobjects.missile.AbstractMissile;

public interface GameObjectVisitor {

    void visitCannon(Cannon cannon);
    void visitMissile(AbstractMissile missile);

}
