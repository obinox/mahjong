package obinox.com;

import obinox.com.Enums.MahjongError;

public class MahjongException extends Exception{
    MahjongException(MahjongError me){
        super(me.message);
    }
}
