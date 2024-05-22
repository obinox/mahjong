package obinox.com.Enums;

public enum MahjongError {
    IS_ALREADY_TSUMO("Hand already has tsumohai"),
    HAND_INDEX_OUT_OF_RANGE("Index is out of range (idx < 0 or 13 < idx)"),
    HAIPAI_ERROR("Starting hand form is incorrect"),
    KOUTSU_ERROR("Koutsu need three same tile"),
    KANTSU_ERROR("Kantsu need four same tile"),
    SHUNTSU_ERROR("Shuntsu need three continuous tile"),

    ;

    public final String message;

    MahjongError(String message) {
        this.message = message;
    }
}