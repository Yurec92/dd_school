package com.digdes.school.phonebook.model;

public class ExitCommand extends InlineCommand {

    public ExitCommand() {
        super(null);
    }

    @Override
    public CommandResponse execute() {
        System.exit(0);
        return null;
    }
}
