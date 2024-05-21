package obinox.com;

import java.util.Scanner;

/**
 * {@summary Java Mahjong Server for obinox}
 * @author obinox
 *
 */
public class Main {
    public final int ba = 0;
    public final int kyoku = 0;
    public final int honba = 0;
    public final int jun = 1;
    public static void main(String[] args) {

        Mentsu.mentsu m1 = Mentsu.tiles(new Tile[]{Tile.PIN8, Tile.PIN8, Tile.PIN8});
        System.out.println(m1);
        System.out.println(m1.getClass());


        Mentsu.mentsu m2 = Mentsu.tiles(new Tile[]{Tile.PIN7, Tile.PIN8, Tile.PIN9});
        System.out.println(m2);
        System.out.println(m2.getClass());

        Mentsu.mentsu m3 = Mentsu.tiles(new Tile[]{Tile.EAST, Tile.SOUTH, Tile.WEST});
        System.out.println(m3);
        System.out.println(m3.getClass());

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
                hands[h].setKyoku(haipais[h], h);
            }
        } catch (MahjongException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(yama.HAIYAMA);

        // Oya tsumo
        int turn = 0;

        // Start game
        while (true||!yama.isYamaEnd()){
            try {
                hands[turn].tsumo(yama.tsumo());
                hands[turn].suteru(0);
            } catch (MahjongException e) {
                System.out.println(e.getMessage());
            }
            scn.next();
            turn=(turn+1)%4;
        }

    }
}
