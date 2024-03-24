package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static model.BaseballNumberGenerator.BASEBALL_DIGIT_LENGTH;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class GameTest {

    private final Game game = new Game();

    @ParameterizedTest
    @DisplayName("gameSetting 에 입력되는 값이 1이면 게임 시작, 값이 2면 게임 종료 동작 여부를 검사한다.")
    @CsvSource(value = {"1:true", "2:false"}, delimiter = ':')
    void isGameSetting_ShouldReturnExpectedValue(String input, boolean expected) {
        boolean gameStatus = game.gameSetting(input);
        assertThat(gameStatus).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("gameSetting 에 허용되지 않는 값을 넣으면 ERROR 및 안내 메세지 출력 여부를 검사한다.")
    @ValueSource(strings = {"15", "", "응 안해~", "0", "3", "게임 시작하기", "게임 끝내기"})
    void isGameSetting_ShouldThrowIllegalArgumentExceptionWithWrongInput(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                boolean gameStatus = game.gameSetting(input);
            }).withMessage("[ERROR] 잘못된 게임 코드 값입니다. " + GameSettingStatus.getAllStatusNameCode());
    }

    @ParameterizedTest
    @DisplayName("checkInputValidation 에 허용되지 않는 값을 넣으면 ERROR 및 안내 메세지 출력 여부를 검사한다.")
    @ValueSource(strings = {"1", "13", "4143", "값을 넣어볼까?", "", "0"})
    void isCheckInputValidation_ShouldThrowIllegalArgumentExceptionWithWrongInput(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                game.checkInputValidation(input);
            }).withMessage("[ERROR] %d 자리 숫자로 입력해야 합니다.", BASEBALL_DIGIT_LENGTH);
    }
}