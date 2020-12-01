package cz.litvaluk.fit.adp.game.bridge;

import cz.litvaluk.fit.adp.game.model.gameobjects.Position;

public interface GameGraphicsImplementor {

    void drawImage(String path, Position position, double angle);
    void drawText(String text, Position position, String fontFamily, double fontSize);
    void clear();

}
