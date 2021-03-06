package com.company.service.impl;

import com.company.service.inter.DifferentLettersNickGeneratorInter;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 *
 * @author x
 */
@Service("oneletters")
public class OneLettersNickGeneratorImpl implements DifferentLettersNickGeneratorInter
{

    private Map<Character, Character> letters;

    public OneLettersNickGeneratorImpl()
    {
        initLetters();
    }

    private void initLetters()
    {
        letters = new HashMap<>();
        letters.put('a', 'α');
        letters.put('b', 'в');
        letters.put('c', '¢');
        letters.put('d', '∂');
        letters.put('e', 'є');
        letters.put('f', 'ƒ');
        letters.put('g', 'g');
        letters.put('h', 'н');
        letters.put('i', 'ι');
        letters.put('j', 'נ');
        letters.put('k', 'к');
        letters.put('l', 'ℓ');
        letters.put('m', 'м');
        letters.put('n', 'η');
        letters.put('o', 'σ');
        letters.put('p', 'ρ');
        letters.put('q', 'q');
        letters.put('r', 'я');
        letters.put('s', 'ѕ');
        letters.put('t', 'т');
        letters.put('u', 'υ');
        letters.put('v', 'ν');
        letters.put('w', 'ω');
        letters.put('x', 'χ');
        letters.put('y', 'у');
        letters.put('z', 'z');
        letters.put(' ', 'Ī');
    }

    @Override
    public String generateNick(String name)
    {
        name = name.toLowerCase();
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < name.length(); i++)
        {
            Character c = letters.get(name.charAt(i));
            
            if (c != null)
                sb.append(c);
            else
                sb.append(name.charAt(i));
        }
        
        return sb.toString();
    }

    @Override
    public char getCharacter(char c)
    {
        return letters.get(c) != null ? letters.get(c) : c;
    }

}
