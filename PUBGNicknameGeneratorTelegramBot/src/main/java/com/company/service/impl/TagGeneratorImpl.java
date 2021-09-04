package com.company.service.impl;

import com.company.service.inter.TagGeneratorInter;
import com.company.store.Symbols;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author x
 */
@Service
public class TagGeneratorImpl implements TagGeneratorInter
{

    private final String[] pairSymbols;
    private final char[] tagSymbols;
    
    private final Symbols symbol;

    public TagGeneratorImpl(Symbols symbol)
    {
        this.symbol = symbol;
        
        pairSymbols = symbol.getPairSymbols();
        tagSymbols = symbol.getClanTagSymbols();
    }
    
    @Override
    public List<String> generateTag(String tag)
    {
        List<String> tags = new ArrayList<>();
        
        for (String symb: pairSymbols)
            tags.add(symb.charAt(0) + tag + symb.charAt(1));
        
        for (char symb: tagSymbols)
            tags.add(tag + symb);
        
        tags.add(tag.toLowerCase());
        
        return tags;
    }
    
}
