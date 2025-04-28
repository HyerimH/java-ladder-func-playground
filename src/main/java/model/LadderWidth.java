package model;

public class LadderWidth {

  private static final int MINIMUM_LADDER_WIDTH = 1;
  private final int width;


  public LadderWidth(int width) {
    validateLadderWidth(width);
    this.width = width;
  }

  private void validateLadderWidth(int width) {
    if(width <= MINIMUM_LADDER_WIDTH) {
      throw new IllegalArgumentException("사다리의 넓이는 1보다 커야합니다.");
    }
  }

  public int getLadderWidth() {
    return width;
  }
}
