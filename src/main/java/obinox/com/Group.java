package obinox.com;

public enum Group{
    MAN(9),
    PIN(9),
    SOU(9),
    KAZEHAI(4),
    SANGENPAI(3),

    ;

    public final int count;
    Group(int count){
        this.count = count;
    }

}
