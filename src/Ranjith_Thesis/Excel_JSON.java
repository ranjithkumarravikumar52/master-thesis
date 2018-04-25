package Ranjith_Thesis;

import java.io.*;
import java.util.*;
//API for microsoft documents
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//JSON Object
import org.json.simple.JSONObject;

public class Excel_JSON {
    
    public static void parseExceltoJSON(String FILE_NAME){
        
        try{            
                        
            ArrayList<String> headers = new ArrayList<String>();
            
            //input stream for reading excel file
            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
            
            //opening workbook; XSSF is for xlsx
            Workbook workbook = new XSSFWorkbook(excelFile);
            
            //accessing sheet_number; 0-based index; //change the index to read a specific sheet in the workbook
            Sheet sheet1 = workbook.getSheetAt(5);
            
            int numberOfCells=0;
            int numberOfError=0;
            
            //json object; to push this object later into elasticserver
            JSONObject jsonObject = new JSONObject();
            
            //accessing row for a specific sheet;
            Iterator<Row> Sheet_Iterator = sheet1.iterator();
            while (Sheet_Iterator.hasNext()) {                
                              
                Row currentRow = Sheet_Iterator.next();
                Iterator<Cell> RowIterator = currentRow.iterator();                
                
                if(currentRow.getRowNum() == 0){ //0th row is for headers; to store headers and access it later;
                    //headers_size = currentRow.getLastCellNum();
                    while(RowIterator.hasNext()){
                        Cell currentCell = RowIterator.next();
                        headers.add(currentCell.getStringCellValue());
                    }//end while
                    
                }//end if
                
                else{ 
                    
                    while (RowIterator.hasNext()) {
                        Cell currentCell = RowIterator.next();
                        if (currentCell.getCellTypeEnum() == CellType.STRING) {
                            jsonObject.put(headers.get(currentCell.getColumnIndex()), currentCell.getStringCellValue());
                            numberOfCells++;
                        } 
                        else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
                            jsonObject.put(headers.get(currentCell.getColumnIndex()),currentCell.getNumericCellValue());
                            numberOfCells++;
                        } 
                        else if (currentCell.getCellTypeEnum() == CellType.FORMULA){
                            jsonObject.put(headers.get(currentCell.getColumnIndex()), currentCell.getNumericCellValue());
                            numberOfCells++;
                        }
                        else if (currentCell.getCellTypeEnum() == CellType.BLANK){
                            jsonObject.put(headers.get(currentCell.getColumnIndex()), "null"); //BLANK CELLS WILL BE REPLACED WITH NULL TEXT; CAN BE LATER REMOVED IN KIBANA WITH A FILTER
                            numberOfCells++;
                        }
                        else {
                            System.out.println("Error reading the cell at: "+currentCell.getCellFormula());
                            numberOfError++;
                        }
                    
                    }//end while-cell
                  
                }//end else
                
                Debug.JSONObject(jsonObject);//may be send an index for the JSONObject
                JSON_ElasticSearch.PushJSON(jsonObject); //push into the elastic search
                
            }//end while-row
            
        Debug.Headers(headers);
        Debug.Number_of_cells(numberOfCells);        
        Debug.Number_of_records_pushed();
        Debug.Number_of_errors(numberOfError);
      
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         
        
    }
    
}
