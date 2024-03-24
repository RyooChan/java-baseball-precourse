import java.util.Scanner;

import static model.BaseballNumberGenerator.BASEBALL_DIGIT_LENGTH;

public class GameView {
    Scanner scanner = new Scanner(System.in);

    public String getUserGameSettingInput() {
        System.out.print("게임 시작 여부를 입력해주세요: ");
        return scanner.nextLine();
    }

    public String getUserGamePlayingInput() {
        System.out.printf("%d자리 숫자를 입력해주세요: ", BASEBALL_DIGIT_LENGTH);
        return scanner.nextLine();
    }

    public void getResponse(String response) {
        System.out.println(response);
    }

    public void getErrorMessage(String message) {
        System.out.println(message);
    }

}
