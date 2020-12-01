package cz.litvaluk.fit.adp.game.visitor;

import cz.litvaluk.fit.adp.game.bridge.GameGraphicsAbstraction;
import cz.litvaluk.fit.adp.game.model.gameobjects.cannon.Cannon;
import cz.litvaluk.fit.adp.game.model.gameobjects.missile.AbstractMissile;
import cz.litvaluk.fit.adp.game.model.gameobjects.ui.info.Info;

public class GameObjectRenderer implements GameObjectVisitor {

    private GameGraphicsAbstraction gameGraphics;

    public void setGameGraphics(GameGraphicsAbstraction gameGraphics) {
        this.gameGraphics = gameGraphics;
    }

    @Override
    public void visitCannon(Cannon cannon) {
        gameGraphics.drawImage("images/cannon.png", cannon.getPosition(), -cannon.getAngle());
    }

    @Override
    public void visitMissile(AbstractMissile missile) {
        gameGraphics.drawImage("images/missile.png", missile.getPosition(), 0);
    }

    @Override
    public void visitInfo(Info info) {
        gameGraphics.drawText(info.toString(), info.getPosition(), info.getFontFamily(), info.getFontSize());
    }

}
