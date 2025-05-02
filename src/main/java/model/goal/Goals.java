package model.goal;

import java.util.ArrayList;
import java.util.List;

public class Goals {

  private final List<Goal> goals;

  public Goals(List<Goal> goals, int playerCount) {
    validateGoals(goals, playerCount);
    this.goals = new ArrayList<>(goals);

  }

  private void validateGoals(List<Goal> goals, int playerCount) {
    if (goals.size() != playerCount) {
      throw new IllegalArgumentException("실행 결과 수와 참여자 수는 같아야 합니다.");
    }
  }

  public List<Goal> getGoals() {
    return List.copyOf(goals);
  }
}
