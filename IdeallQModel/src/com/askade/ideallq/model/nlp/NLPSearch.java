package com.askade.ideallq.model.nlp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.xml.stream.XMLStreamException;

/**
 *
 * @author mcealera
 */
public class NLPSearch {
    
    public static Set getSearchItems(String text) throws FileNotFoundException, IOException, XMLStreamException{
    
    //List<String> whitelist = NLPUtils.getWords(NLPConfig.getConfigParameter("NLP_WHITELIST"));
    
    List<String> criticalSentences = new ArrayList();
    Set<String> finalSearchItems = new HashSet<String>();
    
    List<String> whitelist = new ArrayList();
    whitelist.add("problem");
    whitelist.add("test");

      System.out.println("in nlpsearch");
     
      String sentences[] = NLPUtils.findSentences(text);
    for(String sentence:sentences){
        System.out.println(sentence);
        for(String s:whitelist){
            if(sentence.contains(s)){
                  System.out.println("found critical item: "+s);
                  criticalSentences.add(sentence);
                  
            }
        }
    }
    
    System.out.println("Critical sentences: ");
    System.out.println(criticalSentences);
    
    for(String s:criticalSentences){
        finalSearchItems.addAll(NLPUtils.getNouns(NLPUtils.posTest(s)));
    }
    
    System.out.println("Final Search Items: ");
    finalSearchItems.remove("");
    System.out.println(finalSearchItems);
    
   
    
    return finalSearchItems;
    
    }
      
     //Returns a Set of strings representing the key items extracted from the user sentence.
     //Example:
     //NLPSearch.getSearchItemsRemap("This is a test");
    
     public static Set getSearchItemsRemap(String text) throws FileNotFoundException, IOException, XMLStreamException{
    
    
    List<String> criticalSentences = new ArrayList();
    Set<String> finalSearchItems = new HashSet<String>();
    
    List<String> whitelist = new ArrayList();
    whitelist.add("problem");
    whitelist.add("test");

        System.out.println("in nlpsearch");
     
      String sentences[] = NLPUtils.findSentences(text);
    for(String sentence:sentences){

        finalSearchItems.addAll(NLPUtils.getNouns(NLPUtils.posTest(sentence)));
    }
    
    System.out.println("Final Search Items: ");
    finalSearchItems.remove("");
    System.out.println(finalSearchItems);
    
   
    
    return finalSearchItems;
    
    }
    
}
