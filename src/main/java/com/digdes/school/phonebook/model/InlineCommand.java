package com.digdes.school.phonebook.model;

import java.util.Arrays;

public abstract class InlineCommand extends Command {

    public InlineCommand(String originalCommand) {
        this.originalCommand = originalCommand;
        if(this.originalCommand != null) {
            String[] commandParts = originalCommand.trim().replaceAll(" +", " ").split(" ");
            Arrays.stream(commandParts).skip(1).forEach(c->{
                addParameter(c);
            });
        }
    }

    @Override
    protected String[] getParameterNames() {
        return new String[0];
    }
}
