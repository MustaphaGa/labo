package com.form.org.Controller;

import static com.form.org.utils.Constants.APP_ROOT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.form.org.Services.ExcelFileService;



@RestController
public class DownloadFileRestAPIs {
	@Autowired
	ExcelFileService fileService;
	
	//@GetMapping("/api/file")
	@GetMapping(value= APP_ROOT + "/api/file", produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<InputStreamResource> downloadFile() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=patient.xlsx");
		return ResponseEntity.ok().headers(headers)
									.contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
									.body(new InputStreamResource(fileService.loadFile()));
	}
}