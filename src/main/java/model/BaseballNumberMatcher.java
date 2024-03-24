package model;

import static java.lang.Character.*;
import static model.BaseballNumberGenerator.BASEBALL_DIGIT_LENGTH;
import static model.BaseballNumberGenerator.RANDOM_NUM_LIST;

public class BaseballNumberMatcher {
    public static final String STRIKE = "스트라이크";
    public static final String BALL = "볼";
    public static final String NOTHING = "낫싱";

    public HintDto getHint(String input) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int i=0; i<input.length(); i++) {
            String checkDigitStatus = checkDigitStatus(getNumericValue(input.charAt(i)), i);

            if (checkDigitStatus == null) {
                continue;
            }

            if (checkDigitStatus.equals(STRIKE)) {
                strikeCount++;
            }

            if (checkDigitStatus.equals(BALL)) {
                ballCount++;
            }
        }

        return new HintDto(strikeCount, ballCount);
    }

    public String checkDigitStatus(int digit, int index) {

        for(int i=0; i<BASEBALL_DIGIT_LENGTH; i++) {
            if (RANDOM_NUM_LIST[i] == digit) {
                return checkStrikeOrBall(i, index);
            }
        }

        return null;
    }

    private String checkStrikeOrBall(int targetIndex, int inputIndex) {

        if (targetIndex == inputIndex) {
            return STRIKE;
        }

        return BALL;
    }
}
