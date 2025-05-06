package model.goal;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GoalTest {

    @DisplayName("정상적으로 Goal 객체를 생성한다")
    @Test
    void createGoal() {
        assertDoesNotThrow(() -> new Goal("꽝"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"결과가너무너무길때", " "})
    @DisplayName("플레이어 이름이 공백이거나 6글자 이상이면 예외가 발생한다")
    void throwExceptionWhenExceedsFive(String goal) {
        assertThatThrownBy(() -> new Goal(goal))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("실행 결과는 1~5글자여야 합니다.");
    }
}
