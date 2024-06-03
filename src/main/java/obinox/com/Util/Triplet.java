package obinox.com.Util;

import java.util.Objects;

public class Triplet<K, V1, V2> {
    private final K key;
    private final V1 value1;
    private final V2 value2;
    public Triplet(K k, V1 v1, V2 v2){
        this.key = k;
        this.value1 = v1;
        this.value2 = v2;
    }

    @Override
    public String toString() {
        return "("+this.key+": "+this.value1+", "+this.value2+")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triplet<?, ?, ?> pair = (Triplet<?, ?, ?>) o;
        return Objects.equals(key, pair.key) && Objects.equals(value1, pair.value1) && Objects.equals(value2, pair.value2);
    }

    public K getKey() {
        return key;
    }
    public V1 getValue1() {
        return value1;
    }
    public V2 getValue2() {
        return value2;
    }
    public Pair<V1, V2> getValues(){
        return new Pair<>(value1, value2);
    }
}
