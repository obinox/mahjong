package obinox.com.Enums;

public enum Group{
    MAN(9, 0),
    PIN(9, 10),
    SOU(9, 20),
    KAZE(4, 30),
    SANGEN(3, 34),
    AKA(3, -1),

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
