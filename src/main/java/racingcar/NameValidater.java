package racingcar;


public class NameValidater {
    public static void validateName(String name) {
        if (name == null || name.length() > 5) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }
}

