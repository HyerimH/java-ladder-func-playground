package model.ladder;

public class LadderHeight {

    private static final int MAXIMUM_LADDER_HEIGHT = 20;

    private final int height;

    public LadderHeight(int height, int playerCount) {
        validateLadderHeight(height, playerCount);
        this.height = height;
    }

    private void validateLadderHeight(int height, int playerCount) {
        if (height < playerCount - 1 || height > MAXIMUM_LADDER_HEIGHT) {
            throw new IllegalArgumentException("사다리의 높이는 (플레이어 수 - 1) 이상, 20 이하의 숫자만 가능합니다.");
        }
    }

    public int getLadderHeight() {
        return height;
    }
}
