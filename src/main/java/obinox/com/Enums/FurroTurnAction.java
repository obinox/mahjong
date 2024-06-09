package obinox.com.Enums;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum FurroTurnAction {
    RON("ron"),
    KAN("kan"),
    PONG("pong"),
    CHII("chii"),

    ;

    public final String str;

    FurroTurnAction(String str){
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    private static final Map<String, FurroTurnAction> strFinder = Collections.unmodifiableMap(Stream.of(values()).collect(Collectors.toMap(FurroTurnAction::getStr, e->e)));
    public static FurroTurnAction of(String str){
        return strFinder.get(str);
    }
}
