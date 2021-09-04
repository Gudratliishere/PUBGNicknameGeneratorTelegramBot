package com.company.service.impl;

import com.company.service.inter.DifferentLettersNickGeneratorInter;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 *
 * @author x
 */
@Service("lowercase")
public class LowercaseNickGeneratorImpl implements DifferentLettersNickGeneratorInter
{

    private Map<Character, Character> letters;

    public LowercaseNickGeneratorImpl()
    {
        initLetters();
    }

    private void initLetters()
    {
        letters = new HashMap<>();
        letters.put('a', 'ａ');
        letters.put('b', 'ｂ');
        letters.put('c', 'ｃ');
        letters.put('d', 'ｄ');
        letters.put('e', 'ｅ');
        letters.put('f', 'ｆ');
        letters.put('g', 'ｇ');
        letters.put('h', 'ｈ');
        letters.put('i', 'ｉ');
        letters.put('j', 'ｊ');
        letters.put('k', 'ｋ');
        letters.put('l', 'ｌ');
        letters.put('m', 'ｍ');
        letters.put('n', 'ｎ');
        letters.put('o', 'ｏ');
        letters.put('p', 'ｐ');
        letters.put('q', 'ｑ');
        letters.put('r', 'ｒ');
        letters.put('s', 'ｓ');
        letters.put('t', 'ｔ');
        letters.put('u', 'ｕ');
        letters.put('v', 'ｖ');
        letters.put('w', 'ｗ');
        letters.put('x', 'ｘ');
        letters.put('y', 'ｙ');
        letters.put('z', 'ｚ');
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
