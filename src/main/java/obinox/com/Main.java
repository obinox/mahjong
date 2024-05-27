package obinox.com;

import obinox.com.Enums.Tile;
import obinox.com.Mentsu.Mentsu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * {@summary Java Mahjong Server for obinox}
 * @author obinox
 *
 */
public class Main {

    public static void main(String[] args) {
        Tile ba = Tile.EAST;
        int kyoku = 0;
        int honba = 0;
        int jun = 1;

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
                hands[h].setKyoku(haipais[h], ba, Tile.of(Tile.EAST.ordinal()+h));
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
