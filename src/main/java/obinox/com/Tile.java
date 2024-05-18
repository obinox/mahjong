package obinox.com;

import java.util.Arrays;
import java.util.List;

public enum Tile {

    //ManZu
    MAN1(1, Group.MAN, "1m",  false),
    MAN2(2, Group.MAN, "2m",  false),
    MAN3(3, Group.MAN, "3m",  false),
    MAN4(4, Group.MAN, "4m",  false),
    MAN0(5, Group.MAN, "0m",  true),
    MAN5(5, Group.MAN, "5m",  false),
    MAN6(6, Group.MAN, "6m",  false),
    MAN7(7, Group.MAN, "7m",  false),
    MAN8(8, Group.MAN, "8m",  false),
    MAN9(9, Group.MAN, "9m",  false),

    //PinZu
    PIN1(1, Group.PIN, "1p",  false),
    PIN2(2, Group.PIN, "2p",  false),
    PIN3(3, Group.PIN, "3p",  false),
    PIN4(4, Group.PIN, "4p",  false),
    PIN0(5, Group.PIN, "0p",  true),
    PIN5(5, Group.PIN, "5p",  false),
    PIN6(6, Group.PIN, "6p",  false),
    PIN7(7, Group.PIN, "7p",  false),
    PIN8(8, Group.PIN, "8p",  false),
    PIN9(9, Group.PIN, "9p",  false),

    //SouZu
    SOU1(1, Group.SOU, "1s",  false),
    SOU2(2, Group.SOU, "2s",  false),
    SOU3(3, Group.SOU, "3s",  false),
    SOU4(4, Group.SOU, "4s",  false),
    SOU0(5, Group.SOU, "0s",  true),
    SOU5(5, Group.SOU, "5s",  false),
    SOU6(6, Group.SOU, "6s",  false),
    SOU7(7, Group.SOU, "7s",  false),
    SOU8(8, Group.SOU, "8s",  false),
    SOU9(9, Group.SOU, "9s",  false),

    //KazeHai
    EAST(1, Group.KAZEHAI, "Ez", false),
    SOUTH(2, Group.KAZEHAI, "Sz", false),
    WEST(3, Group.KAZEHAI, "Wz", false),
    NORTH(4, Group.KAZEHAI, "Nz", false),

    //SangenPai
    WHITE(1, Group.SANGENPAI, "Hz", false),
    GREEN(2, Group.SANGENPAI, "Gz", false),
    RED(3, Group.SANGENPAI, "Rz", false),

    ;

    public final int value;
    public final Group group;
    public final String str;
    public final boolean aka;

    Tile(int value, Group group, String str, boolean aka){
        this.value = value;
        this.group = group;
        this.str = str;
        this.aka = aka;
    }

    public static List<Tile> getDora(Tile t){
        return Arrays.stream(values()).filter(p -> (t.value%t.group.count)+1 == p.value && t.group == p.group).toList();
    }
}

