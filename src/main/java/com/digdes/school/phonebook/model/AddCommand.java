package com.digdes.school.phonebook.model;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AddCommand extends Command {

    private Person person;

    private String[] parameterNames = new String[] {
            "Person id: ",
            "First name: ",
            "Last name: ",
            "Middle name: ",
            "Birth date: ",
            "Phone number: "
    };

    @Override
    public CommandResponse execute() {
        CommandResponse response = new CommandResponse();
        Person p = new Person();
        p.setId(Long.parseLong(parameters.get(0)));
        p.setFirstName(parameters.get(1));
        p.setLastName(parameters.get(2));
        p.setMiddleName(parameters.get(3));
        //DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        try {
            p.setDateBirth(sdf.parse(parameters.get(4)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        p.setPhoneNumber(parameters.get(5));
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(getStorePath(), true);
            StatefulBeanToCsv<Person> beanToCsv = new StatefulBeanToCsvBuilder(fileWriter)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .build();
            beanToCsv.write(p);
            fileWriter.flush();
            fileWriter.close();
            response.setSuccess(true);
            response.setResponseData("New person created!");
        } catch (IOException e) {
            e.printStackTrace();
            response.setError(e.getMessage());
        } catch (CsvRequiredFieldEmptyException e) {
            e.printStackTrace();
            response.setError(e.getMessage());
        } catch (CsvDataTypeMismatchException e) {
            e.printStackTrace();
            response.setError(e.getMessage());
        }

        return response;
    }

    @Override
    protected String[] getParameterNames() {
        return parameterNames;
    }

}
