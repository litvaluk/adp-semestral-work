package cz.litvaluk.fit.adp.game.command.cannon;

import cz.litvaluk.fit.adp.game.command.AbstractGameCommand;
import cz.litvaluk.fit.adp.game.model.AbstractGameModel;

public class CannonAimUpCommand extends AbstractGameCommand {

    public CannonAimUpCommand(AbstractGameModel model) {
        this.model = model;
    }

    @Override
    protected void simpleExecute() {
        model.cannonAimUp();
    }

}
