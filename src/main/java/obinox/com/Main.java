package obinox.com;

import obinox.com.Enums.IteratorGroup;
import obinox.com.Enums.Machi;
import obinox.com.Enums.Tile;
import obinox.com.Util.Tenpai;
import java.util.*;
import java.util.stream.Collectors;

/**
 * {@summary Java Mahjong Server for obinox}
 * @author obinox
 *
 */
public class Main {

    public static void main(String[] args) {
        Tile[] tiles = new Tile[]{
                Tile.MAN1, Tile.MAN1, Tile.MAN1,
                Tile.MAN2, Tile.MAN3, Tile.MAN4,
                Tile.MAN5, Tile.MAN6, Tile.MAN7,
                Tile.MAN8, Tile.MAN9, Tile.MAN9, Tile.MAN9,};
        System.out.println(mentsuTest(Arrays.asList(tiles)).toString());


//        game();

    }

    private static List<Tenpai> mentsuTest(List<Tile> tiles) {
        Collections.sort(tiles);
        EnumMap<Tile, Integer> count = new EnumMap<>(Tile.class);
        List<Tenpai> out = new ArrayList<>();

        //recursion stack
        Stack<List<Tile>> stack = new Stack<>();
        List<Tile> target;
        int length;

        List<List<Tile>> groups = new ArrayList<>();
        for (Tile t: tiles){
            int c = count.getOrDefault(t, 0);
            if (c == 0){
                count.put(t, 0);
            }
            count.replace(t, c+1);
        }
        stack.add(tiles); // insert list by group(4)
        while (!stack.isEmpty()){
            target = stack.pop();
            length = target.size();
            switch(length){
                case 0 -> {
                    out.add(new Tenpai(Tile.NULL, Machi.NOM));
                }
                case 1 -> {
                    if (!(count.get(target.get(0))>3)){
                        out.add(new Tenpai(target.get(0), Machi.TAN));
                    }
                }
                case 2 -> {
                    if (target.get(0).group == target.get(1).group){
                        if (target.get(0).value == target.get(1).value){
                            Tile t = Tile.of(target.get(0), 0);
                            if (!(count.get(t)>3)){
                                out.add(new Tenpai(t, Machi.SHP));
                            }
                        } else if (!IteratorGroup.isIn(IteratorGroup.JIHAI, tiles.get(0))){
                            if (Tile.sequence(target.get(0), target.get(1))) {
                                Tile t1 = Tile.of(target.get(0), -1);
                                if (t1 != Tile.NULL && !(count.get(t1)>3)){
                                    if (t1.value == 7){
                                        out.add(new Tenpai(t1, Machi.PEN));
                                    } else {
                                        out.add(new Tenpai(t1, Machi.RYM));
                                    }
                                }
                                Tile t2 = Tile.of(target.get(0), 2);
                                if (t2 != Tile.NULL && !(count.get(t2)>3)){
                                    if (t2.value == 3){
                                        out.add(new Tenpai(t2, Machi.PEN));
                                    } else {
                                        out.add(new Tenpai(t2, Machi.RYM));
                                    }
                                }
                            } else if (Tile.sequence(target.get(0), target.get(1), 2)) {
                                Tile t = Tile.of(target.get(0), 1);
                                if (t != Tile.NULL && !(count.get(t) > 3)){
                                    out.add(new Tenpai(t, Machi.KAN));
                                }
                            }
                        }
                    }
                }
                case 4 -> {
                    if (IteratorGroup.isAllIn(target.get(0).group, target)){
                        for (int i=0; i<3; i++) {
                            List<Tile> sub;
                            Tile rm;
                            if (Tile.equal(target.get(i), target.get(i+1)) && !(count.get(target.get(i))>3)){
                                sub = new ArrayList<>(List.copyOf(target));
                                rm = sub.remove(i);
                                rm = sub.remove(i);
                                stack.push(sub);
                            }
                        }
                        List<Tile> sub;
                        boolean rb;
                        if (target.contains(Tile.of(target.get(0), 1)) && target.contains(Tile.of(target.get(0), 2))){
                            sub = new ArrayList<>(List.copyOf(target));
                            rb = sub.remove(Tile.of(target.get(0), 0));
                            rb = sub.remove(Tile.of(target.get(0), 1));
                            rb = sub.remove(Tile.of(target.get(0), 2));
                            stack.push(sub);
                        }
                        Tile rm;
                        if (Collections.frequency(target, target.get(0))>=3){
                            sub = new ArrayList<>(List.copyOf(target));
                            rm = sub.remove(0);
                            rm = sub.remove(0);
                            rm = sub.remove(0);
                            stack.push(sub);
                        }
                    }
                }
                default -> {
                    for (int i=0; i<length-2; i++){
                        List<Tile> sub;
                        boolean rb;
                        if (target.contains(Tile.of(target.get(i), 1)) && target.contains(Tile.of(target.get(i), 2))){
                            sub = new ArrayList<>(List.copyOf(target));
                            rb = sub.remove(Tile.of(target.get(i), 0));
                            rb = sub.remove(Tile.of(target.get(i), 1));
                            rb = sub.remove(Tile.of(target.get(i), 2));
                            stack.push(sub);
                        }
                    }
                    for (int i=0; i<length-2; i++){
                        List<Tile> sub;
                        Tile rm;
                        if (Collections.frequency(target, target.get(i))>=3){
                            sub = new ArrayList<>(List.copyOf(target));
                            rm = sub.remove(i);
                            rm = sub.remove(i);
                            rm = sub.remove(i);
                            i+=2;
                            stack.push(sub);
                        }
                    }
                }
            }
        }
        out = out.stream().distinct().collect(Collectors.toList());
        Collections.sort(out);
        return out;
    }

    static void game(){
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
        System.out.println(yama.haiYama);

        // Oya tsumo
        int turn = 0;
        // Start game
        while (true||!yama.isYamaEnd()){
            try {
                hands[turn].tsumo(yama);
                hands[turn].suteru(0);
            } catch (MahjongException e) {
                System.out.println(e.getMessage());
            }
            scn.next();
            turn=(turn+1)%4;
        }
    }
    static void test1(){
        EnumMap<Tile, Machi> em;
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
                h.setKyoku(tiles, Tile.EAST, Tile.EAST);
            } catch (MahjongException ignored) {
            }
            em = h.isTenpai();
        } while(em.isEmpty());
        EnumMap<Tile, Integer> allTileMap = new EnumMap<>(Tile.class);
        System.out.println();
    }
}
