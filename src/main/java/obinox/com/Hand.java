package obinox.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hand {
    private Tile[] tiles = new Tile[13];
    public final List<Mentsu> naki = new ArrayList<>();
    public final List<Tile> kawa = new ArrayList<>();
    private Tile tsumohai;
    private int direction = -1;

    Hand(){}

    public void setKyoku(Tile[] tiles, int d) throws MahjongException{
        this.direction = d;
        if (tiles.length != 13){
            throw new MahjongException(MahjongException.MahjongError.HAIPAI_ERROR);
        }
        for (Tile t: tiles){
            if (t==null){
                throw new MahjongException(MahjongException.MahjongError.HAIPAI_ERROR);
            }
        }
        this.tiles = tiles;
        Arrays.sort(this.tiles);
        this.kawa.clear();
        System.out.println(this);
    }

    public void tsumo(Tile t) throws MahjongException{
        if (this.tsumohai!=null){
            throw new MahjongException(MahjongException.MahjongError.IS_ALREADY_TSUMO);
        }
        this.tsumohai = t;
        System.out.println("Direction: "+this.direction+", Tsumo:"+this.tsumohai);
    }

    @Override
    public String toString() {
        return Arrays.deepToString(tiles);
    }

    public Tile suteru(int idx) throws MahjongException{
        if (idx<0||idx>13){
            throw new MahjongException(MahjongException.MahjongError.HAND_INDEX_OUT_OF_RANGE);
        }
        Tile t;
        if (idx == 13){
            t = this.tsumohai;
        } else {
            t = this.tiles[idx];
            this.tiles[idx] = this.tsumohai;
        }
        Arrays.sort(this.tiles);
        this.tsumohai = null;
        this.kawa.add(t);
        return t;
    }

    public void pong(){

    }
    public void chii(){

    }
    public void kan(){

    }
}
