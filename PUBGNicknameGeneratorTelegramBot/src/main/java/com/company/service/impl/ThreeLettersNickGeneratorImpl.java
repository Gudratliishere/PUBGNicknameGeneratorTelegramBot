package com.company.service.impl;

import com.company.service.inter.DifferentLettersNickGeneratorInter;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 *
 * @author x
 */
@Service("threeletters")
public class ThreeLettersNickGeneratorImpl implements DifferentLettersNickGeneratorInter
{

    private Map<Character, Character> letters;

    public ThreeLettersNickGeneratorImpl()
    {
        initLetters();
    }

    private void initLetters()
    {
        letters = new HashMap<>();
        letters.put('a', '卂');
        letters.put('b', '乃');
        letters.put('c', '匚');
        letters.put('d', '刀');
        letters.put('e', '乇');
        letters.put('f', '千');
        letters.put('g', 'ム');
        letters.put('h', '卄');
        letters.put('i', '工');
        letters.put('j', 'ﾌ');
        letters.put('k', 'Ｋ');
        letters.put('l', 'ㄥ');
        letters.put('m', '爪');
        letters.put('n', '几');
        letters.put('o', 'ㄖ');
        letters.put('p', 'ㄗ');
        letters.put('q', '卩');
        letters.put('r', '尺');
        letters.put('s', '丂');
        letters.put('t', 'ㄒ');
        letters.put('u', 'ㄩ');
        letters.put('v', '∨');
        letters.put('w', '山');
        letters.put('x', '乂');
        letters.put('y', 'ㄚ');
        letters.put('z', '乙');
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
