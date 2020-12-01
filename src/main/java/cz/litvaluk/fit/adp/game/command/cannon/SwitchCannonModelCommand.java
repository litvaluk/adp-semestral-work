package cz.litvaluk.fit.adp.game.command.cannon;

import cz.litvaluk.fit.adp.game.command.AbstractGameCommand;
import cz.litvaluk.fit.adp.game.model.AbstractGameModel;

public class SwitchCannonModelCommand extends AbstractGameCommand {

    public SwitchCannonModelCommand(AbstractGameModel model) {
        this.model = model;
    }

    @Override
    protected void simpleExecute() {
        model.switchCannonMode();
    }

}
