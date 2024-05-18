package obinox.com;

public class MahjongException extends Exception{
    MahjongException(MahjongError me){
        super(me.message);
    }
}
