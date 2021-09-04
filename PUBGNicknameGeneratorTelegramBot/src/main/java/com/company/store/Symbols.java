package com.company.store;

import org.springframework.stereotype.Component;

/**
 *
 * @author x
 */
@Component
public class Symbols
{

    private final char[] symbols =
    {
        '〆', '乇', '乡', 'ツ', 'į', 'び', '又', '太', 'ム', 'क', '山', '彡', '๏', '卄', '么', '交', '・', '々'
    };
    private final String[] pairSymbols =
    {
        "〖〗", "｟｠", "「」", "≪≫", "⪻⪼", "◥◤", "୧୨", "⪑⪒", "⪓⪔", "༺༻", "☽☾", "『』", "﹄﹃",
        "⸔⸕", "⫷⫸", "∉∌", "⩻⩼", "⪨⪩", "⁅⁆", "⋉⋊", "⧼⧽", "⦃⦄", "⦅⦆", "⦇⦈", "⦉⦊", "【】", "❴❵", "【】",
        "《》", "〖〗"
    };
    private final char[] clanTagSymbols =
    {
        '๛', '๖', '乛', '卐', 'ツ', '彡', '๏', '・'
    };

    public char[] getSymbols()
    {
        return symbols;
    }

    public String[] getPairSymbols()
    {
        return pairSymbols;
    }

    public char[] getClanTagSymbols()
    {
        return clanTagSymbols;
    }
}
