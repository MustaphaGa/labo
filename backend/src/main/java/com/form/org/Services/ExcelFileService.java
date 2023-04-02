package com.form.org.Services;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.form.org.Repository.patientRepositoryTest;
import com.form.org.model.Patient;
import com.form.org.utils.excelUtil;


@Service
public class ExcelFileService {

	@Autowired
	patientRepositoryTest patientRepoTest;
	
	// Store File Data to Database
//	public void store(MultipartFile file) {
//		try {
//			List<Patient> lsPat = excelUtil.parseExcelFile(file.getInputStream());
//			// Save patients to DataBase
//			patientRepoTest.saveAll(lsPat);
//		} catch (IOException e) {
//			throw new RuntimeException("FAIL! -> message = " + e.getMessage());
//		}
//	}

	// Load Data to Excel File
	public ByteArrayInputStream loadFile() {
		List<Patient> patients = (List<Patient>) patientRepoTest.findAll();

		try {
			ByteArrayInputStream in = excelUtil.patientToExcel(patients);
			return in;
		} catch (IOException e) {}

		return null;
	}
}