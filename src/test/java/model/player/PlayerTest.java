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
}
