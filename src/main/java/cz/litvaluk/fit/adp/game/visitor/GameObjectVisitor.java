package cz.litvaluk.fit.adp.game.visitor;

import cz.litvaluk.fit.adp.game.model.gameobjects.cannon.Cannon;
import cz.litvaluk.fit.adp.game.model.gameobjects.collision.Collision;
import cz.litvaluk.fit.adp.game.model.gameobjects.enemy.AbstractEnemy;
import cz.litvaluk.fit.adp.game.model.gameobjects.missile.AbstractMissile;
import cz.litvaluk.fit.adp.game.model.gameobjects.ui.info.Info;

public interface GameObjectVisitor {

    void visitCannon(Cannon cannon);
    void visitMissile(AbstractMissile missile);
    void visitInfo(Info info);
    void visitEnemy(AbstractEnemy enemy);
    void visitCollision(Collision collision);

}
