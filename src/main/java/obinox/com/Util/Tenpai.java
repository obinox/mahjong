package obinox.com.Util;

import obinox.com.Enums.Group;
import obinox.com.Enums.IteratorGroup;
import obinox.com.Enums.Machi;
import obinox.com.Enums.Tile;
import obinox.com.Mentsu.Mentsu;

import java.util.*;
import java.util.stream.Collectors;

public class Tenpai extends Pair<Tile, Machi> implements Comparable<Pair<Tile, Machi>> {

    public Tenpai(Tile t, Machi m) {
        super(t, m);
    }

    @Override
    public int compareTo(Pair<Tile, Machi> o) {
        int k = this.getKey().ordinal() - o.getKey().ordinal();
        if (k == 0){
            return this.getValue().ordinal() - o.getValue().ordinal();
        } else {
            return k;
        }
    }

    public static List<Tenpai> getTenpai(List<Tile> tiles) {
        return getTenpai(tiles, new ArrayList<Tile>());
    }

    @SuppressWarnings("ReassignedVariable")
    public static List<Tenpai> getTenpai(List<Tile> tiles, List<Tile> fuuro) {
        Collections.sort(tiles);
        EnumMap<Tile, Integer> count = new EnumMap<>(Tile.class);
        EnumMap<Group, List<Tile>> groups = new EnumMap<>(Group.class);

        //Recursion stack
        Stack<List<Tile>> stack = new Stack<>();
        List<Tile> target;
        List<Tile> sub;
        int length;
        int type;

        //Output
        List<Tenpai> out = new ArrayList<>();
        List<Tenpai> shapon = new ArrayList<>();
        List<Tenpai> wait;

        //Count tiles
        for (Tile t: tiles){
            count.merge(t, 1, (v, p) -> v+1);
        }
        System.out.println(count);

        //Chiitoitsu and Kokushi Musou/Kokushi Musou 13Men Machi
        if (tiles.size() == 13){
            if (count.size() == 7){
                if (count.values().stream().allMatch(v -> v == 2 || v == 1)){
                    for (Tile t: count.keySet()){
                        if (count.get(t) == 1){
                            out.add(new Tenpai(t, Machi.CHI));
                        }
                    }
                }
            } else if (IteratorGroup.isAllIn(IteratorGroup.YAOCHUUHAI, tiles)){
                if (count.size() == 12) {
                    if (count.values().stream().allMatch(v -> v == 2 || v == 1)) {
                        Tile koku;
                        for (Tile t: IteratorGroup.YAOCHUUHAI.iterator){
                            koku = t;
                            if (!tiles.contains(koku)){
                                out.add(new Tenpai(t, Machi.KMU));
                                return out;
                            }
                        }
                    }
                } else if (count.size() == 13) {
                    if (count.values().stream().allMatch(v -> v == 1)) {
                        for (Tile t: IteratorGroup.YAOCHUUHAI.iterator){
                            out.add(new Tenpai(t, Machi.KMU13));
                        }
                            return out;
                    }
                }
            }
        }

        for (Tile t: fuuro){
            int c = count.getOrDefault(t, 0);
            if (c == 0){
                count.put(t, 0);
            }
            count.replace(t, c+1);
        }

        //Split by group
        for (Tile t: tiles){
            List<Tile> g = groups.getOrDefault(t.group, null);
            if (g == null){
                groups.put(t.group, new ArrayList<>());
            }
            groups.get(t.group).add(t);
        }

        for (List<Tile> g: groups.values()){
            wait = new ArrayList<>();
            type = g.size()%3;
            stack.add(g);
            while (!stack.isEmpty()){
                target = stack.pop();
                length = target.size();
                switch(length){
                    case 0 -> wait.add(new Tenpai(Tile.NULL, Machi.NOM));
                    case 1 -> {
                        if (!(count.get(target.get(0))>3)){
                            wait.add(new Tenpai(target.get(0), Machi.TAN));
                        }
                    }
                    case 2 -> {
                        if (target.get(0).group == target.get(1).group){
                            if (target.get(0).value == target.get(1).value){
                                Tile t = Tile.of(target.get(0), 0);
                                if (!(count.get(t)>3)){
                                    shapon.add(new Tenpai(t, Machi.SHP));
                                }
                            } else if (!IteratorGroup.isIn(IteratorGroup.JIHAI, target.get(0))){
                                if (Tile.sequence(target.get(0), target.get(1))) {
                                    Tile t1 = Tile.of(target.get(0), -1);
                                    if (t1 != Tile.NULL && !(count.get(t1)>3)){
                                        if (t1.value == 7){
                                            wait.add(new Tenpai(t1, Machi.PEN));
                                        } else {
                                            wait.add(new Tenpai(t1, Machi.RYML));
                                        }
                                    }
                                    Tile t2 = Tile.of(target.get(0), 2);
                                    if (t2 != Tile.NULL && !(count.get(t2)>3)){
                                        if (t2.value == 3){
                                            wait.add(new Tenpai(t2, Machi.PEN));
                                        } else {
                                            wait.add(new Tenpai(t2, Machi.RYMH));
                                        }
                                    }
                                } else if (Tile.sequence(target.get(0), target.get(1), 2)) {
                                    Tile t = Tile.of(target.get(0), 1);
                                    if (t != Tile.NULL && !(count.get(t) > 3)){
                                        wait.add(new Tenpai(t, Machi.KAN));
                                    }
                                }
                            }
                        }
                    }
                    case 4 -> {
                        if (IteratorGroup.isAllIn(target.get(0).group, target)){
                            for (int i=0; i<length-1; i++) {
                                if (Tile.equal(target.get(i), target.get(i+1)) && !(count.get(target.get(i))>3)){
                                    sub = new ArrayList<>(List.copyOf(target));
                                    sub.remove(Tile.of(target.get(i), 0));
                                    sub.remove(Tile.of(target.get(i), 0));
                                    stack.push(sub);
                                }
                            }
                            for (int i=0; i<length-2; i++) {
                                if (!IteratorGroup.isIn(IteratorGroup.JIHAI, target.get(0))){
                                    if (target.contains(Tile.of(target.get(0), 1)) && target.contains(Tile.of(target.get(0), 2))){
                                        sub = new ArrayList<>(List.copyOf(target));
                                        sub.remove(Tile.of(target.get(0), 0));
                                        sub.remove(Tile.of(target.get(0), 1));
                                        sub.remove(Tile.of(target.get(0), 2));
                                        stack.push(sub);
                                    }
                                }
                            }
                            for (int i=0; i<length-2; i++) {
                                if (Collections.frequency(target, target.get(i))>=3){
                                    sub = new ArrayList<>(List.copyOf(target));
                                    sub.remove(Tile.of(target.get(i), 0));
                                    sub.remove(Tile.of(target.get(i), 0));
                                    sub.remove(Tile.of(target.get(i), 0));
                                    stack.push(sub);
                                }
                            }

                        }
                    }
                    default -> {
                        if (!IteratorGroup.isIn(IteratorGroup.JIHAI, target.get(0))){
                            for (int i=0; i<length-2; i++){
                                if (target.contains(Tile.of(target.get(i), 1)) && target.contains(Tile.of(target.get(i), 2))){
                                    sub = new ArrayList<>(List.copyOf(target));
                                    sub.remove(Tile.of(target.get(i), 0));
                                    sub.remove(Tile.of(target.get(i), 1));
                                    sub.remove(Tile.of(target.get(i), 2));
                                    stack.push(sub);
                                }
                            }
                        }

                        for (int i=0; i<length-2; i++){
                            if (Collections.frequency(target, target.get(i))>=3){
                                sub = new ArrayList<>(List.copyOf(target));
                                sub.remove(Tile.of(target.get(i), 0));
                                sub.remove(Tile.of(target.get(i), 0));
                                sub.remove(Tile.of(target.get(i), 0));
                                i+=2;
                                stack.push(sub);
                            }
                        }
                    }
                }
            }
            wait = wait.stream().distinct().collect(Collectors.toList());
            if (type == 0 && out.isEmpty() && !wait.contains(new Tenpai(Tile.NULL, Machi.NOM))){
                return new ArrayList<>();
            } else {
                out.addAll(wait);
            }
        }
        if (shapon.size() == 2){
            out.addAll(shapon);
        }

        out = out.stream().distinct().collect(Collectors.toList());
        Collections.sort(out);
        return out;
    }
}
