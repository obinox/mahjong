package obinox.com.Mentsu;

import obinox.com.Enums.Agaru;
import obinox.com.Enums.MentsuType;
import obinox.com.Enums.Tile;

public class Toitsu extends Mentsu {
    public Toitsu(Tile[] tiles) {
        super(tiles);
        this.tsu = MentsuType.ELSE;
    }

    public Toitsu(Tile[] tiles, Agaru agaru) {
        super(tiles);
        switch (agaru){
            case TSUMO -> this.tsu = MentsuType.ELSE;
            case RON -> this.tsu = MentsuType.NULL;
        }
    }
}
