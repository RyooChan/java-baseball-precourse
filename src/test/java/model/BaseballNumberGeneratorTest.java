package model;

import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.*;
import static model.BaseballNumberGenerator.BASEBALL_DIGIT_LENGTH;
import static model.BaseballNumberGenerator.RANDOM_NUM_LIST;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class BaseballNumberGeneratorTest {
    private final BaseballNumberGenerator baseballNumberGenerator = new BaseballNumberGenerator();

    @BeforeEach
    void setUp() {
        baseballNumberGenerator.makeRandomDigitList();
    }

    @RepeatedTest(10)
    @DisplayName("makeRandomNum으로 만든 배열이 서로 다른 숫자로 이루어져 있는지 검사한다. - 모두 다른 숫자일 확률 70%에 대해 10번 수행")
    void isMakeRandomNum_ShouldNotHasSameDigits() {

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i< BASEBALL_DIGIT_LENGTH; i++) {
            set.add(RANDOM_NUM_LIST[i]);
        }

        assertThat(set.size()).isEqualTo(BASEBALL_DIGIT_LENGTH);
    }

    @Test
    @DisplayName("makeRandomNum으로 만든 배열의 숫자들이 1~9의 숫자로 이루어져 있는지 검사한다.")
    void isMakeRandomNum_ShouldRangeZeroToNine() {
        Set<Integer> numExpectedSet = new HashSet<>(asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

        for (int i : RANDOM_NUM_LIST) {
            assertThat(numExpectedSet).contains(i);
        }
    }
}