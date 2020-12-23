package itmostady.exam3;

public class StartGame implements Command{
    Game game;

    public StartGame(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.start();
    }
}
