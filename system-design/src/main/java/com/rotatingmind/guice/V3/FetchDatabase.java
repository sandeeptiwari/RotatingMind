package com.rotatingmind.guice.V3;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FetchDatabase implements IFetchData {

    @Override
    public List<Object[]> fetchData() {
        List<Object[]> dataFromDB = new ArrayList<Object[]>();
        //Logic to call database, execute a query and fetch the data
        return dataFromDB;
    }
}
