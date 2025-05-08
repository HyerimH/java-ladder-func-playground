package model;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
        return IntStream.range(0, players.size())
                .boxed()
                .collect(Collectors.toMap(
                        players::getPlayerAt,
                        index -> goals.getGoalAt(ladder.getGoalsPosition(new Position(index)).getValue())
                ));
    }
}
