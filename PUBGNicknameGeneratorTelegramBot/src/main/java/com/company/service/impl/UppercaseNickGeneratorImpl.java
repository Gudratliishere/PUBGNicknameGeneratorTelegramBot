package com.company.service.impl;

import com.company.service.inter.UppercaseNickGeneratorInter;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 *
 * @author x
 */
@Service()
public class UppercaseNickGeneratorImpl implements UppercaseNickGeneratorInter
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
    }

    @Override
    public String generateNick(String name)
    {
        name = name.toLowerCase();
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < name.length(); i++)
            sb.append(letters.get(name.charAt(i)));
        
        return sb.toString();
    }

}
