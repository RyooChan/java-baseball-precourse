package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static model.BaseballNumberGenerator.RANDOM_NUM_LIST;
import static model.BaseballNumberMatcher.BALL;
import static model.BaseballNumberMatcher.STRIKE;
import static org.assertj.core.api.Assertions.assertThat;

class BaseballNumberMatcherTest {
    private final BaseballNumberMatcher baseballNumberMatcher = new BaseballNumberMatcher();

    @BeforeEach
    void setUp() {
        RANDOM_NUM_LIST[0] = 1;
        RANDOM_NUM_LIST[1] = 7;
        RANDOM_NUM_LIST[2] = 3;
    }

    @ParameterizedTest
    @DisplayName("숫자는 같지만 Index 가 다른 경우 checkDigitStatus 가 BALL 을 반환하는지 검사한다.")
    @CsvSource(value = {"7:0", "7:2", "1:1", "1:2", "3:0", "3:1"}, delimiter = ':')
    void isCheckDigitStatus_ShouldReturnBallWithSameNumDifferentIndex(int num, int index) {
        String checkDigitStatus = baseballNumberMatcher.checkDigitStatus(num, index);

        assertThat(checkDigitStatus).isEqualTo(BALL);
    }

    @ParameterizedTest
    @DisplayName("숫자와 Index 가 같은 경우 checkDigitStatus 가 STRIKE 를 반환하는지 검사한다.")
    @CsvSource(value = {"1:0", "7:1", "3:2"}, delimiter = ':')
    void isCheckDigitStatus_ShouldReturnStrikeWithSameNumSameIndex(int num, int index) {
        String checkDigitStatus = baseballNumberMatcher.checkDigitStatus(num, index);

        assertThat(checkDigitStatus).isEqualTo(STRIKE);
    }

    @ParameterizedTest
    @DisplayName("해당하는 숫자가 없는 경우 checkDigitStatus 가 NOTHING 을 반환하는지 검사한다.")
    @CsvSource(value = {"2:0", "2:1", "2:2", "4:0", "4:1", "4:2", "5:0", "5:1", "5:2"}, delimiter = ':')
    void isCheckDigitStatus_ShouldReturnNothingWithoutAnyMatch(int num, int index) {
        String checkDigitStatus = baseballNumberMatcher.checkDigitStatus(num, index);

        assertThat(checkDigitStatus).isNull();
    }

    @ParameterizedTest
    @DisplayName("각 입력에 따라 getHint 가 힌트를 제대로 반환하는지 검사한다.")
    @CsvSource(value = {"173:3:0", "073:2:0", "130:1:1", "317:0:3", "834:0:1", "894:0:0", "111:1:2", "000:0:0"}, delimiter = ':')
    void isGetHint_ShouldReturnHintWithCount(String input, int strikeCount, int ballCount) {
        HintDto hintDto = baseballNumberMatcher.getHint(input);
        HintDto expectedHintDto = new HintDto(strikeCount, ballCount);

        assertThat(hintDto).isEqualTo(expectedHintDto);
    }

}