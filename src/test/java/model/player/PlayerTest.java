package model.player;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    @DisplayName("정상적으로 Player 객체를 생성한다")
    void playerShouldHaveNameAndPosition() {
        // Given
        PlayerName playerName = new PlayerName("abc");
        Position position = new Position(5);
        Player player = new Player(playerName, position);

        // When & Then
        assertThat(player.getName()).isEqualTo(playerName);
        assertThat(player.getPosition()).isEqualTo(position);
    }

    @Test
    @DisplayName("같은 이름이나 포지션을 가진 Player 객체는 true를 반환한다")
    void playerShouldHaveNameAndPositionTrue() {
        // Given
        PlayerName playerName1 = new PlayerName("abc");
        Position position1 = new Position(5);
        Player player1 = new Player(playerName1, position1);

        PlayerName playerName2 = new PlayerName("abc");
        Position position2 = new Position(5);
        Player player2 = new Player(playerName2, position2);

        // When & Then
        assertThat(player1).isEqualTo(player2);
    }
}
