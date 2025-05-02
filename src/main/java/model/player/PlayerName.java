package model.player;

import java.util.Objects;

public class PlayerName {

  private final int MAXINUM_NAME_LENGTH = 5;
  private final String name;

  public PlayerName(String name) {
    validateName(name);
    this.name = name;
  }

  private void validateName(String name) {
    if (name == null || name.isBlank() || name.length() > MAXINUM_NAME_LENGTH) {
      throw new IllegalArgumentException("플레이어의 이름은 1~5글자여야 합니다.");
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
