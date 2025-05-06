package model.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import model.player.Position;
import util.LadderGenerator;

public class Line {

    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = List.copyOf(points);
    }

    public static Line create(int playerCount, LadderGenerator ladderGenerator) {
        List<Point> points = new ArrayList<>();
        IntStream.range(0, playerCount - 1)
                .forEach(i -> makeLine(points, ladderGenerator));
        return new Line(points);
    }

    private static void makeLine(List<Point> points, LadderGenerator ladderGenerator) {
        if (points.isEmpty()) { // 비어 있을 땐, 랜덤 생성
            points.add(Point.from(ladderGenerator.generate()));
            return;
        }
        if (points.get(points.size() - 1).isConnected()) { // 연속 연결 방지
            points.add(Point.DISCONNECTED);
            return;
        }
        points.add(Point.from(ladderGenerator.generate())); // 다시 랜덤 생성
    }

    public Position move(Position position) {
        return Stream.of(Direction.RIGHT, Direction.LEFT, Direction.STAY)
                .filter(direction -> direction.isMovable(position, points))
                .findFirst()
                .map(direction -> direction.move(position))
                .orElse(position);
    }

    public List<Point> getPoints() {
        return List.copyOf(points);
    }

    public int getLadderWidth() {
        return points.size();
    }
}
