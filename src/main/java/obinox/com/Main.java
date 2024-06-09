package obinox.com;

import obinox.com.Enums.Agaru;
import obinox.com.Enums.IteratorGroup;
import obinox.com.Enums.Machi;
import obinox.com.Enums.Tile;
import obinox.com.Mentsu.Mentsu;
import obinox.com.Mentsu.Shuntsu;
import obinox.com.Util.Agari;
import obinox.com.Util.Tenpai;
import java.util.*;
import java.util.stream.Collectors;

import static obinox.com.Enums.Yaku.getYaku;
import static obinox.com.Util.Tenpai.getTenpai;

/**
 * {@summary Java Mahjong Server for obinox}
 * @author obinox
 *
 */
public class Main {

    public static void main(String[] args) {
//        Tile[] tiles = new Tile[]{
//                Tile.SOU9,Tile.SOU9,Tile.SOU9,
//                Tile.EAST,
//                Tile.SOUTH,Tile.SOUTH,Tile.SOUTH,
//                Tile.RED,Tile.RED,Tile.RED,
//                Tile.NORTH,Tile.NORTH,Tile.NORTH,
//        };
//        Tile[] tiles = new Tile[]{
//                Tile.SOU9,Tile.SOU9,
//                Tile.EAST,
//                Tile.SOUTH,Tile.SOUTH,
//                Tile.RED,Tile.RED,
//                Tile.NORTH,Tile.NORTH,
//                Tile.WHITE,Tile.WHITE,
//                Tile.GREEN,Tile.GREEN,
//        };
//        Tile[] tiles = new Tile[]{
//                Tile.MAN2, Tile.MAN2,
//                Tile.MAN3, Tile.MAN3,
//                Tile.MAN4, Tile.MAN4,
//                Tile.MAN5,
//                Tile.MAN6, Tile.MAN7, Tile.MAN8,
//                Tile.MAN6, Tile.MAN7, Tile.MAN8,
//        };
        Tile[] tiles = new Tile[]{
                Tile.MAN1, Tile.MAN2,
                Tile.MAN1, Tile.MAN3,
                Tile.MAN1, Tile.MAN4,
                Tile.MAN5,
                Tile.MAN9, Tile.MAN6,
                Tile.MAN9, Tile.MAN7,
                Tile.MAN9, Tile.MAN8,
        };
//        Tile[] tiles = new Tile[]{
//                Tile.MAN1, Tile.MAN2,
//                Tile.MAN3, Tile.MAN4,
//                Tile.MAN5, Tile.MAN4,
//                Tile.MAN0,
//                Tile.MAN7, Tile.MAN7,
//                Tile.MAN8, Tile.MAN9,
//                Tile.MAN9, Tile.MAN8,
//        };
//        Tile[] tiles = new Tile[]{
//                Tile.MAN1, Tile.MAN1,
//                Tile.MAN3, Tile.MAN3,
//                Tile.MAN7, Tile.MAN7,
//                Tile.MAN0,
//                Tile.MAN9, Tile.MAN9,
//                Tile.PIN1, Tile.PIN1,
//                Tile.MAN2, Tile.MAN2,
//        };
//        Tile[] tiles = new Tile[]{
//                Tile.MAN3, Tile.MAN3,
//                Tile.MAN4, Tile.MAN4,
//                Tile.MAN6, Tile.MAN6, Tile.MAN6,
//                Tile.PIN6, Tile.PIN6, Tile.PIN6,
//                Tile.SOU6, Tile.SOU6, Tile.SOU6,
//        };
//        Tile[] tiles = new Tile[]{
//                Tile.WHITE, Tile.WHITE, Tile.WHITE,
//                Tile.GREEN, Tile.GREEN, Tile.GREEN,
//                Tile.RED, Tile.RED, Tile.RED,
//                Tile.SOU5, Tile.SOU4, Tile.SOU6,
//                Tile.SOU5,
//        };
//        Tile[] tiles = new Tile[]{
//                Tile.SOU1,Tile.SOU2,Tile.SOU3,Tile.SOUTH,
//                Tile.SOU1,Tile.SOU2,Tile.SOU3,Tile.SOUTH,
//                Tile.SOU1,Tile.SOU2,Tile.SOU3,
//                Tile.SOU1,Tile.SOU2,
//        };
//        System.out.println(getTenpai(Arrays.asList(tiles)).toString());
////        List<Mentsu> f = new ArrayList<>();
////        Mentsu m = new Shuntsu(new Tile[]{Tile.MAN6, Tile.MAN7, Tile.MAN8});
////        f.add(m);
//        List<Agari> a = Agari.getAgari(Arrays.asList(tiles), new ArrayList<>(), Tile.MAN0, Agaru.TSUMO);
//        System.out.println(a);
//        System.out.println(getYaku(a.get(0), Tile.EAST, Tile.EAST));

        game();

    }



    static void game(){
        Tile ba = Tile.EAST;
        int kyoku = 0;
        int honba = 0;
        int[] jun = {0,0,0,0};

        Scanner scn = new Scanner(System.in);

        //East-ba 1-kyoku 0-honba
        Yama yama = new Yama();
        Hand[] hands = new Hand[]{new Hand(), new Hand(), new Hand(), new Hand()};

        Tile[][] haipais = new Tile[][]{new Tile[13], new Tile[13], new Tile[13], new Tile[13]};
        for (int k=0;k<3;k++){
            for (int h=0;h<4;h++){
                for (int i=k*4;i<k*4+4;i++){
                    haipais[h][i] = yama.tsumo();
                }
            }
        }
        for (int h=0;h<4;h++){
            haipais[h][12] = yama.tsumo();
        }

        try {
            for (int h=0;h<4;h++){
                hands[h].setKyoku(List.of(haipais[h]), ba, Tile.of(Tile.EAST.ordinal()+h));
            }
        } catch (MahjongException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(yama.haiYama);

        // Oya tsumo
        int turn = 0;
        Tile giri;
        // Start game
        while (true||!yama.isYamaEnd()){
            try {
                System.out.println(hands[turn]);
                hands[turn].tsumo(yama);
                giri = hands[turn].suteru(scn.nextInt());
                System.out.println(hands[turn]);

            } catch (MahjongException e) {
                System.out.println(e.getMessage());
            }
//            scn.next();
            turn=(turn+1)%4;
        }
    }
    static void test1(){
        List<Tenpai> em;
        do{
            Hand h = new Hand();
//            Tile[] tiles = new Tile[]{Tile.WEST, Tile.WEST, Tile.WEST, Tile.WEST, Tile.EAST, Tile.EAST,
//                    Tile.MAN0, Tile.MAN0, Tile.MAN0, Tile.MAN0,
//                    Tile.SOU0, Tile.SOU0, Tile.SOU0};
            Tile[] tiles = new Tile[13];
            Yama yama = new Yama();
            for (int i=0;i<13;i++){
                tiles[i] = yama.tsumo();
            }
            Arrays.sort(tiles);
            try {
                h.setKyoku(List.of(tiles), Tile.EAST, Tile.EAST);
            } catch (MahjongException ignored) {
            }
            em = h.getTenpai();
        } while(em.isEmpty());
        EnumMap<Tile, Integer> allTileMap = new EnumMap<>(Tile.class);
        System.out.println();
    }
}
