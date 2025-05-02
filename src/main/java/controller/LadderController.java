package controller;

import static view.InputView.INPUT_EXCEPTION_MESSAGE;

import java.util.Map;
import java.util.stream.Collectors;
import model.goal.Goal;
import model.goal.Goals;
import model.ladder.Ladder;
import model.LadderGame;
import model.ladder.LadderHeight;
import java.util.ArrayList;
import java.util.List;
import model.player.Player;
import model.player.PlayerName;
import model.player.Players;
import model.player.Position;
import util.LadderGenerator;
import view.InputView;
import view.OutputView;

public class LadderController {

  private final InputView inputView;
  private final OutputView outputView;
  private final LadderGenerator generator;

  public LadderController(InputView inputView, OutputView outputView, LadderGenerator generator) {
    this.inputView = inputView;
    this.outputView = outputView;
    this.generator = generator;
  }

  public void run() {
    Players players = createPlayers();
    Goals goals = createGoals(players);
    LadderHeight height = createLadderHeight(players.size());
    Ladder ladder = Ladder.of(players, height, generator);
    LadderGame game = new LadderGame(ladder);
    Map<Player, Goal> results = game.play(players, goals);
    outputView.printLadder(ladder, players, goals);
    showResults(players, results);
  }

  private Players createPlayers() {
    try {
      List<String> rawNames = inputView.inputPlayers();
      List<Player> players = new ArrayList<>();
      for (int i = 0; i < rawNames.size(); i++) {
        players.add(new Player(new PlayerName(rawNames.get(i)),
            new Position(i)));
      }
      return new Players(players);
    } catch (IllegalArgumentException e) {
      System.out.println(INPUT_EXCEPTION_MESSAGE);
      return createPlayers();
    }
  }

  private Goals createGoals(Players players) {
    try {
      List<String> rawGoals = inputView.inputGoals(players);
      List<Goal> goalList = rawGoals.stream()
          .map(Goal::new)
          .collect(Collectors.toList());
      return new Goals(goalList, players.size());
    } catch (IllegalArgumentException e) {
      System.out.println(INPUT_EXCEPTION_MESSAGE);
      return createGoals(players);
    }
  }

  private LadderHeight createLadderHeight(int playerCount) {
    try {
      int height = inputView.inputLadderHeight();
      return new LadderHeight(height, playerCount);
    } catch (IllegalArgumentException e) {
      System.out.println(INPUT_EXCEPTION_MESSAGE);
      return createLadderHeight(playerCount);
    }
  }

  private void showResults(Players players, Map<Player, Goal> results) {
    String input = inputView.inputPlayerForResult();
    while (!input.isBlank()) {
      input = processResultInput(input, players, results);
    }
  }

  private String processResultInput(String input, Players players, Map<Player, Goal> results) {
    try {
      selectResult(input, players, results);
      return inputView.inputPlayerForResult();
    } catch (IllegalArgumentException e) {
      System.out.println(INPUT_EXCEPTION_MESSAGE);
      return inputView.inputPlayerForResult();
    }
  }

  private void selectResult(String input, Players players, Map<Player, Goal> results) {
    if (input.equals("all")) {
      outputView.printAllResults(results);
      return;
    }
    players.validateContainsPlayer(input);
    outputView.printSingleResult(input, players, results);
  }
}
