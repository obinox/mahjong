package obinox.com;

import obinox.com.Enums.IteratorGroup;
import obinox.com.Enums.MahjongError;
import obinox.com.Enums.Tile;
import obinox.com.Mentsu.Koutsu;
import obinox.com.Mentsu.Mentsu;
import obinox.com.Mentsu.Taatsu;
import obinox.com.Mentsu.Toitsu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hand {
    private Tile[] tiles = new Tile[13];
    public final List<Mentsu> naki = new ArrayList<>();
    public final List<Tile> kawa = new ArrayList<>();
    private Tile tsumohai;

    private Tile ba;
    private Tile ji;

    Hand(){}

    public void setKyoku(Tile[] tiles, Tile b, Tile j) throws MahjongException{
        this.ba = b;
        this.ji = j;
        if (tiles.length != 13){
            throw new MahjongException(MahjongError.HAIPAI_ERROR);
        }
        for (Tile t: tiles){
            if (t==null){
                throw new MahjongException(MahjongError.HAIPAI_ERROR);
            }
        }
        this.tiles = tiles;
        Arrays.sort(this.tiles);
        this.kawa.clear();
        System.out.println(this);
    }

    public void tsumo(Tile t) throws MahjongException{
        if (this.tsumohai!=null){
            throw new MahjongException(MahjongError.IS_ALREADY_TSUMO);
        }
        this.tsumohai = t;
        System.out.println("Direction: "+this.ji +", Tsumo:"+this.tsumohai);
    }

    @Override
    public String toString() {
        return Arrays.deepToString(tiles);
    }

    public Tile suteru(int idx) throws MahjongException{
        if (idx<0||idx>13){
            throw new MahjongException(MahjongError.HAND_INDEX_OUT_OF_RANGE);
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

    public Mentsu pong(Toitsu toi, Tile tile, Tile from){
        Mentsu men = NewMentsu.fuuro(toi, tile, from);
        this.naki.add(men);
        return men;
    }
    public Mentsu chii(Taatsu taa, Tile tile){
        Mentsu men = NewMentsu.fuuro(taa, tile, IteratorGroup.KAZEHAI.iterator.get((this.ji.value+3)%4));
        this.naki.add(men);
        return men;
    }
    public Mentsu kan(Koutsu kou, Tile tile, Tile from){
        Mentsu men = NewMentsu.fuuro(kou, tile, from);
        this.naki.add(men);
        return men;
    }

    public void isTenpai(){
        //2-3-3-3-3
        // tiles set
        Tile[] ts = new Tile[13];
        int i;
        i=0;
        for (Tile t: this.tiles){
            ts[i] = t;
            i++;
        }

        Tile[] ts1;
        for (Tile t: Tile.values()){
            ts1 = Arrays.copyOf(ts, ts.length+1);
            ts1[13] = t;
            Arrays.sort(ts1);
        }

        Mentsu[] ms = new Mentsu[4];
        i=0;
        for (Mentsu m: this.naki){
            ms[i] = m;
            i++;
        }
        this.naki.size();
        //2-2-2-2-2-2-2
        //Kokushi Musou
    }

    public void YakuCalc(){

    }
}
