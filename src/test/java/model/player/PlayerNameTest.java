package model.player;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerNameTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "abc", "abcde"})
    @DisplayName("플레이어 이름이 1글자에서 5글자 사이면 정상적으로 생성된다")
    void createWhenPlayerNameIsBetween(String name) {
        assertThatNoException().isThrownBy(() -> new PlayerName(name));
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "hahahaha", " "})
    @DisplayName("플레이어 이름이 공백이거나 6글자 이상이면 예외가 발생한다")
    void throwExceptionWhenExceedsFive(String name) {
        assertThatThrownBy(() -> new PlayerName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("플레이어의 이름은 1~5글자여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"all", "ALL", "aLl"})
    @DisplayName("플레이어 이름이 'all'이면 예외가 발생한다")
    void throwExceptionWhenNameIsAll(String name) {
        assertThatThrownBy(() -> new PlayerName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("플레이어 이름으로 'all'은 사용할 수 없습니다.");
    }
}
