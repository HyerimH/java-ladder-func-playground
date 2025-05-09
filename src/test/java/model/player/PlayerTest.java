package model.player;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    @DisplayName("정상적으로 Player 객체를 생성한다")
    void playerShouldHaveNameAndPosition() {
        // Given
        Player player = new Player("abc", 5);

        // When & Then
        assertThat(player.getName()).isEqualTo(new PlayerName("abc"));
        assertThat(player.getPosition()).isEqualTo(new Position(5));
    }
}
