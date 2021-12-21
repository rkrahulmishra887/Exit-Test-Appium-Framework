package com.demoApp.library;

import com.demoApp.constants.ExcelParameters;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.*;


public class ExcelReader extends BaseTest {

    private Workbook workbook;
    private Sheet sheet;

    public Sheet getSheet(String fileName, String sheetName) {

        // Creating a Workbook from an Excel file (.xls or .xlsx)
        try {
            workbook = WorkbookFactory.create(new File(System.getProperty("user.dir") + File.separator + fileName));

            // Getting the Sheet at index zero
            sheet = workbook.getSheet(sheetName);
            workbook.close();
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }
        return sheet;
    }

    public List<Map<ExcelParameters.Preferences, String>> getPreferences() {
        ExcelReader excel = new ExcelReader();
        String SAMPLE_XLSX_FILE_PATH = "src" + File.separator + "test" + File.separator + "java" + File.separator + "com" + File.separator + "demoApp"
                + File.separator + "data" + File.separator + "testData.xls";

        Sheet sheet = excel.getSheet(SAMPLE_XLSX_FILE_PATH, "Preferences");
        int favouriteAnimal = 0;
        int listPreference = 1;
        List<Map<ExcelParameters.Preferences, String>> allPreferenceDetails = new ArrayList<>();
        int lastRow = sheet.getLastRowNum();
        for (int rowIndex = 1; rowIndex <= lastRow; rowIndex++) {
            Row row = sheet.getRow(rowIndex);
            Map<ExcelParameters.Preferences, String> preferenceDetails = new HashMap<>();
            preferenceDetails.put(ExcelParameters.Preferences.FAVOURITEANIMAL, row.getCell(favouriteAnimal).getStringCellValue());
            preferenceDetails.put(ExcelParameters.Preferences.LISTPREFERENCE, row.getCell(listPreference).getStringCellValue());
            allPreferenceDetails.add(preferenceDetails);
        }
        return allPreferenceDetails;
    }
}