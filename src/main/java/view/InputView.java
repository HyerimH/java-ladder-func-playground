package view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Scanner;
import model.player.Players;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    public static final String INPUT_EXCEPTION_MESSAGE = "올바른 입력 형식이 아닙니다. 숫자로 입력해주세요.";
    private static final String LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String EXECUTION_GOAL_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String EXECUTION_NAME_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String PLAYER_FOR_RESULT_MESSAGE = "결과를 보고 싶은 사람은?";
    private static final String INPUT_DELIMITER = ",";
    private static final String NEW_LINE = "\n";

    public int inputLadderHeight() {
        System.out.println(NEW_LINE + LADDER_HEIGHT_MESSAGE);
        String rawLadderHeight = scanner.nextLine();
        return parseInt(rawLadderHeight);
    }

    private int parseInt(String rawLadderHeight) {
        try {
            return Integer.parseInt(rawLadderHeight);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_EXCEPTION_MESSAGE);
        }
    }

    public List<String> inputPlayers() {
        System.out.println(NEW_LINE + EXECUTION_NAME_MESSAGE);
        String rawPlayerName = scanner.nextLine();
        return Arrays.stream(rawPlayerName.split(INPUT_DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public List<String> inputGoals() {
        System.out.println(NEW_LINE + EXECUTION_GOAL_MESSAGE);
        String rawGoals = scanner.nextLine();
        return Arrays.stream(rawGoals.split(INPUT_DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public String inputPlayerForResult() {
        System.out.println(NEW_LINE + PLAYER_FOR_RESULT_MESSAGE);
        return scanner.nextLine();
    }
}
