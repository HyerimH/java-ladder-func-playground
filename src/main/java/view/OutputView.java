package view;

import model.Ladder;
import model.Status;
import java.util.Map;

public class OutputView {
  public void printLadder(Ladder ladder) {
    for (var line : ladder.getLines()) {
      System.out.print("|");
      for (Status status : line.getPoints()) {
        System.out.print(status.getStatus() ? "----|" : "    |");
      }
      System.out.println();
    }
  }

  public void printResults(Map<Integer, Integer> results) {
    for (var entry : results.entrySet()) {
      System.out.println(entry.getKey() + " -> " + entry.getValue());
    }
  }
}
