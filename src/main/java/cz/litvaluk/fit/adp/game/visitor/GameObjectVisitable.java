package cz.litvaluk.fit.adp.game.visitor;

public interface GameObjectVisitable {

    void acceptVisitor(GameObjectVisitor visitor);

}
