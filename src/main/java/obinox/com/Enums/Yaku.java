package obinox.com.Enums;

import obinox.com.Mentsu.Kantsu;
import obinox.com.Mentsu.Koutsu;
import obinox.com.Mentsu.Mentsu;
import obinox.com.Mentsu.Shuntsu;
import obinox.com.Util.Agari;
import obinox.com.Util.Triplet;

import java.util.*;

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
    RCH(1, 0),

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
    DRI(2, 0),

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
    IPP(1, 0),

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
    SMO(1, 0),

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
    TAN(1, 1),

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
    PFU(1, 0),

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
    IPK(1, 0),

    /**
     * <h1>Ikitsuukan/ittsuu(<i>ITT</i>)</h1>
     * <h2>Value</h2>
     * <p>{@link Rule#Menzen Menzen}: 2 han</p>
     * <p>{@link Rule#Fuuro Fuuro}: 1 han</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>Have all of the {@link Rule#Tiles shuupai} in one suit</li>
     *     <li>{@link Rule#Mentsu Shuntsu} must form 123, 456, 789</li>
     * </ul>
     *
     * @see Yaku#SDJ
     * @see Yaku#HON
     * @see Yaku#CHN
     */
    ITT(2, 1),

    /**
     * <h1>Yakuhai/Fanpai(<i>YAK</i>)</h1>
     * <h2>Value</h2>
     * <p>1 han per count</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>{@link Group#SANGEN Sangenpai}/{@link Yaku#YAKB Bakaze}/{@link Yaku#YAKJ Jikaze} {@link Rule#Mentsu koutsu}</li>
     *     <li>{@link Rule#Tiles Otakaze} {@link Rule#Mentsu koutsu} is not allowed</li>
     * </ul>
     *
     * @see Group#SANGEN
     * @see Group#KAZE
     * @see Yaku#YAKB
     * @see Yaku#YAKJ
     * @see Yaku#YAKW
     * @see Yaku#YAKG
     * @see Yaku#YAKR
     */
    YAK(1, 1),

    /**
     * <h1>Yakuhai: Bakaze(<i>YAKB</i>)</h1>
     * <h2>Value</h2>
     * <p>1 han</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>Same {@link Group#KAZE kaze} tiles which as current round {@link Rule#Mentsu koutsu}</li>
     * </ul>
     *
     * @see Group#KAZE
     */
    YAKB(1, 1),

    /**
     * <h1>Yakuhai: Jikaze(<i>YAKJ</i>)</h1>
     * <h2>Value</h2>
     * <p>1 han</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>Same {@link Group#KAZE kaze} tiles which as current player {@link Rule#Mentsu koutsu}</li>
     * </ul>
     *
     * @see Group#KAZE
     */
    YAKJ(1, 1),

    /**
     * <h1>Yakuhai: Haku(<i>YAKW</i>)</h1>
     * <h2>Value</h2>
     * <p>1 han</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>{@link Tile#WHITE Haku} {@link Rule#Mentsu koutsu}</li>
     * </ul>
     *
     * @see Group#SANGEN
     * @see Tile#WHITE
     */
    YAKW(1, 1),

    /**
     * <h1>Yakuhai: Hatsu(<i>YAKG</i>)</h1>
     * <h2>Value</h2>
     * <p>1 han</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>{@link Tile#GREEN Hatsu} {@link Rule#Mentsu koutsu}</li>
     * </ul>
     *
     * @see Group#SANGEN
     * @see Tile#GREEN
     */
    YAKG(1, 1),

    /**
     * <h1>Yakuhai: Chun(<i>YAKR</i>)</h1>
     * <h2>Value</h2>
     * <p>1 han</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>{@link Tile#RED Chun} {@link Rule#Mentsu koutsu}</li>
     * </ul>
     *
     * @see Group#SANGEN
     * @see Tile#RED
     */
    YAKR(1, 1),

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
    SDJ(2, 1),

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
    SDO(2, 2),

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
    TOI(2, 2),

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
    SNA(2, 2),

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
    SNK(2, 2),

    /**
     * <h1>Chanta/Honchantai Yaochuu(<i>CHA</i>)</h1>
     * <h2>Value</h2>
     * <p>{@link Rule#Menzen Menzen}: 2 han</p>
     * <p>{@link Rule#Fuuro Fuuro}: 1 han</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>All {@link Rule#Mentsu mentsu} and {@link Rule#Mentsu toitsu}/{@link Rule#Mentsu jantou} inclued {@link Rule#Tiles yaochuuhai}</li>
     *     <li>Not all the tiles are {@link Rule#Tiles yaochuuhai}</li>
     * </ul>
     *
     * @see Yaku#JUN
     */
    CHA(2, 1),

    /**
     * <h1>Junchan/Junchantai Yaochuu(<i>JUN</i>)</h1>
     * <h2>Value</h2>
     * <p>{@link Rule#Menzen Menzen}: 3 han</p>
     * <p>{@link Rule#Fuuro Fuuro}: 2 han</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>All {@link Rule#Mentsu mentsu} and {@link Rule#Mentsu toitsu}/{@link Rule#Mentsu jantou} inclued {@link Rule#Tiles routouhai}</li>
     *     <li>Not all the tiles are {@link Rule#Tiles yaochuuhai}</li>
     * </ul>
     *
     * @see Yaku#CHA
     */
    JUN(3, 2),

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
    RPK(3, 0),

    /**
     * <h1>Shousangen(<i>SSG</i>)</h1>
     * <h2>Value</h2>
     * <p>2 han</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>Two {@link Rule#Mentsu koutsu} and one {@link Rule#Mentsu jantou} with {@link Rule#Tiles Sangenpai}</li>
     * </ul>
     *
     * @see Group#SANGEN
     * @see Yaku#DSG
     */
    SSG(2, 2),

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
    HRO(2, 2),

    /**
     * <h1>Honiisou/Honistu(<i>HON</i>)</h1>
     * <h2>Value</h2>
     * <p>{@link Rule#Menzen Menzen}: 3 han</p>
     * <p>{@link Rule#Fuuro Fuuro}: 2 han</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>All tiles are {@link Rule#Tiles jihai} or single suit {@link Rule#Tiles shuupai}</li>
     *     <li>Require at least one {@link Rule#Tiles shuupai} {@link Rule#Mentsu mentsu} or {@link Rule#Mentsu jantou} </li>
     * </ul>
     *
     * @see Yaku#CHI
     * @see Yaku#TOI
     */
    HON(3, 2),

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
    CHN(6, 5),

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
    CHI(2, 0),

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
    RIN(1, 1),

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
    HAI(1, 1),

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
    HOU(1, 1),

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
    CHK(1, 1),

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
    DRA(1, 1),

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
    URA(1, 1),

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
    AKA(1, 1),

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
    KMU(13, 13),

    /**
     * <h1>Daisangen(<i>DSG</i>)</h1>
     * <h2>Value</h2>
     * <p>Yakuman</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>Three {@link Rule#Mentsu koutsu} with {@link Rule#Tiles Sangenpai}</li>
     * </ul>
     *
     * @see Group#SANGEN
     * @see Yaku#SSG
     */
    DSG(13, 13),

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
    SUA(13, 0),

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
     * @see Group#KAZE
     * @see Yaku#DSS
     */
    SSS(13, 13),

    /**
     * <h1>Tsuuiisou(<i>TSU</i>)</h1>
     * <h2>Value</h2>
     * <p>Yakuman</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>All tiles are {@link Rule#Tiles jihai}</li>
     * </ul>
     *
     * @see Group#KAZE
     * @see Yaku#DSS
     */
    TSU(13, 13),

    /**
     * <h1>Ryuuiisou(<i>RYU</i>)</h1>
     * <h2>Value</h2>
     * <p>Yakuman</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>All tiles are {@link Tile#SOU2 2sou}, {@link Tile#SOU3 3sou}, {@link Tile#SOU4 4sou}, {@link Tile#SOU6 6sou}, {@link Tile#SOU8 8sou} and/or {@link Tile#GREEN hatsu}</li>
     * </ul>
     *
     * @see Group#KAZE
     * @see Yaku#DSS
     */
    RYU(13, 13),

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
    CHR(13, 13),

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
    CHU(13, 0),

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
    SUK(13, 13),

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
    TEN(13, 0),

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
    CHH(13, 0),

    // Double Yakuman!!

    /**
     * <h1>Kokushi Musou Juusan(13) Men Machi(<i>KMU13</i>)</h1>
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
    KMU13(26, 0),

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
    SUA1(26, 0),

    /**
     * <h1>Daisuushii/Suushiihou(<i>DSS</i>)</h1>
     * <h2>Value</h2>
     * <p>Double Yakuman</p>
     * <h2>Requirements</h2>
     * <ul>
     *     <li>Four {@link Rule#Mentsu koutsu} with {@link Rule#Tiles Kazehai}</li>
     * </ul>
     *
     * @see Group#KAZE
     * @see Yaku#SSS
     */
    DSS(26, 26),

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
    CHU9(26, 0),

    /**
     * <h1>No Yaku(<i>NOY</i>)</h1>
     */
    NOY(0, 0)
    ;
    public final int menzen;
    public final int fuuro;

    Yaku(int m, int f){
        this.menzen=m;
        this.fuuro=f;
    }


    public static List<Yaku> getYaku(Agari agari, Tile ba, Tile ji){

        List<Yaku> out = new ArrayList<>();
        List<Yaku> yakuman = new ArrayList<>();
        Map<Mentsu, Integer> mentsuCount;
        EnumMap<Group, Integer> groupCount;
        Map<Integer, Integer> intCount;
        Map<Integer, EnumMap<Group, Boolean>> intGroup;
        boolean b;
        int c;

        //SMO
        if (agari.menzen && agari.agaru == Agaru.TSUMO){
            out.add(SMO);
        }

        //TAN
        b = true;
        for (Mentsu m: agari.mentsu){
            b = b && IteratorGroup.isAllIn(IteratorGroup.CHUNCHANPAI, m.tiles);
        }
        if (b){
            out.add(TAN);
        }

        //PFU
        b = true;
        if (agari.menzen && (agari.machi == Machi.RYML || agari.machi == Machi.RYMH)){
            for (Mentsu m: agari.mentsu){
                if (m.tiles.length == 2){
                    b = b && m.tiles[0]!=ba && m.tiles[0]!=ji && !IteratorGroup.isAllIn(IteratorGroup.SANGENPAI, m.tiles);
                } else {
                    b = b && IteratorGroup.isAllIn(IteratorGroup.SHUUPAI, m.tiles);
                }
            }
        }
        if (b){
            out.add(PFU);
        }

        //IPK
        //RPK
        mentsuCount = new HashMap<>();
        c = 0;
        if (agari.menzen){
            for (Mentsu m: agari.mentsu){
                if (m.tsu == MentsuType.ANJUN){
                    mentsuCount.merge(m, 1, (v, p) -> v+1);
                }
            }
        }
        for (Mentsu m: mentsuCount.keySet()){
            if (mentsuCount.get(m)>=2){
                c++;
            }
        }
        switch (c) {
            case 1 -> out.add(IPK);
            case 2 -> out.add(RPK);
        }

        //ITT
        b = true;
        groupCount = new EnumMap<>(Group.class);
        for (Mentsu m: agari.mentsu){
            if (m.getClass() == Shuntsu.class){
                groupCount.merge(m.tiles[0].group, 1, (v, p) -> v+1);
            }
        }
        for (Group g: groupCount.keySet()){
            if (groupCount.get(g)>=3){
                Mentsu[] ittsuu = new Mentsu[]{null, null, null};
                for (Mentsu m: agari.mentsu){
                    if (m.getClass() == Shuntsu.class && m.tiles[0].group == g){
                        switch (m.tiles[0].value) {
                            case 1 -> ittsuu[0] = m;
                            case 4 -> ittsuu[1] = m;
                            case 7 -> ittsuu[2] = m;
                        }
                    }
                }
                for (Mentsu m: ittsuu){
                    b = b && m != null;
                }
            }
        }
        if (b){
            out.add(ITT);
        }

        //YAK
        for (Mentsu m: agari.mentsu){
            if (m.tiles.length >= 3){
                switch (m.tiles[0]) {
                    case EAST, SOUTH, WEST, NORTH -> {
                        if (m.tiles[0] == ba){
                            out.add(YAKB);
                        }
                        if (m.tiles[0] == ji){
                            out.add(YAKJ);
                        }
                    }
                    case WHITE -> out.add(YAKW);
                    case GREEN -> out.add(YAKG);
                    case RED -> out.add(YAKR);
                }
            }
        }

        //SDJ
        b = false;
        intGroup = new HashMap<>();
        for (Mentsu m: agari.mentsu){
            if (m.getClass() == Shuntsu.class){
                if (intGroup.get(m.tiles[0].value) == null){
                    intGroup.put(m.tiles[0].value, new EnumMap<>(Group.class));
                }
                intGroup.get(m.tiles[0].value).merge(m.tiles[0].group, true, (v1, v2) -> v1);
            }
        }
        for (int i: intGroup.keySet()){
            EnumMap<Group, Boolean> e;
            e = intGroup.get(i);
            b = b || (e.get(Group.MAN) != null && e.get(Group.PIN) != null && e.get(Group.SOU) != null);
        }
        if (b){
            out.add(SDJ);
        }

        //SDO
        b = false;
        intGroup = new HashMap<>();
        for (Mentsu m: agari.mentsu){
            if (m.getClass() == Koutsu.class || m.getClass() == Kantsu.class){
                if (intGroup.get(m.tiles[0].value) == null){
                    intGroup.put(m.tiles[0].value, new EnumMap<>(Group.class));
                }
                intGroup.get(m.tiles[0].value).merge(m.tiles[0].group, true, (v1, v2) -> v1);
            }
        }
        for (int i: intGroup.keySet()){
            EnumMap<Group, Boolean> e;
            e = intGroup.get(i);
            b = b || (e.get(Group.MAN) != null && e.get(Group.PIN) != null && e.get(Group.SOU) != null);
        }
        if (b){
            out.add(SDO);
        }

        //TOI
        c = 0;
        for (Mentsu m: agari.mentsu){
            if (m.getClass() == Koutsu.class || m.getClass() == Kantsu.class){
                c++;
            }
        }
        if (c == 4){
            out.add(TOI);
        }

        //SNA
        //SUA
        c = 0;
        for (Mentsu m: agari.mentsu){
            if (m.tsu == MentsuType.ANKOU || m.tsu == MentsuType.ANKAN){
                c++;
            }
        }
        if (c == 3){
            out.add(SNA);
        } else if (agari.menzen && c == 4) {
            if (agari.machi == Machi.TAN){
                yakuman.add(SUA1);
            } else {
                yakuman.add(SUA);
            }
        }

        //SNK
        //SUK
        c = 0;
        for (Mentsu m: agari.mentsu){
            if (m.getClass() == Kantsu.class){
                c++;
            }
        }
        if (c == 3){
            out.add(SNK);
        } else if (c == 4) {
            yakuman.add(SUK);
        }

        //CHA
        //JUN
        //HRO
        //CHR
        b = true;
        for (Mentsu m: agari.mentsu){
            b = b && IteratorGroup.isAllIn(IteratorGroup.ROUTOUHAI, m.tiles);
        }
        if (b){
            yakuman.add(CHR);
        } else {
            b = true;
            for (Mentsu m: agari.mentsu){
                b = b && IteratorGroup.isAllIn(IteratorGroup.YAOCHUUHAI, m.tiles);
            }
            if (b){
                out.add(HRO);
            } else {
                b = true;
                for (Mentsu m: agari.mentsu){
                    b = b && IteratorGroup.isAnyIn(IteratorGroup.ROUTOUHAI, m.tiles);
                }
                if (b){
                    out.add(JUN);
                } else {
                    b = true;
                    for (Mentsu m: agari.mentsu){
                        b = b && IteratorGroup.isAnyIn(IteratorGroup.YAOCHUUHAI, m.tiles);
                    }
                    if (b){
                        out.add(CHA);
                    }
                }
            }
        }

        //SSG
        //DSG
        c = 0;
        for (Mentsu m: agari.mentsu){
            if (IteratorGroup.isAllIn(IteratorGroup.SANGENPAI, m.tiles)){
                c += Math.min(m.tiles.length, 3);
            }
        }
        if (c == 8){
            out.add(SSG);
        } else if (c == 9){
            yakuman.add(DSG);
        }

        //HON
        //CHN
        //CHU
        //CHU13
        groupCount = new EnumMap<>(Group.class);
        intCount = new HashMap<>();
        c = 0;
        b = true;
        for (Mentsu m: agari.mentsu){
            groupCount.merge(m.tiles[0].group, 1, (v, p) -> v+1);
        }
        for (Group g: new Group[]{Group.MAN, Group.PIN, Group.SOU}){
            if (groupCount.get(g) != null){
                c++;
            }
        }
        if (c == 1){
            if (groupCount.size() == 1){
                out.add(CHN);
                if (agari.menzen){
                    int[] chu = {3,1,1,1,1,1,1,1,3};
                    for (Mentsu m: agari.mentsu){
                        for (Tile t: m.tiles){
                            intCount.merge(t.value, 1, (v, p) -> v+1);
                        }
                    }
                    for (int i=1; i<10; i++){
                        b = b && intCount.get(i) >= chu[i-1];
                    }
                    if (b){
                        for (int i=1; i<10; i++){
                            if (intCount.get(i) - chu[i-1] == 1){
                                if (agari.agaripai.value == i){
                                    yakuman.add(CHU9);
                                } else {
                                    yakuman.add(CHU);
                                }
                            }
                        }
                    }
                }
            } else {
                out.add(HON);
            }
        }


        //CHI
        if (agari.machi == Machi.CHI){
            out.add(CHI);
        }

        //KMU
        if (agari.machi == Machi.KMU){
            yakuman.add(KMU);
        }

        //KMU13
        if (agari.machi == Machi.KMU13){
            yakuman.add(KMU13);
        }


        //SSS
        //DSS
        c = 0;
        for (Mentsu m: agari.mentsu){
            if (IteratorGroup.isAllIn(IteratorGroup.KAZEHAI, m.tiles)){
                c+=Math.min(m.tiles.length, 3);
            }
        }
        if (c == 11){
            yakuman.add(SSS);
        } else if (c == 12){
            yakuman.add(DSS);
        }

        //RYU
        b = true;
        for (Mentsu m: agari.mentsu){
            b = b && IteratorGroup.isAllIn(IteratorGroup.MIDORIPAI, m.tiles);
        }
        if (b){
            yakuman.add(RYU);
        }

        //TSU
        b = true;
        for (Mentsu m: agari.mentsu){
            b = b && IteratorGroup.isAllIn(IteratorGroup.JIHAI, m.tiles);
        }
        if (b){
            yakuman.add(TSU);
        }



        //RCH
        //DRI
        //IPP
        //RIN
        //HAI
        //HOU
        //CHK



        //TEN
        //CHH
        if (yakuman.isEmpty()){
            return out;
        } else {
            return yakuman;
        }
    }
}

