package obinox.com.Enums;

public enum Group{
    MAN(9, 0),
    PIN(9, 9),
    SOU(9, 18),
    KAZE(4, 27),
    SANGEN(3, 31),
    AKA(3, 34),

    //NULL
    NULL(0, -1),

    ;

    public final int count;
    public final int index;
    Group(int count, int index){
        this.count = count;
        this.index = index;
    }

}
