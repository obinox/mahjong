package obinox.com;

import obinox.com.Enums.IteratorGroup;
import obinox.com.Enums.Machi;
import obinox.com.Enums.MahjongError;
import obinox.com.Enums.Tile;
import obinox.com.Mentsu.Koutsu;
import obinox.com.Mentsu.Mentsu;
import obinox.com.Mentsu.Taatsu;
import obinox.com.Mentsu.Toitsu;

import java.util.*;

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

    public void tsumo(Yama y) throws MahjongException{
        if (this.tsumohai!=null){
            throw new MahjongException(MahjongError.IS_ALREADY_TSUMO);
        }
        this.tsumohai = y.tsumo();
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

    public EnumMap<Tile, Machi> isTenpai(){
        //2-3-3-3-3
        EnumMap<Tile, Machi> machiTile = new EnumMap<>(Tile.class);
        @SuppressWarnings("unchecked") // just Map warns
        EnumMap<Tile, Integer>[] tileMap = new EnumMap[]{
                new EnumMap<>(Tile.class),
                new EnumMap<>(Tile.class),
                new EnumMap<>(Tile.class),
                new EnumMap<>(Tile.class),
        };
        EnumMap<Tile, Integer> allTileMap = new EnumMap<>(Tile.class);

        int[] tileCount = new int[]{0, 0, 0, 0};
        List<List<Integer>> tileForm = new ArrayList<>(4);
        for (int i=0;i<4;i++){
            tileForm.add(new ArrayList<>(13));
        }
        int groupIdx = 0;
        for (Tile t: this.tiles){
            switch (t.group){
                case SANGEN, KAZE -> groupIdx = 0;
                case MAN -> groupIdx = 1;
                case PIN -> groupIdx = 2;
                case SOU -> groupIdx = 3;
            }
            tileCount[groupIdx]+=1;
            if (!tileMap[groupIdx].containsKey(t)){
                tileMap[groupIdx].put(t, 1);
            } else {
                tileMap[groupIdx].replace(t, tileMap[groupIdx].get(t)+1);
            }
            if (!allTileMap.containsKey(t)){
                allTileMap.put(t, 1);
            } else {
                allTileMap.replace(t, allTileMap.get(t)+1);
            }
            tileForm.get(groupIdx).add(t.value);
        }

        for (int i = 0; i<4; i++){
            System.out.println(tileMap[i] + " " +  tileForm.get(i) + " " + tileMap[i].size() + " " + tileCount[i]);
        }

        // Check form of each group.
        int[] countForm = new int[]{tileCount[0]%3, tileCount[1]%3, tileCount[2]%3, tileCount[3]%3};
        Arrays.sort(countForm);
        int handType;

        System.out.println(Arrays.toString(countForm));
        System.out.println(Arrays.equals(countForm, new int[]{0, 0, 2, 2}) || Arrays.equals(countForm, new int[]{0, 0, 0, 1}));
        System.out.println(tileMap[0].size() == (tileCount[0]+2)/3);

        if (Arrays.equals(countForm, new int[]{0, 0, 0, 1})){
            handType = 1;
        } else if (Arrays.equals(countForm, new int[]{0, 0, 2, 2})){
            handType = 2;
        } else {
            return machiTile;
        }


        // Check jihai form. Each Tiles can not be more than 3 (t<=3).

        if (!(tileMap[0].size() == (tileCount[0]+2)/3)){
            return machiTile;
        }
        for (int i: tileMap[0].values()){
            if (i>3){
                return machiTile;
            }
        }

        // 1 or 4 form. 4 can be 1/3 or 2/2

        int[] countMod3 = new int[]{tileCount[0]%3, tileCount[1]%3, tileCount[2]%3, tileCount[3]%3};
        int[] formIdxs = new int[2];
        if (handType==1){
            for (int i=0;i<4;i++){
                if (tileCount[i]%3==1&&tileCount[i]!=1){
                    countMod3[i] = 4;
                    handType = 4;
                }
            }
        }

        for (int i=1;i<4;i++){

        }



        System.out.println(Arrays.toString(countMod3));
        System.out.println(handType);





        // Check each shuupai form

        //2-2-2-2-2-2-2
        //Kokushi Musou
        machiTile.put(Tile.NULL, Machi.NOM);

        return machiTile;
    }
    //TODO machi tiles
    public void YakuCalc(){

    }
}
