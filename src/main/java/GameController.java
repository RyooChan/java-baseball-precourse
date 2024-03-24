import model.BaseballNumberGenerator;
import model.BaseballNumberMatcher;
import model.Game;
import model.HintDto;

import static model.Game.CORRECT;

public class GameController {
    private final BaseballNumberGenerator baseballNumberGenerator;
    private final BaseballNumberMatcher baseballNumberMatcher;
    private final Game game;
    private final GameView gameView;

    public GameController(BaseballNumberGenerator baseballNumberGenerator,
                          BaseballNumberMatcher baseballNumberMatcher,
                          Game game,
                          GameView gameView) {
        this.baseballNumberGenerator = baseballNumberGenerator;
        this.baseballNumberMatcher = baseballNumberMatcher;
        this.game = game;
        this.gameView = gameView;
    }

    public void run() {
        while (true) {
            baseballNumberGenerator.makeRandomDigitList();
            baseballPlay();
            boolean keepGoing = gamePlay();

            if (!keepGoing) {
                return;
            }
        }
    }

    private boolean gamePlay() {

        while (true) {

            String userGameSettingInput = gameView.getUserGameSettingInput();

            try {
                return game.gameSetting(userGameSettingInput);

            } catch (IllegalArgumentException e) {
                gameView.getErrorMessage(e.getMessage());
            }
        }
    }

    private void baseballPlay() {

        while (true) {
            String userGamePlayingInput = gameView.getUserGamePlayingInput();

            try {
                game.checkInputValidation(userGamePlayingInput);
            } catch (IllegalArgumentException e) {
                gameView.getErrorMessage(e.getMessage());
                continue;
            }

            HintDto hint = baseballNumberMatcher.getHint(userGamePlayingInput);
            String gameResponse = game.getGameResponse(hint);
            gameView.getResponse(gameResponse);

            if (gameResponse.equals(CORRECT)) {
                break;
            }
        }

    }
}
