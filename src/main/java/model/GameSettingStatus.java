package model;

public enum GameSettingStatus {
    START("게임 시작하기", 1),
    END("게임 끝내기", 2),
    ;

    private final String name;
    private final int code;

    GameSettingStatus(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }

    public static String getAllStatusNameCode() {

        String allStatusNameCodeStringBuilder = START.name + " : " + START.code
                                                + ", "
                                                + END.name + " : " + END.code;

        return allStatusNameCodeStringBuilder;

    }
}
