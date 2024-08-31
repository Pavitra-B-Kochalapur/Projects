package com.springboot.rest.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;import java.net.Authenticator.RequestorType;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadDownloadController {

	@ResponseBody
	@RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String fileUpload(@RequestParam("file") MultipartFile file) throws IOException {

		File fileObj = new File("/var/tmp/"+file.getOriginalFilename());
		fileObj.createNewFile();
		FileOutputStream fout = new FileOutputStream(fileObj);
		fout.write(file.getBytes());
		fout.close();
		
		return "file was uploaded successfully";
	}
	
	@RequestMapping(value="/download", method=RequestMethod.GET)
	public ResponseEntity<Object> downloadFile(@RequestParam("fileName") String fileName) throws FileNotFoundException {
		
		File file = new File("/var/tmp/"+fileName);
		
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=simplilearn-"+file.getName());
		
		return ResponseEntity.ok().headers(headers).body(resource);
	}
	
}