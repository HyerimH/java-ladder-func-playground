package model.ladder;

public enum Point {
  CONNECTED,
  DISCONNECTED;

  public static Point of(boolean status) {
    if (status) {
      return CONNECTED;
    }
    return DISCONNECTED;
  }

  public boolean isConnected() {
    return this.equals(CONNECTED);
  }
}
