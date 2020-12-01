package cz.litvaluk.fit.adp.game.bridge;

import cz.litvaluk.fit.adp.game.model.gameobjects.Position;

public class GameGraphics implements GameGraphicsAbstraction {

    GameGraphicsImplementor impl;

    public GameGraphics(GameGraphicsImplementor impl) {
        this.impl = impl;
    }

    @Override
    public void drawImage(String path, Position position, double angle) {
        impl.drawImage(path, position, angle);
    }

    @Override
    public void drawText(String text, Position position, String fontFamily, double fontSize) {
        impl.drawText(text, position, fontFamily, fontSize);
    }

    @Override
    public void clear() {
        impl.clear();
    }

}
