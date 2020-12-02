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

    public Cannon(Cannon cannon) {
        this.position = new Position(cannon.getPosition().getX(), cannon.getPosition().getY());
        this.gameObjectFactory = cannon.gameObjectFactory;
        this.shootingMode = cannon.shootingMode;
        this.force = cannon.getForce();
        this.angle = cannon.getAngle();
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

    public String getShootingModeName() {
        return shootingMode.getName();
    }

    @Override
    public void acceptVisitor(GameObjectVisitor visitor) {
        visitor.visitCannon(this);
    }

    public void increaseForce() {
        force += GameConfig.FORCE_STEP;
        if(force > GameConfig.MAX_FORCE) {
            force = GameConfig.MAX_FORCE;
        }
    }

    public void decreaseForce() {
        force -= GameConfig.FORCE_STEP;
        if(force < GameConfig.MIN_FORCE) {
            force = GameConfig.MIN_FORCE;
        }
    }

    public void aimUp() {
        angle += GameConfig.ANGLE_STEP;
        if(angle > GameConfig.MAX_ANGLE) {
            angle = GameConfig.MAX_ANGLE;
        }
    }

    public void aimDown() {
        angle -= GameConfig.ANGLE_STEP;
        if(angle < GameConfig.MIN_ANGLE) {
            angle = GameConfig.MIN_ANGLE;
        }
    }

}
