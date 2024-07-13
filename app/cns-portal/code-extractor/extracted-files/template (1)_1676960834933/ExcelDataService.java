//package com.realnet.excel.service;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.poi.EncryptedDocumentException;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.DataFormatter;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.springframework.stereotype.Service;
//
//import com.realnet.excel.entity.ExcelFileUpload;
//
//@Service
//public class ExcelDataService {
// 
//	Workbook workbook;
//
//	public List<ExcelFileUpload> getExcelDataAsList() {
//
//		List<String> list = new ArrayList<String>();
//
//		// Create a DataFormatter to format and get each cell's value as String
//		DataFormatter dataFormatter = new DataFormatter();
//
//		// Create the Workbook
////		try {
////			workbook = WorkbookFactory.create();
////		} catch (EncryptedDocumentException | IOException e) {
////			e.printStackTrace();
////		}
//
//		// Retrieving the number of sheets in the Workbook
//		System.out.println("-------Workbook has '" + workbook.getNumberOfSheets() + "' Sheets-----");
//
//		// Getting the Sheet at index zero
//		Sheet sheet = workbook.getSheetAt(0);
//
//		// Getting number of columns in the Sheet
//		int noOfColumns = sheet.getRow(0).getLastCellNum();
//		System.out.println("-------Sheet has '"+noOfColumns+"' columns------");
//
//		// Using for-each loop to iterate over the rows and columns
//		for (Row row : sheet) {
//			for (Cell cell : row) {
//				String cellValue = dataFormatter.formatCellValue(cell);
//				list.add(cellValue);
//			}
//		}
//
//		// filling excel data and creating list as List<Invoice>
//		List<ExcelFileUpload> invList = createList(list, noOfColumns);
//
//		// Closing the workbook
//		try {
//			workbook.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return invList;
//	}
//
//	private List<ExcelFileUpload> createList(List<String> excelData, int noOfColumns) {
//
//		ArrayList<ExcelFileUpload> invList = new ArrayList<ExcelFileUpload>();
//
//		int i = noOfColumns;
//		do {
//			ExcelFileUpload inv = new ExcelFileUpload();
//
////			inv.setName(excelData.get(i));
////			inv.setAmount(Double.valueOf(excelData.get(i + 1)));
////			inv.setNumber(excelData.get(i + 2));
////			inv.setReceivedDate(excelData.get(i + 3));
//
//			invList.add(inv);
//			i = i + (noOfColumns);
//
//		} while (i < excelData.size());
//		return invList;
//	}
//
////	public int saveExcelData(List<ExcelFileUpload> invoices) {
////		invoices = repo.saveAll(invoices);
////		return invoices.size();
////	}
//	
	
	
//}
