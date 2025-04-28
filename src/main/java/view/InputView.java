package view;

import model.LadderHeight;
import model.LadderWidth;
import java.util.Scanner;

public class InputView {

  private static final Scanner scanner = new Scanner(System.in);
  private static final String INPUT_EXCEPTION_MESSAGE = "올바른 입력 형식이 아닙니다. 다시 입력해주세요.";


  public LadderHeight inputLadderHeight() {
    try {
      System.out.println("사다리의 높이는 몇 개인가요?");
      return new LadderHeight(Integer.parseInt(scanner.nextLine()));
    } catch (IllegalArgumentException e) {
      System.out.println(INPUT_EXCEPTION_MESSAGE);
      return inputLadderHeight();
    }
  }

  public LadderWidth inputLadderWidth() {
    try {
      System.out.println("사다리 넓이는 몇 개인가요?");
      return new LadderWidth(Integer.parseInt(scanner.nextLine()));
    } catch (IllegalArgumentException e) {
      System.out.println("INPUT_EXCEPTION_MESSAGE");
      return inputLadderWidth();
    }
  }
}
