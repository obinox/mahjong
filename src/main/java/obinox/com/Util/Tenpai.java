package obinox.com.Util;

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
        Tenpai t = (Tenpai) o;
        int k = this.getKey().ordinal() - o.getKey().ordinal();
        if (k == 0){
            return this.getValue().ordinal() - o.getValue().ordinal();
        } else {
            return k;
        }
    }

    public static List<Tenpai> getTenpai(List<Tile> tiles) {
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
}
