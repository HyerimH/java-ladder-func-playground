package model.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderHeightTest {

    @Test
    @DisplayName("정상적으로 LadderHeight 객체가 생성된다")
    void createLadderHeight() {
        // Given
        int height = 5;
        int player = 5;

        // When
        LadderHeight ladderHeight = new LadderHeight(height, player);

        // Then
        assertThat(ladderHeight.getLadderHeight()).isEqualTo(height);
    }

    @Test
    @DisplayName("사다리 높이가 (플레이어 - 1) 작거나 20보다 크면 예외가 발생한다")
    void throwExceptionHeightWhenIsBetween() {
        // Given
        int invalidHeight = 10;
        int playerCount = 15;

        // When & Then
        assertThatThrownBy(() -> new LadderHeight(invalidHeight, playerCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리의 높이는 (플레이어 수 - 1) 이상, 20 이하의 숫자만 가능합니다.");
    }
}
