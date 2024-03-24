package model;

import static java.lang.Integer.*;
import static java.lang.String.*;
import static model.BaseballNumberGenerator.BASEBALL_DIGIT_LENGTH;
import static model.BaseballNumberMatcher.BALL;
import static model.BaseballNumberMatcher.NOTHING;
import static model.BaseballNumberMatcher.STRIKE;
import static model.GameSettingStatus.*;

public class Game {
    public static final String CORRECT = "정답!";

    public boolean gameSetting(String input) {

        if (!isNumeric(input)) {
            throw new IllegalArgumentException("[ERROR] 잘못된 게임 코드 값입니다. "
                + GameSettingStatus.getAllStatusNameCode());
        }

        if (parseInt(input) == START.getCode()) {
            return true;
        }

        if (parseInt(input) == END.getCode()) {
            return false;
        }

        throw new IllegalArgumentException("[ERROR] 잘못된 게임 코드 값입니다. "
            + GameSettingStatus.getAllStatusNameCode());
    }

    private boolean isNumeric(String input) {

        try {
            parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    public void checkInputValidation(String input) {
        if (input.length() != BASEBALL_DIGIT_LENGTH) {
            throw new IllegalArgumentException(format("[ERROR] %d 자리 숫자로 입력해야 합니다."
                , BASEBALL_DIGIT_LENGTH));
        }
    }

    public String getGameResponse(HintDto hintDto) {
        int strikeCount = hintDto.getStrikeCount();
        int ballCount = hintDto.getBallCount();
        StringBuilder outputStringBuilder = new StringBuilder();

        if (strikeCount + ballCount == 0) {
            return NOTHING;
        }

        if (strikeCount != 0) {

            if (strikeCount == BASEBALL_DIGIT_LENGTH) {
                return CORRECT;
            }

            outputStringBuilder.append(strikeCount).append(STRIKE);
        }

        if (ballCount != 0) {

            if (strikeCount != 0) {
                outputStringBuilder.append(" ");
            }

            outputStringBuilder.append(ballCount).append(BALL);
        }

        return outputStringBuilder.toString();
    }
}
