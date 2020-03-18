package com.eci.cosw.springbootsecureapi.model;

/**
 * @author Amalia Alfonso.
 */
public class Task{
    private String taskId;
    private String description;
    private String userId;
    private String status;
    private String dueDate;

    public Task(String taskId, String description, String userId, String status, String dueDate){
        this.taskId=taskId;
        this.description=description;
        this.userId=userId;
        this.status=status;
        this.dueDate=dueDate;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getDescription() {
        return description;
    }

    public String getUserId() {
        return userId;
    }

    public String getStatus() {
        return status;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
} 