package cz.litvaluk.fit.adp.game.command.cannon;

import cz.litvaluk.fit.adp.game.command.AbstractGameCommand;
import cz.litvaluk.fit.adp.game.model.AbstractGameModel;

public class CannonDecreaseCommand extends AbstractGameCommand {

    public CannonDecreaseCommand(AbstractGameModel model) {
        this.model = model;
    }

    @Override
    protected void simpleExecute() {
        model.cannonDecreaseForce();
    }

}
