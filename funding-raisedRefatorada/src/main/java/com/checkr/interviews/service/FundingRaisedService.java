package com.checkr.interviews.service;

import com.checkr.interviews.exceptions.NoSuchEntryException;
import com.checkr.interviews.model.Company;
import com.checkr.interviews.repository.FundingRaisedRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FundingRaisedService {
    private final FundingRaisedRepository repository;

    public FundingRaisedService(FundingRaisedRepository repository) {
        this.repository = repository;
    }

    public List<Map<String, String>> where(Map<String, String> options) throws IOException {
        List<Company> companies = repository.getAll();

        if (options.containsKey("company_name")) {
            List<Company> results = new ArrayList<>();

            for (Company c : companies) {
                if (c.getCompany_name().equals(options.get("company_name"))) {
                    results.add(c);
                }
            }
            companies = results;
        }

        if (options.containsKey("city")) {
            List<Company> results = new ArrayList<>();

            for (Company c : companies) {
                if (c.getCity().equals(options.get("city"))) {
                    results.add(c);
                }
            }
            companies = results;
        }

        if (options.containsKey("state")) {
            List<Company> results = new ArrayList<>();

            for (Company c : companies) {
                if (c.getState().equals(options.get("state"))) {
                    results.add(c);
                }
            }
            companies = results;
        }

        if (options.containsKey("round")) {
            List<Company> results = new ArrayList<>();

            for (Company c : companies) {
                if (c.getRound().equals(options.get("round"))) {
                    results.add(c);
                }
            }
            companies = results;
        }

        List<Map<String, String>> output = new ArrayList<>();

        for (Company c : companies) {
            Map<String, String> mapped = c.createMap();
            output.add(mapped);
        }

        return output;
    }

    public Map<String, String> findBy(Map<String, String> options) throws IOException, NoSuchEntryException {
        List<Company> companies = repository.getAll();

        for (Company c : companies) {
            if (options.containsKey("company_name")
                    && !c.getCompany_name().equals(
                    options.get("company_name"))) {
                continue;
            }

            if (options.containsKey("city")
                    && !c.getCity().equals(options.get("city"))) {
                continue;
            }

            if (options.containsKey("state")
                    && !c.getState().equals(options.get("state"))) {
                continue;
            }

            if (options.containsKey("round")
                    && !c.getRound().equals(options.get("round"))) {
                continue;
            }

            return c.createMap();
        }

        throw new NoSuchEntryException();
    }


}
