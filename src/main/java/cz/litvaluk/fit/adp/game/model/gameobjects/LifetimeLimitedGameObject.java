package cz.litvaluk.fit.adp.game.model.gameobjects;

public class LifetimeLimitedGameObject extends GameObject {

    private final long bornAt;

    public LifetimeLimitedGameObject(Position position) {
        super(position);
        bornAt = System.nanoTime();
    }

    public long getAge() {
        return bornAt - System.nanoTime();
    }

}
