package model.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import model.player.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    @DisplayName("정상적으로 객체를 가진다")
    void createPosition() {
        // Given
        Position position = new Position(5);

        // When & Then
        assertThat(position.getValue()).isEqualTo(5);
    }

    @Test
    @DisplayName("position은 값이 0 이하로 내려갈 수 없다")
    void throwExceptionWhenPositionIsNegative() {
        // Given
        Position position = new Position(-0);

        // When & Then
        assertThatThrownBy(() -> position.moveToLeft())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Position의 값은 음수가 될 수 없습니다.");
    }
}
