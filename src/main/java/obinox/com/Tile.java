package obinox.com;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Tile {

    //ManZu
    MAN1(1, Group.MAN, "1m",  4),
    MAN2(2, Group.MAN, "2m",  4),
    MAN3(3, Group.MAN, "3m",  4),
    MAN4(4, Group.MAN, "4m",  4),
    MAN0(5, Group.MAN, "0m",  1),
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
    PIN0(5, Group.PIN, "0p",  1),
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
    SOU0(5, Group.SOU, "0s",  1),
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

    ;

    public final int value;
    public final Group group;
    public final String str;
    public final int count;

    Tile(int value, Group group, String str, int count){
        this.value = value;
        this.group = group;
        this.str = str;
        this.count = count;
    }
    public final String getStr(){
        return this.str;
    }

    public static boolean equal(Tile t1, Tile t2){
        return t1.group == t2.group && t1.value == t2.value;
    }
    public static boolean equal(Tile... ts){
        boolean b = true;
        for (Tile t: ts){
            b = b && ts[0].group == t.group && ts[0].value == t.value;
        }
        return b;
    }
    public static boolean sequence(Tile t1, Tile t2){
        return t1.group == t2.group && t1.value == t2.value+1;
    }
    public static boolean sequence(Tile... ts){
        boolean b = true;
        int d = 0;
        for (Tile t: ts){
            b = b && ts[0].group == t.group && ts[0].value+d == t.value;
            d++;
        }
        return b;
    }

    private static final Map<String, Tile> strFinder = Collections.unmodifiableMap(Stream.of(values()).collect(Collectors.toMap(Tile::getStr, e->e)));
    public static Tile of(String str){
        return strFinder.get(str);
    }

    public static List<Tile> getDora(Tile t){
        return Arrays.stream(values()).filter(p -> (t.value%t.group.count)+1 == p.value && t.group == p.group).toList();
    }
}

