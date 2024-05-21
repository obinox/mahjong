package obinox.com;

import java.util.Arrays;
import java.util.List;

public class Mentsu{

    public static abstract class mentsu{
        public final Tile[] mentsu;
        public final int from;
        public final int fuuroIdx = 0;

        @Override
        public String toString() {
            return Arrays.deepToString(this.mentsu);
        }

        mentsu(Tile[] tiles){
            this.mentsu = tiles;
            this.from = 0;
        }
        mentsu(Tile[] tiles, int from){
            this.mentsu = tiles;
            this.from = from;
        }
        mentsu(toitsu toi, Tile tile, int from){
            this.mentsu = new Tile[]{tile, toi.mentsu[0], toi.mentsu[1]};
            this.from = from;
        }
        mentsu(koutsu kou, Tile tile, int from){
            this.mentsu = new Tile[]{kou.mentsu[0], kou.mentsu[1], kou.mentsu[2], tile};
            this.from = from;
        }
    }
    public static class toitsu extends mentsu{
        toitsu(Tile[] tiles){
            super(tiles);
        }
    }
    public static class koutsu extends mentsu{
        koutsu(Tile[] tiles){
            super(tiles);
        }
        koutsu(toitsu toi, Tile tile, int from){
            super(toi, tile, from);
        }
    }
    public static class kantsu extends mentsu{
        kantsu(Tile[] tiles){
            super(tiles);
        }
        kantsu(koutsu kou, Tile tile, int from){
            super(kou, tile, from);
        }
    }
    public static class shuntsu extends mentsu{
        shuntsu(Tile[] tiles){
            super(tiles);
        }
    }
    public static class nulltsu extends mentsu{
        nulltsu(Tile[] tiles){
            super(tiles);
        }
    }


    public static mentsu tiles(Tile[] tiles){
        Arrays.sort(tiles);
        if (tiles.length == 3) {
            if (Tile.equal(tiles)){
                return new koutsu(tiles);
            } else if (Tile.sequence(tiles)&&IteratorGroup.isIn(IteratorGroup.SHUUPAI, tiles)){
                return new shuntsu(tiles);
            }
        } else if (tiles.length == 2){
            return new toitsu(tiles);
        } else if (tiles.length == 4) {
            return new kantsu(tiles);
        }
        return new nulltsu(tiles);
    }
}