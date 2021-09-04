/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.service.impl;

import com.company.service.inter.SymbolsNickGeneratorInter;
import com.company.store.Symbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author x
 */
@Service
public class SymbolsNickGeneratorImpl implements SymbolsNickGeneratorInter
{

    private final char[] symbols;
    private final String[] pairSymbols;
    
    private final Symbols symbol;

    public SymbolsNickGeneratorImpl(Symbols symbol)
    {
        this.symbol = symbol;
        
        symbols = symbol.getSymbols();
        pairSymbols = symbol.getPairSymbols();
    }
    
    @Override
    public List<String> generateNicks(String name, boolean changeCase)
    {
        String uppercaseName = null, lowercaseName = null, standardName = null;
        if (changeCase)
        {
            uppercaseName = name.toUpperCase();
            lowercaseName = name.toLowerCase();
            standardName = uppercaseName.charAt(0) + lowercaseName.substring(1, lowercaseName.length());
        }

        List<String> nicks = new ArrayList<>();

        for (char c : symbols)
            if (changeCase)
            {
                nicks.add(c + uppercaseName);
                nicks.add(c + lowercaseName);
                nicks.add(c + standardName);
            } else
                nicks.add(c + name);
        
        for (String str: pairSymbols)
        {
            if (changeCase)
            {
                nicks.add(str.charAt(0) + lowercaseName + str.charAt(1));
                nicks.add(str.charAt(0) + uppercaseName + str.charAt(1));
                nicks.add(str.charAt(0) + standardName + str.charAt(1));
            } else
                nicks.add(str.charAt(0) + name + str.charAt(1));
        }

        return nicks;
    }

    @Override
    public Character getRandomSymbol()
    {
        Random random = new Random();
        
        return symbols[random.nextInt()];
    }

    @Override
    public String getRandomPairSymbol()
    {
        Random random = new Random();
        
        return pairSymbols[random.nextInt()];
    }

}
