package com.Bhaba.code;

import java.io.File;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import dataProvider.FilloExcelReader;
import dataProvider.ReadPropertyFile;

public class MAIN {

	public static Recordset mainRecordSet = null, dataRecordSet = null,valueRedcordSet=null;
	public static String mainSheetPath;
	public static String maiSheetName;
	public static String srNo;
//	public static String runstatus;
	public static String browser;
	public static String module;
//	public static String description;
	public static String sheetPath;

//	~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static String dataSheetPath;
	public static String dataSheetName;
	public static String No;
	public static String pageName;
	public static String control;
	public static String objectType;
	public static String propertyName;
	public static String propertyValue;
	public static String dataField;
	public static String action;
	public static String testCaseNo;
	public static String testCaseType;
	public static String description;
	public static String scenarioNo;
	
	public static String dataFieldValue;

	public static void main(String[] args) {

		System.out.println("Code start--------------------");

		ReadPropertyFile.read();

//		############(mainsheet)
		try {

			mainSheetPath = System.getProperty("user.dir") + File.separator + "DataSheet" + File.separator
					+ "MainController.xlsx";
			maiSheetName = "mainsheet";

			
			
			mainRecordSet = FilloExcelReader.getRecord(mainSheetPath, maiSheetName);
		
			
			while (mainRecordSet.next()) {
				srNo = mainRecordSet.getField("srNo");
				browser = mainRecordSet.getField("browser");
				module = mainRecordSet.getField("module");
				sheetPath = mainRecordSet.getField("sheetPath");

//				***************(datasheet)
				dataSheetPath = System.getProperty("user.dir") + File.separator + "DataSheet" + File.separator
						+ sheetPath;
				dataSheetName = "sheet1";
				dataRecordSet = FilloExcelReader.getRecord(dataSheetPath, dataSheetName);
				while (dataRecordSet.next()) {

					No= dataRecordSet.getField("No");
					pageName = dataRecordSet.getField("pageName");
					control = dataRecordSet.getField("control");
					objectType = dataRecordSet.getField("objectType");
					propertyName = dataRecordSet.getField("propertyName");
					propertyValue = dataRecordSet.getField("propertyValue");
					dataField = dataRecordSet.getField("dataField");
					action = dataRecordSet.getField("action");
					testCaseNo = dataRecordSet.getField("testCaseNo");
					testCaseType = dataRecordSet.getField("testCaseType");
					description = dataRecordSet.getField("description");
					scenarioNo = dataRecordSet.getField("scenarioNo");
//					System.out.println(action);
					System.out.println(dataField);
					
					if(dataField!=null || dataField!="")
					{
						System.out.println("inner");
						valueRedcordSet=FilloExcelReader.getRecord(dataSheetPath,"Sheet2");
						valueRedcordSet.next();
						dataFieldValue=valueRedcordSet.getField(dataField);
						System.out.println(dataFieldValue);
					}
					
					//call action 
					
					
					break;

				}

			}
		} catch (FilloException e) {
			e.printStackTrace();
		}

//	   ########## end

	}
}
