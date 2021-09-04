package com.company.service.impl;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.company.service.inter.DifferentLettersNickGeneratorInter;

/**
 *
 * @author x
 */
@Service("uppercase")
public class UppercaseNickGeneratorImpl implements DifferentLettersNickGeneratorInter
{

    private Map<Character, Character> letters;

    public UppercaseNickGeneratorImpl()
    {
        initLetters();
    }

    private void initLetters()
    {
        letters = new HashMap<>();
        letters.put('a', 'Ａ');
        letters.put('b', 'Ｂ');
        letters.put('c', 'Ｃ');
        letters.put('d', 'Ｄ');
        letters.put('e', 'Ｅ');
        letters.put('f', 'Ｆ');
        letters.put('g', 'Ｇ');
        letters.put('h', 'Ｈ');
        letters.put('i', 'Ｉ');
        letters.put('j', 'Ｊ');
        letters.put('k', 'Ｋ');
        letters.put('l', 'Ｌ');
        letters.put('m', 'Ｍ');
        letters.put('n', 'Ｎ');
        letters.put('o', 'Ｏ');
        letters.put('p', 'Ｐ');
        letters.put('q', 'Ｑ');
        letters.put('r', 'Ｒ');
        letters.put('s', 'Ｓ');
        letters.put('t', 'Ｔ');
        letters.put('u', 'Ｕ');
        letters.put('v', 'Ｖ');
        letters.put('w', 'Ｗ');
        letters.put('x', 'Ｘ');
        letters.put('y', 'Ｙ');
        letters.put('z', 'Ｚ');
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
