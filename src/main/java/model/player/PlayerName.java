package model.player;

import java.util.Objects;

public class PlayerName {

    private final String name;
    private final String CANNOT_NAME = "all";
    private final int MAXINUM_NAME_LENGTH = 5;

    public PlayerName(String name) {
        validateName(name);
        validateNaming(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank() || name.length() > MAXINUM_NAME_LENGTH) {
            throw new IllegalArgumentException("플레이어의 이름은 1~5글자여야 합니다.");
        }
    }

    private void validateNaming(String name) {
        if (name.equalsIgnoreCase(CANNOT_NAME)) {
            throw new IllegalArgumentException("플레이어 이름으로 'all'은 사용할 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PlayerName that = (PlayerName) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }
}
