package obinox.com;

/**
 * Yaku for Mahjong.
 * @see Yaku#RCH
 */

public enum Yaku {
    /**
     * <h1>RCH(<i>Riichi</i>)</h1>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>{@link Rule#Menzen Menzen}</li>
     *     <li>{@link Rule#Tenpai Tenpai}</li>
     *     <li>(player) at least <b>1,000 points</b></li>
     *     <li>(live wall) at least <b>4 tiles</b></li>
     * </ul>
     */
    RCH,
    /**
     * <h1>RCH(<i>Rffiichi</i>)</h1>
     * <h2>Requirements</h2>
     * <ul>
     *     <li><a id="b">menzen</a></li>
     *     <li>tenpai</li>
     *     <li>(player) at least <b>1,000 points</b></li>
     *     <li>(live wall) at least <b>4 tiles</b></li>
     * </ul>
     * {@link Yaku#RCH asdf}
     */
    CHANKAN,
    DOUBLERIICHI,
    HOUTEI,
    HAITEI,
    MENZENTSUMO,
    RINSHAN,
    HONITSU,
    HONROUTOU,
    SHOUSANGEN,
    TANYAO,
    YAKUHAI,
    IPPATSU,
    IIPEIKOU,
    ITTSU,
    PINFU,
    RYANPEIKOU,
    SNASHOKU,
    CHANTA,
    JUNCHAN,
    NAGASHI,
    SANANKOU,
    SNAKATSU,
    TOITOI,
    HONIISOU,
    CHINIISOU;



//
//    private int han;
//    private int opened;
//    private boolean local;
}

/*
Yaku table
   |RCH|DRI|IPP|SMO|TAN|PFU|IPK|ITT|YAK|SDJ|SDO|TOI|SNA|SNK|CHA|JUN|RPK|SSG|HRO|HON|CHN|CHI|RIN|HAI|HOU|CHK|menz|naki|
---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+----+----+
RCH|///|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |    |    |
DRI|   |///|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |    |    |
IPP|   |   |///|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |    |    |
SMO|   |   |   |///|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |    |    |
TAN|   |   |   |   |///|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |    |    |
PFU|   |   |   |   |   |///|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |    |    |
IPK|   |   |   |   |   |   |///|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |    |    |
ITT|   |   |   |   |   |   |   |///|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |    |    |
YAK|   |   |   |   |   |   |   |   |///|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |    |    |
SDJ|   |   |   |   |   |   |   |   |   |///|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |    |    |
SDO|   |   |   |   |   |   |   |   |   |   |///|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |    |    |
TOI|   |   |   |   |   |   |   |   |   |   |   |///|   |   |   |   |   |   |   |   |   |   |   |   |   |   |    |    |
SNA|   |   |   |   |   |   |   |   |   |   |   |   |///|   |   |   |   |   |   |   |   |   |   |   |   |   |    |    |
SNK|   |   |   |   |   |   |   |   |   |   |   |   |   |///|   |   |   |   |   |   |   |   |   |   |   |   |    |    |
CHA|   |   |   |   |   |   |   |   |   |   |   |   |   |   |///|   |   |   |   |   |   |   |   |   |   |   |    |    |
JUN|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |///|   |   |   |   |   |   |   |   |   |   |    |    |
RPK|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |///|   |   |   |   |   |   |   |   |   |    |    |
SSG|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |///|   |   |   |   |   |   |   |   |    |    |
HRO|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |///|   |   |   |   |   |   |   |    |    |
HON|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |///|   |   |   |   |   |   |    |    |
CHN|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |///|   |   |   |   |   |    |    |
CHI|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |///|   |   |   |   |    |    |
RIN|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |///|   |   |   |    |    |
HAI|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |///|   |   |    |    |
HOU|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |///|   |    |    |
CHK|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |///|    |    |



 */