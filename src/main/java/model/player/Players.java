package model.player;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {

    private final List<Player> players;

    public Players(List<Player> players) {
        validatePlayerCount(players);
        validateDuplicate(players);
        this.players = List.copyOf(players);
        ;
    }

    public static Players from(List<String> names) {
        List<Player> players = IntStream.range(0, names.size())
                .mapToObj(i -> new Player(names.get(i), i))
                .toList();
        return new Players(players);
    }

    public Player getPlayerAt(int index) {
        if (index < 0 || index >= players.size()) {
            throw new IllegalArgumentException("유효하지 않은 인덱스입니다: " + index);
        }
        return players.get(index);
    }

    private void validatePlayerCount(List<Player> players) {
        if (players.size() < 2) {
            throw new IllegalArgumentException("플레이어는 최소 2명 이상이어야 합니다.");
        }
    }

    private void validateDuplicate(List<Player> players) {
        Set<PlayerName> names = players.stream()
                .map(Player::getName)
                .collect(Collectors.toSet());
        if (names.size() != players.size()) {
            throw new IllegalArgumentException("플레이어의 이름은 중복될 수 없습니다.");
        }
    }

    public void validateContainsPlayer(String input) {
        if (!this.containsPlayer(input)) {
            throw new IllegalArgumentException("해당 이름의 플레이어가 존재하지 않습니다: " + input);
        }
    }

    public boolean containsPlayer(String name) {
        return players.stream()
                .anyMatch(player -> player.getName().getName().equals(name));
    }

    public int size() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return List.copyOf(players);
    }
}
