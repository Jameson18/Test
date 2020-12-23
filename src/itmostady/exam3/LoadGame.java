package itmostady.exam3;

public class LoadGame implements Command{
    Game game;

    public LoadGame(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.load();
    }
}
