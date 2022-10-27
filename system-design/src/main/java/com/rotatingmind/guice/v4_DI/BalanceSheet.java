package com.rotatingmind.guice.v4_DI;

import com.rotatingmind.guice.V3.IExportData;
import com.rotatingmind.guice.V3.IFetchData;

import java.util.List;

public class BalanceSheet {
    private IExportData exportDataObj= null;
    private IFetchData fetchDataObj= null;

    //All dependencies are injected from client's constructor
    BalanceSheet(IFetchData fetchData, IExportData exportData){
        this.fetchDataObj = fetchData;
        this.exportDataObj = exportData;
    }

    public Object generateBalanceSheet(){
        List<Object[]> dataLst = fetchDataObj.fetchData();
        return exportDataObj.exportData(dataLst);
    }
}
