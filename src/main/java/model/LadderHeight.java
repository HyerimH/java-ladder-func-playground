package model;

public class LadderHeight {

  private static final int MAXIMUM_LADDER_HEIGHT = 20;
  private static final int MINIMUM_LADDER_HEIGHT = 1;

  private final int height;

  public LadderHeight(int height) {
    validateLadderHeight(height);
    this.height = height;
  }

  private void validateLadderHeight(int height) {
    if (height < MINIMUM_LADDER_HEIGHT || height > MAXIMUM_LADDER_HEIGHT) {
      throw new IllegalArgumentException("사다리의 높이는 1 이상, 20 이하의 숫자만 가능합니다.");
    }
  }

  public int getLadderHeight(){
    return height;
  }
}
