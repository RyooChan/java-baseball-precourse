package model;

import static java.lang.Integer.*;
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
}
