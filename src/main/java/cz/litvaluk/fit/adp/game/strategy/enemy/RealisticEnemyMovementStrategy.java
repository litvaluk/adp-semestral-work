package cz.litvaluk.fit.adp.game.strategy.enemy;

import cz.litvaluk.fit.adp.game.model.gameobjects.Vector;
import cz.litvaluk.fit.adp.game.model.gameobjects.enemy.AbstractEnemy;
import cz.litvaluk.fit.adp.game.utils.Utils;

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
                angle = Utils.degToRad(180);
                break;
            case UP_LEFT:
                angle = Utils.degToRad(135);
                break;
            case UP:
                angle = Utils.degToRad(90);
                break;
            case UP_RIGHT:
                angle = Utils.degToRad(45);
                break;
            case RIGHT:
                angle = Utils.degToRad(0);
                break;
            case DOWN_RIGHT:
                angle = Utils.degToRad(315);
                break;
            case DOWN:
                angle = Utils.degToRad(270);
                break;
            case DOWN_LEFT:
                angle = Utils.degToRad(225);
                break;
        }

        double dX = enemy.getSpeed() * Math.cos(angle);
        double dY = -(enemy.getSpeed() * Math.sin(angle));
        enemy.move(new Vector((int) dX, (int) dY));
    }

}
