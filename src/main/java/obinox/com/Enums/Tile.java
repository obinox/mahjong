package obinox.com.Enums;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Tile {
    //Padding
    PAD(0, Group.NULL, "pd", 0),

    //ManZu
    MAN1(1, Group.MAN, "1m",  4),
    MAN2(2, Group.MAN, "2m",  4),
    MAN3(3, Group.MAN, "3m",  4),
    MAN4(4, Group.MAN, "4m",  4),
    MAN5(5, Group.MAN, "5m",  3),
    MAN6(6, Group.MAN, "6m",  4),
    MAN7(7, Group.MAN, "7m",  4),
    MAN8(8, Group.MAN, "8m",  4),
    MAN9(9, Group.MAN, "9m",  4),

    //PinZu
    PIN1(1, Group.PIN, "1p",  4),
    PIN2(2, Group.PIN, "2p",  4),
    PIN3(3, Group.PIN, "3p",  4),
    PIN4(4, Group.PIN, "4p",  4),
    PIN5(5, Group.PIN, "5p",  3),
    PIN6(6, Group.PIN, "6p",  4),
    PIN7(7, Group.PIN, "7p",  4),
    PIN8(8, Group.PIN, "8p",  4),
    PIN9(9, Group.PIN, "9p",  4),

    //SouZu
    SOU1(1, Group.SOU, "1s",  4),
    SOU2(2, Group.SOU, "2s",  4),
    SOU3(3, Group.SOU, "3s",  4),
    SOU4(4, Group.SOU, "4s",  4),
    SOU5(5, Group.SOU, "5s",  3),
    SOU6(6, Group.SOU, "6s",  4),
    SOU7(7, Group.SOU, "7s",  4),
    SOU8(8, Group.SOU, "8s",  4),
    SOU9(9, Group.SOU, "9s",  4),

    //KazeHai
    EAST(1, Group.KAZE, "1z", 4),
    SOUTH(2, Group.KAZE, "2z", 4),
    WEST(3, Group.KAZE, "3z", 4),
    NORTH(4, Group.KAZE, "4z", 4),

    //SangenPai
    WHITE(1, Group.SANGEN, "5z", 4),
    GREEN(2, Group.SANGEN, "6z", 4),
    RED(3, Group.SANGEN, "7z", 4),

    //AkaDora
    MAN0(5, Group.MAN, "0m",  1),
    PIN0(5, Group.PIN, "0p",  1),
    SOU0(5, Group.SOU, "0s",  1),

    //Null
    NULL(0, Group.NULL, "nl", 0),

    ;

    public final int value;
    public final Group group;
    public final String str;
    public final int count;

    Tile(int v, Group g, String s, int c){
        this.value = v;
        this.group = g;
        this.str = s;
        this.count = c;
    }
    public final String getStr(){
        return this.str;
    }
    public final int getInt() { return this.ordinal(); }

    public static boolean equal(Tile t1, Tile t2){
        return t1.group == t2.group && t1.value == t2.value;
    }
    public static boolean equal(Tile[] ts, Tile ti){
        boolean b = true;
        for (Tile t: ts){
            b = b && ti.group == t.group && ti.value == t.value;
        }
        return b;
    }
    public static boolean equal(Tile... ts){
        boolean b = true;
        for (Tile t: ts){
            b = b && ts[0].group == t.group && ts[0].value == t.value;
        }
        return b;
    }
    public static boolean sequence(Tile t1, Tile t2){
        return t1.group == t2.group && t1.value+1 == t2.value;
    }
    public static boolean sequence(Tile t1, Tile t2, int j){
        return t1.group == t2.group && t1.value+j == t2.value;
    }
    public static boolean sequence(Tile[] ts){
        boolean b = true;
        int d = 0;
        for (Tile t: ts){
            b = b && ts[0].group == t.group && ts[0].value+d == t.value;
            d++;
        }
        return b;
    }
    public static boolean sequence(Tile[] ts, int j){
        boolean b = true;
        int d = 0;
        for (Tile t: ts){
            b = b && ts[0].group == t.group && ts[0].value+d*j == t.value;
            d++;
        }
        return b;
    }

    private static final Map<String, Tile> strFinder = Collections.unmodifiableMap(Stream.of(values()).collect(Collectors.toMap(Tile::getStr, e->e)));
    private static final Map<Integer, Tile> intFinder = Collections.unmodifiableMap(Stream.of(values()).collect(Collectors.toMap(Tile::getInt, e->e)));
    public static Tile of(String str){
        return strFinder.get(str);
    }
    public static Tile of(int i){
        return intFinder.get(i);
    }
    public static Tile of(Group g, int v){
        return intFinder.get(g.index+v);
    }
    public static Tile of(Tile t, int s){
        Tile r = intFinder.get(t.ordinal()+s);
        if (r.group == t.group){
            return r;
        } else {
            return NULL;
        }
    }

    public static List<Tile> getDora(Tile t){
        return Arrays.stream(values()).filter(p -> (t.value%t.group.count)+1 == p.value && t.group == p.group).toList();
    }
}

