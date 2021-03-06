package cz.litvaluk.fit.adp.game.model;

import cz.litvaluk.fit.adp.game.abstractfactory.AbstractGameObjectFactory;
import cz.litvaluk.fit.adp.game.abstractfactory.RealisticGameObjectFactory;
import cz.litvaluk.fit.adp.game.command.AbstractGameCommand;
import cz.litvaluk.fit.adp.game.config.GameConfig;
import cz.litvaluk.fit.adp.game.memento.Caretaker;
import cz.litvaluk.fit.adp.game.model.gameobjects.GameObject;
import cz.litvaluk.fit.adp.game.model.gameobjects.Position;
import cz.litvaluk.fit.adp.game.model.gameobjects.cannon.Cannon;
import cz.litvaluk.fit.adp.game.model.gameobjects.collision.Collision;
import cz.litvaluk.fit.adp.game.model.gameobjects.enemy.AbstractEnemy;
import cz.litvaluk.fit.adp.game.model.gameobjects.missile.AbstractMissile;
import cz.litvaluk.fit.adp.game.model.gameobjects.ui.info.Info;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class GameModel extends AbstractGameModel {

    private final AbstractGameObjectFactory gameObjectFactory;
    private Cannon cannon;
    private final List<AbstractMissile> missiles;
    private final List<AbstractEnemy> enemies;
    private final List<Collision> collisions;
    private final Info info;
    private int score;
    private Object quickSave;
    private long lastTimeEnemySpawned;

    private final Queue<AbstractGameCommand> unexecutedCommands = new LinkedBlockingQueue<>();
    private final Stack<AbstractGameCommand> executedCommands = new Stack<>();

    public GameModel() {
        gameObjectFactory = new RealisticGameObjectFactory();
        cannon = new Cannon(new Position(GameConfig.CANNON_X, GameConfig.CANNON_Y), gameObjectFactory);
        missiles = new ArrayList<>();
        enemies = new ArrayList<>();
        collisions = new ArrayList<>();
        lastTimeEnemySpawned = 0;
        info = new Info(new Position(GameConfig.INFO_X, GameConfig.INFO_Y),
                GameConfig.INFO_FONT_FAMILY, GameConfig.INFO_FONT_SIZE);
        score = 0;
        quickSave = createMemento();
        updateInfo();
    }

    @Override
    public List<GameObject> getGameObjects() {
        List<GameObject> gameObjects = new ArrayList<>();
        gameObjects.add(cannon);
        gameObjects.addAll(missiles);
        gameObjects.addAll(enemies);
        gameObjects.addAll(collisions);
        gameObjects.add(info);
        return gameObjects;
    }

    @Override
    public void update() {
        executeCommands();
        moveEnemies();
        moveMissiles();
        destroyEnemies();
        destroyCollisions();
        destroyMissiles();
        spawnEnemies();
        updateInfo();
    }

    private void executeCommands() {
        while (!unexecutedCommands.isEmpty()) {
            AbstractGameCommand cmd = unexecutedCommands.poll();
            cmd.execute();
            executedCommands.push(cmd);
        }
    }

    private void updateInfo() {
        info.update(cannon.getForce(), cannon.getAngle(), score, GameConfig.GRAVITY, cannon.getShootingModeName());
    }

    @Override
    public void moveCannonUp() {
        cannon.moveUp();
        notifyObservers();
    }

    @Override
    public void moveCannonDown() {
        cannon.moveDown();
        notifyObservers();
    }

    @Override
    public void cannonAimUp() {
        cannon.aimUp();
        notifyObservers();
    }

    @Override
    public void cannonAimDown() {
        cannon.aimDown();
        notifyObservers();
    }

    @Override
    public void cannonIncreaseForce() {
        cannon.increaseForce();
        notifyObservers();
    }

    @Override
    public void cannonDecreaseForce() {
        cannon.decreaseForce();
        notifyObservers();
    }

    @Override
    public void cannonShoot() {
        missiles.addAll(cannon.shoot());
        notifyObservers();
    }

    private void moveMissiles() {
        for(AbstractMissile missile : missiles) {
            missile.move();
        }
        if(!missiles.isEmpty()) {
            notifyObservers();
        }
    }

    private void destroyMissiles() {
        missiles.removeIf(this::isOutOfScreen);
    }

    private boolean isOutOfScreen(GameObject gameObject) {
        return gameObject.getPosition().getX() > GameConfig.MAX_X
                || gameObject.getPosition().getY() > GameConfig.MAX_Y;
    }

    @Override
    public void switchCannonMode() {
        cannon.switchMode();
        updateInfo();
        notifyObservers();
    }

    @Override
    public void spawnEnemies() {
        if (lastTimeEnemySpawned == 0) {
            enemies.add(gameObjectFactory.createEnemyAtRandomPosition());
            lastTimeEnemySpawned = System.nanoTime();
        }
        if (System.nanoTime() - lastTimeEnemySpawned > GameConfig.ENEMY_SPAWN_PERIOD * 1000000000L) {
            enemies.add(gameObjectFactory.createEnemyAtRandomPosition());
            lastTimeEnemySpawned = System.nanoTime();
        }
        notifyObservers();
    }

    @Override
    public void moveEnemies() {
        for (AbstractEnemy enemy : enemies) {
            enemy.move();
        }
        if (!enemies.isEmpty()) {
            notifyObservers();
        }
    }

    @Override
    public void destroyEnemies() {
        if (missiles.isEmpty() || enemies.isEmpty()) {
            return;
        }
        List<AbstractEnemy> colliding = new ArrayList<>();
        for (AbstractMissile missile : missiles) {
           for (AbstractEnemy enemy : enemies) {
               if (enemy.isColliding(missile)) {
                   colliding.add(enemy);
               }
           }
        }
        enemies.removeIf(colliding::contains);
        for (AbstractEnemy enemy : colliding) {
            score += enemy.getSpeed();
            collisions.add(new Collision(enemy.getPosition()));
        }
        notifyObservers();
    }

    @Override
    public void destroyCollisions() {
        if (collisions.isEmpty()) {
            return;
        }
        collisions.removeIf(c -> c.getAge() > GameConfig.COLLISION_TIME * 1000000000L);
        notifyObservers();
    }

    @Override
    public void quickSave() {
        quickSave = Caretaker.getInstance().createMemento();
    }

    @Override
    public void quickLoad() {
        Caretaker.getInstance().setMemento(quickSave);
        updateInfo();
        notifyObservers();
    }

    private static class Memento {
        private int score;
        private long timestamp;
        private final List<AbstractMissile> missiles = new ArrayList<>();
        private final List<AbstractEnemy> enemies = new ArrayList<>();
        private final List<Collision> collisions = new ArrayList<>();
        private Cannon cannon;
    }

    @Override
    public Object createMemento() {
        Memento memento = new Memento();
        memento.score = score;
        memento.timestamp = System.nanoTime();
        missiles.forEach(x -> memento.missiles.add(gameObjectFactory.createMissileCopy(x)));
        enemies.forEach(x -> memento.enemies.add(gameObjectFactory.createEnemyCopy(x)));
        collisions.forEach(x -> {
            Collision newCollision = new Collision(new Position(x.getPosition().getX(), x.getPosition().getY()));
            memento.collisions.add(newCollision);
        });
        memento.cannon = new Cannon(cannon);
        return memento;
    }

    @Override
    public void setMemento(Object memento) {
        Memento m = (Memento) memento;
        long timeDiff = System.nanoTime() - m.timestamp;
        score = m.score;
        missiles.clear();
        enemies.clear();
        collisions.clear();
        m.missiles.forEach(x -> missiles.add(gameObjectFactory.createMissileCopy(x)));
        m.enemies.forEach(x-> enemies.add(gameObjectFactory.createEnemyCopy(x)));
        m.collisions.forEach(x -> {
            Collision newCollision = new Collision(new Position(x.getPosition().getX(), x.getPosition().getY()));
            newCollision.addToBornAt(-x.getAge());
            collisions.add(newCollision);
        });
        missiles.forEach(x -> x.addToBornAt(timeDiff));
        enemies.forEach(x -> x.addToBornAt(timeDiff));
        collisions.forEach(x -> x.addToBornAt(timeDiff));
        cannon = new Cannon(m.cannon);
    }

    @Override
    public void registerCommand(AbstractGameCommand cmd) {
        unexecutedCommands.add(cmd);
    }

    @Override
    public void undoLastCommand() {
        if (executedCommands.isEmpty()) {
            return;
        }
        executedCommands.pop().revert();
        notifyObservers();
    }

    @Override
    public Cannon getCannon() {
        return cannon;
    }

}
