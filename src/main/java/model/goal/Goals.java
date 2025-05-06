package model.goal;

import java.util.List;

public class Goals {

    private final List<Goal> goals;

    public Goals(List<Goal> goals, int playerCount) {
        validateGoals(goals, playerCount);
        this.goals = List.copyOf(goals);

    }

    public static Goals from(List<String> rawGoals, int playerCount) {
        List<Goal> goalList = rawGoals.stream()
                .map(Goal::new)
                .toList();
        return new Goals(goalList, playerCount);
    }

    private void validateGoals(List<Goal> goals, int playerCount) {
        if (goals.size() != playerCount) {
            throw new IllegalArgumentException("실행 결과 수와 참여자 수는 같아야 합니다.");
        }
    }

    public Goal getGoalAt(int index) {
        if (index < 0 || index >= goals.size()) {
            throw new IllegalArgumentException("유효하지 않은 인덱스입니다: " + index);
        }
        return goals.get(index);
    }

    public List<Goal> getGoals() {
        return List.copyOf(goals);
    }
}
