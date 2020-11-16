package cz.litvaluk.fit.adp.game.model.gameobjects.cannon;

import cz.litvaluk.fit.adp.game.abstractfactory.AbstractGameObjectFactory;
import cz.litvaluk.fit.adp.game.config.GameConfig;
import cz.litvaluk.fit.adp.game.model.gameobjects.GameObject;
import cz.litvaluk.fit.adp.game.model.gameobjects.Position;
import cz.litvaluk.fit.adp.game.model.gameobjects.Vector;
import cz.litvaluk.fit.adp.game.model.gameobjects.missile.AbstractMissile;
import cz.litvaluk.fit.adp.game.state.ShootingMode;
import cz.litvaluk.fit.adp.game.state.SingleShootingMode;
import cz.litvaluk.fit.adp.game.visitor.GameObjectVisitor;

import java.util.ArrayList;
import java.util.List;

public class Cannon extends GameObject {

    private AbstractGameObjectFactory gameObjectFactory;
    private ShootingMode shootingMode;
    private double force;
    private double angle;
    private List<AbstractMissile> shootingBatch;

    public Cannon(Position position, AbstractGameObjectFactory gameObjectFactory) {
        this.position = position;
        this.gameObjectFactory = gameObjectFactory;
        this.shootingMode = new SingleShootingMode();
        this.force = GameConfig.STARTING_FORCE;
        this.angle = GameConfig.STARTING_ANGLE;
        this.shootingBatch = new ArrayList<>();
    }

    public double getForce() {
        return force;
    }

    public double getAngle() {
        return angle;
    }

    public void moveUp() {
        move(new Vector(0, -GameConfig.MOVE_STEP));
    }

    public void moveDown() {
        move(new Vector(0, GameConfig.MOVE_STEP));
    }

    public void simpleShoot() {
        shootingBatch.add(gameObjectFactory.createMissile(position.add(new Vector(10, 0)), force, angle));
    }

    public List<AbstractMissile> shoot() {
        shootingBatch.clear();
        shootingMode.shoot(this);
        return shootingBatch;
    }

    public void switchMode() {
        shootingMode = shootingMode.nextMode();
    }

    @Override
    public void acceptVisitor(GameObjectVisitor visitor) {
        visitor.visitCannon(this);
    }

    public void increaseForce() {
        force += GameConfig.FORCE_STEP;
    }

    public void decreaseForce() {
        force -= GameConfig.FORCE_STEP;
    }

    public void aimUp() {
        angle += GameConfig.ANGLE_STEP;
    }

    public void aimDown() {
        angle -= GameConfig.ANGLE_STEP;
    }

}
