package cz.litvaluk.fit.adp.game.model.gameobjects;

public abstract class TimeableGameObject extends GameObject {

    private long bornAt = System.nanoTime();

    public long getAge() {
        return System.nanoTime() - bornAt;
    }

    public void addToBornAt(long dt) {
        bornAt += dt;
    }

}
