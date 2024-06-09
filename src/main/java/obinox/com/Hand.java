package obinox.com;

import obinox.com.Enums.*;
import obinox.com.Mentsu.*;
import obinox.com.Util.Agari;
import obinox.com.Util.Tenpai;

import java.util.*;

public class Hand {
    private List<Tile> tiles = new ArrayList<>(13);
    public final List<Mentsu> naki = new ArrayList<>(4);
    public final List<Tile> kawa = new ArrayList<>(30);
    private Tile tsumohai;
    public boolean menzen = true;

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
        this.tiles = new ArrayList<>(List.copyOf(tiles));
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
        return t;
    }

    public boolean canPong(Tile t){
        EnumMap<Tile, Integer> count = new EnumMap<>(Tile.class);
        Collections.sort(this.tiles);
        for (Tile h: this.tiles){
            count.merge(Tile.of(h, 0), 1, (v, p) -> v+1);
        }
        return count.getOrDefault(Tile.of(t, 0),0) > 2;
    }
    public boolean canShouMinKan(){
        Collections.sort(this.tiles);
        for (Mentsu m: this.naki){
            if (m instanceof Koutsu){
                for (Tile t: tiles) {
                    if (Tile.of(m.tiles[0], 0) == Tile.of(t, 0)) {
                        return true;
                    }
                }
                if (Tile.of(m.tiles[0], 0) == Tile.of(tsumohai, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean canDaiminKan(Tile t){
        EnumMap<Tile, Integer> count = new EnumMap<>(Tile.class);
        Collections.sort(this.tiles);
        for (Tile h: this.tiles){
            count.merge(Tile.of(h, 0), 1, (v, p) -> v+1);
        }
        return count.getOrDefault(Tile.of(t, 0),0) > 3;
    }
    public boolean canAnkan(){
        EnumMap<Tile, Integer> count = new EnumMap<>(Tile.class);
        Collections.sort(this.tiles);
        for (Tile h: this.tiles){
            count.merge(Tile.of(h, 0), 1, (v, p) -> v+1);
        }
        count.merge(Tile.of(this.tsumohai, 0), 1, (v, p) -> v+1);
        return count.containsValue(4);
    }

    public boolean canChii(Tile t){
        EnumMap<Tile, Integer> count = new EnumMap<>(Tile.class);
        Collections.sort(this.tiles);
        for (Tile h: this.tiles){
            count.merge(Tile.of(h, 0), 1, (v, p) -> v+1);
        }
        return
                (count.containsKey(Tile.of(t, 1)) && count.containsKey(Tile.of(t, 2))) ||
                (count.containsKey(Tile.of(t, -1)) && count.containsKey(Tile.of(t, 1))) ||
                (count.containsKey(Tile.of(t, -2)) && count.containsKey(Tile.of(t, -1)));

    }

    public boolean canRon(Tile t){
        List<Tenpai> ten = getTenpai();
        if (ten.isEmpty()){
            return false;
        }
        if (kawa.contains(t)){
            return false;
        }
        for (Tenpai tn: ten){
            if (tn.getKey() == t){
                List<Agari> agaris = Agari.getAgari(tiles, naki, t, Agaru.RON);
                boolean b = false;
                for (Agari a: agaris){
                    b = b || !Yaku.getYaku(a, ba, ji).isEmpty();
                }
                return b;
            }
        }
        return false;
    }

    public boolean canRiichi(){
        List<Tile> riichigiri = new ArrayList<>();
        if (!menzen){
            return false;
        }
        if (!Tenpai.getTenpai(tiles).isEmpty()){
            riichigiri.add(tsumohai);
        }
        for (int i=0;i<tiles.size();i++){
            List<Tile> sub = new ArrayList<>(List.copyOf(tiles));
            sub.add(tsumohai);
            sub.remove(i);
            if (!Tenpai.getTenpai(sub).isEmpty()){
                riichigiri.add(tsumohai);
            }
        }
        return !riichigiri.isEmpty();
    }

    public void pong(Tile tile, int from){
        Tile t = Tile.of(tile, 0);
        Tile[] mentsu = new Tile[3];
        mentsu[0] = tile;
        tiles.remove(t);
        mentsu[1] = t;
        if (tiles.remove(t)){
            tiles.remove(Tile.aka(t));
            mentsu[2] = Tile.aka(t);
        } else {
            mentsu[2] = t;
        }
        Mentsu men = new Koutsu(mentsu, from);
        menzen = false;
        this.naki.add(men);
    }

    public List<Integer> whatChii(Tile tile){
        List<Integer> out = new ArrayList<>();
        if ((tiles.contains(Tile.of(tile, -2))||tiles.contains(Tile.aka(Tile.of(tile, -2))))
                &&(tiles.contains(Tile.of(tile, -1))||tiles.contains(Tile.aka(Tile.of(tile, -1))))){
            out.add(1);
        }
        if ((tiles.contains(Tile.of(tile, 1))||tiles.contains(Tile.aka(Tile.of(tile, 1))))
                &&(tiles.contains(Tile.of(tile, -1))||tiles.contains(Tile.aka(Tile.of(tile, -1))))){
            out.add(0);
        }
        if ((tiles.contains(Tile.of(tile, 2))||tiles.contains(Tile.aka(Tile.of(tile, 2))))
                &&(tiles.contains(Tile.of(tile, 1))||tiles.contains(Tile.aka(Tile.of(tile, 1))))){
            out.add(-1);
        }
        return out;
    }

    public void chii(Tile tile, int from, int idx){
        Tile[] mentsu = new Tile[3];
        mentsu[0] = tile;
        Tile t1 = null;
        Tile t2 = null;
        switch (idx){
            case -1 ->{
                t1 = Tile.of(tile, 1);
                t2 = Tile.of(tile, 2);
            }
            case 0 ->{
                t1 = Tile.of(tile, -1);
                t2 = Tile.of(tile, 1);
            }
            case 1 ->{
                t1 = Tile.of(tile, -2);
                t2 = Tile.of(tile, -1);
            }
        }
        if (tiles.remove(t1)){
            tiles.remove(Tile.aka(t1));
            mentsu[1] = Tile.aka(t1);
        } else {
            mentsu[1] = t2;
        }
        if (tiles.remove(t2)){
            tiles.remove(Tile.aka(t2));
            mentsu[1] = Tile.aka(t2);
        } else {
            mentsu[1] = t2;
        }
        Mentsu men = new Shuntsu(mentsu, from);
        menzen = false;
        this.naki.add(men);
    }

    public void daiminKan(Tile tile, int from) {
        Tile t = Tile.of(tile, 0);
        Tile[] mentsu = new Tile[4];
        mentsu[0] = tile;
        tiles.remove(t);
        mentsu[1] = t;
        tiles.remove(t);
        mentsu[2] = t;
        if (tiles.remove(t)) {
            tiles.remove(Tile.aka(t));
            mentsu[3] = Tile.aka(t);
        } else {
            mentsu[3] = t;
        }
        Mentsu men = new Kantsu(mentsu, from);
        menzen = false;
        this.naki.add(men);
    }

    public void anKan(){
        EnumMap<Tile, Integer> count = new EnumMap<>(Tile.class);
        Collections.sort(this.tiles);
        Tile t = null;
        for (Tile h: this.tiles){
            count.merge(Tile.of(h, 0), 1, (v, p) -> v+1);
        }
        count.merge(Tile.of(this.tsumohai, 0), 1, (v, p) -> v+1);
        for (Tile h: count.keySet()){
            if (count.get(h)==4){
                t = h;
            }
        }

        Tile[] mentsu = new Tile[4];
        mentsu[0] = t;
        tiles.remove(t);
        mentsu[1] = t;
        tiles.remove(t);
        mentsu[2] = t;
        if (tiles.remove(t)) {
            tiles.remove(Tile.aka(t));
            mentsu[3] = Tile.aka(t);
        } else {
            mentsu[3] = t;
        }
        Mentsu men = new Kantsu(mentsu);
        this.naki.add(men);
    }

    public void shouminKan(){
        int i = 0;
        for (Mentsu m: this.naki){
            if (m instanceof Koutsu){
                for (Tile t: tiles){
                    if (Tile.of(m.tiles[0], 0) == Tile.of(t, 0)){
                        naki.add(new Kantsu((Koutsu) naki.remove(i), t));
                    }
                }
            }
            i++;
        }

    }
    public void ron(Tile tile, int from){

    }



    public List<Tenpai> getTenpai(){
        List<Tile> fuuro = new ArrayList<>();
        for (Mentsu m: this.naki){
            fuuro.addAll(List.of(m.tiles));
        }
        return Tenpai.getTenpai(this.tiles, fuuro);
    }

    public List<Tile> getTiles() {
        return tiles;
    }

    public void YakuCalc(){

    }

    public boolean canTsumo() {
        return true;
    }
    public boolean canRyukyoku(){
        return false;
    }

    public void tsumohou() {

    }
}
