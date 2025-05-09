package model.player;

public class Player {

    private final PlayerName name;
    private final Position position;

    public Player(String name, int position) {
        this.name = new PlayerName(name);
        this.position = new Position(position);
    }

    public PlayerName getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }
}
