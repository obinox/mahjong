package obinox.com;

public enum MahjongError {
    IS_ALREADY_TSUMO("Hand already has tsumohai"),
    HAND_INDEX_OUT_OF_RANGE("Index is out of range (idx < 0 or 13 < idx)"),
    HAIPAI_ERROR("Starting hand form is incorrect");

    ;
    public final String message;

    MahjongError(String message){
        this.message = message;
    }
}