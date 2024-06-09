package obinox.com.Enums;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum MyTurnAction {
    TSUMO("tsumo"),
    KAN("kan"),
    RIICHI("riichi"),
    NUKI("nuki"),
    RYUKYOKU("ryukyoku"),

    ;

    public final String str;

    MyTurnAction(String str){
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    private static final Map<String, MyTurnAction> strFinder = Collections.unmodifiableMap(Stream.of(values()).collect(Collectors.toMap(MyTurnAction::getStr, e->e)));
    public static MyTurnAction of(String str){
        return strFinder.get(str);
    }
}
