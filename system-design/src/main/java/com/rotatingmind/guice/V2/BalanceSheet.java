package com.rotatingmind.guice.V2;

import com.rotatingmind.guice.ExportHTML;
import com.rotatingmind.guice.ExportPDF;
import com.rotatingmind.guice.FetchDatabase;
import com.rotatingmind.guice.FetchWebService;

import java.util.List;

public class BalanceSheet {
    private ExportHTML exportHTML = null;
    private FetchDatabase fetchDatabase = null;
    private ExportPDF exportPDF = null;
    private FetchWebService fetchWebService = null;

    public void generateBalanceSheet(int inputMethod, int outputMethod){

        //1. Instantiate the low level module object.
        if(inputMethod == 1){
            fetchDatabase = new FetchDatabase();
        }else if(inputMethod == 2){
            fetchWebService = new FetchWebService();
        }

        //2. fetch and export the data for specific format based on flags.
        if(outputMethod == 1){
            List<Object[]> dataLst = null;
            if(inputMethod == 1){
                dataLst = fetchDatabase.fetchDataFromDatabase();
            }else{
                dataLst = fetchWebService.fetchDataFromWebService();
            }
            exportHTML.exportToHTML(dataLst);
        }else if(outputMethod ==2){
            List<Object[]> dataLst = null;
            if(inputMethod == 1){
                dataLst = fetchDatabase.fetchDataFromDatabase();
            }else{
                dataLst = fetchWebService.fetchDataFromWebService();
            }
            exportPDF.exportToPDF(dataLst);
        }

    }

}
