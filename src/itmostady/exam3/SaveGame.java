package itmostady.exam3;

public class SaveGame implements Command{
    Game game;

    public SaveGame(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.save();
    }
}
