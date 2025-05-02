package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.ladder.Ladder;
import model.player.Position;
import model.goal.Goal;
import model.goal.Goals;
import model.player.Player;
import model.player.Players;

public class LadderGame {

  private final Ladder ladder;

  public LadderGame(Ladder ladder) {
    this.ladder = ladder;
  }

  public Map<Player, Goal> play(Players players, Goals goals) {
    Map<Player, Goal> results = new HashMap<>();
    List<Player> playerList = players.getPlayers();
    List<Goal> goalList = goals.getGoals();
    for (int start = 0; start < playerList.size(); start++) {
      Position end = ladder.getGoalsPosition(new Position(start));
      results.put(playerList.get(start), goalList.get(end.getValue()));
    }
    return results;
  }
}
