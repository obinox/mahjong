package obinox.com.Mentsu;

import obinox.com.Enums.MentsuType;
import obinox.com.Enums.Tile;

public class Koutsu extends Mentsu {
    public Koutsu(Tile[] tiles) {
        super(tiles);
        this.tsu = MentsuType.ANKOU;
    }

    public Koutsu(Toitsu toi, Tile tile, Tile from) {
        super(toi, tile, from);
        this.tsu = MentsuType.MINKOU;
    }
}
