package obinox.com.Util;

import java.util.Objects;

public class Pair<K, V> {
    private final K key;
    private final V value;
    public Pair(K k, V v){
        this.key = k;
        this.value = v;
    }

    @Override
    public String toString() {
        return "("+this.key+": "+this.value+")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(key, pair.key) && Objects.equals(value, pair.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    public K getKey() {
        return key;
    }
    public V getValue() {
        return value;
    }
}
