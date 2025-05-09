package model.player;

public class Position {

    public static final int MINIMUM_POSITION = 0;
    private final int value;

    public Position(int value) {
        this.value = value;
    }

    public Position moveToRight() {
        return new Position(value + 1);
    }

    public Position moveToLeft() {
        if (value <= MINIMUM_POSITION) {
            throw new IllegalArgumentException("Position의 값은 음수가 될 수 없습니다.");
        }
        return new Position(value - 1);
    }

    public int getValue() {
        return value;
    }
}
