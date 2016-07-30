package com.askade.ideallq.resources;

import com.askade.ideallq.model.service.IdealQAMImpl;

import oracle.jbo.client.Configuration;

public class IdeallQAMController {
    public IdeallQAMController() {
        super();
    }
    
    
    public IdealQAMImpl getIveloModule(){
        return (IdealQAMImpl) Configuration.createRootApplicationModule("com.askade.ideallq.service.IdealQAM","IdealQAMLocal");   
    }
    
    public void commitIveloChanges(IdealQAMImpl iveloAM){
        iveloAM.getTransaction().commit();
    }
    
    public void rollbackIveloChanges(IdealQAMImpl iveloAM){
        iveloAM.getTransaction().rollback();
    }
    
    public void closeIveloModule(IdealQAMImpl iveloAM){
        if(iveloAM != null){
            Configuration.releaseRootApplicationModule(iveloAM, true);
        }
    }
    
}
