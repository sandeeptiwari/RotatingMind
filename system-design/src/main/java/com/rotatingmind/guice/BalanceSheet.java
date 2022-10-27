package com.rotatingmind.guice;

import java.util.List;

public class BalanceSheet {
    private ExportHTML exportHTML = new ExportHTML();
    private FetchDatabase fetchDatabase = new FetchDatabase();

    public void generateBalanceSheet() {
        List<Object[]> dataFromDB =
                fetchDatabase.fetchDataFromDatabase();
        exportHTML.exportToHTML(dataFromDB);
    }

}
