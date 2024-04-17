package util;

import java.io.Serializable;

public class Message implements Serializable {
    private String playerName;
    private int points;

    public Message(String playerName, int points) {
        this.playerName = playerName;
        this.points = points;
    }

    public String getPlayerName() {
        return playerName;
    }

   public int getPoints() {
       return points;
   }

}
