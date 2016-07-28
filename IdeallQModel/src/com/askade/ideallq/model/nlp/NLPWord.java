/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.askade.ideallq.model.nlp;

/**
 *
 * @author mcealera
 */
public class NLPWord {
    
    String partOfSpeech = "";
    String word = "";
    
    NLPWord(String word, String pos){
        this.word = word;
        this.partOfSpeech = pos;
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
   
    
}
