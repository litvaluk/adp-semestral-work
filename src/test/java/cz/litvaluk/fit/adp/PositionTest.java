package cz.litvaluk.fit.adp;

import cz.litvaluk.fit.adp.game.model.gameobjects.Position;
import cz.litvaluk.fit.adp.game.model.gameobjects.Vector;
import org.junit.Assert;
import org.junit.Test;

public class PositionTest {

    @Test
    public void testAddVectorToPosition() {
        Position position = new Position(10, 10);
        Vector vector = new Vector(5, 1);
        Position shiftedPosition = position.add(vector);
        Assert.assertEquals(shiftedPosition.getX(), 15);
        Assert.assertEquals(shiftedPosition.getY(), 11);
    }

}
