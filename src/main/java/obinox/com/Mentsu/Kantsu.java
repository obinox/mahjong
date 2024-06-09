package obinox.com.Mentsu;

import obinox.com.Enums.MentsuType;
import obinox.com.Enums.Tile;

public class Kantsu extends Mentsu {
    public Kantsu(Tile[] tiles) {
        super(tiles);
        this.tsu = MentsuType.ANKAN;
    }

    public Kantsu(Tile[] tiles, int from) {
        super(tiles, from);
        this.tsu = MentsuType.DAIMINKAN;
    }

    public Kantsu(Koutsu kou, Tile tile) {
        super(kou, tile, kou.from);
        this.tsu = MentsuType.SHOUMINKAN;
    }
}
