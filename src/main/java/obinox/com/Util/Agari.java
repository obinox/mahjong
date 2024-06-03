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

    Agari(Tile t, List<Mentsu> mentsu, Machi m, boolean menzen, Agaru a){
        this.agaripai = t;
        this.mentsu = mentsu;
        this.machi = m;
        this.menzen = menzen;
        this.agaru = a;
    }

    @Override
    public String toString() {
        return machi.name()+" "+agaripai.name()+" "+agaru.name()+" "+mentsu.toString()+" "+menzen;
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
        boolean menzen = naki.isEmpty();

        for (Mentsu m: naki){
            fuuro.addAll(List.of(m.mentsu));
        }

        List<Tenpai> tenpai = Tenpai.getTenpai(tiles, fuuro);
        if (tenpai.isEmpty()){
            return new ArrayList<>();
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
            subTile = new ArrayList<>(List.copyOf(tiles));
            subMentsu = new ArrayList<>(naki);
            switch (t.getValue()){
                case RYML -> {
                    hasToitsu = false;

                    subTile.remove(Tile.of(at, 1));
                    subTile.remove(Tile.of(at, 2));
                    subMentsu.add(new Shuntsu(new Tile[]{at, Tile.of(at, 1), Tile.of(at, 2)}, agaru));
                    stack.push(new Triplet<>(subTile, subMentsu, Machi.RYML));
                }
                case RYMH -> {
                    hasToitsu = false;

                    subTile.remove(Tile.of(at, -2));
                    subTile.remove(Tile.of(at, -1));
                    subMentsu.add(new Shuntsu(new Tile[]{Tile.of(at, -2), Tile.of(at, -1), at}, agaru));
                    stack.push(new Triplet<>(subTile, subMentsu, Machi.RYMH));
                }
                case PEN -> {
                    hasToitsu = false;

                    switch (at.value){
                        case 3 -> {
                            subTile.remove(Tile.of(at, -2));
                            subTile.remove(Tile.of(at, -1));
                            subMentsu.add(new Shuntsu(new Tile[]{Tile.of(at, -2), Tile.of(at, -1), at}, agaru));
                        }
                        case 7 -> {
                            subTile.remove(Tile.of(at, 1));
                            subTile.remove(Tile.of(at, 2));
                            subMentsu.add(new Shuntsu(new Tile[]{at, Tile.of(at, 1), Tile.of(at, 2)}, agaru));
                        }
                    }
                    stack.push(new Triplet<>(subTile, subMentsu, Machi.PEN));
                }
                case KAN -> {
                    hasToitsu = false;

                    subTile.remove(Tile.of(at, -1));
                    subTile.remove(Tile.of(at, 1));
                    subMentsu.add(new Shuntsu(new Tile[]{Tile.of(at, -1), at, Tile.of(at, 1)}, agaru));
                    stack.push(new Triplet<>(subTile, subMentsu, Machi.KAN));
                }
                case SHP -> {
                    hasToitsu = false;

                    subTile.remove(at);
                    subTile.remove(at);
                    subMentsu.add(new Koutsu(new Tile[]{at, at, at}, agaru));
                    stack.push(new Triplet<>(subTile, subMentsu, Machi.SHP));
                }
                case TAN -> {
                    hasToitsu = true;

                    subTile.remove(at);
                    subMentsu.add(new Toitsu(new Tile[]{at, at}, agaru));
                    stack.push(new Triplet<>(subTile, subMentsu, Machi.TAN));
                }
                case CHI -> {
                    List<Tile> chiitoi = subTile.stream().distinct().toList();
                    for (Tile c: chiitoi){
                        subMentsu.add(new Toitsu(new Tile[]{c, c}, agaru));
                    }
                    out.add(new Agari(agaruTile, subMentsu, Machi.CHI, true, agaru));
                }
                case KMU -> {
                    subTile.add(agaruTile);
                    Tile[] subArray = new Tile[14];
                    for (int i=0;i<14;i++){
                        subArray[i] = subTile.get(i);
                    }
                    subMentsu.add(new Kokushi(subArray));
                    out.add(new Agari(agaruTile, subMentsu, Machi.KMU, true, agaru));
                }
                case KMU13 -> {
                    subTile.add(agaruTile);
                    Tile[] subArray = new Tile[14];
                    for (int i=0;i<14;i++){
                        subArray[i] = subTile.get(i);
                    }
                    subMentsu.add(new Kokushi(subArray));
                    out.add(new Agari(agaruTile, subMentsu, Machi.KMU13, true, agaru));
                }
            }
            if (!hasToitsu){
                count = new EnumMap<>(Tile.class);
                sub = stack.pop();
                for (Tile s: sub.getKey()){
                    count.merge(s, 1, (v, p) -> v+1);
                }
                for (Tile s: count.keySet()){
                    if (count.get(s)>=2){
                        subTile = new ArrayList<>(List.copyOf(sub.getKey()));
                        subMentsu = new ArrayList<>(List.copyOf(sub.getValue1()));
                        subTile.remove(s);
                        subTile.remove(s);
                        subMentsu.add(new Toitsu(new Tile[]{s, s}));
                        stack.push(new Triplet<>(subTile, subMentsu, sub.getValue2()));
                    }
                }
            }
        }
        while (!stack.isEmpty()){
            target = stack.pop();
            length = target.getKey().size();
            if (length == 0){
                Collections.sort(target.getValue1());
                out.add(new Agari(agaruTile, target.getValue1(), target.getValue2(), menzen, agaru));
            } else {
                for (int i=0; i<length-2; i++){
                    if (target.getKey().contains(Tile.of(target.getKey().get(i), 1)) && target.getKey().contains(Tile.of(target.getKey().get(i), 2))){
                        Tile at = target.getKey().get(i);
                        subTile = new ArrayList<>(List.copyOf(target.getKey()));
                        subMentsu = new ArrayList<>(List.copyOf(target.getValue1()));
                        subTile.remove(Tile.of(at, 0));
                        subTile.remove(Tile.of(at, 1));
                        subTile.remove(Tile.of(at, 2));
                        subMentsu.add(new Shuntsu(new Tile[]{Tile.of(at, 0), Tile.of(at, 1), Tile.of(at, 2)}));
                        stack.push(new Triplet<>(subTile, subMentsu, target.getValue2()));
                    }
                }
                for (int i=0; i<length-2; i++){
                    if (Collections.frequency(target.getKey(), target.getKey().get(i))>=3){
                        Tile at = target.getKey().get(i);
                        subTile = new ArrayList<>(List.copyOf(target.getKey()));
                        subMentsu = new ArrayList<>(List.copyOf(target.getValue1()));
                        subTile.remove(Tile.of(at, 0));
                        subTile.remove(Tile.of(at, 0));
                        subTile.remove(Tile.of(at, 0));
                        subMentsu.add(new Shuntsu(new Tile[]{Tile.of(at, 0), Tile.of(at, 0), Tile.of(at, 0)}));
                        i+=2;
                        stack.push(new Triplet<>(subTile, subMentsu, target.getValue2()));
                    }
                }
            }

        }
        out = out.stream().distinct().collect(Collectors.toList());
        return out;
    }
}
