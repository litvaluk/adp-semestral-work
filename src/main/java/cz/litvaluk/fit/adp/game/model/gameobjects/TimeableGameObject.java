package cz.litvaluk.fit.adp.game.model.gameobjects;

public abstract class TimeableGameObject extends GameObject {

    private final long bornAt = System.nanoTime();

    public long getAge() {
        return bornAt - System.nanoTime();
    }

}
