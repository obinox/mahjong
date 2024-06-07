package obinox.com.Util;

import obinox.com.Enums.Group;
import obinox.com.Enums.IteratorGroup;
import obinox.com.Enums.Machi;
import obinox.com.Enums.Tile;

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
        EnumMap<Tile, Integer> subCount = new EnumMap<>(Tile.class);
        EnumMap<Group, List<Tile>> groups = new EnumMap<>(Group.class);
        List<Tile> naTiles = new ArrayList<>();


        //Recursion stack
        Stack<List<Tile>> stack = new Stack<>();
        List<Tile> target;
        List<Tile> sub;
        int length;
        int type;

        //Output
        List<Tenpai> out = new ArrayList<>();
        List<Tenpai> shapon = new ArrayList<>();
        List<Tenpai> aka = new ArrayList<>();
        List<Tenpai> wait;

        //Count tiles
        for (Tile t: tiles){
            count.merge(t, 1, (v, p) -> v+1);
            naTiles.add(Tile.of(t, 0));
        }
        for (Tile t: naTiles){
            subCount.merge(t, 1, (v, p) -> v+1);
        }
        System.out.println(count);

        //Chiitoitsu and Kokushi Musou/Kokushi Musou 13Men Machi
        if (naTiles.size() == 13){
            System.out.println(subCount);
            if (subCount.size() == 7){
                if (subCount.values().stream().allMatch(v -> v == 2 || v == 1)){
                    for (Tile t: subCount.keySet()){
                        if (subCount.get(t) == 1){
                            if (count.getOrDefault(t, 0)<t.count){
                                out.add(new Tenpai(t, Machi.CHI));
                            }
                        }
                    }
                }
            } else if (IteratorGroup.isAllIn(IteratorGroup.YAOCHUUHAI, naTiles)){
                if (count.size() == 12) {
                    if (count.values().stream().allMatch(v -> v == 2 || v == 1)) {
                        Tile koku;
                        for (Tile t: IteratorGroup.YAOCHUUHAI.iterator){
                            koku = t;
                            if (!naTiles.contains(koku)){
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
        for (Tile t: naTiles){
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
                        Tile t = Tile.of(target.get(0), 0);
                        if (t.value==5){
                            if (count.getOrDefault(t, 0)<t.count){
                                wait.add(new Tenpai(t, Machi.TAN));
                            }
                        } else {
                            if (count.get(t)<t.count){
                                wait.add(new Tenpai(t, Machi.TAN));
                            }
                        }
                    }
                    case 2 -> {
                        if (target.get(0).group == target.get(1).group){
                            if (target.get(0).value == target.get(1).value){
                                Tile t = Tile.of(target.get(0), 0);
                                if (count.get(t)<t.count){
                                    shapon.add(new Tenpai(t, Machi.SHP));
                                }
                            } else if (!IteratorGroup.isIn(IteratorGroup.JIHAI, target.get(0))){
                                if (Tile.sequence(target.get(0), target.get(1))) {
                                    Tile t1 = Tile.of(target.get(0), -1);
                                    if (t1 != Tile.NULL){
                                        if (t1.value == 7) {
                                            if (count.getOrDefault(t1, 0)<t1.count){
                                                wait.add(new Tenpai(t1, Machi.PEN7));
                                            }
                                        } else {
                                            if (count.getOrDefault(t1, 0)<t1.count){
                                                wait.add(new Tenpai(t1, Machi.RYML));
                                            }
                                        }
                                    }
                                    Tile t2 = Tile.of(target.get(0), 2);
                                    if (t2 != Tile.NULL && count.getOrDefault(t2, 0)<t2.count){
                                        if (t2.value == 3) {
                                            if (count.getOrDefault(t2, 0)<t2.count){
                                                wait.add(new Tenpai(t2, Machi.PEN3));
                                            }
                                        } else {
                                            if (count.getOrDefault(t2, 0)<t2.count){
                                                wait.add(new Tenpai(t2, Machi.RYMH));
                                            }
                                        }
                                    }
                                } else if (Tile.sequence(target.get(0), target.get(1), 2)) {
                                    Tile t = Tile.of(target.get(0), 1);
                                    if (t != Tile.NULL){
                                        if (count.getOrDefault(t, 0)<t.count){
                                            wait.add(new Tenpai(t, Machi.KAN));
                                        }
                                    }
                                }
                            }
                        }
                    }
                    case 4 -> {
                        if (IteratorGroup.isAllIn(target.get(0).group, target)){
                            for (int i=0; i<length-1; i++) {
                                Tile t0 = Tile.of(target.get(i), 0);
                                Tile t1 = Tile.of(target.get(i+1), 0);
                                if (Tile.equal(t0, t1) && !(count.get(t0)>3)){
                                    sub = new ArrayList<>(List.copyOf(target));
                                    sub.remove(Tile.of(t0, 0));
                                    sub.remove(Tile.of(t0, 0));
                                    stack.push(sub);
                                }
                            }

                            if (!IteratorGroup.isIn(IteratorGroup.JIHAI, target.get(0))){
                                for (int i=0; i<length-2; i++){
                                    Tile t0 = Tile.of(target.get(i), 0);
                                    Tile t1 = Tile.of(target.get(i), 1);
                                    Tile t2 = Tile.of(target.get(i), 2);

                                    if (target.contains(t1) && target.contains(t2)){
                                        sub = new ArrayList<>(List.copyOf(target));
                                        sub.remove(t0);
                                        sub.remove(t1);
                                        sub.remove(t2);
                                        stack.push(sub);
                                    }
                                }
                            }

                            for (int i=0; i<length-2; i++){
                                Tile t = Tile.of(target.get(i), 0);
                                int freq = Collections.frequency(target, Tile.of(t, 0));
                                if (freq>=3){
                                    sub = new ArrayList<>(List.copyOf(target));
                                    sub.remove(t);
                                    sub.remove(t);
                                    sub.remove(t);
                                    i+=2;
                                    stack.push(sub);
                                }
                            }
                        }
                    }
                    default -> {
                        if (!IteratorGroup.isIn(IteratorGroup.JIHAI, target.get(0))){
                            for (int i=0; i<length-2; i++){
                                Tile t0 = Tile.of(target.get(i), 0);
                                Tile t1 = Tile.of(target.get(i), 1);
                                Tile t2 = Tile.of(target.get(i), 2);

                                if (target.contains(t1) && target.contains(t2)){
                                    sub = new ArrayList<>(List.copyOf(target));
                                    sub.remove(t0);
                                    sub.remove(t1);
                                    sub.remove(t2);
                                    stack.push(sub);
                                }
                            }
                        }

                        for (int i=0; i<length-2; i++){
                            Tile t = Tile.of(target.get(i), 0);
                            int freq = Collections.frequency(target, Tile.of(t, 0));
                            if (freq>=3){
                                sub = new ArrayList<>(List.copyOf(target));
                                sub.remove(t);
                                sub.remove(t);
                                sub.remove(t);
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
        shapon = shapon.stream().distinct().collect(Collectors.toList());
        if (shapon.size() == 2){
            out.addAll(shapon);
        }

        out = out.stream().distinct().collect(Collectors.toList());
        for (Tenpai p: out){
            Tile t = p.getKey();
            if (t.value == 5 && count.getOrDefault(Tile.aka(t), 0)<Tile.aka(t).count){
                aka.add(new Tenpai(Tile.aka(t), p.getValue()));
            }
        }
        out.addAll(aka);
        Collections.sort(out);
        return out;
    }
}
