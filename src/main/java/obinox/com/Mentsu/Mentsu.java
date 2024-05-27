package obinox.com.Mentsu;

import obinox.com.Enums.MentsuType;
import obinox.com.Enums.Tile;

import java.util.Arrays;

public abstract class Mentsu {
    public final Tile[] mentsu;
    public final Tile from;
    public final int fuuroIdx;
    public MentsuType tsu;

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
