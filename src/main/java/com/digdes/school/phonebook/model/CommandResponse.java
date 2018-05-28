package com.digdes.school.phonebook.model;

public class CommandResponse<T> {

    private String originalCommand;
    private T responseData;
    private boolean success;
    private String error;


    public String getOriginalCommand() {
        return originalCommand;
    }

    public void setOriginalCommand(String originalCommand) {
        this.originalCommand = originalCommand;
    }

    public T getResponseData() {
        return responseData;
    }

    public void setResponseData(T responseData) {
        this.responseData = responseData;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public static final  CommandResponse createError(String error) {
        CommandResponse commandResponse = new CommandResponse();
        commandResponse.setSuccess(false);
        commandResponse.setError(error);
        return commandResponse;
    }
}
