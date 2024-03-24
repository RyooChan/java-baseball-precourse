import model.BaseballNumberGenerator;
import model.BaseballNumberMatcher;
import model.Game;

public class BaseballApplication {
    public static void main(String[] args) {
        BaseballNumberGenerator baseballNumberGenerator = new BaseballNumberGenerator();
        BaseballNumberMatcher baseballNumberMatcher = new BaseballNumberMatcher();
        Game game = new Game();
        GameView gameView = new GameView();
        GameController gameController = new GameController(baseballNumberGenerator, baseballNumberMatcher, game, gameView);
        gameController.run();
    }
}
