/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.service.impl;

import com.company.service.inter.DifferentLettersNickGeneratorInter;
import com.company.service.inter.NameGeneratorInter;
import com.company.service.inter.SymbolsNickGeneratorInter;
import com.company.service.inter.TagGeneratorInter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author x
 */
@Service
public class NameGeneratorImpl implements NameGeneratorInter
{

    @Autowired
    @Qualifier("uppercase")
    DifferentLettersNickGeneratorInter uppercaseNickGenerator;

    @Autowired
    @Qualifier("lowercase")
    DifferentLettersNickGeneratorInter lowercaseNickGenerator;

    @Autowired
    SymbolsNickGeneratorInter symbolsNickGenerator;

    @Autowired
    TagGeneratorInter tagGenerator;

    @Override
    public List<String> getNicknames(String name)
    {
        List<String> nicks = new ArrayList<>();

        nicks.add(getUppercaseNickWithSpace(name));
        nicks.add(getLowercaseNickWithSpace(name));
        nicks.add(getUpperAndLowercaseNickWithSpace(name));

        getNickWithSymbols(name, true).forEach((nick) -> nicks.add(nick));
        getNickWithSymbols(getUppercaseNickWithSpace(name), false).forEach((nick) -> nicks.add(nick));
        getNickWithSymbols(getLowercaseNickWithSpace(name), false).forEach((nick) -> nicks.add(nick));
        getNickWithSymbols(getUpperAndLowercaseNickWithSpace(name), false).forEach((nick) -> nicks.add(nick));

        return nicks;
    }

    @Override
    public List<String> getNicknames(String name, String tag)
    {
        List<String> nicks = new ArrayList<>();

        getClanTag(tag).forEach((clanTag) ->
        {
            getNicksForClanTag(name).forEach((nick) -> nicks.add(clanTag + nick));
        });

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
        return lowercaseNickGenerator.generateNick(name);
    }

    @Override
    public String getUpperAndLowercaseNickWithSpace(String name)
    {
        StringBuilder sb = new StringBuilder();

        sb.append(uppercaseNickGenerator.getCharacter(name.charAt(0)));
        for (int i = 1; i < name.length(); i++)
            sb.append(lowercaseNickGenerator.getCharacter(name.charAt(i)));

        return sb.toString();
    }

    @Override
    public List<String> getNickWithSymbols(String name, boolean changeCase)
    {
        return symbolsNickGenerator.generateNicks(name, changeCase);
    }

    @Override
    public List<String> getClanTag(String tag)
    {
        return tagGenerator.generateTag(tag);
    }

    @Override
    public List<String> getNicksForClanTag(String name)
    {
        List<String> nicks = new ArrayList<>();

        boolean existLetter = false;

        for (int i = 0; i < name.length(); i++)
            if (Character.isLetter(name.charAt(i)))
                existLetter = true;

        if (existLetter)
        {
            nicks.add(name.toUpperCase());
            nicks.add(name.toUpperCase());
            nicks.add(name.toUpperCase().charAt(0) + name.toLowerCase().substring(1));
        } else
            nicks.add(name);

        return nicks;
    }

}
