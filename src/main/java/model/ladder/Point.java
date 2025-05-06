package model.ladder;

public enum Point {
    CONNECTED,
    DISCONNECTED;

    public static Point from(boolean status) {
        if (status) {
            return CONNECTED;
        }
        return DISCONNECTED;
    }

    public boolean isConnected() {
        return this.equals(CONNECTED);
    }
}
