package com.digdes.school.phonebook.model;

import com.digdes.school.phonebook.config.StoreConfig;

public class OpenCommand extends InlineCommand {


    public OpenCommand(String originalCommand) {
        super(originalCommand);
    }

    @Override
    public CommandResponse execute() {
        CommandResponse response = new CommandResponse();
        StoreConfig.setStorePath(parameters.get(0));
        response.setSuccess(true);
        response.setResponseData("Current store path: "+StoreConfig.getStorePath());
        return response;
    }
}
