package cz.litvaluk.fit.adp.game.config;

public class GameConfig {

    // screen
    public static final int MAX_X = 1280;
    public static final int MAX_Y = 720;

    // info text
    public static final int INFO_X = 8;
    public static final int INFO_Y = 16;
    public static final String INFO_FONT_FAMILY = "Courier New";
    public static final double INFO_FONT_SIZE = 12;

    // cannon
    public static final int CANNON_X = 50;
    public static final int CANNON_Y = MAX_Y/2;
    public static final int MOVE_STEP = 6;
    public static final double GRAVITY = 9.81;
    public static final double STARTING_FORCE = 1.0;
    public static final double FORCE_STEP = 0.1;
    public static final double MIN_FORCE = 0.1;
    public static final double MAX_FORCE = 5.0;
    public static final double STARTING_ANGLE = 0.0;
    public static final double ANGLE_STEP = 3.0;
    public static final double MIN_ANGLE = -90.0;
    public static final double MAX_ANGLE = 90.0;

}