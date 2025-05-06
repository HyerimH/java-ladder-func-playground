package model.goal;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GoalsTest {

    @Test
    @DisplayName("플레이어의 수와 다른 갯수의 결과가 입력되면 예외를 반환한다")
    void throwExceptionWhenNotMatches() {
        // Given
        List<Goal> goals = List.of(new Goal("당첨"), new Goal("꽝"));
        int playerCount = 3;

        // When & Then
        assertThatThrownBy(() -> new Goals(goals, playerCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("실행 결과 수와 참여자 수는 같아야 합니다.");
    }
}
