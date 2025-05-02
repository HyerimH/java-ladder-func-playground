package view;

import java.util.List;
import model.goal.Goal;
import model.goal.Goals;
import model.ladder.Ladder;
import model.player.Player;
import model.player.Players;
import model.ladder.Point;
import java.util.Map;

public class OutputView {

  private static final int MAXIMUM_PLAYER_NAME_SPACE = 6;
  private static final String EXECUTION_RESULT = "\n실행 결과";
  private static final String LADDER_RESULT_HEADER = "\n사다리 결과\n";
  private static final String CONNECTED_LINE="-----|";
  private static final String DISCONNECTED_LINE="     |";
  private static final String EDGE_OF_POINT="|";

  public void printLadder(Ladder ladder, Players players, Goals goals) {
    System.out.println(LADDER_RESULT_HEADER);
    printPlayerNamers(players);
    printLadderLines(ladder);
    printGoals(goals);
  }

  private void printPlayerNamers(Players players) {
    for (Player player : players.getPlayers()) {
      System.out.printf("%-" + MAXIMUM_PLAYER_NAME_SPACE + "s", player.getName().getName());
    }
    System.out.println();
  }

  private void printLadderLines(Ladder ladder) {
    for (var line : ladder.getLines()) {
      printLine(line.getPoints());
    }
  }

  private void printLine(List<Point> points) {
    System.out.print("  "+EDGE_OF_POINT);
    for (var point : points) {
      printPoint(point);
    }
    System.out.println();
  }

  private void printPoint(Point point) {
    if(point.isConnected()){
      System.out.print(CONNECTED_LINE);
      return;
    }
    System.out.print(DISCONNECTED_LINE);
  }

  private void printGoals(Goals goals) {
    System.out.print("  ");
    for (Goal goal : goals.getGoals()) {
      System.out.printf("%-" + MAXIMUM_PLAYER_NAME_SPACE + "s", goal.getGoal());
    }
    System.out.println();
  }

  public void printAllResults(Map<Player, Goal> results) {
    System.out.println(EXECUTION_RESULT);
    for (var entry : results.entrySet()) {
      System.out.println(entry.getKey().getName().getName() + " : " + entry.getValue().getGoal());
    }
  }

  public void printSingleResult(String name, Players players, Map<Player, Goal> results) {
    System.out.println(EXECUTION_RESULT);
    for (Player player : players.getPlayers()) {
      printPlayerResult(name, player, results);
    }
  }

  private void printPlayerResult(String name, Player player, Map<Player, Goal> results) {
    if (player.getName().getName().equals(name)) {
      System.out.println(results.get(player).getGoal());
    }
  }
}
