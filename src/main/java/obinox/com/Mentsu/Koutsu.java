package obinox.com.Mentsu;

import obinox.com.Enums.Agaru;
import obinox.com.Enums.MentsuType;
import obinox.com.Enums.Tile;

public class Koutsu extends Mentsu {
    public Koutsu(Tile[] tiles) {
        super(tiles);
        this.tsu = MentsuType.ANKOU;
    }

    public Koutsu(Tile[] tiles, int from) {
        super(tiles, from);
        this.tsu = MentsuType.MINKOU;
    }


    public Koutsu(Tile[] tiles, Agaru agaru){
        super(tiles);
        switch (agaru){
            case TSUMO -> this.tsu = MentsuType.ANKOU;
            case RON -> this.tsu = MentsuType.MINKOU;
        }
    }
}
