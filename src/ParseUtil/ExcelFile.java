package ParseUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.*;
import main.App;
//API needed for reading microsoft documents
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//JSON Object
import org.json.simple.JSONObject;

public class ExcelFile {

    //member variables
    private int numberOfCellsRead;
    private int errorCells;
    private ArrayList<String> headers;
    private String fileName;

    public ExcelFile(String fileName) {
        this.fileName = fileName;
        this.headers = new ArrayList<String>();
    }

    public void parseExceltoJSON() {

        try {
            Workbook workbook = getExcelWorkBook(fileName);
            //accessing sheet_number; 0-based index; change the index to read a specific sheet in the workbook
            Sheet excelSheetIndex = workbook.getSheetAt(5);
            //accessing row for a specific sheet;
            Iterator<Row> rowIterator = excelSheetIndex.iterator();
            //loop ends when there are no more rows to read
            while (rowIterator.hasNext()) {
                //get current row
                Row currentRow = rowIterator.next();
                //get each cell for the current
                Iterator<Cell> cellIterator = currentRow.iterator();
                //creating a JSON object
                JSONObject jsonObject = new JSONObject();
                //0th row is for headers; to store headers and access it laterfor assigning to value JSON -> (header, value) pairs;
                if (isHeaderRow(currentRow)) {
                    getHeadersForJSON(cellIterator);
                } else {
                    getValuesForJSON(cellIterator, jsonObject);
                    ElasticSearchServer.pushToElasticSearch(jsonObject);
                }
            }
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }

    }

    private void getValuesForJSON(Iterator<Cell> cellIterator, JSONObject jsonObject) {
        while (cellIterator.hasNext()) {
            Cell currentCell = cellIterator.next();
            readEachCell(currentCell, jsonObject, headers);
        }
    }

    private void getHeadersForJSON(Iterator<Cell> cellIterator) {
        while (cellIterator.hasNext()) {
            Cell currentCell = cellIterator.next();
            headers.add(currentCell.getStringCellValue());
        }
    }

    private static boolean isHeaderRow(Row currentRow) {
        return currentRow.getRowNum() == 0;
    }

    private Workbook getExcelWorkBook(String fileName1) throws FileNotFoundException, IOException {
        //member variable
//            ArrayList<String> headers = new ArrayList<String>();
        //input stream for reading excel file
        FileInputStream excelInputStream = new FileInputStream(new File(fileName1));
        //opening workbook; XSSF is for xlsx
        Workbook workbook = new XSSFWorkbook(excelInputStream);
        return workbook;
    }

    private void readEachCell(Cell currentCell, JSONObject jsonObject, ArrayList<String> headers) {
        if (isCellTypeString(currentCell)) {
            jsonObject.put(headers.get(currentCell.getColumnIndex()), currentCell.getStringCellValue());
            //numberOfCells++;
            numberOfCellsRead++;
        } else if (isCellTypeNumeric(currentCell)) {
            jsonObject.put(headers.get(currentCell.getColumnIndex()), currentCell.getNumericCellValue());
            //numberOfCells++;
            numberOfCellsRead++;
        } else if (isCellTypeFormula(currentCell)) {
            jsonObject.put(headers.get(currentCell.getColumnIndex()), currentCell.getNumericCellValue());
            //numberOfCells++;
            numberOfCellsRead++;
        } else if (isCellTypeBlank(currentCell)) {
            //BLANK CELLS WILL BE REPLACED WITH NULL TEXT; CAN BE LATER REMOVED IN KIBANA WITH A FILTER
            jsonObject.put(headers.get(currentCell.getColumnIndex()), "null");
            //numberOfCells++;
            numberOfCellsRead++;
        } else {
            System.out.println("Error reading the cell at: " + currentCell.getCellFormula());
            //numberOfError++;
            errorCells++;
        }
    }

    // cellType could be optimized by enum
    private boolean isCellTypeBlank(Cell currentCell) {
        return currentCell.getCellTypeEnum() == CellType.BLANK;
    }

    private boolean isCellTypeFormula(Cell currentCell) {
        return currentCell.getCellTypeEnum() == CellType.FORMULA;
    }

    private boolean isCellTypeNumeric(Cell currentCell) {
        return currentCell.getCellTypeEnum() == CellType.NUMERIC;
    }

    private boolean isCellTypeString(Cell currentCell) {
        return currentCell.getCellTypeEnum() == CellType.STRING;
    }

    @Override
    public String toString() {
        return "numberOfCellsRead= " + numberOfCellsRead + "\n"
                + "errorCells = " + errorCells;
    }
}
