package obinox.com;

import obinox.com.Enums.IteratorGroup;
import obinox.com.Enums.Tile;
import obinox.com.Mentsu.*;

import java.util.Arrays;

public class MentsuGen {

    public static Mentsu mentsu(Tile[] tiles){
        Arrays.sort(tiles);
        if (tiles.length == 3) {
            if (Tile.equal(tiles)){
                return new Koutsu(tiles);
            } else if (Tile.sequence(tiles) && IteratorGroup.isIn(IteratorGroup.SHUUPAI, tiles)){
                return new Shuntsu(tiles);
            }
        } else if (tiles.length == 2){
            if (Tile.equal(tiles)){
                return new Toitsu(tiles);
            } else if ((Tile.sequence(tiles) || Tile.sequence(tiles, 2)) && IteratorGroup.isIn(IteratorGroup.SHUUPAI, tiles)){
                return new Taatsu(tiles);
            }
        } else if (tiles.length == 4 && Tile.equal(tiles)) {
            return new Kantsu(tiles);
        }
        return new Nulltsu(new Tile[0]);
    }

    public static Mentsu fuuro(Toitsu toi, Tile tile, int from){
        if (Tile.equal(toi.mentsu, tile)){
            return new Koutsu(toi, tile, from);
        }
        return new Nulltsu(new Tile[0]);
    }
    public static Mentsu fuuro(Koutsu kou, Tile tile, int from){
        if (Tile.equal(kou.mentsu, tile)){
            return new Kantsu(kou, tile, from);
        }
        return new Nulltsu(new Tile[0]);
    }

    public static Mentsu fuuro(Taatsu taa, Tile tile, int from){
        if (Tile.sequence(new Tile[]{tile, taa.mentsu[0], taa.mentsu[1]})){
            return new Shuntsu(taa, tile, 0, from);
        } else if (Tile.sequence(new Tile[]{taa.mentsu[0], tile, taa.mentsu[1]})){
            return new Shuntsu(taa, tile, 1, from);
        } else if (Tile.sequence(new Tile[]{taa.mentsu[0], taa.mentsu[1], tile})){
            return new Shuntsu(taa, tile, 2, from);
        }
        return new Nulltsu(new Tile[0]);
    }
}