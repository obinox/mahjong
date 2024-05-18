package obinox.com;

/**
 * <h1>{@link Yaku} for Mahjong</h1>
 *
 * <h2>{@link Yaku} table</h2>
 *
 * <table style="text-align: center">
 * <tr><th style="text-align: center">{@link Yaku}</th><th style="text-align: center">{@link Yaku#RCH}</th><th style="text-align: center">{@link Yaku#DRI}</th><th style="text-align: center">{@link Yaku#IPP}</th><th style="text-align: center">{@link Yaku#SMO}</th><th style="text-align: center">{@link Yaku#TAN}</th><th style="text-align: center">{@link Yaku#PFU}</th><th style="text-align: center">{@link Yaku#IPK}</th><th style="text-align: center">{@link Yaku#ITT}</th><th style="text-align: center">{@link Yaku#YAK}</th><th style="text-align: center">{@link Yaku#SDJ}</th><th style="text-align: center">{@link Yaku#SDO}</th><th style="text-align: center">{@link Yaku#TOI}</th><th style="text-align: center">{@link Yaku#SNA}</th><th style="text-align: center">{@link Yaku#SNK}</th><th style="text-align: center">{@link Yaku#CHA}</th><th style="text-align: center">{@link Yaku#JUN}</th><th style="text-align: center">{@link Yaku#RPK}</th><th style="text-align: center">{@link Yaku#SSG}</th><th style="text-align: center">{@link Yaku#HRO}</th><th style="text-align: center">{@link Yaku#HON}</th><th style="text-align: center">{@link Yaku#CHN}</th><th style="text-align: center">{@link Yaku#CHI}</th><th style="text-align: center">{@link Yaku#RIN}</th><th style="text-align: center">{@link Yaku#HAI}</th><th style="text-align: center">{@link Yaku#HOU}</th><th style="text-align: center">{@link Yaku#CHK}</th></tr>
 * <tr><td style="text-align: center">{@link Yaku#RCH}</td><td style="text-align: center">=</td><td style="text-align: center">=</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">    </td><td style="text-align: center">    </td><td style="text-align: center"></tr>
 * <tr><td style="text-align: center">{@link Yaku#DRI}</td><td style="text-align: center">=</td><td style="text-align: center">=</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">-</td><td style="text-align: center">    </td><td style="text-align: center">    </td><td style="text-align: center"></tr>
 * <tr><td style="text-align: center">{@link Yaku#IPP}</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">=</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">    </td><td style="text-align: center">    </td><td style="text-align: center"></tr>
 * <tr><td style="text-align: center">{@link Yaku#SMO}</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">=</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">-</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">    </td><td style="text-align: center">    </td><td style="text-align: center"></tr>
 * <tr><td style="text-align: center">{@link Yaku#TAN}</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">=</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">-</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">    </td><td style="text-align: center">    </td><td style="text-align: center"></tr>
 * <tr><td style="text-align: center">{@link Yaku#PFU}</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">=</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">    </td><td style="text-align: center">    </td><td style="text-align: center"></tr>
 * <tr><td style="text-align: center">{@link Yaku#IPK}</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">=</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">    </td><td style="text-align: center">    </td><td style="text-align: center"></tr>
 * <tr><td style="text-align: center">{@link Yaku#ITT}</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">=</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">    </td><td style="text-align: center">    </td><td style="text-align: center"></tr>
 * <tr><td style="text-align: center">{@link Yaku#YAK}</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">    </td><td style="text-align: center">    </td><td style="text-align: center"></tr>
 * <tr><td style="text-align: center">{@link Yaku#SDJ}</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">=</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">    </td><td style="text-align: center">    </td><td style="text-align: center"></tr>
 * <tr><td style="text-align: center">{@link Yaku#SDO}</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">=</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">    </td><td style="text-align: center">    </td><td style="text-align: center"></tr>
 * <tr><td style="text-align: center">{@link Yaku#TOI}</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">-</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">=</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">-</td><td style="text-align: center">-</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">    </td><td style="text-align: center">    </td><td style="text-align: center"></tr>
 * <tr><td style="text-align: center">{@link Yaku#SNA}</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">=</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">    </td><td style="text-align: center">    </td><td style="text-align: center"></tr>
 * <tr><td style="text-align: center">{@link Yaku#SNK}</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">=</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">    </td><td style="text-align: center">    </td><td style="text-align: center"></tr>
 * <tr><td style="text-align: center">{@link Yaku#CHA}</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">-</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">=</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">-</td><td style="text-align: center">-</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">    </td><td style="text-align: center">    </td><td style="text-align: center"></tr>
 * <tr><td style="text-align: center">{@link Yaku#JUN}</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">-</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">=</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">-</td><td style="text-align: center">-</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">    </td><td style="text-align: center">    </td><td style="text-align: center"></tr>
 * <tr><td style="text-align: center">{@link Yaku#RPK}</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">=</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">    </td><td style="text-align: center">    </td><td style="text-align: center"></tr>
 * <tr><td style="text-align: center">{@link Yaku#SSG}</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">=</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">    </td><td style="text-align: center">    </td><td style="text-align: center"></tr>
 * <tr><td style="text-align: center">{@link Yaku#HRO}</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">-</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">=</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">    </td><td style="text-align: center">    </td><td style="text-align: center"></tr>
 * <tr><td style="text-align: center">{@link Yaku#HON}</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">-</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">-</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">=</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">    </td><td style="text-align: center">    </td><td style="text-align: center"></tr>
 * <tr><td style="text-align: center">{@link Yaku#CHN}</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">-</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">=</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">    </td><td style="text-align: center">    </td><td style="text-align: center"></tr>
 * <tr><td style="text-align: center">{@link Yaku#CHI}</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">-</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">=</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">    </td><td style="text-align: center">    </td><td style="text-align: center"></tr>
 * <tr><td style="text-align: center">{@link Yaku#RIN}</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">=</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">    </td><td style="text-align: center">    </td><td style="text-align: center"></tr>
 * <tr><td style="text-align: center">{@link Yaku#HAI}</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">=</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">    </td><td style="text-align: center">    </td><td style="text-align: center"></tr>
 * <tr><td style="text-align: center">{@link Yaku#HOU}</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">=</td><td style="text-align: center">X</td><td style="text-align: center">    </td><td style="text-align: center">    </td><td style="text-align: center"></tr>
 * <tr><td style="text-align: center">{@link Yaku#CHK}</td><td style="text-align: center">O</td><td style="text-align: center">-</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">=</td><td style="text-align: center">    </td><td style="text-align: center">    </td><td style="text-align: center"></tr>
 * </table>
 *
 * <h2>Yakuman table</h2>
 *
 * <table>
 *     <tr><th style="text-align: center">{@link Yaku}</th><th style="text-align: center">{@link Yaku#KMU}</th><th style="text-align: center">{@link Yaku#DSG}</th><th style="text-align: center">{@link Yaku#SUA}</th><th style="text-align: center">{@link Yaku#SSS}</th><th style="text-align: center">{@link Yaku#DSS}</th><th style="text-align: center">{@link Yaku#TSU}</th><th style="text-align: center">{@link Yaku#RYU}</th><th style="text-align: center">{@link Yaku#CHR}</th><th style="text-align: center">{@link Yaku#CHU}</th><th style="text-align: center">{@link Yaku#SUK}</th><th style="text-align: center">{@link Yaku#TEN}</th><th style="text-align: center">{@link Yaku#CHH}</th></tr>
 *     <tr><td style="text-align: center">{@link Yaku#KMU}</td><td style="text-align: center">=</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td></tr>
 *     <tr><td style="text-align: center">{@link Yaku#DSG}</td><td style="text-align: center">X</td><td style="text-align: center">=</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td></tr>
 *     <tr><td style="text-align: center">{@link Yaku#SUA}</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">=</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td></tr>
 *     <tr><td style="text-align: center">{@link Yaku#SSS}</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">=</td><td style="text-align: center">=</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td></tr>
 *     <tr><td style="text-align: center">{@link Yaku#DSS}</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">=</td><td style="text-align: center">=</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td></tr>
 *     <tr><td style="text-align: center">{@link Yaku#TSU}</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">=</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td></tr>
 *     <tr><td style="text-align: center">{@link Yaku#RYU}</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">=</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td></tr>
 *     <tr><td style="text-align: center">{@link Yaku#CHR}</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">=</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td></tr>
 *     <tr><td style="text-align: center">{@link Yaku#CHU}</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">X</td><td style="text-align: center">=</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td></tr>
 *     <tr><td style="text-align: center">{@link Yaku#SUK}</td><td style="text-align: center">X</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">=</td><td style="text-align: center">X</td><td style="text-align: center">X</td></tr>
 *     <tr><td style="text-align: center">{@link Yaku#TEN}</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">=</td><td style="text-align: center">=</td></tr>
 *     <tr><td style="text-align: center">{@link Yaku#CHH}</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">O</td><td style="text-align: center">X</td><td style="text-align: center">=</td><td style="text-align: center">=</td></tr>
 * </table>
 */

public enum Yaku {
    /**
     * <h1>Riichi(<i>RCH</i>)</h1>
     * <h2>Value</h2>
     * <p>{@link Rule#Menzen Menzen}: 1 han</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>Player must be {@link Rule#Menzen menzen}</li>
     *     <li>Player must be {@link Rule#Tenpai tenpai}</li>
     *     <li>Player needs at least <b>1,000 points</b></li>
     *     <li>{@link Rule#Livewall Live wall} needs at least <b>4 tiles</b></li>
     * </ul>
     * <h2>Additional Occurrences</h2>
     * <ul>
     *     <li>{@link Yaku#IPP Ippatsu}</li>
     *     <li>{@link Yaku#URA Uradora}</li>
     *     <li>{@link Yaku#DRI Daburu Riichi}</li>
     * </ul>
     * <h2>{@link Rule#Kan Kan}</h2>
     * <li>If {@link Rule#Kan Ankan} does not change the hand's possible {@link Rule#Machi machi}, kan is allowed</li>
     * <h2>{@link Rule#Furiten Furiten}</h2>
     * <li>{@link Rule#Furiten Pearmant furiten}</li>
     * <h2>{@link Rule#Ryuukyoku Ryuukyoku}</h2>
     * <li>{@link Rule#Ryuukyoku Suucha riichi}</li>
     *
     * @see Yaku#DRI
     * @see Yaku#IPP
     * @see Yaku#URA
     */
    RCH,

    /**
     * <h1>Daburu Riichi/Double Riichi(<i>DRI</i>)</h1>
     * <h2>Value</h2>
     * <p>{@link Rule#Menzen Menzen}: 2 han</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>Same as {@link Yaku#RCH Riichi}</li>
     *     <li>{@link Yaku#RCH Riichi} when player's first {@link Rule#Tsumo tsumo}</li>
     *     <li>No any {@link Rule#Fuuro fuuro} before {@link Yaku#RCH riichi}</li>
     * </ul>
     *
     * @see Yaku#RCH
     * @see Yaku#TEN
     * @see Yaku#CHH
     */
    DRI,

    /**
     * <h1>Ippatsu(<i>IPP</i>)</h1>
     * <h2>Value</h2>
     * <p>{@link Rule#Menzen Menzen}: 1 han</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>Dependent on {@link Yaku#RCH Riichi}</li>
     *     <li>No any {@link Rule#Fuuro fuuro} and {@link Rule#Agari agari} before player's next {@link Rule#Tsumo tsumo}</li>
     *     <li>{@link Yaku#CHK Chankan} is allowed</li>
     * </ul>
     *
     * @see Yaku#RCH
     * @see Yaku#DRI
     * @see Yaku#CHK
     */
    IPP,

    /**
     * <h1>Menzenchin Tsumohou/Menzen Tsumo(<i>SMO</i>)</h1>
     * <h2>Value</h2>
     * <p>{@link Rule#Menzen Menzen}: 1 han</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>Player must be {@link Rule#Menzen menzen}</li>
     *     <li>{@link Rule#Agari Agari}  with {@link Rule#Tsumo tsumo} tile</li>
     * </ul>
     *
     * @see Yaku#RCH
     */
    SMO,

    /**
     * <h1>Tanyao(<i>TAN</i>)</h1>
     * <h2>Value</h2>
     * <p>{@link Rule#Menzen Menzen}: 1 han</p>
     * <p>{@link Rule#Fuuro Fuuro}: 1 han or not allowed</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>No {@link Rule#Tiles jihai} and {@link Rule#Tiles routouhai}</li>
     *     <li>{@link Rule#Agari Agari}  with only {@link Rule#Tiles chunchanhai} tile</li>
     * </ul>
     * <h2>Kuitan</h2>
     * <ul>
     *     <li>Tanyao with {@link Rule#Fuuro Fuuro}</li>
     * </ul>
     *
     * @see Yaku#SMO
     * @see Yaku#TAN
     * @see Yaku#PFU
     */
    TAN,

    /**
     * <h1>Pinfu(<i>PFU</i>)</h1>
     * <h2>Value</h2>
     * <p>{@link Rule#Menzen Menzen}: 1 han</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>Player must be {@link Rule#Menzen menzen}</li>
     *     <li>All {@link Rule#Mentsu mentsu} is {@link Rule#Mentsu shuntsu}</li>
     *     <li>{@link Rule#Machi Ryanmen} {@link Rule#Machi machi} </li>
     *     <li>No {@link Yaku#YAK yakuhai} </li>
     * </ul>
     *
     * @see Yaku#SMO
     * @see Yaku#TAN
     * @see Yaku#PFU
     */
    PFU,

    /**
     * <h1>Iipeikou(<i>IPK</i>)</h1>
     * <h2>Value</h2>
     * <p>{@link Rule#Menzen Menzen}: 1 han</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>Player must be {@link Rule#Menzen menzen}</li>
     *     <li>A pair of same {@link Rule#Mentsu shuntsu}</li>
     * </ul>
     *
     * @see Yaku#RPK
     */
    IPK,

    /**
     * <h1>Ikitsuukan/ittsuu(<i>ITT</i>)</h1>
     * <h2>Value</h2>
     * <p>{@link Rule#Menzen Menzen}: 2 han</p>
     * <p>{@link Rule#Fuuro Fuuro}: 1 han</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>Player must be {@link Rule#Menzen menzen}</li>
     *     <li>Have all of the {@link Rule#Tiles shuupai} in one suit</li>
     *     <li>{@link Rule#Mentsu Shuntsu} must form 123, 456, 789</li>
     * </ul>
     *
     * @see Yaku#SDJ
     * @see Yaku#HON
     * @see Yaku#CHN
     */
    ITT,

    /**
     * <h1>Yakuhai/Fanpai(<i>YAK</i>)</h1>
     * <h2>Value</h2>
     * <p>1 han per count</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>{@link Rule#Tiles Sangenpai}/{@link Rule#Tiles Bakaze}/{@link Rule#Tiles Jikaze} {@link Rule#Mentsu koutsu}</li>
     *     <li>{@link Rule#Tiles Otakaze} {@link Rule#Mentsu koutsu} is not allowed</li>
     * </ul>
     *
     * @see Group#SANGENPAI
     * @see Group#KAZEHAI
     */
    YAK,

    /**
     * <h1>Sanshoku Doujun/Sanshiki(<i>SDJ</i>)</h1>
     * <h2>Value</h2>
     * <p>{@link Rule#Menzen Menzen}: 2 han</p>
     * <p>{@link Rule#Fuuro Fuuro}: 1 han</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>Three {@link Rule#Mentsu shuntsu} with same {@link Rule#Tiles shuupai}</li>
     *     <li>Each of {@link Rule#Mentsu shuntsu} must across {@link Group#MAN manzu}/{@link Group#PIN pinzu}/{@link Group#SOU souzu}</li>
     * </ul>
     *
     * @see Yaku#ITT
     * @see Group#MAN
     * @see Group#PIN
     * @see Group#SOU
     */
    SDJ,

    /**
     * <h1>Sanshoku Doukou(<i>SDO</i>)</h1>
     * <h2>Value</h2>
     * <p>2 han</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>Three {@link Rule#Mentsu koutsu} with same {@link Rule#Tiles shuupai}</li>
     *     <li>Each of {@link Rule#Mentsu koutsu} must across {@link Group#MAN manzu}/{@link Group#PIN pinzu}/{@link Group#SOU souzu}</li>
     * </ul>
     *
     * @see Yaku#SDJ
     * @see Group#MAN
     * @see Group#PIN
     * @see Group#SOU
     */
    SDO,

    /**
     * <h1>Toitoihou/ToiToi(<i>TOI</i>)</h1>
     * <h2>Value</h2>
     * <p>2 han</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>Four {@link Rule#Mentsu koutsu}</li>
     * </ul>
     *
     * @see Yaku#SNA
     * @see Yaku#SUA
     */
    TOI,

    /**
     * <h1>Sanankou(<i>SNA</i>)</h1>
     * <h2>Value</h2>
     * <p>2 han</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>Three {@link Rule#Mentsu ankou}</li>
     * </ul>
     *
     * @see Yaku#TOI
     */
    SNA,

    /**
     * <h1>Sankantsu(<i>SNK</i>)</h1>
     * <h2>Value</h2>
     * <p>2 han</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>Three {@link Rule#Mentsu kan}</li>
     * </ul>
     *
     * @see Yaku#TOI
     * @see Yaku#SNA
     */
    SNK,

    /**
     * <h1>Chanta/Honchantai Yaochuu(<i>CHA</i>)</h1>
     * <h2>Value</h2>
     * <p>{@link Rule#Menzen Menzen}: 2 han</p>
     * <p>{@link Rule#Fuuro Fuuro}: 1 han</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>All {@link Rule#Mentsu mentsu} and {@link Rule#Mentsu toitsu}/{@link Rule#Mentsu jantou} inclued {@link Rule#Tiles yaochuuhai}</li>
     * </ul>
     *
     * @see Yaku#JUN
     */
    CHA,

    /**
     * <h1>Junchan/Junchantai Yaochuu(<i>JUN</i>)</h1>
     * <h2>Value</h2>
     * <p>{@link Rule#Menzen Menzen}: 3 han</p>
     * <p>{@link Rule#Fuuro Fuuro}: 2 han</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>All {@link Rule#Mentsu mentsu} and {@link Rule#Mentsu toitsu}/{@link Rule#Mentsu jantou} inclued {@link Rule#Tiles routouhai}</li>
     * </ul>
     *
     * @see Yaku#CHA
     */
    JUN,

    /**
     * <h1>Ryanpeikou(<i>RPK</i>)</h1>
     * <h2>Value</h2>
     * <p>{@link Rule#Menzen Menzen}: 3 han</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>Player must be {@link Rule#Menzen menzen}</li>
     *     <li>Double {@link Yaku#IPK iipeikou}</li>
     * </ul>
     *
     * @see Yaku#CHA
     */
    RPK,

    /**
     * <h1>Shousangen(<i>SSG</i>)</h1>
     * <h2>Value</h2>
     * <p>2 han</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>Two {@link Rule#Mentsu koutsu} and one {@link Rule#Mentsu jantou} with {@link Rule#Tiles Sangenpai}</li>
     * </ul>
     *
     * @see Group#SANGENPAI
     * @see Yaku#DSG
     */
    SSG,

    /**
     * <h1>Honroutou(<i>HRO</i>)</h1>
     * <h2>Value</h2>
     * <p>2 han</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>All tiles are {@link Rule#Tiles yaochuuhai}</li>
     * </ul>
     *
     * @see Yaku#CHI
     * @see Yaku#TOI
     */
    HRO,

    /**
     * <h1>Honiisou/Honistu(<i>HON</i>)</h1>
     * <h2>Value</h2>
     * <p>2 han</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>All tiles are {@link Rule#Tiles jihai} or single suit {@link Rule#Tiles shuupai}</li>
     *     <li>Require at least one {@link Rule#Tiles shuupai} {@link Rule#Mentsu mentsu} or {@link Rule#Mentsu jantou} </li>
     * </ul>
     *
     * @see Yaku#CHI
     * @see Yaku#TOI
     */
    HON,

    /**
     * <h1>Chiniisou/Chinitsu(<i>CHN</i>)</h1>
     * <h2>Value</h2>
     * <p>{@link Rule#Menzen Menzen}: 6 han</p>
     * <p>{@link Rule#Fuuro Fuuro}: 5 han</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>All tiles are single {@link Rule#Tiles shuupai}</li>
     * </ul>
     *
     * @see Yaku#CHU
     */
    CHN,

    /**
     * <h1>Chitoitsu/Chitoi(<i>CHI</i>)</h1>
     * <h2>Value</h2>
     * <p>{@link Rule#Menzen Menzen}: 2 han</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>Seven different {@link Rule#Mentsu toitsu}</li>
     * </ul>
     *
     * @see Yaku#TAN
     * @see Yaku#HRO
     * @see Yaku#HON
     * @see Yaku#CHN
     * @see Yaku#HAI
     * @see Yaku#HOU
     */
    CHI,

    /**
     * <h1>Rinshan Kaihou(<i>RIN</i>)</h1>
     * <h2>Value</h2>
     * <p>1 han</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>{@link Rule#Agari Agari} with {@link Rule#Tiles rinshanpai}</li>
     * </ul>
     *
     * @see Yaku
     */
    RIN,

    /**
     * <h1>Haitei Raoyue(<i>HAI</i>)</h1>
     * <h2>Value</h2>
     * <p>1 han</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>{@link Rule#Agari Agari} with {@link Rule#Tsumo tsumo} {@link Rule#Tiles haiteihai}</li>
     * </ul>
     * <h2>Haiteihai</h2>
     * <ul>
     *     <li>Very last tile can be {@link Rule#Tsumo} of {@link Rule#Yama haiyama}</li>
     * </ul>
     *
     * @see Yaku#HOU
     */
    HAI,

    /**
     * <h1>Houtei Raoyui(<i>HOU</i>)</h1>
     * <h2>Value</h2>
     * <p>1 han</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>{@link Rule#Agari Agari} with {@link Rule#Ron ron} {@link Rule#Tiles houteihai}</li>
     * </ul>
     * <h2>Houteihai</h2>
     * <ul>
     *     <li>Very last {@link Rule#Suteru suteru} tile</li>
     * </ul>
     *
     * @see Yaku#HAI
     */
    HOU,

    /**
     * <h1>Chankan(<i>CHK</i>)</h1>
     * <h2>Value</h2>
     * <p>1 han</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>{@link Rule#Ron Ron} {@link Rule#Mentsu kakan}</li>
     * </ul>
     *
     * @see Yaku
     */
    CHK,

    /**
     * <h1>Dora/Kandora(<i>DRA</i>)</h1>
     * <h2>Value</h2>
     * <p>1 han</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>The tiles after the dora hyoujihai</li>
     *     <li>{@link Rule#Tiles Shuupai}: 1>2>3>4>5>6>7>8>9>1</li>
     *     <li>{@link Rule#Tiles Kazehai}: East>South>West>North>East</li>
     *     <li>{@link Rule#Tiles Sangenpai}: White>Green>Red>White</li>
     *     <li>Dora can stack with other dora</li>
     * </ul>
     *
     * @see Yaku#URA
     * @see Yaku#AKA
     */
    DRA,

    /**
     * <h1>Uradora(<i>URA</i>)</h1>
     * <h2>Value</h2>
     * <p>1 han</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>Uradora hyoujihai open when {@link Yaku#RCH riichi}</li>
     *     <li>The tiles after the uradora hyoujihai</li>
     *     <li>Same as {@link Yaku#DRA dora}</li>
     *     <li>Dora can stack with other dora</li>
     * </ul>
     *
     * @see Yaku#DRA
     * @see Yaku#AKA
     */
    URA,

    /**
     * <h1>Akadora(<i>AKA</i>)</h1>
     * <h2>Value</h2>
     * <p>1 han</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>Specifically marked {@link Tile#MAN0 5man}, {@link Tile#PIN0 5pin}, {@link Tile#SOU0 5sou} red tile</li>
     *     <li>Dora can stack with other dora</li>
     * </ul>
     *
     * @see Yaku#URA
     * @see Yaku#AKA
     */
    AKA,

    // Yakuman!

    /**
     * <h1>Kokushi Musou(<i>KMU</i>)</h1>
     * <h2>Value</h2>
     * <p>Yakuman</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>One of each of {@link Rule#Tiles yaochuuhai} (13 tiles)</li>
     *     <li>One more any {@link Rule#Tiles yaochuuhai}</li>
     * </ul>
     * <h2>{@link Yaku#CHK Chankan}</h2>
     * <li>{@link Yaku#CHK Chankan} for {@link Rule#Mentsu ankan} is allowed</li>
     *
     * @see Yaku#CHK
     */
    KMU,

    /**
     * <h1>Daisangen(<i>DSG</i>)</h1>
     * <h2>Value</h2>
     * <p>Yakuman</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>Three {@link Rule#Mentsu koutsu} with {@link Rule#Tiles Sangenpai}</li>
     * </ul>
     *
     * @see Group#SANGENPAI
     * @see Yaku#SSG
     */
    DSG,

    /**
     * <h1>Suuankou(<i>SUA</i>)</h1>
     * <h2>Value</h2>
     * <p>{@link Rule#Menzen Menzen}: Yakuman</p>
     * <p>{@link Rule#Fuuro Fuuro}: {@link Yaku#TOI Toitoihou}</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>Player must be {@link Rule#Menzen menzen}</li>
     *     <li>Four {@link Rule#Mentsu ankou}</li>
     * </ul>
     * <h2>Warning for Yakuman when {@link Rule#Machi shanpon} machi</h2>
     * <ul>
     *     <li>{@link Rule#Mentsu Koutsu} with {@link Rule#Ron ron} is not {@link Rule#Mentsu ankou}</li>
     * </ul>
     *
     * @see Yaku#TOI
     * @see Yaku#SNA
     * @see Yaku#SUA1
     */
    SUA,

    /**
     * <h1>Shousuushii/Suushiihou(<i>SSS</i>)</h1>
     * <h2>Value</h2>
     * <p>Yakuman</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>Three {@link Rule#Mentsu koutsu} with {@link Rule#Tiles Kazehai}</li>
     *     <li>One {@link Rule#Mentsu jantou} with last {@link Rule#Tiles Kazehai}</li>
     * </ul>
     *
     * @see Group#KAZEHAI
     * @see Yaku#DSS
     */
    SSS,

    /**
     * <h1>Tsuuiisou(<i>TSU</i>)</h1>
     * <h2>Value</h2>
     * <p>Yakuman</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>All tiles are {@link Rule#Tiles jihai}</li>
     * </ul>
     *
     * @see Group#KAZEHAI
     * @see Yaku#DSS
     */
    TSU,

    /**
     * <h1>Ryuuiisou(<i>RYU</i>)</h1>
     * <h2>Value</h2>
     * <p>Yakuman</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>All tiles are {@link Tile#SOU2 2sou}, {@link Tile#SOU3 3sou}, {@link Tile#SOU4 4sou}, {@link Tile#SOU6 6sou}, {@link Tile#SOU8 8sou} and/or {@link Tile#GREEN hatsu}</li>
     * </ul>
     *
     * @see Group#KAZEHAI
     * @see Yaku#DSS
     */
    RYU,

    /**
     * <h1>Chinroutou(<i>CHR</i>)</h1>
     * <h2>Value</h2>
     * <p>Yakuman</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>All tiles are {@link Rule#Tiles routouhai}</li>
     * </ul>
     *
     * @see Yaku#HRO
     */
    CHR,

    /**
     * <h1>Chuuren Poutou(<i>CHU</i>)</h1>
     * <h2>Value</h2>
     * <p>{@link Rule#Menzen Menzen}: Double Yakuman</p>
     * <p>{@link Rule#Fuuro Fuuro}: {@link Yaku#CHN Chiniisou}</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>Player must be {@link Rule#Menzen menzen}</li>
     *     <li>1112345678999 for one suit {@link Rule#Tiles shuupai}</li>
     *     <li>One more any {@link Rule#Tiles shuupai} for the same suit </li>
     * </ul>
     *
     * @see Group#MAN
     * @see Group#PIN
     * @see Group#SOU
     * @see Yaku#HON
     * @see Yaku#CHU9
     */
    CHU,

    /**
     * <h1>Suukantsu(<i>SUK</i>)</h1>
     * <h2>Value</h2>
     * <p>Yakuman</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>Four {@link Rule#Mentsu kantsu}</li>
     * </ul>
     * <h2>{@link Rule#Ryuukyoku Ryuukyoku}</h2>
     * <li>When other players call {@link Rule#Kan kan}, it can cause {@link Rule#Ryuukyoku suukaikan}</li>
     *
     * @see Yaku#SUA
     */
    SUK,

    /**
     * <h1>Tenhou(<i>TEN</i>)</h1>
     * <h2>Value</h2>
     * <p>Yakuman</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>Player must be {@link Rule#Oya oya} and {@link Rule#Menzen menzen}</li>
     *     <li>{@link Rule#Tsumo Tsumohou} when first {@link Rule#Tsumo tsumo}</li>
     * </ul>
     *
     * @see Yaku#DRI
     */
    TEN,

    /**
     * <h1>Chiihou(<i>CHH</i>)</h1>
     * <h2>Value</h2>
     * <p>Yakuman</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>Player must be {@link Rule#Ko ko} and {@link Rule#Menzen menzen}</li>
     *     <li>{@link Rule#Tsumo Tsumohou} when first {@link Rule#Tsumo tsumo}</li>
     *     <li>No any {@link Rule#Fuuro fuuro} before {@link Rule#Tsumo tsumo}</li>
     * </ul>
     *
     * @see Yaku#DRI
     */
    CHH,

    // Double Yakuman!!

    /**
     * <h1>Kokushi Musou Juusan(13) Menmachi(<i>KMU13</i>)</h1>
     * <h2>Value</h2>
     * <p>Double Yakuman</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>{@link Rule#Tenpai Tenpai} with one of each of {@link Rule#Tiles yaochuuhai} (13 tiles)</li>
     *     <li>{@link Rule#Machi Machi} with any {@link Rule#Tiles yaochuuhai}</li>
     * </ul>
     * <h2>{@link Yaku#CHK Chankan}</h2>
     * <li>{@link Yaku#CHK Chankan} for {@link Rule#Mentsu ankan} is allowed</li>
     *
     * @see Yaku#KMU
     */
    KMU13,

    /**
     * <h1>Suuankou Tanki(<i>SUA1</i>)</h1>
     * <h2>Value</h2>
     * <p>{@link Rule#Menzen Menzen}: Double Yakuman</p>
     * <p>{@link Rule#Fuuro Fuuro}: {@link Yaku#TOI Toitoihou}</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>Player must be {@link Rule#Menzen menzen}</li>
     *     <li>Four {@link Rule#Mentsu ankou}</li>
     *     <li>{@link Rule#Machi Tanki machi}</li>
     * </ul>
     *
     * @see Yaku#SUA
     */
    SUA1,

    /**
     * <h1>Daisuushii/Suushiihou(<i>DSS</i>)</h1>
     * <h2>Value</h2>
     * <p>Double Yakuman</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>Four {@link Rule#Mentsu koutsu} with {@link Rule#Tiles Kazehai}</li>
     * </ul>
     *
     * @see Group#KAZEHAI
     * @see Yaku#SSS
     */
    DSS,

    /**
     * <h1>Junsei Chuuren Poutou(<i>CHU9</i>)</h1>
     * <h2>Value</h2>
     * <p>{@link Rule#Menzen Menzen}: Double Yakuman</p>
     * <p>{@link Rule#Fuuro Fuuro}: {@link Yaku#CHN Chiniisou}</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>Player must be {@link Rule#Menzen menzen}</li>
     *     <li>{@link Rule#Tenpai Tenpai} with 1112345678999 for one suit {@link Rule#Tiles shuupai}</li>
     *     <li>{@link Rule#Machi Machi} with any {@link Rule#Tiles shuupai} for the same suit </li>
     * </ul>
     *
     * @see Group#MAN
     * @see Group#PIN
     * @see Group#SOU
     * @see Yaku#CHU
     */
    CHU9,
    ;
//    public boolean
}

