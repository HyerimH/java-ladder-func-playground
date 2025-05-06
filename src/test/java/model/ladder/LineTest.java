package model.ladder;

import static model.ladder.Point.CONNECTED;
import static model.ladder.Point.DISCONNECTED;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import model.TestLadderGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.RandomLadderGenerator;

class LineTest {

    @Test
    @DisplayName("인자값으로 받은 playerCount -1 개 만큼의 Point를 가진다")
    void createLine() {
        // Given
        int playerCount = 3;

        // When
        Line line = Line.create(3, new RandomLadderGenerator());
        List<Point> points = line.getPoints();

        // Then
        assertThat(points.size()).isEqualTo(playerCount - 1);
    }

    @Test
    @DisplayName("Point 들은 연속된 다리를 가질 수 없다")
    void pointCanNotHaveDuplicate() {
        int playerCount = 4;
        List<Boolean> orderList = List.of(
                true,
                true,
                true
        );

        Line line = Line.create(playerCount, new TestLadderGenerator(orderList));
        List<Point> points = line.getPoints();

        assertThat(points).containsExactly(CONNECTED, DISCONNECTED, CONNECTED);
    }

}
