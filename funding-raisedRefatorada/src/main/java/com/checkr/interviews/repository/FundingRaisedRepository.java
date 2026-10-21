package com.checkr.interviews.repository;

import com.checkr.interviews.model.Company;

import java.io.IOException;
import java.util.List;

public interface FundingRaisedRepository{
    public List<Company> getAll() throws IOException;
}
