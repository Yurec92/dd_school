package com.digdes.school.phonebook.model;

import com.digdes.school.phonebook.config.StoreConfig;
import com.linuxense.javadbf.DBFReader;
import com.linuxense.javadbf.DBFRow;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class ConvertCommand extends Command {

    public static final String NAME = "convert";

    private String inputDbf;
    private String outputCsv;
    private String[] parameterNames = new String[]{
            "Dbf file path: ",
            "Csv file path: "
    };

    @Override
    public CommandResponse execute() {
        CommandResponse response = new CommandResponse();
        inputDbf = parameters.get(0);
        outputCsv = parameters.get(1);
        try {
            DBFReader reader = new DBFReader(new FileInputStream(inputDbf), Charset.forName("windows-1251"));
            DBFRow dbfRow = null;
            FileWriter fileWriter = new FileWriter(outputCsv);
            StatefulBeanToCsv<Person> beanToCsv = new StatefulBeanToCsvBuilder(fileWriter)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .build();
            List<Person> personList = new ArrayList<>();
            while ((dbfRow = reader.nextRow()) != null) {
                personList.add(dbfRowToPerson(dbfRow));
            }
            beanToCsv.write(personList);
            fileWriter.flush();
            fileWriter.close();
            StoreConfig.setStorePath(outputCsv);
            response.setSuccess(true);
            response.setResponseData("File successfully converted!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            response.setError(e.getLocalizedMessage());
        } catch (IOException e) {
            e.printStackTrace();
            response.setError(e.getLocalizedMessage());
        } catch (CsvRequiredFieldEmptyException e) {
            e.printStackTrace();
            response.setError(e.getLocalizedMessage());
        } catch (CsvDataTypeMismatchException e) {
            e.printStackTrace();
            response.setError(e.getLocalizedMessage());
        }
        return response;
    }


    @Override
    protected String[] getParameterNames() {
        return parameterNames;
    }

    private Person dbfRowToPerson(DBFRow row) {
        Person p = new Person();
        p.setId(row.getLong(Person.Cols.ID));
        p.setFirstName(row.getString(Person.Cols.FIRST_NAME));
        p.setLastName(row.getString(Person.Cols.LAST_NAME));
        p.setMiddleName(row.getString(Person.Cols.MIDDLE_NAME));
        p.setDateBirth(row.getDate(Person.Cols.DATE_BIRTH));
        p.setPhoneNumber(row.getString(Person.Cols.PHONE_NUMBER));
        return p;
    }
}
