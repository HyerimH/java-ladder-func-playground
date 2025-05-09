package model.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import model.TestLadderGenerator;
import model.player.Player;
import model.player.PlayerName;
import model.player.Players;
import model.player.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import util.RandomLadderGenerator;

class LadderTest {

    @Test
    @DisplayName("Ladder는 올바른 높이와 플레이어 수에 맞는 라인을 생성한다")
    void createLadder() {
        // Given
        int playerCount = 4;
        LadderHeight height = new LadderHeight(5, playerCount);

        List<Player> playersList = List.of(
                new Player("a", 0),
                new Player("b", 1),
                new Player("c", 2),
                new Player("d", 3)
        );
        Players players = new Players(playersList);

        // When
        Ladder ladder = Ladder.of(players, height, new RandomLadderGenerator());

        // Then
        assertThat(ladder.getLadderHeight()).isEqualTo(5);
        assertThat(ladder.getLadderWidth(players)).isEqualTo(4);
        assertThat(ladder.getLines().size()).isEqualTo(5);
    }

    @Test
    @DisplayName("플레이어가 다르다면 서로 다른 결과 위치를 반환해주어야 한다")
    void getDifferentStartEndPosition() {
        // Given
        LadderHeight height = new LadderHeight(2, 3);
        List<Player> playersList = List.of(
                new Player("a", 0),
                new Player("b", 1),
                new Player("c", 2)
        );
        Players players = new Players(playersList);
        Ladder ladder = Ladder.of(players, height, new RandomLadderGenerator());

        // When
        Position first = ladder.getGoalsPosition(new Position(0));
        Position second = ladder.getGoalsPosition(new Position(1));

        // Then
        assertThat(first).isNotEqualTo(second);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:3", "1:1", "2:2", "3:0"}, delimiter = ':')
    @DisplayName("사다리의 결과에 맞는 시작 위치, 도착 위치를 반환해주어야 한다")
    void getAppropriatePosition(int start, int end) {
        // Given
        List<Boolean> orderList = List.of(true, true, false, true, true, true);
        LadderHeight height = new LadderHeight(3, 4);
        List<Player> playersList = List.of(
                new Player("a", 0),
                new Player("b", 1),
                new Player("c", 2),
                new Player("d", 3)
        );
        Players players = new Players(playersList);
        Ladder ladder = Ladder.of(players, height, new TestLadderGenerator(orderList));

        // When
        Position results = ladder.getGoalsPosition(new Position(start));

        // Then
        assertThat(results.getValue()).isEqualTo(end);
    }
}
