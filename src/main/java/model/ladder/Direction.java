package model.ladder;

import java.util.List;
import model.player.Position;

public enum Direction {

    // 현재 위치의 오른쪽에 사다리 연결이 있을 경우 오른쪽 이동
    RIGHT(
            (position, points) -> position.getValue() < points.size()
                                  && points.get(position.getValue()).isConnected(),
            Position::moveToRight
    ),
    // 현재 위치의 왼쪽에 사다리 연결이 있을 경우 왼쪽 이동
    LEFT(
            (position, points) -> position.getValue() > 0
                                  && points.get(position.getValue() - 1).isConnected(),
            Position::moveToLeft
    ),
    // 그 외의 경우, 현재 위치에 그대로 머무름
    STAY(
            (position, points) -> true,
            position -> position
    );

    private final MoveStrategy strategy;
    private final PositionChanger changer;

    Direction(MoveStrategy strategy, PositionChanger changer) {
        this.strategy = strategy;
        this.changer = changer;
    }

    public boolean isMovable(Position position, List<Point> points) {
        return strategy.isMovable(position, points);
    }

    public Position move(Position position) {
        return changer.move(position);
    }

    @FunctionalInterface
    interface MoveStrategy { // 지금 이 방향으로 움직일 수 있는가?
        boolean isMovable(Position position, List<Point> points);
    }

    @FunctionalInterface
    interface PositionChanger { // 이동했을 때 Position 어디인가?
        Position move(Position position);
    }
}
