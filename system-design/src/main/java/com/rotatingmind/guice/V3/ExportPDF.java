package com.rotatingmind.guice.V3;

import java.io.File;
import java.util.List;

public class ExportPDF implements IExportData {
    @Override
    public File exportData(List<Object[]> listData) {
        File pdfFile = null;
        //Logic to iterate the listData and generate PDF file
        return pdfFile;
    }
}
