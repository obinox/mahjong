package obinox.com;

import obinox.com.Enums.Agaru;
import obinox.com.Enums.IteratorGroup;
import obinox.com.Enums.Tile;
import obinox.com.Mentsu.*;

import java.util.Arrays;

public class NewMentsu {

    public static Mentsu mentsu(Tile[] tiles, Agaru agaru){
        Arrays.sort(tiles);
        if (tiles.length == 3) {
            if (Tile.equal(tiles)){
                return new Koutsu(tiles);
            } else if (Tile.sequence(tiles) && IteratorGroup.isAllIn(IteratorGroup.SHUUPAI, tiles)){
                return new Shuntsu(tiles);
            }
        } else if (tiles.length == 2){
            if (Tile.equal(tiles)){
                return new Toitsu(tiles);
            } else if ((Tile.sequence(tiles) || Tile.sequence(tiles, 2)) && IteratorGroup.isAllIn(IteratorGroup.SHUUPAI, tiles)){
                return new Taatsu(tiles);
            }
        } else if (tiles.length == 4 && Tile.equal(tiles)) {
            return new Kantsu(tiles);
        }
        return new Nulltsu(new Tile[0]);
    }

    public static Mentsu mentsu(Tile[] tiles){
        return mentsu(tiles, Agaru.TSUMO);
    }


}