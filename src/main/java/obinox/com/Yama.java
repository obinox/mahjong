package obinox.com;

import obinox.com.Enums.Tile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Yama {
    //Wanpai
    public final List<Tile> rinshanpai = new ArrayList<>(4);
    public final List<Tile> dorahyoujihai = new ArrayList<>(5);
    public final List<Tile> uradorahyoujihai = new ArrayList<>(5);

    //Dora
    public final List<Tile> dorapai = new ArrayList<>(15);

    //Haiyama
    public final List<Tile> haiYama =  new ArrayList<>(122);
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

        this.rinshanpai.addAll(tiles.subList(0,4));
        for (int i=4;i<14;i+=2){
            this.dorahyoujihai.add(tiles.get(i));
            this.uradorahyoujihai.add(tiles.get(i+1));
        }

        this.dorapai.addAll(Tile.getDora(dorahyoujihai.get(this.haiteiIdx)));

        this.haiYama.addAll(tiles.subList(14,136));

        System.out.println(rinshanpai);
        System.out.println(dorahyoujihai);
        System.out.println(dorapai);
        System.out.println(haiYama);
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

        this.rinshanpai.addAll(tiles.subList(0,4));
        for (int i=4;i<14;i+=2){
            this.dorahyoujihai.add(tiles.get(i));
            this.uradorahyoujihai.add(tiles.get(i+1));
        }

        this.dorapai.addAll(Tile.getDora(dorahyoujihai.get(this.haiteiIdx)));

        this.haiYama.addAll(tiles.subList(14,136));

        System.out.println(rinshanpai);
        System.out.println(dorahyoujihai);
        System.out.println(dorapai);
        System.out.println(haiYama);
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
        return this.haiYama.remove(i-1);
    }

    public final Tile Rinshan(){
        this.haiteiIdx++;
        return this.rinshanpai.remove(0);
    }
}
