package obinox.com;

import obinox.com.Enums.IteratorGroup;
import obinox.com.Enums.Machi;
import obinox.com.Enums.MahjongError;
import obinox.com.Enums.Tile;
import obinox.com.Mentsu.Koutsu;
import obinox.com.Mentsu.Mentsu;
import obinox.com.Mentsu.Taatsu;
import obinox.com.Mentsu.Toitsu;
import obinox.com.Util.Tenpai;

import java.util.*;

public class Hand {
    private List<Tile> tiles = new ArrayList<>(13);
    public final List<Mentsu> naki = new ArrayList<>(4);
    public final List<Tile> kawa = new ArrayList<>(30);
    private Tile tsumohai;

    private Tile ba;
    private Tile ji;

    Hand(){}

    public void setKyoku(List<Tile> tiles, Tile b, Tile j) throws MahjongException{
        this.ba = b;
        this.ji = j;
        if (tiles.size() != 13){
            throw new MahjongException(MahjongError.HAIPAI_ERROR);
        }
        for (Tile t: tiles){
            if (t==null){
                throw new MahjongException(MahjongError.HAIPAI_ERROR);
            }
        }
        this.tiles = tiles;
        Collections.sort(this.tiles);
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

    public void tsumo(Yama y) throws MahjongException{
        if (this.tsumohai!=null){
            throw new MahjongException(MahjongError.IS_ALREADY_TSUMO);
        }
        this.tsumohai = y.tsumo();
        System.out.println("Direction: "+this.ji +", Tsumo:"+this.tsumohai);
    }

    @Override
    public String toString() {
        return tiles.toString();
    }

    public Tile suteru(int idx) throws MahjongException{
        if (idx<0||idx>13){
            throw new MahjongException(MahjongError.HAND_INDEX_OUT_OF_RANGE);
        }
        Tile t;
        if (idx == 13){
            t = this.tsumohai;
        } else {
            t = this.tiles.get(idx);
            this.tiles.set(idx, this.tsumohai);
        }
        Collections.sort(this.tiles);
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

    public List<Tenpai> getTenpai(){
        List<Tile> fuuro = new ArrayList<>();
        for (Mentsu m: this.naki){
            fuuro.addAll(List.of(m.mentsu));
        }
        return Tenpai.getTenpai(this.tiles, fuuro);
    }
    public void YakuCalc(){

    }
}
