package obinox.com;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * {@summary Java Mahjong Server for obinox}
 * @author obinox
 *
 */
public class Main {
    public static void main(String[] args) {

        List<Tile> tiles = new ArrayList<>(136);
        for (Tile t: Tile.values()){
            for (int i = 0; i<(t.value==5?(t.aka?1:3):4); i++){
                tiles.add(t);
            }
        }
        Collections.shuffle(tiles);

        System.out.println(tiles);

        StringBuilder yamaCode = new StringBuilder();
        for (Tile t: tiles){
            yamaCode.append(t.str);
        }
        System.out.println(yamaCode);

        List<Tile> rinshanhai;
        List<Tile> dorahyoujihai;
        List<Tile> uradorahyoujihai;
        List<Tile> dorapai;
        List<Tile> haiyama;

        rinshanhai = tiles.subList(0,4);
        dorahyoujihai = tiles.subList(4,9);
        uradorahyoujihai = tiles.subList(9,14);
        dorapai = new ArrayList<>(Tile.getDora(dorahyoujihai.get(0)));
        haiyama = tiles.subList(14,136);

        System.out.println(rinshanhai);
        System.out.println(dorahyoujihai);
        System.out.println(dorapai);
        System.out.println(haiyama);

        //hand Tile[13] + tsumo

    }
}
