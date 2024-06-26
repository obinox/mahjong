package obinox.com.Util;

import obinox.com.Enums.Agaru;
import obinox.com.Enums.Machi;
import obinox.com.Enums.Tile;
import obinox.com.Mentsu.*;

import java.util.*;
import java.util.stream.Collectors;

public class Agari {

    public final Tile agaripai;
    public final List<Mentsu> mentsu;
    public final Machi machi;
    public final boolean menzen;
    public final Agaru agaru;
    public final List<Tile> aka = new ArrayList<>();

    Agari(Tile t, List<Mentsu> mentsu, Machi m, boolean menzen, Agaru a, List<Tile> aka){
        this.agaripai = t;
        this.mentsu = mentsu;
        this.machi = m;
        this.menzen = menzen;
        this.agaru = a;
        this.aka.addAll(aka);
    }

    @Override
    public String toString() {
        return machi.name()+" "+agaripai.name()+" "+agaru.name()+" "+mentsu.toString()+" "+aka+" "+menzen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agari agari = (Agari) o;
        List<Mentsu> m1 = new ArrayList<>(List.copyOf(mentsu));
        List<Mentsu> m2 = new ArrayList<>(List.copyOf(agari.mentsu));
        Collections.sort(m1);
        Collections.sort(m2);
        return menzen == agari.menzen && agaripai == agari.agaripai && Objects.deepEquals(m1, m2) && machi == agari.machi && agaru == agari.agaru;
    }

    @Override
    public int hashCode() {
        return Objects.hash(agaripai, mentsu, machi, menzen, agaru);
    }

    @SuppressWarnings("DataFlowIssue")
    public static List<Agari> getAgari(List<Tile> tiles, List<Mentsu> naki, Tile agaruTile, Agaru agaru){
        List<Tile> fuuro = new ArrayList<>();
        boolean menzen = true;
        for (Mentsu m: naki){
            menzen = menzen && m.tsu.menzen;
        }

        for (Mentsu m: naki){
            fuuro.addAll(List.of(m.tiles));
        }

        List<Tenpai> tenpai = Tenpai.getTenpai(tiles, fuuro);
        if (tenpai.isEmpty()){
            return new ArrayList<>();
        }

        List<Tile> naTiles = new ArrayList<>();
        List<Tile> aka = new ArrayList<>();
        if (Tile.of(agaruTile, 0) != agaruTile){
            aka.add(Tile.aka(agaruTile));
        }
        for (Tile t: tiles){
            if (Tile.of(t, 0) != t){
                aka.add(Tile.aka(t));
            }
            naTiles.add(Tile.of(t, 0));
        }

        List<Tenpai> machi = new ArrayList<>();
        for (Tenpai t: tenpai){
            if (t.getKey() == agaruTile){
                machi.add(t);
            }
        }
        if (machi.isEmpty()){
            return new ArrayList<>();
        }

        Stack<Triplet<List<Tile>, List<Mentsu>, Machi>> stack = new Stack<>();
        Triplet<List<Tile>, List<Mentsu>, Machi> target;
        Triplet<List<Tile>, List<Mentsu>, Machi> sub;
        EnumMap<Tile, Integer> count;
        List<Tile> subTile;
        List<Mentsu> subMentsu;
        int length;
        int type;
        boolean hasToitsu = true;

        //Output
        List<Agari> out = new ArrayList<>();
        List<List<Mentsu>> wait;

        for (Tenpai t: machi){
            Tile at = t.getKey();
            subTile = new ArrayList<>(List.copyOf(naTiles));
            subMentsu = new ArrayList<>(naki);
            switch (t.getValue()){
                case RYML -> {
                    hasToitsu = false;
                    Tile t0 = Tile.of(at, 0);
                    Tile t1 = Tile.of(at, 1);
                    Tile t2 = Tile.of(at, 2);

                    subTile.remove(t1);
                    subTile.remove(t2);
                    subMentsu.add(new Shuntsu(new Tile[]{t0, t1, t2}, agaru));
                    stack.push(new Triplet<>(subTile, subMentsu, Machi.RYML));
                }
                case RYMH -> {
                    hasToitsu = false;
                    Tile t0 = Tile.of(at, 0);
                    Tile t1 = Tile.of(at, -1);
                    Tile t2 = Tile.of(at, -2);

                    subTile.remove(t1);
                    subTile.remove(t2);
                    subMentsu.add(new Shuntsu(new Tile[]{t2, t1, t0}, agaru));
                    stack.push(new Triplet<>(subTile, subMentsu, Machi.RYMH));
                }
                case PEN3 -> {
                    hasToitsu = false;
                    Tile t0 = Tile.of(at, 0);
                    Tile t1 = Tile.of(at, -1);
                    Tile t2 = Tile.of(at, -2);

                    subTile.remove(t1);
                    subTile.remove(t2);
                    subMentsu.add(new Shuntsu(new Tile[]{t2, t1, t0}, agaru));
                    stack.push(new Triplet<>(subTile, subMentsu, Machi.PEN3));
                }
                case PEN7 -> {
                    hasToitsu = false;
                    Tile t0 = Tile.of(at, 0);
                    Tile t1 = Tile.of(at, 1);
                    Tile t2 = Tile.of(at, 2);

                    subTile.remove(t1);
                    subTile.remove(t2);
                    subMentsu.add(new Shuntsu(new Tile[]{t0, t1, t2}, agaru));
                    stack.push(new Triplet<>(subTile, subMentsu, Machi.PEN7));
                }
                case KAN -> {
                    hasToitsu = false;
                    Tile t0 = Tile.of(at, 0);
                    Tile t1 = Tile.of(at, 1);
                    Tile t2 = Tile.of(at, -1);

                    subTile.remove(t1);
                    subTile.remove(t2);
                    subMentsu.add(new Shuntsu(new Tile[]{t2, t0, t1}, agaru));
                    stack.push(new Triplet<>(subTile, subMentsu, Machi.KAN));
                }
                case SHP -> {
                    hasToitsu = false;
                    Tile t0 = Tile.of(at, 0);

                    subTile.remove(t0);
                    subTile.remove(t0);
                    subMentsu.add(new Koutsu(new Tile[]{t0, t0, t0}, agaru));
                    stack.push(new Triplet<>(subTile, subMentsu, Machi.SHP));
                }
                case TAN -> {
                    hasToitsu = true;
                    Tile t0 = Tile.of(at, 0);

                    subTile.remove(t0);
                    subMentsu.add(new Toitsu(new Tile[]{t0, t0}, agaru));
                    stack.push(new Triplet<>(subTile, subMentsu, Machi.TAN));
                }
                case CHI -> {
                    List<Tile> chiitoi = subTile.stream().distinct().toList();
                    for (Tile c: chiitoi){
                        subMentsu.add(new Toitsu(new Tile[]{c, c}, agaru));
                    }
                    out.add(new Agari(agaruTile, subMentsu, Machi.CHI, true, agaru, aka));
                }
                case KMU -> {
                    subTile.add(agaruTile);
                    Tile[] subArray = new Tile[14];
                    for (int i=0;i<14;i++){
                        subArray[i] = subTile.get(i);
                    }
                    subMentsu.add(new Kokushi(subArray));
                    out.add(new Agari(agaruTile, subMentsu, Machi.KMU, true, agaru, aka));
                }
                case KMU13 -> {
                    subTile.add(agaruTile);
                    Tile[] subArray = new Tile[14];
                    for (int i=0;i<14;i++){
                        subArray[i] = subTile.get(i);
                    }
                    subMentsu.add(new Kokushi(subArray));
                    out.add(new Agari(agaruTile, subMentsu, Machi.KMU13, true, agaru, aka));
                }
            }
            if (!hasToitsu){
                count = new EnumMap<>(Tile.class);
                sub = stack.pop();
                for (Tile s: sub.getValue1()){
                    count.merge(s, 1, (v, p) -> v+1);
                }
                for (Tile s: count.keySet()){
                    if (count.get(s)>=2){
                        subTile = new ArrayList<>(List.copyOf(sub.getValue1()));
                        subMentsu = new ArrayList<>(List.copyOf(sub.getValue2()));
                        subTile.remove(s);
                        subTile.remove(s);
                        subMentsu.add(new Toitsu(new Tile[]{s, s}));
                        stack.push(new Triplet<>(subTile, subMentsu, sub.getValue3()));
                    }
                }
            }
        }
        while (!stack.isEmpty()){
            target = stack.pop();
            length = target.getValue1().size();
            if (length == 0){
                Collections.sort(target.getValue2());
                out.add(new Agari(agaruTile, target.getValue2(), target.getValue3(), menzen, agaru, aka));
            } else {
                for (int i=0; i<length-2; i++){
                    if (target.getValue1().contains(Tile.of(target.getValue1().get(i), 1)) && target.getValue1().contains(Tile.of(target.getValue1().get(i), 2))){
                        Tile at = target.getValue1().get(i);
                        subTile = new ArrayList<>(List.copyOf(target.getValue1()));
                        subMentsu = new ArrayList<>(List.copyOf(target.getValue2()));
                        subTile.remove(Tile.of(at, 0));
                        subTile.remove(Tile.of(at, 1));
                        subTile.remove(Tile.of(at, 2));
                        subMentsu.add(new Shuntsu(new Tile[]{Tile.of(at, 0), Tile.of(at, 1), Tile.of(at, 2)}));
                        stack.push(new Triplet<>(subTile, subMentsu, target.getValue3()));
                    }
                }
                for (int i=0; i<length-2; i++){
                    if (Collections.frequency(target.getValue1(), target.getValue1().get(i))>=3){
                        Tile at = target.getValue1().get(i);
                        subTile = new ArrayList<>(List.copyOf(target.getValue1()));
                        subMentsu = new ArrayList<>(List.copyOf(target.getValue2()));
                        subTile.remove(Tile.of(at, 0));
                        subTile.remove(Tile.of(at, 0));
                        subTile.remove(Tile.of(at, 0));
                        subMentsu.add(new Koutsu(new Tile[]{Tile.of(at, 0), Tile.of(at, 0), Tile.of(at, 0)}));
                        i+=2;
                        stack.push(new Triplet<>(subTile, subMentsu, target.getValue3()));
                    }
                }
            }

        }
        out = out.stream().distinct().collect(Collectors.toList());
        return out;
    }
}
