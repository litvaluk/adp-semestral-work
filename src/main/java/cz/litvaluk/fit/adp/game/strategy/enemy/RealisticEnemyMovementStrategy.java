package cz.litvaluk.fit.adp.game.strategy.enemy;

import cz.litvaluk.fit.adp.game.model.gameobjects.Vector;
import cz.litvaluk.fit.adp.game.model.gameobjects.enemy.AbstractEnemy;

public class RealisticEnemyMovementStrategy implements EnemyMovementStrategy {

    @Override
    public void updatePosition(AbstractEnemy enemy) {
        if (enemy.isOutOfBounds()) {
            enemy.changeDirectionInverse();
        }
        if (enemy.getDirectionTime() > enemy.getDirectionChangeInterval()) {
            enemy.changeDirectionRandom();
        }

        double angle = 0;
        switch (enemy.getDirection()) {
            case LEFT:
                angle = toRad(180);
                break;
            case UP_LEFT:
                angle = toRad(135);
                break;
            case UP:
                angle = toRad(90);
                break;
            case UP_RIGHT:
                angle = toRad(45);
                break;
            case RIGHT:
                angle = toRad(0);
                break;
            case DOWN_RIGHT:
                angle = toRad(315);
                break;
            case DOWN:
                angle = toRad(270);
                break;
            case DOWN_LEFT:
                angle = toRad(225);
                break;
        }

        double dX = enemy.getSpeed() * Math.cos(angle);
        double dY = -(enemy.getSpeed() * Math.sin(angle));
        enemy.move(new Vector((int) dX, (int) dY));
    }

    private double toRad(double degrees) {
        return Math.PI * degrees / 180;
    }

}
