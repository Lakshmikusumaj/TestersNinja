 package utilities; 

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
    public static List<Map<String, String>> getDataForSheet(String sheetName) {

        List<Map<String, String>> dataList = new ArrayList<>();

        try {
        	String testDataFilePath1 = System.getProperty("user.dir") + "/src/test/resources/testdata/ArrayTestData.xlsx";
        	FileInputStream fis = new FileInputStream(testDataFilePath1);

        	//String testDataFilePath12 = ConfigReader.getProperty("test_data_file_path");
           //FileInputStream fis12 = new FileInputStream(testDataFilePath12);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(sheetName);

            Row headerRow = sheet.getRow(0);
            int rowCount = sheet.getPhysicalNumberOfRows();
            int colCount = headerRow.getPhysicalNumberOfCells();

            for (int i = 1; i < rowCount; i++) {
                Row currentRow = sheet.getRow(i);
                Map<String, String> rowData = new HashMap<>();

                for (int j = 0; j < colCount; j++) {
                    Cell keyCell = headerRow.getCell(j);
                    Cell valueCell = currentRow.getCell(j);

                    String key = keyCell.getStringCellValue();
                    String value = getCellValue(valueCell);

                    rowData.put(key, value);
                }
                dataList.add(rowData);
            }

            workbook.close();
            fis.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataList;
    }

    private static String getCellValue(Cell cell) {

        if (cell == null)
            return "";

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();

            case NUMERIC:
                return String.valueOf((int) cell.getNumericCellValue());

            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());

            default:
                return "";
        }
    }
}
