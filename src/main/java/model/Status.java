package model;

public enum Status {
  CONNECTED(true),
  DISCONNECTED(false);

  private boolean status;

  Status(boolean status) {
    this.status = status;
  }

  public boolean getStatus() {
    return status;
  }

  public static Status findStatus(boolean status) {
    if (status) {
      return CONNECTED;
    }
    return DISCONNECTED;
  }
}
