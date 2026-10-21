package com.checkr.interviews.repository;

import com.checkr.interviews.model.Company;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFundingRaisedRepository implements FundingRaisedRepository {
    private String path;

    public CsvFundingRaisedRepository(String path){
        this.path = path;
    }

    @Override
    public List<Company> getAll() throws IOException{
        List<Company> companies = new ArrayList<Company>();
        CSVReader reader = new CSVReader(new FileReader(path));
        String[] row = null;

        while((row = reader.readNext()) != null) {
            companies.add(Company.fromCSVROW(row));
        }

        reader.close();
        companies.remove(0);

        return companies;
    };


}
