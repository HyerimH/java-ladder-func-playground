package model.goal;

public class Goal {

    private final int MAXINUM_GOAL_LENGTH = 5;
    private final String goal;

    public Goal(String goal) {
        validateGoal(goal);
        this.goal = goal;
    }

    private void validateGoal(String goal) {
        if (goal == null || goal.isBlank() || goal.length() > MAXINUM_GOAL_LENGTH) {
            throw new IllegalArgumentException("실행 결과는 1~5글자여야 합니다.");
        }

    }

    public String getGoal() {
        return goal;
    }
}
