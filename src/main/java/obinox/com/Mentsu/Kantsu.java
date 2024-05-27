package obinox.com.Mentsu;

import obinox.com.Enums.MentsuType;
import obinox.com.Enums.Tile;

public class Kantsu extends Mentsu {
    public Kantsu(Tile[] tiles) {
        super(tiles);
        this.tsu = MentsuType.ANKAN;
    }

    public Kantsu(Koutsu kou, Tile tile, Tile from) {
        super(kou, tile, from);
        if (kou.tsu == MentsuType.ANKOU) {
            this.tsu = MentsuType.DAIMINKAN;
        } else if (kou.tsu == MentsuType.MINKOU) {
            this.tsu = MentsuType.SHOUMINKAN;
        }
    }
}
