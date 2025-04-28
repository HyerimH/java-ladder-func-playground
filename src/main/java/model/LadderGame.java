package model;

import java.util.HashMap;
import java.util.Map;

public class LadderGame {
  private final Ladder ladder;

  public LadderGame(Ladder ladder) {
    this.ladder = ladder;
  }

  public Map<Integer, Integer> play() {
    Map<Integer, Integer> results = new HashMap<>();
    for (int start = 0; start < ladder.getLadderWidth(); start++) {
      results.put(start, ladder.move(start));
    }
    return results;
  }
}
