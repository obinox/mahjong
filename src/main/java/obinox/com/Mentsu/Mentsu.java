package obinox.com.Mentsu;

import obinox.com.Enums.MentsuType;
import obinox.com.Enums.Tile;

import java.util.Arrays;
import java.util.Objects;

public abstract class Mentsu implements Comparable<Mentsu>{
    public final Tile[] mentsu;
    public final Tile from;
    public final int fuuroIdx;
    public MentsuType tsu;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mentsu mentsu1 = (Mentsu) o;
        return fuuroIdx == mentsu1.fuuroIdx && Arrays.equals(mentsu, mentsu1.mentsu) && from == mentsu1.from && tsu == mentsu1.tsu;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(from, fuuroIdx, tsu);
        result = 31 * result + Arrays.hashCode(mentsu);
        return result;
    }

    @Override
    public int compareTo(Mentsu o) {

        if (tsu.menzen == o.tsu.menzen){
            if (mentsu.length == o.mentsu.length){
                if (mentsu[0].ordinal() == o.mentsu[0].ordinal()){
                    return mentsu[1].ordinal() - o.mentsu[1].ordinal();
                } else {
                    return mentsu[0].ordinal() - o.mentsu[0].ordinal();
                }
            } else {
                return mentsu.length - o.mentsu.length;
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
        return Arrays.deepToString(this.mentsu);
    }

    public Mentsu(Tile[] tiles) {
        this.mentsu = tiles;
        this.from = Tile.NULL;
        this.fuuroIdx = -1;
    }

    public Mentsu(Tile[] tiles, Tile from) {
        this.mentsu = tiles;
        this.from = from;
        this.fuuroIdx = 0;
    }

    public Mentsu(Taatsu taa, Tile tile, int fuuro, Tile from) {
        Tile[] tiles = new Tile[]{tile, taa.mentsu[0], taa.mentsu[1]};
        Arrays.sort(tiles);
        this.mentsu = tiles;
        this.from = from;
        this.fuuroIdx = fuuro;
    }

    public Mentsu(Toitsu toi, Tile tile, Tile from) {
        this.mentsu = new Tile[]{tile, toi.mentsu[0], toi.mentsu[1]};
        this.from = from;
        this.fuuroIdx = 0;
    }

    public Mentsu(Koutsu kou, Tile tile, Tile from) {
        this.mentsu = new Tile[]{kou.mentsu[0], kou.mentsu[1], kou.mentsu[2], tile};
        this.from = from;
        this.fuuroIdx = 0;
    }
}
