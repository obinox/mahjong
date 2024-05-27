package obinox.com.Mentsu;

import obinox.com.Enums.MentsuType;
import obinox.com.Enums.Tile;

public class Shuntsu extends Mentsu {
    public Shuntsu(Tile[] tiles) {
        super(tiles);
        this.tsu = MentsuType.ANJUN;
    }

    public Shuntsu(Taatsu taa, Tile tile, int fuuro, Tile from) {
        super(taa, tile, fuuro, from);
        this.tsu = MentsuType.MINJUN;
    }
}
