package main;

import ParseUtil.ExcelFile;

public class App {

    public static final String FILE_NAME = "Open-Ended.xlsx";

    public static void main(String[] args) {

        ExcelFile excelFile = new ExcelFile(FILE_NAME);
        excelFile.parseExceltoJSON();

    }

}
