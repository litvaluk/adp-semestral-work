package cz.litvaluk.fit.adp.game.model.gameobjects.ui.info;

import cz.litvaluk.fit.adp.game.model.gameobjects.GameObject;
import cz.litvaluk.fit.adp.game.model.gameobjects.Position;
import cz.litvaluk.fit.adp.game.visitor.GameObjectVisitor;

public class Info extends GameObject {

    private double force = 0;
    private double angle = 0;
    private int score = 0;
    private double gravity = 0;
    private String shootingMode = "";

    private final String fontFamily;
    private final double fontSize;

    public Info(Position position, String fontFamily, double fontSize) {
        this.position = position;
        this.fontFamily = fontFamily;
        this.fontSize = fontSize;
    }

    public void update(double force, double angle, int score, double gravity, String shootingMode) {
        this.force = force;
        this.angle = angle;
        this.score = score;
        this.gravity = gravity;
        this.shootingMode = shootingMode;
    }

    public String getFontFamily() {
        return fontFamily;
    }

    public double getFontSize() {
        return fontSize;
    }

    @Override
    public String toString() {
        return "Force: " + force + ", " +
                "Angle: " + angle + "º, " +
                "Score: " + score + ", " +
                "Gravity: " + gravity + ", " +
                "Shooting mode: " + shootingMode;
    }

    @Override
    public void acceptVisitor(GameObjectVisitor visitor) {
        visitor.visitInfo(this);
    }

}
