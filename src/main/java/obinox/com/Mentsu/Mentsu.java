package obinox.com.Mentsu;

import obinox.com.Enums.MentsuType;
import obinox.com.Enums.Tile;

import java.util.Arrays;
import java.util.Objects;

public abstract class Mentsu implements Comparable<Mentsu>{
    public final Tile[] tiles;
    public final int from;
    public final int fuuroIdx;
    public MentsuType tsu;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mentsu mentsu1 = (Mentsu) o;
        return fuuroIdx == mentsu1.fuuroIdx && Arrays.equals(tiles, mentsu1.tiles) && from == mentsu1.from && tsu == mentsu1.tsu;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(from, fuuroIdx, tsu);
        result = 31 * result + Arrays.hashCode(tiles);
        return result;
    }

    @Override
    public int compareTo(Mentsu o) {

        if (tsu.menzen == o.tsu.menzen){
            if (tiles.length == o.tiles.length){
                if (tiles[0].ordinal() == o.tiles[0].ordinal()){
                    return tiles[1].ordinal() - o.tiles[1].ordinal();
                } else {
                    return tiles[0].ordinal() - o.tiles[0].ordinal();
                }
            } else {
                return tiles.length - o.tiles.length;
            }
        } else {
            if (tsu.menzen){
                return -1;
            } else {
                return 1;
            }
        }
    }

    @Override
    public String toString() {
        return Arrays.deepToString(this.tiles);
    }

    public Mentsu(Tile[] tiles) {
        this.tiles = tiles;
        this.from = -1;
        this.fuuroIdx = -1;
    }

    public Mentsu(Tile[] tiles, int from) {
        this.tiles = tiles;
        this.from = from;
        this.fuuroIdx = 0;
    }

    public Mentsu(Tile[] tiles, int from, int fuuroIdx) {
        this.tiles = tiles;
        this.from = from;
        this.fuuroIdx = fuuroIdx;
    }

    public Mentsu(Taatsu taa, Tile tile, int fuuro, int from) {
        Tile[] tiles = new Tile[]{tile, taa.tiles[0], taa.tiles[1]};
        Arrays.sort(tiles);
        this.tiles = tiles;
        this.from = from;
        this.fuuroIdx = fuuro;
    }

    public Mentsu(Toitsu toi, Tile tile, int from) {
        this.tiles = new Tile[]{tile, toi.tiles[0], toi.tiles[1]};
        this.from = from;
        this.fuuroIdx = 0;
    }

    public Mentsu(Koutsu kou, Tile tile, int from) {
        this.tiles = new Tile[]{kou.tiles[0], kou.tiles[1], kou.tiles[2], tile};
        this.from = from;
        this.fuuroIdx = 0;
    }
}
