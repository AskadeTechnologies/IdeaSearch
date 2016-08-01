package com.askade.ideallq.resources;

import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class NLPBean {
    
    public Set<String> keyItems;
    
    public NLPBean(){}
    
    public NLPBean(Set<String> keyItems){
            this.keyItems = keyItems;
        }
    
    
}
