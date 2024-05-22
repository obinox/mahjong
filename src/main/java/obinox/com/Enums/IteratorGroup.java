package obinox.com.Enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum IteratorGroup {
    MANTANYAO(new Tile[]{Tile.MAN2, Tile.MAN3, Tile.MAN4, Tile.MAN0, Tile.MAN5, Tile.MAN6, Tile.MAN7, Tile.MAN8}),
    PINTANYAO(new Tile[]{Tile.PIN2, Tile.PIN3, Tile.PIN4, Tile.PIN0, Tile.PIN5, Tile.PIN6, Tile.PIN7, Tile.PIN8}),
    SOUTANYAO(new Tile[]{Tile.SOU2, Tile.SOU3, Tile.SOU4, Tile.SOU0, Tile.SOU5, Tile.SOU6, Tile.SOU7, Tile.SOU8}),
    MANROUTOU(new Tile[]{Tile.MAN1, Tile.MAN9}),
    PINROUTOU(new Tile[]{Tile.PIN1, Tile.PIN9}),
    SOUROUTOU(new Tile[]{Tile.SOU1, Tile.SOU9}),
    MANZU(MANTANYAO, MANROUTOU),
    PINZU(PINTANYAO, PINROUTOU),
    SOUZU(SOUTANYAO, SOUROUTOU),
    KAZEHAI(new Tile[]{Tile.EAST, Tile.SOUTH, Tile.WEST, Tile.NORTH}),
    SANGENPAI(new Tile[]{Tile.WHITE, Tile.GREEN, Tile.RED}),
    SHUUPAI(MANZU, PINZU, SOUZU),
    CHUNCHANPAI(MANTANYAO, PINTANYAO, SOUTANYAO),
    ROUTOUHAI(MANROUTOU, PINROUTOU, SOUROUTOU),
    JIHAI(KAZEHAI, SANGENPAI),
    YAOCHUUHAI(ROUTOUHAI, JIHAI),
    AKAPAI(new Tile[]{Tile.MAN0, Tile.PIN0, Tile.SOU0}),
    MIDORIPAI(new Tile[]{Tile.SOU2, Tile.SOU3, Tile.SOU4, Tile.SOU6, Tile.SOU8, Tile.GREEN}),
    KUROHAI(new Tile[]{Tile.PIN2, Tile.PIN4, Tile.PIN8, Tile.EAST, Tile.SOUTH, Tile.WEST, Tile.NORTH}),

    ;

    public final List<Tile> iterator;

    IteratorGroup(Tile[] iter){
        this.iterator = Arrays.asList(iter);
    }

    IteratorGroup(IteratorGroup... iter){
        this.iterator = new ArrayList<>();
        for (IteratorGroup i: iter){
            this.iterator.addAll(i.iterator);
        }
    }

    public static boolean isIn(IteratorGroup iter, Tile t){
        return iter.iterator.contains(t);
    }
    public static boolean isIn(IteratorGroup iter, Tile[] ts){
        boolean b = true;
        for (Tile t: ts){
            b = b && iter.iterator.contains(t);
        }
        return b;
    }
}
