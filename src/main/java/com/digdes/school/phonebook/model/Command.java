package com.digdes.school.phonebook.model;

import com.digdes.school.phonebook.config.StoreConfig;

import java.util.ArrayList;
import java.util.List;

public abstract class Command {

    protected String originalCommand;
    protected List<String> parameters = new ArrayList<>();

    public Command() {
    }

    public Command(String originalCommand) {
        this.originalCommand = originalCommand;
    }

    public abstract CommandResponse execute();

    public void addParameter(String param) {
        parameters.add(param);
    }

    public boolean needMoreParameters() {
        return getParameterNames() != null && parameters.size() < getParameterNames().length;
    }

    public String getParameterName(int i) {
        if (getParameterNames() != null) {
            return getParameterNames()[i];
        } else {
            return null;
        }

    }

    protected String getStorePath() {
        return StoreConfig.getStorePath();
    }

    protected abstract String[] getParameterNames();

}
