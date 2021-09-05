package com.company.service.impl;

import com.company.service.inter.DifferentLettersNickGeneratorInter;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 *
 * @author x
 */
@Service("twoletters")
public class TwoLettersNickGeneratorImpl implements DifferentLettersNickGeneratorInter
{

    private Map<Character, Character> letters;

    public TwoLettersNickGeneratorImpl()
    {
        initLetters();
    }

    private void initLetters()
    {
        letters = new HashMap<>();
        letters.put('a', '₳');
        letters.put('b', '฿');
        letters.put('c', '₵');
        letters.put('d', 'Đ');
        letters.put('e', 'Ɇ');
        letters.put('f', '₣');
        letters.put('g', '₲');
        letters.put('h', 'Ⱨ');
        letters.put('i', 'ł');
        letters.put('j', 'J');
        letters.put('k', '₭');
        letters.put('l', 'Ⱡ');
        letters.put('m', '₥');
        letters.put('n', '₦');
        letters.put('o', 'Ø');
        letters.put('p', '₱');
        letters.put('q', 'Q');
        letters.put('r', 'Ɽ');
        letters.put('s', '₴');
        letters.put('t', '₮');
        letters.put('u', 'Ʉ');
        letters.put('v', 'V');
        letters.put('w', '₩');
        letters.put('x', 'Ӿ');
        letters.put('y', 'Ɏ');
        letters.put('z', 'Ⱬ');
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
