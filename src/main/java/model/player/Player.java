package model.player;

import java.util.Objects;

public class Player {

    private final PlayerName name;
    private final Position position;

    public Player(PlayerName name, Position position) {
        this.name = name;
        this.position = position;
    }

    public PlayerName getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }
}
