package model.ladder;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import model.player.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DirectionTest {

    @Test
    @DisplayName("오른쪽 이동이 가능한 경우")
    void rightDirectionTest() {
        // Given
        Position position = new Position(0);
        List<Point> points = List.of(Point.CONNECTED);

        // When
        boolean result = Direction.RIGHT.isMovable(position, points);

        // Then
        assertTrue(result);
    }

    @Test
    @DisplayName("왼쪽 이동이 가능한 경우")
    void leftDirectionTest() {
        // Given
        Position position = new Position(1);
        List<Point> points = List.of(Point.CONNECTED);

        // When
        boolean result = Direction.LEFT.isMovable(position, points);

        // Then
        assertTrue(result);
    }

    @Test
    @DisplayName("왼쪽 이동이 가능한 경우")
    void stayDirectionTest() {
        // Given
        Position position = new Position(1);
        List<Point> points = List.of(Point.DISCONNECTED);

        // When
        boolean movable = Direction.STAY.isMovable(position, points);
        Position moved = Direction.STAY.move(position);

        // Then
        assertTrue(movable);
        assertEquals(1, moved.getValue());
    }
}
