package obinox.com.Enums;

public enum MentsuType {
    MINKOU(3, false),
    ANKOU(3, true),
    MINJUN(3, false),
    ANJUN(3, true),
    DAIMINKAN(4, false),
    SHOUMINKAN(4, false),
    ANKAN(4, true),
    ELSE(0, true),

    ;

    public final boolean menzen;
    public final int count;

    MentsuType(int c, boolean m) {
        this.count = c;
        this.menzen = m;
    }

}
