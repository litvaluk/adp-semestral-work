package cz.litvaluk.fit.adp.game.command.save;

import cz.litvaluk.fit.adp.game.command.AbstractGameCommand;
import cz.litvaluk.fit.adp.game.model.AbstractGameModel;

public class QuickLoadCommand extends AbstractGameCommand {

    public QuickLoadCommand(AbstractGameModel model) {
        this.model = model;
    }

    @Override
    protected void simpleExecute() {
        model.quickLoad();
    }

}
