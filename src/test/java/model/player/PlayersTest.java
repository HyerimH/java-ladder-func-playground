package model.player;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersTest {

    @Test
    @DisplayName("플레이어가 2명 미만일 경우 예외가 발생한다")
    void throwExceptionWhenLessThanTwo() {
        // Given
        List<Player> players = List.of(new Player("abc", 2));

        // When & Then
        assertThatThrownBy(() -> new Players(players))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("플레이어는 최소 2명 이상이어야 합니다.");
    }

    @Test
    @DisplayName("플레이어 이름이 중복되면 예외가 발생한다")
    void throwExceptionWhenDuplicate() {
        // Given
        Player player1 = new Player("abc",1);
        Player player2 = new Player("abc",2);
        List<Player> players = List.of(player1, player2);

        // When & Then
        assertThatThrownBy(() -> new Players(players))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("플레이어의 이름은 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("존재하지 않는 플레이어 이름 입력 시 예외가 발생한다")
    void throwExceptionWhenInvalidName() {
        // Given
        Player player1 = new Player("a",0);
        Player player2 = new Player("b",1);
        Players players = new Players(List.of(player1, player2));

        // When & Then
        assertThatThrownBy(() -> players.validateContainsPlayer("invalid"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("해당 이름의 플레이어가 존재하지 않습니다: invalid");
    }
}
