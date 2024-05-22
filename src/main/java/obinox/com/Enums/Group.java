package obinox.com.Enums;

public enum Group{
    MAN(9),
    PIN(9),
    SOU(9),
    KAZE(4),
    SANGEN(3),

    ;

    public final int count;
    Group(int count){
        this.count = count;
    }

}
