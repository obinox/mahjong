package obinox.com.Mentsu;

import obinox.com.Enums.MentsuType;
import obinox.com.Enums.Tile;

public class Taatsu extends Mentsu {
    public Taatsu(Tile[] tiles) {
        super(tiles);
        this.tsu = MentsuType.ELSE;
    }
}
