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

        StringBuilder wallCode = new StringBuilder();
        for (Tile t: tiles){
            wallCode.append(t.str);
        }
        System.out.println(wallCode);

        List<Tile> rinshanTiles;
        List<Tile> doraIndicators;
        List<Tile> uradoraIndicators;
        List<Tile> doraTiles;
        List<Tile> liveWall;

        rinshanTiles = tiles.subList(0,4);
        doraIndicators = tiles.subList(4,9);
        uradoraIndicators = tiles.subList(9,14);
        doraTiles = new ArrayList<>(Tile.getDora(doraIndicators.get(0)));
        liveWall = tiles.subList(14,136);

        System.out.println(rinshanTiles);
        System.out.println(doraIndicators);
        System.out.println(doraTiles);
        System.out.println(liveWall);

        //hand Tile[13] + tsumo

    }
}
