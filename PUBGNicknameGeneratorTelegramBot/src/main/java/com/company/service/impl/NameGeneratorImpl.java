/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.service.impl;

import com.company.service.inter.NameGeneratorInter;
import com.company.service.inter.UppercaseNickGeneratorInter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author x
 */
@Service
public class NameGeneratorImpl implements NameGeneratorInter
{

    @Autowired
    UppercaseNickGeneratorInter uppercaseNickGenerator;
    
    @Override
    public List<String> getNicknames(String name)
    {
        List<String> nicks = new ArrayList<>();

        nicks.add(getUppercaseNickWithSpace(name));
//        nicks.add(getLowercaseNickWithSpace(name));
//        nicks.add(getUpperAndLowercaseNickWithSpace(name));
//        
//        getNickWithSymbols(name).forEach((nick) -> nicks.add(nick));

        return nicks;
    }

    @Override
    public List<String> getNicknames(String name, String tag)
    {
        List<String> nicks = new ArrayList<>();
        
        getClanTag(tag).forEach((clanTag) -> nicks.add(clanTag + name));
        
        return nicks;
    }

    @Override
    public String getUppercaseNickWithSpace(String name)
    {
        return uppercaseNickGenerator.generateNick(name);
    }

    @Override
    public String getLowercaseNickWithSpace(String name)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getUpperAndLowercaseNickWithSpace(String name)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> getNickWithSymbols(String name)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> getClanTag(String tag)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
