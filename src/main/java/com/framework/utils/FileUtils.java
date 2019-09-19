package com.framework.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

public class FileUtils {

	public static Properties loadProperties(String fileName) {
		Properties newProperties = new Properties();
		try {
			newProperties.load(FileUtils.class.getResourceAsStream(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return newProperties;
	}
	
	public static String [] updateImportContactFile(String contactIdToUpdate){
		//read data from original file
		//copy it with updated one to temp file
		//delete original file and rename temp file to original file name
		String []newData = null;
		try {
			CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/testdata/update_contact_import.csv"));
			CSVWriter csvWriter = new CSVWriter(new FileWriter("src/test/resources/testdata/update_contact_import_temp.csv"), ',', CSVWriter.NO_QUOTE_CHARACTER);
			List<String[]> allData = csvReader.readAll();
			for(int i=0; i<allData.size(); i++){
				String [] data = allData.get(i);
				if(i==0){
					//writing header
					csvWriter.writeNext(data);
				}else{
					//updating contact id
					newData = new String[data.length];
					for(int j=0; j<data.length; j++){
						newData[j] = data[j];
					}
					newData[0] = contactIdToUpdate;
					csvWriter.writeNext(newData);
				}
	        }
			
			csvReader.close();
			csvWriter.close();
			File oldFile = new File("src/test/resources/testdata/update_contact_import.csv");
			File newFile = new File("src/test/resources/testdata/update_contact_import_temp.csv");
			oldFile.delete();
			newFile.renameTo(oldFile);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return newData;
		
	}
	
	public static String [] updateImportLeadFile(String leadIdToUpdate){
		//read data from original file
		//copy it with updated one to temp file
		//delete original file and rename temp file to original file name
		String []newData = null;
		try {
			CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/testdata/update_lead_import.csv"));
			CSVWriter csvWriter = new CSVWriter(new FileWriter("src/test/resources/testdata/update_lead_import_temp.csv"), ',', CSVWriter.NO_QUOTE_CHARACTER);
			List<String[]> allData = csvReader.readAll();
			for(int i=0; i<allData.size(); i++){
				String [] data = allData.get(i);
				if(i==0){
					//writing header
					csvWriter.writeNext(data);
				}else{
					//updating contact id
					newData = new String[data.length];
					for(int j=0; j<data.length; j++){
						newData[j] = data[j];
					}
					newData[0] = leadIdToUpdate;
					csvWriter.writeNext(newData);
				}
	        }
			
			csvReader.close();
			csvWriter.close();
			File oldFile = new File("src/test/resources/testdata/update_lead_import.csv");
			File newFile = new File("src/test/resources/testdata/update_lead_import_temp.csv");
			oldFile.delete();
			newFile.renameTo(oldFile);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return newData;
		
	}
	
	public static String[] updateUploadStudentCourseFile(String contactIdToUpdate){
		//read data from original file
		//copy it with updated one to temp file
		//delete original file and rename temp file to original file name
		String []newData = null;
		try {
			CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/testdata/course_upload.csv"));
			CSVWriter csvWriter = new CSVWriter(new FileWriter("src/test/resources/testdata/course_upload_temp.csv"), ',', CSVWriter.NO_QUOTE_CHARACTER);
			List<String[]> allData = csvReader.readAll();
			for(int i=0; i<allData.size(); i++){
				String [] data = allData.get(i);
				if(i==0){
					//writing header
					csvWriter.writeNext(data);
				}else{
					//updating contact id
					newData = new String[data.length];
					for(int j=0; j<data.length; j++){
						newData[j] = data[j];
					}
					newData[4] = contactIdToUpdate;
					csvWriter.writeNext(newData);}}	
			csvReader.close();
			csvWriter.close();
			File oldFile = new File("src/test/resources/testdata/course_upload.csv");
			File newFile = new File("src/test/resources/testdata/course_upload_temp.csv");
			oldFile.delete();
			newFile.renameTo(oldFile);	
		} catch (IOException e) {
			e.printStackTrace();
		}
		return newData;	
	}

	public static String[] ReadCsvFile() throws IOException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
		   LocalDateTime now = LocalDateTime.now();
		   String date=dtf.format(now);
		String []newData = null;
		CSVReader csvReader = new CSVReader(new FileReader("C:/Users/farheen.ahmad/Facilitation_Report/Facilitator Manager Report - "+date+".csv"));
		List<String[]> allRows = csvReader.readAll();
		
		for(int i=0; i<allRows.size(); i++){
			String [] data = allRows.get(i);
			if(i==0){//header
			}else{
				//updating contact id
				newData = new String[data.length];
				for(int j=0; j<data.length; j++){
					newData[j] = data[j].replaceAll("\\s", "");
				}
				//System.out.println(Arrays.toString(newData));
		}	
		csvReader.close();
	}
		return newData;

	}}
