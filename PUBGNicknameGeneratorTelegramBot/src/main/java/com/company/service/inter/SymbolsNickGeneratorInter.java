/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.service.inter;

import java.util.List;

/**
 *
 * @author x
 */
public interface SymbolsNickGeneratorInter
{

    List<String> generateNicks(String name, boolean changeCase);

    Character getRandomSymbol();

    String getRandomPairSymbol();
}
