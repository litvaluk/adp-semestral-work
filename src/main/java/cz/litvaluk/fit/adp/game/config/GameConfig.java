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
    public static final int CANNON_Y = MAX_Y / 2;
    public static final int MOVE_STEP = 6;
    public static final double GRAVITY = 9.81;
    public static final double STARTING_FORCE = 3.0;
    public static final double FORCE_STEP = 0.1;
    public static final double MIN_FORCE = 1.0;
    public static final double MAX_FORCE = 6.0;
    public static final double FORCE_MODIFIER = 3.0;
    public static final double STARTING_ANGLE = 0.0;
    public static final double ANGLE_STEP = 2.0;
    public static final double MIN_ANGLE = -90.0;
    public static final double MAX_ANGLE = 90.0;
    public static final int CANNON_MISSILE_SHIFT = 20;

    // enemy
    public static final int ENEMY_MAX_X = MAX_X - 50;
    public static final int ENEMY_MAX_Y = MAX_Y - 50;
    public static final int ENEMY_MIN_X = 120;
    public static final int ENEMY_MIN_Y = 50;
    public static final int ENEMY_SPAWN_PERIOD = 5;
    public static final int ENEMY_SPEED_INTERVAL_MIN = 2;
    public static final int ENEMY_SPEED_INTERVAL_MAX = 3;
    public static final int ENEMY_DIRECTION_INTERVAL_MIN = 1;
    public static final int ENEMY_DIRECTION_INTERVAL_MAX = 5;
    public static final int ENEMY_COLLISION_DISTANCE = 35;

    // collision
    public static final double COLLISION_TIME = 1.0;
}