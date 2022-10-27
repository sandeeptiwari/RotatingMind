package com.rotatingmind.guice.V3;

import java.util.ArrayList;
import java.util.List;

public class FetchWebService implements IFetchData {
    @Override
    public List<Object[]> fetchData() {
        List<Object[]> dataFromWebService = new ArrayList<Object[]>();
        //Logic to call Web Service and fetch the data and return it.
        return dataFromWebService;
    }
}
