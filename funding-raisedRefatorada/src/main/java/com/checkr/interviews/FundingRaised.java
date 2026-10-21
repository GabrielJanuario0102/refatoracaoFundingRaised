package com.checkr.interviews;

import java.util.*;

import com.checkr.interviews.exceptions.NoSuchEntryException;
import com.checkr.interviews.repository.CsvFundingRaisedRepository;
import com.checkr.interviews.repository.FundingRaisedRepository;
import com.checkr.interviews.service.FundingRaisedService;
import java.io.IOException;

public class FundingRaised {

    public static List<Map<String, String>> where(Map<String, String> options) throws IOException {
        FundingRaisedRepository repository = new CsvFundingRaisedRepository("startup_funding.csv");
        FundingRaisedService service = new FundingRaisedService(repository);

        return service.where(options);
    }

    public static Map<String, String> findBy(Map<String, String> options) throws IOException, NoSuchEntryException {
        FundingRaisedRepository repository = new CsvFundingRaisedRepository("startup_funding.csv");
        FundingRaisedService service = new FundingRaisedService(repository);

        return service.findBy(options);
    }

    public static void main(String[] args){
        try {
            Map<String, String> options = new HashMap<String, String>();

            options.put("company_name", "Facebook");
            options.put("round", "a");

            String s = String.format(
                    "%s : %s\n%s : %s\nquantidade: %d",
                    "company_name", options.get("company_name"),
                    "round", options.get("round"),
                    options.size()
            );

            System.out.println(s);
        } catch(Exception e) {
            System.out.print(e.getMessage());
            System.out.print("error");
        }
    }
}
