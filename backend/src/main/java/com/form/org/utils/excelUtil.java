package com.form.org.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

//org.apache.poi.ss.usermodel.Sheet


import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.form.org.model.Patient;

public class excelUtil {
 public static String EXCELTYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	
//	public static List<Patient> parseExcelFile(InputStream is) {
//		try {
//			Workbook wkbk = new XSSFWorkbook(is);
//			Sheet sheet = wkbk.getSheet("Patient");
//			Iterator<Row> rows = sheet.iterator();
//
//			List<Patient> lsPatients = new ArrayList<Patient>();
//
//			int rowNbr = 0;
//			while (rows.hasNext()) {
//				Row currentRow = (Row) rows.next();
//
//				// skip header
//				if (rowNbr == 0) {
//					rowNbr++;
//					continue;
//				}
//
//				Iterator<Cell> cellsInRow = currentRow.iterator();
//
//				Patient pat = new Patient();
//				int cellIndex = 0;
//				while (cellsInRow.hasNext()) {
//				Cell currentCell = (Cell) cellsInRow.next();
//
//					if (cellIndex == 0) { 
//						pat.setIdPatient((int)currentCell.getNumericCellValue());
//					} else if (cellIndex == 1) { 
//						pat.setNom(currentCell.getStringCellValue());
//					} else if (cellIndex == 7) {
//						pat.setPrenom(currentCell.getStringCellValue());
//					
//					}else if (cellIndex == 2) { 
//						pat.setAdressse(currentCell.getStringCellValue());
//					} else if (cellIndex == 3) {
//						pat.setCni(currentCell.getStringCellValue());
//					}else if (cellIndex == 4) {
//						pat.setCodePatient(currentCell.getStringCellValue());
//					}else if (cellIndex == 5) {
//						pat.setDateNaissance(currentCell.getDateCellValue());
//					}else if (cellIndex == 6) {
//						pat.setEmail(currentCell.getStringCellValue());
//					
//					}else if (cellIndex == 8) {
//						pat.setSexe(currentCell.getStringCellValue());
//					}else if (cellIndex == 9) {
//						pat.setTelephone (currentCell.getStringCellValue());
//					}
//					cellIndex++;
//				}
//
//				lsPatients.add(pat);
//			}
//			// Close WorkBook
//			wkbk.close();
//
//			return lsPatients;
//		} catch (IOException e) {
//			throw new RuntimeException("FAIL! -> message = " + e.getMessage());
//		}
//		
//	}
	
	public static ByteArrayInputStream patientToExcel(List<Patient> patients) throws IOException {
		String[] COLUMNs = { "IdPatient","Nom","Prenom", "Adresse","Cin","CodePatient","DateNaissance", "Email","Sexe", "Telephone"};
		try (Workbook wkbk = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
		//	CreationHelper createHelper = wkbk.getCreationHelper();

			Sheet sheet = wkbk.createSheet("patients");

			Font headerFont = wkbk.createFont();
			headerFont.setBold(true);
			headerFont.setColor(IndexedColors.BLUE.getIndex());

			CellStyle headerCellStyle = wkbk.createCellStyle();
			headerCellStyle.setFont(headerFont);

			// Row for Header
			Row headerRow = sheet.createRow(0);

			// Header
			for (int col = 0; col < COLUMNs.length; col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(COLUMNs[col]);
				cell.setCellStyle(headerCellStyle);
			}
			int rowIdx = 1;
			for (Patient patient : patients) {
				Row row = sheet.createRow(rowIdx++);

				row.createCell(0).setCellValue(patient.getIdPatient());
				row.createCell(1).setCellValue(patient.getNom());
				row.createCell(4).setCellValue(patient.getPrenom());
				row.createCell(2).setCellValue(patient.getAdressse());
				row.createCell(3).setCellValue(patient.getCni());
				row.createCell(5).setCellValue(patient.getCodePatient());
				row.createCell(6).setCellValue(patient.getDateNaissance());
				row.createCell(7).setCellValue(patient.getEmail());
				row.createCell(8).setCellValue(patient.getSexe());
				row.createCell(9).setCellValue(patient.getTelephone());
				
				}
                 wkbk.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		}
	}

	public static boolean isExcelFile(MultipartFile file) {
		
		if(!EXCELTYPE.equals(file.getContentType())) {
			return false;
		}
		
		return true;
	}
	
}

