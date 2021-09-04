package com.company.service.impl;

import com.company.service.inter.DifferentLettersNickGeneratorInter;
import org.springframework.stereotype.Service;

/**
 *
 * @author x
 */
@Service("oneletters")
public class OneLettersNickGeneratorImpl implements DifferentLettersNickGeneratorInter
{

    @Override
    public String generateNick(String name)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public char getCharacter(char c)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
