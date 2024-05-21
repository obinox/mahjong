package obinox.com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Yama {
    //Wanpai
    public final List<Tile> RINSHANPAI = new ArrayList<>(4);
    public final List<Tile> DORAHYOUJIHAI = new ArrayList<>(5);
    public final List<Tile> URADORAHYOUJIHAI = new ArrayList<>(5);

    //Dora
    public final List<Tile> DORAPAI = new ArrayList<>(15);

    //Haiyama
    public final List<Tile> HAIYAMA =  new ArrayList<>(122);
    private int haiyamaSize = 122;
    private int haiteiIdx = 0;

    //yamaCode
    public final StringBuilder yamaCode = new StringBuilder();

    Yama(){
        List<Tile> tiles = new ArrayList<>(136);
        for (Tile t: Tile.values()){
            for (int i = 0; i<t.count; i++){
                tiles.add(t);
            }
        }
        Collections.shuffle(tiles);

        System.out.println(tiles);
        for (Tile t: tiles){
            this.yamaCode.append(t.str);
        }
        System.out.println(yamaCode);

        this.RINSHANPAI.addAll(tiles.subList(0,4));
        for (int i=4;i<14;i+=2){
            this.DORAHYOUJIHAI.add(tiles.get(i));
            this.URADORAHYOUJIHAI.add(tiles.get(i+1));
        }

        this.DORAPAI.addAll(Tile.getDora(DORAHYOUJIHAI.get(this.haiteiIdx)));

        this.HAIYAMA.addAll(tiles.subList(14,136));

        System.out.println(RINSHANPAI);
        System.out.println(DORAHYOUJIHAI);
        System.out.println(DORAPAI);
        System.out.println(HAIYAMA);
    }

    Yama(String yamaCode){
        List<Tile> tiles = new ArrayList<>(136);
        for (int i=0; i<136*2; i+=2){
            tiles.add(Tile.of(yamaCode.substring(i,i+2)));
        }
        System.out.println(tiles);
        for (Tile t: tiles){
            this.yamaCode.append(t.str);
        }
//        System.out.println(yamaCode);

        this.RINSHANPAI.addAll(tiles.subList(0,4));
        for (int i=4;i<14;i+=2){
            this.DORAHYOUJIHAI.add(tiles.get(i));
            this.URADORAHYOUJIHAI.add(tiles.get(i+1));
        }

        this.DORAPAI.addAll(Tile.getDora(DORAHYOUJIHAI.get(this.haiteiIdx)));

        this.HAIYAMA.addAll(tiles.subList(14,136));

        System.out.println(RINSHANPAI);
        System.out.println(DORAHYOUJIHAI);
        System.out.println(DORAPAI);
        System.out.println(HAIYAMA);
    }
    @Override
    public String toString() {
        return this.yamaCode.toString();
    }

    public boolean isYamaEnd(){
        return !(this.haiteiIdx<this.haiyamaSize);
    }

    public final Tile tsumo(){
        if (isYamaEnd()){ return null; }
        int i = this.haiyamaSize;
        this.haiyamaSize--;
        System.out.println("remain: "+ haiyamaSize);
        return this.HAIYAMA.remove(i-1);
    }

    public final Tile Rinshan(){
        this.haiteiIdx++;
        return this.RINSHANPAI.remove(0);
    }
}
