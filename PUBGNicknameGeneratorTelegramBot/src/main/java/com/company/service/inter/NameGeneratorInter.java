package com.company.service.inter;

import java.util.List;

/**
 *
 * @author x
 */
public interface NameGeneratorInter
{
    List<String> getNicknames(String name);
    
    List<String> getNicknames(String name, String tag);
    
    String getUppercaseNickWithSpace (String name);
    
    String getLowercaseNickWithSpace (String name);
    
    String getUpperAndLowercaseNickWithSpace (String name);
    
    String getOneLettersNick (String name);
    
    String getTwoLettersNick (String name);
    
    String getThreeLettersNick (String name);
    
    String getReverseLettersNick (String name);
    
    List<String> getNickWithSymbols (String name, boolean changeCase);
    
    List<String> getClanTag (String tag);
    
    List<String> getNicksForClanTag (String name);
}
