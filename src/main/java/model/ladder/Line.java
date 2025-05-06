package model.ladder;

import java.util.ArrayList;
import java.util.List;
import model.player.Position;
import util.LadderGenerator;

public class Line {

    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = List.copyOf(points);
    }

    public static Line create(int PlayerCount, LadderGenerator ladderGenerator) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < PlayerCount - 1; i++) {
            makeLine(points, ladderGenerator);
        }
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

    public void tryMoveAt(Position position) {
        if (isRightPassable(position)) {
            position.moveToRight();
            return;
        }
        if (isLeftPassable(position)) {
            position.moveToLeft();
        }
    }

    private boolean isRightPassable(Position position) {
        if (position.getValue() == points.size()) { // 오른쪽 끝, 이동 불가
            return false;
        }
        return points.get(position.getValue()).isConnected();
    }

    private boolean isLeftPassable(Position position) {
        if (position.getValue() == Position.MINIMUM_POSITION) { // 왼쪽 끝, 이동 불가
            return false;
        }
        return points.get(position.getValue() - 1).isConnected();
    }

    public List<Point> getPoints() {
        return List.copyOf(points);
    }

    public int getLadderWidth() {
        return points.size();
    }
}
