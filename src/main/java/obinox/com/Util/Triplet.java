package obinox.com.Util;

import java.util.Objects;

public class Triplet<V1, V2, V3> {
    private final V1 value1;
    private final V2 value2;
    private final V3 value3;
    public Triplet(V1 v1, V2 v2, V3 v3){
        this.value1 = v1;
        this.value2 = v2;
        this.value3 = v3;
    }

    @Override
    public String toString() {
        return "("+this.value1 +": "+this.value2 +", "+this.value3 +")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triplet<?, ?, ?> pair = (Triplet<?, ?, ?>) o;
        return Objects.equals(value1, pair.value1) && Objects.equals(value2, pair.value2) && Objects.equals(value3, pair.value3);
    }

    public V1 getValue1() {
        return value1;
    }
    public V2 getValue2() {
        return value2;
    }
    public V3 getValue3() {
        return value3;
    }
}
