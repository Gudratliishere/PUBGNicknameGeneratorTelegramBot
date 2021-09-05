package com.company.service.impl;

import com.company.service.inter.DifferentLettersNickGeneratorInter;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 *
 * @author x
 */
@Service("reverseletters")
public class ReverseLettersNickGeneratorImpl implements DifferentLettersNickGeneratorInter
{

    private Map<Character, Character> letters;

    public ReverseLettersNickGeneratorImpl()
    {
        initLetters();
    }

    private void initLetters()
    {
        letters = new HashMap<>();
        letters.put('a', 'ɐ');
        letters.put('b', 'q');
        letters.put('c', 'ɔ');
        letters.put('d', 'p');
        letters.put('e', 'ǝ');
        letters.put('f', 'ɟ');
        letters.put('g', 'ɓ');
        letters.put('h', 'ɥ');
        letters.put('i', 'ı');
        letters.put('j', 'ɾ');
        letters.put('k', 'ʞ');
        letters.put('l', 'l');
        letters.put('m', 'ɯ');
        letters.put('n', 'u');
        letters.put('o', 'o');
        letters.put('p', 'Ԁ');
        letters.put('q', 'b');
        letters.put('r', 'ɹ');
        letters.put('s', 's');
        letters.put('t', 'ʇ');
        letters.put('u', 'n');
        letters.put('v', 'ʌ');
        letters.put('w', 'ʍ');
        letters.put('x', 'x');
        letters.put('y', 'ʎ');
        letters.put('z', 'z');
        letters.put(' ', 'Ī');
    }

    @Override
    public String generateNick(String name)
    {
        name = name.toLowerCase();
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = name.length() - 1; i >= 0; i--)
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
