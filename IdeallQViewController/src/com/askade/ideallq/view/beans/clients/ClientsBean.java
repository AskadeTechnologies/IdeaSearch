package com.askade.ideallq.view.beans.clients;

import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;

import oracle.adf.view.rich.context.AdfFacesContext;

import org.apache.myfaces.trinidad.util.ComponentReference;

public class ClientsBean {
    public ClientsBean() {
    }
    ComponentReference clientHeaderForm;
    ComponentReference clientIndividualForm;
    
    public RichPanelFormLayout getclientHeaderForm(){
        if(clientHeaderForm != null){
            return (RichPanelFormLayout) clientHeaderForm.getComponent();
        }
        return null;
    }
    
    public void setclientHeaderForm(RichPanelFormLayout clientHeaderForm){
        this.clientHeaderForm = ComponentReference.newUIComponentReference(clientHeaderForm);
    } 
    
    public RichPanelFormLayout getclientIndividualForm(){
        if(clientIndividualForm != null){
            return (RichPanelFormLayout) clientIndividualForm.getComponent();
        }
        return null;
    }
    
    public void setclientIndividualForm(RichPanelFormLayout clientIndividualForm){
        this.clientIndividualForm = ComponentReference.newUIComponentReference(clientIndividualForm);
    } 
    
    
    public void refreshClientForm() {
        AdfFacesContext.getCurrentInstance().addPartialTarget(getclientHeaderForm());
        AdfFacesContext.getCurrentInstance().addPartialTarget(getclientIndividualForm());
    }
}
