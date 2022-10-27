package com.rotatingmind.guice.V3;

import java.util.List;

public class BalanceSheet {
    private IExportData exportDataObj= null;
    private IFetchData fetchDataObj= null;

    //Set the fetch data object from outside of this class.
    public void configureFetchData(IFetchData actualFetchDataObj){
        this.fetchDataObj = actualFetchDataObj;
    }
    //Set the export data object from outside of this class.
    public void configureExportData(IExportData actualExportDataObj){
        this.exportDataObj = actualExportDataObj;
    }

    public Object generateBalanceSheet() {
        List<Object[]> dataLst = fetchDataObj.fetchData();
        return exportDataObj.exportData(dataLst);
    }
}
