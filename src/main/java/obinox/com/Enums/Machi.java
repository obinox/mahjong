package obinox.com.Enums;

public enum Machi {

    /**
     * <h1>Raynmen Machi Low(<i>RYML</i>)</h1>
     * <h2>Value</h2>
     * <p>0 fu</p>
     * <h2>Waiting Type</h2>
     * <ul>
     *     <li>Wait for {@link obinox.com.Mentsu.Shuntsu shuntsu}'s side low tile</li>
     * </ul>
     *
     * @see obinox.com.Mentsu.Shuntsu
     */
    RYML(0),

    /**
     * <h1>Raynmen Machi High(<i>RYMH</i>)</h1>
     * <h2>Value</h2>
     * <p>0 fu</p>
     * <h2>Waiting Type</h2>
     * <ul>
     *     <li>Wait for {@link obinox.com.Mentsu.Shuntsu shuntsu}'s side high tile</li>
     * </ul>
     *
     * @see obinox.com.Mentsu.Shuntsu
     */
    RYMH(0),

    /**
     * <h1>Penchan Machi(<i>PEN</i>)</h1>
     * <h2>Value</h2>
     * <p>2 fu</p>
     * <h2>Waiting Type</h2>
     * <ul>
     *     <li>Wait for 123{@link obinox.com.Mentsu.Shuntsu shuntsu}'s 3 tile</li>
     * </ul>
     *
     * @see obinox.com.Mentsu.Shuntsu
     */
    PEN3(2),

    /**
     * <h1>Penchan Machi(<i>PEN</i>)</h1>
     * <h2>Value</h2>
     * <p>2 fu</p>
     * <h2>Waiting Type</h2>
     * <ul>
     *     <li>Wait for 789 {@link obinox.com.Mentsu.Shuntsu shuntsu}'s 7 tile</li>
     * </ul>
     *
     * @see obinox.com.Mentsu.Shuntsu
     */
    PEN7(2),

    /**
     * <h1>Kanchan Machi(<i>KAN</i>)</h1>
     * <h2>Value</h2>
     * <p>2 fu</p>
     * <h2>Waiting Type</h2>
     * <ul>
     *     <li>Wait for {@link obinox.com.Mentsu.Shuntsu shuntsu}'s middle tile</li>
     * </ul>
     *
     * @see obinox.com.Mentsu.Shuntsu
     */
    KAN(2),

    /**
     * <h1>Shapon Machi(<i>SHP</i>)</h1>
     * <h2>Value</h2>
     * <p>0 fu</p>
     * <h2>Waiting Type</h2>
     * <ul>
     *     <li>Wait for two tiles to complete {@link obinox.com.Mentsu.Koutsu Koutsu}</li>
     * </ul>
     *
     * @see obinox.com.Mentsu.Koutsu
     */
    SHP(0),

    /**
     * <h1>Tanki Machi(<i>TAN</i>)</h1>
     * <h2>Value</h2>
     * <p>2 fu</p>
     * <h2>Waiting Type</h2>
     * <ul>
     *     <li>Wait for one tile to complete {@link obinox.com.Mentsu.Toitsu jantou}</li>
     * </ul>
     * <h2>Hadaka tanki</h2>
     * <ul>
     *     <li>Wait for one tile with fuuro/ankan call four times</li>
     * </ul>
     * <h2>Jigoku</h2>
     * <ul>
     *     <li>Wait for just one tile that already 3 tiles are opened</li>
     * </ul>
     *
     * @see obinox.com.Mentsu.Koutsu
     */
    TAN(2),

    /**
     * <h1>Chiitoitsu Tanki Machi(<i>CHI</i>)</h1>
     * <h2>Value</h2>
     * <p>0 fu</p>
     * <h2>Waiting Type</h2>
     * <ul>
     *     <li>Wait for one tile to complete {@link Yaku#CHI chiitoitsu}</li>
     * </ul>
     *
     * @see Yaku#CHI
     */
    CHI(0),

    /**
     * <h1>Kokushi Musou Machi(<i>KMU</i>)</h1>
     * <h2>Value</h2>
     * <p>0 fu</p>
     * <h2>Waiting Type</h2>
     * <ul>
     *     <li>Wait for one tile to complete {@link Yaku#KMU kokushi musou}</li>
     * </ul>
     *
     * @see Yaku#KMU
     * @see Yaku#KMU13
     */
    KMU(0),

    /**
     * <h1>Kokushi Musou Juusan(13) Men Machi(<i>KMU13</i>)</h1>
     * <h2>Value</h2>
     * <p>0 fu</p>
     * <h2>Waiting Type</h2>
     * <ul>
     *     <li>Wait for 13 tile to complete {@link Yaku#KMU13 kokushi musou juusan men machi}</li>
     * </ul>
     *
     * @see Yaku#KMU
     * @see Yaku#KMU13
     */
    KMU13(0),

    /**
     * <h1>No Machi(<i>NOM</i>)</h1>
     */
    NOM(0),

    ;

    public final int fu;

    Machi(int f){
        this.fu = f;
    }

}
