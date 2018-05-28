package com.digdes.school.phonebook.model;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ListCommand extends InlineCommand {


    public ListCommand() {
        super(null);
    }

    @Override
    public CommandResponse execute() {
        CommandResponse response = new CommandResponse();
        Reader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get(getStorePath()));
            CsvToBean<Person> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(Person.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            List<Person> persons = csvToBean.parse();
            StringBuilder sb = new StringBuilder();
            persons.forEach(p->{
                    sb.append(p.getId()).append("\t")
                            .append(p.getLastName()).append("\t")
                            .append(p.getFirstName()).append("\t")
                            .append(p.getMiddleName()).append("\t")
                            .append(p.getDateBirth()).append("\t")
                            .append(p.getPhoneNumber()).append("\t")
                    .append(System.getProperty("line.separator"));
            });
            response.setSuccess(true);
            response.setResponseData(sb.toString());
        } catch (IOException e) {
            response.setSuccess(false);
            response.setError(e.getMessage());
            e.printStackTrace();
        }

        return response;
    }

}
