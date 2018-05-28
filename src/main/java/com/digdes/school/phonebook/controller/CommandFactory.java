package com.digdes.school.phonebook.controller;

import com.digdes.school.phonebook.model.*;

public class CommandFactory {


    public static Command createCommand(String commandStr) {
        String[] commandParts = commandStr.trim().replaceAll(" +", " ").split(" ");
        if(ConvertCommand.NAME.equalsIgnoreCase(commandParts[0])) {
            return new ConvertCommand();
        } else if("exit".equalsIgnoreCase(commandParts[0])) {
            return new ExitCommand();
        } else if("add".equalsIgnoreCase(commandParts[0])) {
            return new AddCommand();
        } else if("open".equalsIgnoreCase(commandParts[0])) {
            return new OpenCommand(commandStr);
        } else if("list".equalsIgnoreCase(commandParts[0])) {
            return new ListCommand();
        }
        return null;
    }
}
