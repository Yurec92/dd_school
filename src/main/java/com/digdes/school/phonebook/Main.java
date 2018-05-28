package com.digdes.school.phonebook;

import com.digdes.school.phonebook.controller.CommandFactory;
import com.digdes.school.phonebook.model.Command;
import com.digdes.school.phonebook.model.CommandResponse;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter command: ");
            String next = sc.nextLine();
            Command command = CommandFactory.createCommand(next);
            if (command != null) {
                int i = 0;
                while (command.needMoreParameters()) {
                    System.out.println(command.getParameterName(i));
                    String parameter = sc.next();
                    command.addParameter(parameter);
                    ++i;
                }
                CommandResponse executeResult = command.execute();
                if (executeResult.isSuccess()) {
                    System.out.println(executeResult.getResponseData());
                } else {
                    System.out.println(executeResult.getError());
                }

            }
        }
    }
}
