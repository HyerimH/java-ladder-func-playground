package model.ladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.player.Players;
import model.player.Position;
import util.LadderGenerator;

public class Ladder {

    private final LadderHeight height;
    private final List<Line> lines;

    public Ladder(LadderHeight height, List<Line> lines) {
        this.height = height;
        this.lines = lines;
    }

    public static Ladder of(Players players, LadderHeight height, LadderGenerator ladderGenerator) {
        List<Line> lines = new ArrayList<>();
        Ladder ladder = new Ladder(height, lines);
        ladder.addLines(players.size(), ladderGenerator);
        return ladder;
    }

    private void addLines(int playersCount, LadderGenerator ladderGenerator) {
        for (int i = 0; i < getLadderHeight(); i++) {
            lines.add(Line.create(playersCount, ladderGenerator));
        }
        if (isLadderNotConnected(playersCount)) {
            lines.clear();
            addLines(playersCount, ladderGenerator);
        }
    }

    // Line이 최소 한 번 연결되었는지 검증
    private boolean isLadderNotConnected(int playersCount) {
        Boolean[] isConnectedAt = getLadderConnectionStatus(playersCount);
        return Arrays.stream(isConnectedAt)
                       .collect(Collectors.toSet())
                       .size() != 1;
    }

    // 전체 Line별 연결 상태 확인
    private Boolean[] getLadderConnectionStatus(int playersCount) {
        int width = playersCount - 1;
        Boolean[] isConnectedAt = new Boolean[width];
        Arrays.fill(isConnectedAt, false);
        lines.forEach(line -> getLineConnectionStatus(isConnectedAt, line));
        return isConnectedAt;
    }

    // 특정 Line의 연결 상태 확인
    private void getLineConnectionStatus(Boolean[] isConnectedAt, Line line) {
        IntStream.range(0, line.getLadderWidth())
                .forEach(i -> getPointConnectionStatus(isConnectedAt, line, i));
    }

    // 특정 Line의 특정 Point 연결 상태 확인
    private void getPointConnectionStatus(Boolean[] isConnectedAt, Line line, int i) {
        if (line.getPoints().get(i).isConnected()) {
            isConnectedAt[i] = true;
        }
    }

    public int getLadderHeight() {
        return height.getLadderHeight();
    }

    public int getLadderWidth(Players players) {
        return players.size();
    }

    public Position getGoalsPosition(Position start) {
        Position current = start;
        for (Line line : lines) {
            current = line.move(current);
        }
        return current;
    }

    public List<Line> getLines() {
        return List.copyOf(lines);
    }
}
