package org.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelGenerator {
    private ExcelGenerator(){

    }
    private static CellStyle getCellStyle(Workbook workbook){
        CellStyle headerStyle = workbook.createCellStyle();
        Font boldfont = workbook.createFont();
        boldfont.setBold(true);
        headerStyle.setFont(boldfont);
        headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerStyle.setAlignment(HorizontalAlignment.CENTER);
        return headerStyle;
    }
    public static void execute(){
        // xlsx file
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Bank Accounts");
        // header row
        generateHeader(sheet, workbook);
        setColumnWidth(sheet);

        List<Account> accountList = Bank.getAccountlist();
        for (int i = 0 ; i < accountList.size() ; i++){
            Row row = sheet.createRow(i+1);
            row.createCell(0).setCellValue(accountList.get(i).getN_compte());
            row.createCell(1).setCellValue(accountList.get(i).getClient().getName());
            row.createCell(2).setCellValue(accountList.get(i).getSold_initial());

        }

        writeFile(workbook);
        System.out.println("File Created Successfully !!");
    }

    private static void setColumnWidth(Sheet sheet) {
        sheet.setColumnWidth(0,5_000);
        sheet.setColumnWidth(1,5_000);
        sheet.setColumnWidth(2,5_000);
        sheet.setColumnWidth(3,5_000);
        sheet.setColumnWidth(4,5_000);
    }

    private static void generateHeader(Sheet sheet, Workbook workbook) {
        Row headerRow = sheet.createRow(0);
        String[] headers = {"Numéro de compte" , "Nom du client"  , "Solde"};
        for (int i = 0 ; i< headers.length; i++){
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(getCellStyle(workbook));
        }
    }


    private static void writeFile(Workbook workbook) {
        try {
            // name of the file
            FileOutputStream fileOutputStream = new FileOutputStream("accounts.xlsx");
            // open the file & save it
            workbook.write(fileOutputStream);
            // close the file to access it.
            workbook.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}