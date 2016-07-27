package com.askade.ideallq.view.beans;

import java.io.Serializable;

import oracle.adf.controller.TaskFlowId;

public class DynamicRegion implements Serializable {
    private String taskFlowId =
        "/WEB-INF/taskflows/applicationManagement/ApplicationManagementTF.xml#ApplicationManagementTF";

    public DynamicRegion() {
    }

    public TaskFlowId getDynamicTaskFlowId() {
        return TaskFlowId.parse(taskFlowId);
    }

    public void setDynamicTaskFlowId(String taskFlowId) {
        this.taskFlowId = taskFlowId;
    }

    public String applicationManagementTF() {
        setDynamicTaskFlowId("/WEB-INF/taskflows/applicationManagement/ApplicationManagementTF.xml#ApplicationManagementTF");
        return null;
    }

    public String clientManagementTFxml() {
        setDynamicTaskFlowId("/WEB-INF/taskflows/clientManagement/ClientManagementTFxml.xml#ClientManagementTFxml");
        return null;
    }
}
