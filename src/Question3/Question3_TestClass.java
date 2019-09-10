package Question3;

import java.io.File;
import java.io.FileInputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Question3_TestClass {
	String bassurl="D:\\Selenium Project\\AssignmentQuestion\\Assignment_Answers\\WebFile\\Question3.html";
	String ChromeDriverPath = "D:\\Selenium Project\\AssignmentQuestion\\Assignment_Answers\\Lib\\Chrome\\chromedriver.exe";
	
	public WebDriver driver;
	
	//get file form location
	File objFile = new File("D:\\Selenium Project\\AssignmentQuestion\\Assignment_Answers\\ExternalData\\QuestionTestData.xlsx");
	
	@Test(priority=1)
	public void Q3_RegistrationForm_PersonalDataPage_PageLoading() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		driver = new ChromeDriver();
		driver.get(bassurl);
		Thread.sleep(4000);
		
		String ExpectedHeading = "Register Form: SQA Professional Program – Batch 13 – SLIIT";
		driver.close();
		
	}
	
	@Test(priority=2)
	public void Q3_RegistrationForm_PersonalDataPage_ErrorValidationForEmptyFirstName() throws Exception {
		//FileRead object creating
		FileInputStream objFileStram = new FileInputStream(objFile);
			    
		//Create a execl workbook object
		XSSFWorkbook objWrkBook = new XSSFWorkbook(objFileStram);
				
		//Select Sheet form execl
		XSSFSheet objWrkBookSheet = objWrkBook.getSheetAt(2);
		
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		driver = new ChromeDriver();
		driver.get(bassurl);
		Thread.sleep(4000);
		
		//Define variable
		String missingData = "Empty";
		String ActualValue ="Empyt";
		String firstName = null;
		String lastName = null;		
				
		        try {
				firstName=objWrkBookSheet.getRow(2).getCell(0).getStringCellValue();
				System.out.println(firstName);
		        }catch(Exception e) {
					missingData = "First Name is missing";
					ActualValue=missingData;
					System.out.println("Test1");
				}
		
		        try {
				lastName=objWrkBookSheet.getRow(2).getCell(1).getStringCellValue();
				System.out.println(lastName);
		        }catch(Exception e) {
					missingData = "Last Name is missing";
					ActualValue=missingData;
					System.out.println("Test2");
				}
		        
		        driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[2]/input")).sendKeys(lastName);
				Thread.sleep(1000);
		
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[3]/input[1]")).click();
				Thread.sleep(2000);
				
				String ExpectedValue = "First Name is missing";
				try {
					Assert.assertEquals(ActualValue, ExpectedValue);
					} catch (Throwable e) {
						System.out.println("Report Error : " + e);
					}
				System.out.println("Error Validation : "+ActualValue);
				driver.close();
				objWrkBook.close();
	}
	
	@Test(priority=3)
	public void Q3_RegistrationForm_PersonalDataPage_ErrorValidationForEmptyLastName() throws Exception {
		//FileRead object creating
		FileInputStream objFileStram = new FileInputStream(objFile);
			    
		//Create a execl workbook object
		XSSFWorkbook objWrkBook = new XSSFWorkbook(objFileStram);
				
		//Select Sheet form execl
		XSSFSheet objWrkBookSheet = objWrkBook.getSheetAt(2);
		
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		driver = new ChromeDriver();
		driver.get(bassurl);
		Thread.sleep(4000);
		
		//Define variable
		String missingData = "Empty";
		String ActualValue ="Empyt";
		String firstName = null;
		String lastName = null;		
				
		        try {
				firstName=objWrkBookSheet.getRow(3).getCell(0).getStringCellValue();
				System.out.println(firstName);
		        }catch(Exception e) {
					missingData = "First Name is missing";
					ActualValue=missingData;
					System.out.println("Test1");
				}
		
		        try {
				lastName=objWrkBookSheet.getRow(3).getCell(1).getStringCellValue();
				System.out.println(lastName);
		        }catch(Exception e) {
					missingData = "Last Name is missing";
					ActualValue=missingData;
					System.out.println("Test2");
				}
		        
		        driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[1]/input")).sendKeys(firstName);
				Thread.sleep(1000);
		
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[3]/input[1]")).click();
				Thread.sleep(2000);
				String ExpectedValue = "Last Name is missing";
				try {
					Assert.assertEquals(ActualValue, ExpectedValue);
					} catch (Throwable e) {
						System.out.println("Report Error : " + e);
					}
				System.out.println("Error Validation : "+ActualValue);
				driver.close();
				objWrkBook.close();
	}
	
	@Test(priority=4)
	public void Q3_RegistrationForm_PersonalDataPage_ErrorValidationForMaxLengthOfFirstName() throws Exception {
		//FileRead object creating
		FileInputStream objFileStram = new FileInputStream(objFile);
			    
		//Create a execl workbook object
		XSSFWorkbook objWrkBook = new XSSFWorkbook(objFileStram);
				
		//Select Sheet form execl
		XSSFSheet objWrkBookSheet = objWrkBook.getSheetAt(2);
		
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		driver = new ChromeDriver();
		driver.get(bassurl);
		Thread.sleep(4000);
		
		//Define variable
		String ActualValue ="Empyt";
		String firstName = null;
		String lastName = null;		
				
		       
				firstName=objWrkBookSheet.getRow(4).getCell(0).getStringCellValue();
				System.out.println(firstName);
		     
				lastName=objWrkBookSheet.getRow(4).getCell(1).getStringCellValue();
				System.out.println(lastName);
		       
		        
				if(firstName.length()>10) {
					ActualValue = "First Name length is exceding maximun character length";
					System.out.println("Error Validation : "+ ActualValue);
				}
				else {
		        driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[1]/input")).sendKeys(firstName);
				Thread.sleep(1000);
				System.out.println("First name length is ok ");
				}
		
				if(lastName.length()>15) {
					ActualValue = "Last Name length is exceding maximun character length";
					System.out.println("Error Validation : "+ ActualValue);
				}else {
					driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[2]/input")).sendKeys(lastName);
					Thread.sleep(1000);
					System.out.println("Last name length is ok ");
				}
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[3]/input[1]")).click();
				Thread.sleep(2000);
				String ExpectedValue = "First Name length is exceding maximun character length";
				try {
					Assert.assertEquals(ActualValue, ExpectedValue);
					} catch (Throwable e) {
						System.out.println("Report Error : " + e);
					}
				
				driver.close();
				objWrkBook.close();
	}
	
	
	@Test(priority=5)
	public void Q3_RegistrationForm_PersonalDataPage_ErrorValidationForMaxLengthOfLastName() throws Exception {
		//FileRead object creating
		FileInputStream objFileStram = new FileInputStream(objFile);
			    
		//Create a execl workbook object
		XSSFWorkbook objWrkBook = new XSSFWorkbook(objFileStram);
				
		//Select Sheet form execl
		XSSFSheet objWrkBookSheet = objWrkBook.getSheetAt(2);
		
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		driver = new ChromeDriver();
		driver.get(bassurl);
		Thread.sleep(4000);
		
		//Define variable
		String ActualValue ="Empyt";
		String firstName = null;
		String lastName = null;		
				
		       
				firstName=objWrkBookSheet.getRow(5).getCell(0).getStringCellValue();
				System.out.println(firstName);
		     
				lastName=objWrkBookSheet.getRow(5).getCell(1).getStringCellValue();
				System.out.println(lastName);
		       
		        
				if(firstName.length()>10) {
					ActualValue = "First Name length is exceding maximun character length";
					System.out.println("Error Validation : "+ ActualValue);
				}
				else {
		        driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[1]/input")).sendKeys(firstName);
				Thread.sleep(1000);
				System.out.println("First name length is ok ");
				}
		
				if(lastName.length()>15) {
					ActualValue = "Last Name length is exceding maximun character length";
					System.out.println("Error Validation : "+ ActualValue);
				}else {
					driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[2]/input")).sendKeys(lastName);
					Thread.sleep(1000);
					System.out.println("Last name length is ok ");
				}
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[3]/input[1]")).click();
				Thread.sleep(2000);
				String ExpectedValue = "Last Name length is exceding maximun character length";
				try {
					Assert.assertEquals(ActualValue, ExpectedValue);
					} catch (Throwable e) {
						System.out.println("Report Error : " + e);
					}
				
				driver.close();
				objWrkBook.close();
	}
	
	@Test(priority=6)
	public void Q3_RegistrationForm_PersonalDataPage_ErrorValidationForInvaliedFirstName() throws Exception {
		//FileRead object creating
		FileInputStream objFileStram = new FileInputStream(objFile);
			    
		//Create a execl workbook object
		XSSFWorkbook objWrkBook = new XSSFWorkbook(objFileStram);
				
		//Select Sheet form execl
		XSSFSheet objWrkBookSheet = objWrkBook.getSheetAt(2);
		
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		driver = new ChromeDriver();
		driver.get(bassurl);
		Thread.sleep(4000);
		
		//Define variable
		String ActualValue ="Empyt";
		String firstName = null;
		String lastName = null;		
				
		       
				firstName=objWrkBookSheet.getRow(6).getCell(0).getStringCellValue();
				System.out.println(firstName);
		     
				lastName=objWrkBookSheet.getRow(6).getCell(1).getStringCellValue();
				System.out.println(lastName);
		       
		        
				if(Pattern.compile( "[0-9]" ).matcher(firstName ).find()) {
					ActualValue = "First Name include invalidate characters";
					System.out.println("Error Validation : "+ ActualValue);
				}
				else {
		        driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[1]/input")).sendKeys(firstName);
				Thread.sleep(1000);
				System.out.println("First name format is ok ");
				}
		
				if(Pattern.compile( "[0-9]" ).matcher(lastName ).find()) {
					ActualValue = "Last Name include invalidate characters";
					System.out.println("Error Validation : "+ ActualValue);
				}else {
					driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[2]/input")).sendKeys(lastName);
					Thread.sleep(1000);
					System.out.println("Last name format is ok ");
				}
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[3]/input[1]")).click();
				Thread.sleep(2000);
				String ExpectedValue = "First Name include invalidate characters";
				try {
					Assert.assertEquals(ActualValue, ExpectedValue);
					} catch (Throwable e) {
						System.out.println("Report Error : " + e);
					}
				
				driver.close();
				objWrkBook.close();
	}
	
	@Test(priority=7)
	public void Q3_RegistrationForm_PersonalDataPage_ErrorValidationForInvaliedLastName() throws Exception {
		//FileRead object creating
		FileInputStream objFileStram = new FileInputStream(objFile);
			    
		//Create a execl workbook object
		XSSFWorkbook objWrkBook = new XSSFWorkbook(objFileStram);
				
		//Select Sheet form execl
		XSSFSheet objWrkBookSheet = objWrkBook.getSheetAt(2);
		
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		driver = new ChromeDriver();
		driver.get(bassurl);
		Thread.sleep(4000);
		
		//Define variable
		String ActualValue ="Empyt";
		String firstName = null;
		String lastName = null;		
				
		       
				firstName=objWrkBookSheet.getRow(7).getCell(0).getStringCellValue();
				System.out.println(firstName);
		     
				lastName=objWrkBookSheet.getRow(7).getCell(1).getStringCellValue();
				System.out.println(lastName);
		       
		        
				if(Pattern.compile( "[0-9]" ).matcher(firstName ).find()) {
					ActualValue = "First Name include invalidate characters";
					System.out.println("Error Validation : "+ ActualValue);
				}
				else {
		        driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[1]/input")).sendKeys(firstName);
				Thread.sleep(1000);
				System.out.println("First name format is ok ");
				}
		
				if(Pattern.compile( "[0-9]" ).matcher(lastName ).find()) {
					ActualValue = "Last Name include invalidate characters";
					System.out.println("Error Validation : "+ ActualValue);
				}else {
					driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[2]/input")).sendKeys(lastName);
					Thread.sleep(1000);
					System.out.println("Last name format is ok ");
				}
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[3]/input[1]")).click();
				Thread.sleep(2000);
				String ExpectedValue = "Last Name include invalidate characters";
				try {
					Assert.assertEquals(ActualValue, ExpectedValue);
					} catch (Throwable e) {
						System.out.println("Report Error : " + e);
					}
				
				driver.close();
				objWrkBook.close();
	}
	
	@Test(priority=8)
	public void Q3_RegistrationForm_ContactDetailsPage_PageLoading() throws Exception {
		//FileRead object creating
		FileInputStream objFileStram = new FileInputStream(objFile);
			    
		//Create a execl workbook object
		XSSFWorkbook objWrkBook = new XSSFWorkbook(objFileStram);
				
		//Select Sheet form execl
		XSSFSheet objWrkBookSheet = objWrkBook.getSheetAt(2);
		
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		driver = new ChromeDriver();
		driver.get(bassurl);
		Thread.sleep(4000);
		
		//Define variable
		
		String firstName = null;
		String lastName = null;		
				
		       
				firstName=objWrkBookSheet.getRow(1).getCell(0).getStringCellValue();
				System.out.println(firstName);
		     
				lastName=objWrkBookSheet.getRow(1).getCell(1).getStringCellValue();
				System.out.println(lastName);
		       
	
		        driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[1]/input")).sendKeys(firstName);
				Thread.sleep(1000);
			

					driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[2]/input")).sendKeys(lastName);
					Thread.sleep(1000);

				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[3]/input[1]")).click();
				Thread.sleep(2000);
				
				driver.findElement(By.xpath("//*[@id=\"nextBtn\"]")).click();
				Thread.sleep(4000);
				driver.close();
				objWrkBook.close();
	}
	
	@Test(priority=9)
	public void Q3_RegistrationForm_ContactDetailsPage_VerifyTheValiedEmailAddress() throws Exception {
		//FileRead object creating
		FileInputStream objFileStram = new FileInputStream(objFile);
			    
		//Create a execl workbook object
		XSSFWorkbook objWrkBook = new XSSFWorkbook(objFileStram);
				
		//Select Sheet form execl
		XSSFSheet objWrkBookSheet = objWrkBook.getSheetAt(2);
		
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		driver = new ChromeDriver();
		driver.get(bassurl);
		Thread.sleep(4000);
		
		//Define variable
		
		String firstName = null;
		String lastName = null;		
				
		       
				firstName=objWrkBookSheet.getRow(8).getCell(0).getStringCellValue();
				System.out.println(firstName);
		     
				lastName=objWrkBookSheet.getRow(8).getCell(1).getStringCellValue();
				System.out.println(lastName);
		       
	
		        driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[1]/input")).sendKeys(firstName);
				Thread.sleep(1000);
			

					driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[2]/input")).sendKeys(lastName);
					Thread.sleep(1000);

				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[3]/input[1]")).click();
				Thread.sleep(2000);
				
				driver.findElement(By.xpath("//*[@id=\"nextBtn\"]")).click();
				Thread.sleep(4000);
				
				//Validating email address format
				
				String email1 =null;
				email1= objWrkBookSheet.getRow(8).getCell(2).getStringCellValue();
				
				if(email1==null) {
					
					System.out.println("Error massage : Email address not added");
				}
				else {
					driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[2]/p[1]/input")).sendKeys(email1);
					Thread.sleep(1000);
				}
				
				  String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";			      
			      Boolean b = email1.matches(EMAIL_REGEX);
			      System.out.println("is e-mail: "+email1+" :Email Validation = " + b);
			     
			     
			      
				driver.close();
				objWrkBook.close();
	}
	
	@Test(priority=10)
	public void Q3_RegistrationForm_ContactDetailsPage_ErrorValidationForInvaliedEmailAddress() throws Exception {
		//FileRead object creating
		FileInputStream objFileStram = new FileInputStream(objFile);
			    
		//Create a execl workbook object
		XSSFWorkbook objWrkBook = new XSSFWorkbook(objFileStram);
				
		//Select Sheet form execl
		XSSFSheet objWrkBookSheet = objWrkBook.getSheetAt(2);
		
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		driver = new ChromeDriver();
		driver.get(bassurl);
		Thread.sleep(4000);
		
		//Define variable
		
		String firstName = null;
		String lastName = null;		
				
		       
				firstName=objWrkBookSheet.getRow(9).getCell(0).getStringCellValue();
				System.out.println(firstName);
		     
				lastName=objWrkBookSheet.getRow(9).getCell(1).getStringCellValue();
				System.out.println(lastName);
		       
	
		        driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[1]/input")).sendKeys(firstName);
				Thread.sleep(1000);
			

					driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[2]/input")).sendKeys(lastName);
					Thread.sleep(1000);

				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[3]/input[1]")).click();
				Thread.sleep(2000);
				
				driver.findElement(By.xpath("//*[@id=\"nextBtn\"]")).click();
				Thread.sleep(4000);
				
				//Validating email address format
				
				String email1 =null;
				email1= objWrkBookSheet.getRow(9).getCell(2).getStringCellValue();
				
				if(email1==null) {
					
					System.out.println("Error massage : Email address not added");
				}
				else {
					driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[2]/p[1]/input")).sendKeys(email1);
					Thread.sleep(1000);
				}
				
				  String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";			      
			      Boolean b = email1.matches(EMAIL_REGEX);
			      System.out.println("is e-mail: "+email1+" :Email Validation = " + b);
			     			      
				driver.close();
				objWrkBook.close();
	}
	
	@Test(priority=11)
	public void Q3_RegistrationForm_ContactDetailsPage_ErrorValidationForEmptyEmailAddress() throws Exception {
		//FileRead object creating
		FileInputStream objFileStram = new FileInputStream(objFile);
			    
		//Create a execl workbook object
		XSSFWorkbook objWrkBook = new XSSFWorkbook(objFileStram);
				
		//Select Sheet form execl
		XSSFSheet objWrkBookSheet = objWrkBook.getSheetAt(2);
		
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		driver = new ChromeDriver();
		driver.get(bassurl);
		Thread.sleep(4000);
		
		//Define variable
		
		String firstName = null;
		String lastName = null;		
				
		       
				firstName=objWrkBookSheet.getRow(10).getCell(0).getStringCellValue();
				System.out.println(firstName);
		     
				lastName=objWrkBookSheet.getRow(10).getCell(1).getStringCellValue();
				System.out.println(lastName);
		       
	
		        driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[1]/input")).sendKeys(firstName);
				Thread.sleep(1000);
			

					driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[2]/input")).sendKeys(lastName);
					Thread.sleep(1000);

				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[3]/input[1]")).click();
				Thread.sleep(2000);
				
				driver.findElement(By.xpath("//*[@id=\"nextBtn\"]")).click();
				Thread.sleep(4000);
				
				//Validating email address format
				
				String email1 =null;
				try {
				email1= objWrkBookSheet.getRow(10).getCell(2).getStringCellValue();
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[2]/p[1]/input")).sendKeys(email1);
				Thread.sleep(1000);
				
				String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";			      
			      Boolean b = email1.matches(EMAIL_REGEX);
			      System.out.println("is e-mail: "+email1+" :Email Validation = " + b);
			      }
				catch (Exception e) {
					System.out.println("Error massage : Email address is Empty");
			     	}
				
								
				  
			     			      
				driver.close();
				objWrkBook.close();
	}
	@Test(priority=12)
	public void Q3_RegistrationForm_ContactDetailsPage_VerifyTheValiedMobileNumber() throws Exception {
		//FileRead object creating
		FileInputStream objFileStram = new FileInputStream(objFile);
			    
		//Create a execl workbook object
		XSSFWorkbook objWrkBook = new XSSFWorkbook(objFileStram);
				
		//Select Sheet form execl
		XSSFSheet objWrkBookSheet = objWrkBook.getSheetAt(2);
		
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		driver = new ChromeDriver();
		driver.get(bassurl);
		Thread.sleep(4000);
		
		//Define variable
		
		String firstName = null;
		String lastName = null;		
				
		       
				firstName=objWrkBookSheet.getRow(11).getCell(0).getStringCellValue();
				System.out.println(firstName);
		     
				lastName=objWrkBookSheet.getRow(11).getCell(1).getStringCellValue();
				System.out.println(lastName);
		       
	
		        driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[1]/input")).sendKeys(firstName);
				Thread.sleep(1000);
			

					driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[2]/input")).sendKeys(lastName);
					Thread.sleep(1000);

				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[3]/input[1]")).click();
				Thread.sleep(2000);
				
				driver.findElement(By.xpath("//*[@id=\"nextBtn\"]")).click();
				Thread.sleep(4000);
				
				//Validating email address format
				
				String email1 =null;
				try {
				email1= objWrkBookSheet.getRow(11).getCell(2).getStringCellValue();
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[2]/p[1]/input")).sendKeys(email1);
				Thread.sleep(1000);
				
				String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";			      
			      Boolean b = email1.matches(EMAIL_REGEX);
			      System.out.println("is e-mail: "+email1+" :Email Validation = " + b);
			      }
				catch (Exception e) {
					System.out.println("Error massage : Email address is Empty");
			     	}
				
					
				String mobile =null;
				
				try {
					mobile= objWrkBookSheet.getRow(11).getCell(3).getRawValue();
				System.out.println(mobile);
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[2]/p[2]/input")).sendKeys(mobile);
				Thread.sleep(1000);
				Boolean ph = mobile.matches("\\d{9}");
				System.out.println("is phone no : "+mobile+" :Phone no validation = " + ph);
				}
				catch (Exception e){
					System.out.println("Error massage : Mobile nunber is Empty");
				}
			     			      
				driver.close();
				objWrkBook.close();
	}
	
	@Test(priority=13)
	public void Q3_RegistrationForm_ContactDetailsPage_ErrorValidationForInvaliedMobileNumber() throws Exception {
		//FileRead object creating
		FileInputStream objFileStram = new FileInputStream(objFile);
			    
		//Create a execl workbook object
		XSSFWorkbook objWrkBook = new XSSFWorkbook(objFileStram);
				
		//Select Sheet form execl
		XSSFSheet objWrkBookSheet = objWrkBook.getSheetAt(2);
		
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		driver = new ChromeDriver();
		driver.get(bassurl);
		Thread.sleep(4000);
		
		//Define variable
		
		String firstName = null;
		String lastName = null;		
				
		       
				firstName=objWrkBookSheet.getRow(12).getCell(0).getStringCellValue();
				System.out.println(firstName);
		     
				lastName=objWrkBookSheet.getRow(12).getCell(1).getStringCellValue();
				System.out.println(lastName);
		       
	
		        driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[1]/input")).sendKeys(firstName);
				Thread.sleep(1000);
			

					driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[2]/input")).sendKeys(lastName);
					Thread.sleep(1000);

				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[3]/input[1]")).click();
				Thread.sleep(2000);
				
				driver.findElement(By.xpath("//*[@id=\"nextBtn\"]")).click();
				Thread.sleep(4000);
				
				//Validating email address format
				
				String email1 =null;
				try {
				email1= objWrkBookSheet.getRow(12).getCell(2).getStringCellValue();
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[2]/p[1]/input")).sendKeys(email1);
				Thread.sleep(1000);
				
				String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";			      
			      Boolean b = email1.matches(EMAIL_REGEX);
			      System.out.println("is e-mail: "+email1+" :Email Validation = " + b);
			      }
				catch (Exception e) {
					System.out.println("Error massage : Email address is Empty");
			     	}
				
					
				String mobile =null;
				
				try {
					mobile= objWrkBookSheet.getRow(12).getCell(3).getRawValue();
				System.out.println(mobile);
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[2]/p[2]/input")).sendKeys(mobile);
				Thread.sleep(1000);
				Boolean ph = mobile.matches("\\d{9}");
				System.out.println("is phone no : "+mobile+" :Phone no validation = " + ph);
				}
				catch (Exception e){
					System.out.println("Error massage : Mobile nunber is Empty");
				}
			     			      
				driver.close();
				objWrkBook.close();
	}
	
	@Test(priority=14)
	public void Q3_RegistrationForm_ContactDetailsPage_ErrorValidationForEmptyMobileNumber() throws Exception {
		//FileRead object creating
		FileInputStream objFileStram = new FileInputStream(objFile);
			    
		//Create a execl workbook object
		XSSFWorkbook objWrkBook = new XSSFWorkbook(objFileStram);
				
		//Select Sheet form execl
		XSSFSheet objWrkBookSheet = objWrkBook.getSheetAt(2);
		
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		driver = new ChromeDriver();
		driver.get(bassurl);
		Thread.sleep(4000);
		
		//Define variable
		
		String firstName = null;
		String lastName = null;		
				
		       
				firstName=objWrkBookSheet.getRow(13).getCell(0).getStringCellValue();
				System.out.println(firstName);
		     
				lastName=objWrkBookSheet.getRow(13).getCell(1).getStringCellValue();
				System.out.println(lastName);
		       
	
		        driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[1]/input")).sendKeys(firstName);
				Thread.sleep(1000);
			

					driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[2]/input")).sendKeys(lastName);
					Thread.sleep(1000);

				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[3]/input[1]")).click();
				Thread.sleep(2000);
				
				driver.findElement(By.xpath("//*[@id=\"nextBtn\"]")).click();
				Thread.sleep(4000);
				
				//Validating email address format
				
				String email1 =null;
				try {
				email1= objWrkBookSheet.getRow(13).getCell(2).getStringCellValue();
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[2]/p[1]/input")).sendKeys(email1);
				Thread.sleep(1000);
				
				String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";			      
			      Boolean b = email1.matches(EMAIL_REGEX);
			      System.out.println("is e-mail: "+email1+" :Email Validation = " + b);
			      }
				catch (Exception e) {
					System.out.println("Error massage : Email address is Empty");
			     	}
				
					
				String mobile =null;
				
				try {
					mobile= objWrkBookSheet.getRow(13).getCell(3).getRawValue();
				System.out.println(mobile);
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[2]/p[2]/input")).sendKeys(mobile);
				Thread.sleep(1000);
				Boolean ph = mobile.matches("\\d{9}");
				System.out.println("is phone no : "+mobile+" :Phone no validation = " + ph);
				}
				catch (Exception e){
					System.out.println("Error massage : Mobile nunber is Empty");
				}
			     			      
				driver.close();
				objWrkBook.close();
	}
	
	@Test(priority=15)
	public void Q3_RegistrationForm_ContactDetailsPage_SucessfullyAddingContactData() throws Exception {
		//FileRead object creating
		FileInputStream objFileStram = new FileInputStream(objFile);
			    
		//Create a execl workbook object
		XSSFWorkbook objWrkBook = new XSSFWorkbook(objFileStram);
				
		//Select Sheet form execl
		XSSFSheet objWrkBookSheet = objWrkBook.getSheetAt(2);
		
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		driver = new ChromeDriver();
		driver.get(bassurl);
		Thread.sleep(4000);
		
		//Define variable
		
		String firstName = null;
		String lastName = null;		
				
		       
				firstName=objWrkBookSheet.getRow(14).getCell(0).getStringCellValue();
				System.out.println(firstName);
		     
				lastName=objWrkBookSheet.getRow(14).getCell(1).getStringCellValue();
				System.out.println(lastName);
		       
	
		        driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[1]/input")).sendKeys(firstName);
				Thread.sleep(1000);
			

					driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[2]/input")).sendKeys(lastName);
					Thread.sleep(1000);

				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[3]/input[1]")).click();
				Thread.sleep(2000);
				
				driver.findElement(By.xpath("//*[@id=\"nextBtn\"]")).click();
				Thread.sleep(4000);
				
				//Validating email address format
				
				String email1 =null;
				try {
				email1= objWrkBookSheet.getRow(14).getCell(2).getStringCellValue();
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[2]/p[1]/input")).sendKeys(email1);
				Thread.sleep(1000);
				
				String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";			      
			      Boolean b = email1.matches(EMAIL_REGEX);
			      System.out.println("is e-mail: "+email1+" :Email Validation = " + b);
			      }
				catch (Exception e) {
					System.out.println("Error massage : Email address is Empty");
			     	}
				
					
				String mobile =null;
				
				try {
					mobile= objWrkBookSheet.getRow(14).getCell(3).getRawValue();
				System.out.println(mobile);
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[2]/p[2]/input")).sendKeys(mobile);
				Thread.sleep(1000);
				Boolean ph = mobile.matches("\\d{9}");
				System.out.println("is phone no : "+mobile+" :Phone no validation = " + ph);
				}
				catch (Exception e){
					System.out.println("Error massage : Mobile nunber is Empty");
				}
			     	
				
				driver.findElement(By.xpath("//*[@id=\"nextBtn\"]")).click();
				Thread.sleep(4000);
				driver.close();
				objWrkBook.close();
	}
	
	@Test(priority=16)
	public void Q3_RegistrationForm_BirthDayPage_ErrorValidationForEmptyData_Month_Year() throws Exception {
		//FileRead object creating
		FileInputStream objFileStram = new FileInputStream(objFile);
			    
		//Create a execl workbook object
		XSSFWorkbook objWrkBook = new XSSFWorkbook(objFileStram);
				
		//Select Sheet form execl
		XSSFSheet objWrkBookSheet = objWrkBook.getSheetAt(2);
		
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		driver = new ChromeDriver();
		driver.get(bassurl);
		Thread.sleep(4000);
		
		//Define variable
		
		String firstName = null;
		String lastName = null;		
				
		       
				firstName=objWrkBookSheet.getRow(15).getCell(0).getStringCellValue();
				System.out.println(firstName);
		     
				lastName=objWrkBookSheet.getRow(15).getCell(1).getStringCellValue();
				System.out.println(lastName);
		       
	
		        driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[1]/input")).sendKeys(firstName);
				Thread.sleep(1000);
			

				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[2]/input")).sendKeys(lastName);
				Thread.sleep(1000);

				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[3]/input[1]")).click();
				Thread.sleep(2000);
				
				driver.findElement(By.xpath("//*[@id=\"nextBtn\"]")).click();
				Thread.sleep(4000);
				
				//Validating email address format
				
				String email1 =null;
				try {
				email1= objWrkBookSheet.getRow(15).getCell(2).getStringCellValue();
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[2]/p[1]/input")).sendKeys(email1);
				Thread.sleep(1000);
				
				String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";			      
			      Boolean b = email1.matches(EMAIL_REGEX);
			      }
				catch (Exception e) {
					System.out.println("Error massage : Email address is Empty");
			     	}
				
					
				String mobile =null;
				
				try {
					mobile= objWrkBookSheet.getRow(15).getCell(3).getRawValue();
				System.out.println(mobile);
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[2]/p[2]/input")).sendKeys(mobile);
				Thread.sleep(1000);
				Boolean ph = mobile.matches("\\d{9}");
				}
				catch (Exception e){
					System.out.println("Error massage : Mobile nunber is Empty");
				}
			     	
				
				driver.findElement(By.xpath("//*[@id=\"nextBtn\"]")).click();
				Thread.sleep(4000);
				
				String date=null;
				String month=null;
				String year=null;
				
				try {
					date= objWrkBookSheet.getRow(15).getCell(4).getRawValue();
				System.out.println(date);
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[3]/p[1]/input")).sendKeys(date);
				Thread.sleep(1000);
				Boolean ph = date.matches("\\d{2}");
				System.out.println("Date : "+date+" :Date validation = " + ph);
				}
				catch (Exception e){
					System.out.println("Error massage : Date is Empty");
				}							
				
				try {
					month= objWrkBookSheet.getRow(15).getCell(5).getRawValue();
				System.out.println(date);
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[3]/p[2]/input")).sendKeys(month);
				Thread.sleep(1000);
				Boolean ph = month.matches("\\d{1}");
				System.out.println("Month : "+month+" :Month validation = " + ph);
				}
				catch (Exception e){
					System.out.println("Error massage : Month is Empty");
				}
				
				try {
					year= objWrkBookSheet.getRow(15).getCell(6).getRawValue();
				System.out.println(year);
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[3]/p[3]/input")).sendKeys(year);
				Thread.sleep(1000);
				Boolean ph = year.matches("\\d{4}");
				System.out.println("Year : "+year+" :Month validation = " + ph);
				}
				catch (Exception e){
					System.out.println("Error massage : Month is Empty");
				}					
				
				driver.close();
				objWrkBook.close();
	}
	
	@Test(priority=17)
	public void Q3_RegistrationForm_BirthDayPage_ErrorValidationForInvalid_Date_Month_Year() throws Exception {
		//FileRead object creating
		FileInputStream objFileStram = new FileInputStream(objFile);
			    
		//Create a execl workbook object
		XSSFWorkbook objWrkBook = new XSSFWorkbook(objFileStram);
				
		//Select Sheet form execl
		XSSFSheet objWrkBookSheet = objWrkBook.getSheetAt(2);
		
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		driver = new ChromeDriver();
		driver.get(bassurl);
		Thread.sleep(4000);
		
		//Define variable
		
		String firstName = null;
		String lastName = null;		
				
		       
				firstName=objWrkBookSheet.getRow(16).getCell(0).getStringCellValue();
				System.out.println(firstName);
		     
				lastName=objWrkBookSheet.getRow(16).getCell(1).getStringCellValue();
				System.out.println(lastName);
		       
	
		        driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[1]/input")).sendKeys(firstName);
				Thread.sleep(1000);
			

				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[2]/input")).sendKeys(lastName);
				Thread.sleep(1000);

				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[3]/input[1]")).click();
				Thread.sleep(2000);
				
				driver.findElement(By.xpath("//*[@id=\"nextBtn\"]")).click();
				Thread.sleep(4000);
				
				//Validating email address format
				
				String email1 =null;
				try {
				email1= objWrkBookSheet.getRow(16).getCell(2).getStringCellValue();
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[2]/p[1]/input")).sendKeys(email1);
				Thread.sleep(1000);
				
				String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";			      
			      Boolean b = email1.matches(EMAIL_REGEX);
			      }
				catch (Exception e) {
					System.out.println("Error massage : Email address is Empty");
			     	}
				
					
				String mobile =null;
				
				try {
					mobile= objWrkBookSheet.getRow(16).getCell(3).getRawValue();
				System.out.println(mobile);
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[2]/p[2]/input")).sendKeys(mobile);
				Thread.sleep(1000);
				Boolean ph = mobile.matches("\\d{9}");
				}
				catch (Exception e){
					System.out.println("Error massage : Mobile nunber is Empty");
				}
			     	
				
				driver.findElement(By.xpath("//*[@id=\"nextBtn\"]")).click();
				Thread.sleep(4000);
				
				String date=null;
				String month=null;
				String year=null;
				
				try {
					date= objWrkBookSheet.getRow(16).getCell(4).getRawValue();
				System.out.println(date);
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[3]/p[1]/input")).sendKeys(date);
				Thread.sleep(1000);
				Boolean ph = date.matches("\\d{2}");
				System.out.println("Date : "+date+" :Date validation = " + ph);
				}
				catch (Exception e){
					System.out.println(e+"Error massage : Date is Empty");
				}							
				
				try {
					month= objWrkBookSheet.getRow(16).getCell(5).getRawValue();
				System.out.println(date);
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[3]/p[2]/input")).sendKeys(month);
				Thread.sleep(1000);
				Boolean ph = month.matches("\\d{1}");
				System.out.println("Month : "+month+" :Month validation = " + ph);
				}
				catch (Exception e){
					System.out.println(e+ "Error massage : Month is Empty");
				}	
				
				try {
					year= objWrkBookSheet.getRow(16).getCell(6).getRawValue();
				System.out.println(year);
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[3]/p[3]/input")).sendKeys(year);
				Thread.sleep(1000);
				Boolean ph = year.matches("\\d{4}");
				System.out.println("Year : "+year+" :Month validation = " + ph);
				}
				catch (Exception e){
					System.out.println("Error massage : Month is Empty");
				}			
				
				driver.close();
				objWrkBook.close();
	}
	
	@Test(priority=18)
	public void Q3_RegistrationForm_BirthDayPage_ValidateYear() throws Exception {
		//FileRead object creating
		FileInputStream objFileStram = new FileInputStream(objFile);
			    
		//Create a execl workbook object
		XSSFWorkbook objWrkBook = new XSSFWorkbook(objFileStram);
				
		//Select Sheet form execl
		XSSFSheet objWrkBookSheet = objWrkBook.getSheetAt(2);
		
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		driver = new ChromeDriver();
		driver.get(bassurl);
		Thread.sleep(4000);
		
		//Define variable
		
		String firstName = null;
		String lastName = null;		
				
		       
				firstName=objWrkBookSheet.getRow(17).getCell(0).getStringCellValue();
				System.out.println(firstName);
		     
				lastName=objWrkBookSheet.getRow(17).getCell(1).getStringCellValue();
				System.out.println(lastName);
		       
	
		        driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[1]/input")).sendKeys(firstName);
				Thread.sleep(1000);
			

				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[2]/input")).sendKeys(lastName);
				Thread.sleep(1000);

				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[3]/input[1]")).click();
				Thread.sleep(2000);
				
				driver.findElement(By.xpath("//*[@id=\"nextBtn\"]")).click();
				Thread.sleep(4000);
				
				//Validating email address format
				
				String email1 =null;
				try {
				email1= objWrkBookSheet.getRow(17).getCell(2).getStringCellValue();
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[2]/p[1]/input")).sendKeys(email1);
				Thread.sleep(1000);
				
				String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";			      
			      Boolean b = email1.matches(EMAIL_REGEX);
			      }
				catch (Exception e) {
					System.out.println("Error massage : Email address is Empty");
			     	}
				
					
				String mobile =null;
				
				try {
					mobile= objWrkBookSheet.getRow(17).getCell(3).getRawValue();
				System.out.println(mobile);
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[2]/p[2]/input")).sendKeys(mobile);
				Thread.sleep(1000);
				Boolean ph = mobile.matches("\\d{9}");
				}
				catch (Exception e){
					System.out.println("Error massage : Mobile nunber is Empty");
				}
			     	
				
				driver.findElement(By.xpath("//*[@id=\"nextBtn\"]")).click();
				Thread.sleep(4000);
				
				String date=null;
				String month=null;
				String year=null;
				
				try {
					date= objWrkBookSheet.getRow(17).getCell(4).getRawValue();
				System.out.println(date);
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[3]/p[1]/input")).sendKeys(date);
				Thread.sleep(1000);
				Boolean ph = date.matches("\\d{2}");
				System.out.println("Date : "+date+" :Date validation = " + ph);
				}
				catch (Exception e){
					System.out.println("Error massage : Date is Empty");
				}							
				
				try {
					month= objWrkBookSheet.getRow(17).getCell(5).getRawValue();
				System.out.println(date);
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[3]/p[2]/input")).sendKeys(month);
				Thread.sleep(1000);
				Boolean ph = month.matches("\\d{1}");
				System.out.println("Month : "+month+" :Month validation = " + ph);
				}
				catch (Exception e){
					System.out.println("Error massage : Month is Empty");
				}
				
				try {
					year= objWrkBookSheet.getRow(17).getCell(6).getRawValue();
				System.out.println(year);
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[3]/p[3]/input")).sendKeys(year);
				Thread.sleep(1000);
				Boolean ph = year.matches("\\d{4}");
				System.out.println("Year : "+year+" :Month validation = " + ph);
				}
				catch (Exception e){
					System.out.println("Error massage : Month is Empty");
				}		
				driver.close();
				objWrkBook.close();
	}
	
	@Test(priority=19)
	public void Q3_RegistrationForm_UserInformtionPage_PageLoading() throws Exception {
		//FileRead object creating
		FileInputStream objFileStram = new FileInputStream(objFile);
			    
		//Create a execl workbook object
		XSSFWorkbook objWrkBook = new XSSFWorkbook(objFileStram);
				
		//Select Sheet form execl
		XSSFSheet objWrkBookSheet = objWrkBook.getSheetAt(2);
		
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		driver = new ChromeDriver();
		driver.get(bassurl);
		Thread.sleep(4000);
		
		//Define variable
		
		String firstName = null;
		String lastName = null;		
				
		       
				firstName=objWrkBookSheet.getRow(18).getCell(0).getStringCellValue();
				System.out.println(firstName);
		     
				lastName=objWrkBookSheet.getRow(18).getCell(1).getStringCellValue();
				System.out.println(lastName);
		       
	
		        driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[1]/input")).sendKeys(firstName);
				Thread.sleep(1000);
			

				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[2]/input")).sendKeys(lastName);
				Thread.sleep(1000);

				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[3]/input[1]")).click();
				Thread.sleep(2000);
				
				driver.findElement(By.xpath("//*[@id=\"nextBtn\"]")).click();
				Thread.sleep(4000);
				
				//Validating email address format
				
				String email1 =null;
				try {
				email1= objWrkBookSheet.getRow(18).getCell(2).getStringCellValue();
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[2]/p[1]/input")).sendKeys(email1);
				Thread.sleep(1000);
				
				String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";			      
			      Boolean b = email1.matches(EMAIL_REGEX);
			      }
				catch (Exception e) {
					System.out.println("Error massage : Email address is Empty");
			     	}
				
					
				String mobile =null;
				
				try {
					mobile= objWrkBookSheet.getRow(18).getCell(3).getRawValue();
				System.out.println(mobile);
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[2]/p[2]/input")).sendKeys(mobile);
				Thread.sleep(1000);
				Boolean ph = mobile.matches("\\d{9}");
				}
				catch (Exception e){
					System.out.println("Error massage : Mobile nunber is Empty");
				}
			     	
				
				driver.findElement(By.xpath("//*[@id=\"nextBtn\"]")).click();
				Thread.sleep(4000);
				
				String date=null;
				String month=null;
				String year=null;
				
				try {
					date= objWrkBookSheet.getRow(18).getCell(4).getRawValue();
				System.out.println(date);
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[3]/p[1]/input")).sendKeys(date);
				Thread.sleep(1000);
				}
				catch (Exception e){
					System.out.println("Error massage : Date is Empty");
				}							
				
				try {
					month= objWrkBookSheet.getRow(18).getCell(5).getRawValue();
				System.out.println(date);
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[3]/p[2]/input")).sendKeys(month);
				Thread.sleep(1000);
				}
				catch (Exception e){
					System.out.println("Error massage : Month is Empty");
				}
				
				try {
					year= objWrkBookSheet.getRow(18).getCell(6).getRawValue();
				System.out.println(year);
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[3]/p[3]/input")).sendKeys(year);
				Thread.sleep(1000);
				}
				catch (Exception e){
					System.out.println("Error massage : Month is Empty");
				}	
				
				driver.findElement(By.xpath("//*[@id=\"nextBtn\"]")).click();
				Thread.sleep(4000);
				driver.close();
				objWrkBook.close();
	}
	
	@Test(priority=20)
	public void Q3_RegistrationForm_UserInfrorationPage_ErrorValidataionForEmptyUserName() throws Exception {
		//FileRead object creating
		FileInputStream objFileStram = new FileInputStream(objFile);
			    
		//Create a execl workbook object
		XSSFWorkbook objWrkBook = new XSSFWorkbook(objFileStram);
				
		//Select Sheet form execl
		XSSFSheet objWrkBookSheet = objWrkBook.getSheetAt(2);
		
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		driver = new ChromeDriver();
		driver.get(bassurl);
		Thread.sleep(4000);
		
		//Define variable
		
		String firstName = null;
		String lastName = null;		
				
		       
				firstName=objWrkBookSheet.getRow(19).getCell(0).getStringCellValue();
				System.out.println(firstName);
		     
				lastName=objWrkBookSheet.getRow(19).getCell(1).getStringCellValue();
				System.out.println(lastName);
		       
	
		        driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[1]/input")).sendKeys(firstName);
				Thread.sleep(1000);
			

				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[2]/input")).sendKeys(lastName);
				Thread.sleep(1000);

				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[3]/input[1]")).click();
				Thread.sleep(2000);
				
				driver.findElement(By.xpath("//*[@id=\"nextBtn\"]")).click();
				Thread.sleep(4000);
				
				//Validating email address format
				
				String email1 =null;
				try {
				email1= objWrkBookSheet.getRow(19).getCell(2).getStringCellValue();
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[2]/p[1]/input")).sendKeys(email1);
				Thread.sleep(1000);
				
				String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";			      
			      Boolean b = email1.matches(EMAIL_REGEX);
			      }
				catch (Exception e) {
					System.out.println("Error massage : Email address is Empty");
			     	}
				
					
				String mobile =null;
				
				try {
					mobile= objWrkBookSheet.getRow(19).getCell(3).getRawValue();
				System.out.println(mobile);
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[2]/p[2]/input")).sendKeys(mobile);
				Thread.sleep(1000);
				Boolean ph = mobile.matches("\\d{9}");
				}
				catch (Exception e){
					System.out.println("Error massage : Mobile nunber is Empty");
				}
			     	
				
				driver.findElement(By.xpath("//*[@id=\"nextBtn\"]")).click();
				Thread.sleep(4000);
				
				String date=null;
				String month=null;
				String year=null;
				
				try {
					date= objWrkBookSheet.getRow(19).getCell(4).getRawValue();
				System.out.println(date);
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[3]/p[1]/input")).sendKeys(date);
				Thread.sleep(1000);
				}
				catch (Exception e){
					System.out.println("Error massage : Date is Empty");
				}							
				
				try {
					month= objWrkBookSheet.getRow(19).getCell(5).getRawValue();
				System.out.println(date);
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[3]/p[2]/input")).sendKeys(month);
				Thread.sleep(1000);
				}
				catch (Exception e){
					System.out.println("Error massage : Month is Empty");
				}
				
				try {
					year= objWrkBookSheet.getRow(19).getCell(6).getRawValue();
				System.out.println(year);
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[3]/p[3]/input")).sendKeys(year);
				Thread.sleep(1000);
				}
				catch (Exception e){
					System.out.println("Error massage : Month is Empty");
				}	
				
				driver.findElement(By.xpath("//*[@id=\"nextBtn\"]")).click();
				Thread.sleep(4000);
				
				String userName=null;
				String missingData=null;
				try {
					userName=objWrkBookSheet.getRow(19).getCell(7).getStringCellValue();
					System.out.println(userName);
			        }catch(Exception e) {
						missingData = "User Name is empty";
						System.out.println(missingData);
					}
				
				driver.close();
				objWrkBook.close();
	}
	
	@Test(priority=21)
	public void Q3_RegistrationForm_UserInfrorationPage_ErrorValidationForMaxLengthExcededUserName() throws Exception {
		//FileRead object creating
		FileInputStream objFileStram = new FileInputStream(objFile);
			    
		//Create a execl workbook object
		XSSFWorkbook objWrkBook = new XSSFWorkbook(objFileStram);
				
		//Select Sheet form execl
		XSSFSheet objWrkBookSheet = objWrkBook.getSheetAt(2);
		
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		driver = new ChromeDriver();
		driver.get(bassurl);
		Thread.sleep(4000);
		
		//Define variable
		
		String firstName = null;
		String lastName = null;		
				
		       
				firstName=objWrkBookSheet.getRow(20).getCell(0).getStringCellValue();
				System.out.println(firstName);
		     
				lastName=objWrkBookSheet.getRow(20).getCell(1).getStringCellValue();
				System.out.println(lastName);
		       
	
		        driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[1]/input")).sendKeys(firstName);
				Thread.sleep(1000);
			

				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[2]/input")).sendKeys(lastName);
				Thread.sleep(1000);

				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[3]/input[1]")).click();
				Thread.sleep(2000);
				
				driver.findElement(By.xpath("//*[@id=\"nextBtn\"]")).click();
				Thread.sleep(4000);
				
				//Validating email address format
				
				String email1 =null;
				try {
				email1= objWrkBookSheet.getRow(20).getCell(2).getStringCellValue();
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[2]/p[1]/input")).sendKeys(email1);
				Thread.sleep(1000);
				
				String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";			      
			      Boolean b = email1.matches(EMAIL_REGEX);
			      }
				catch (Exception e) {
					System.out.println("Error massage : Email address is Empty");
			     	}
				
					
				String mobile =null;
				
				try {
					mobile= objWrkBookSheet.getRow(20).getCell(3).getRawValue();
				System.out.println(mobile);
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[2]/p[2]/input")).sendKeys(mobile);
				Thread.sleep(1000);
				Boolean ph = mobile.matches("\\d{9}");
				}
				catch (Exception e){
					System.out.println("Error massage : Mobile nunber is Empty");
				}
			     	
				
				driver.findElement(By.xpath("//*[@id=\"nextBtn\"]")).click();
				Thread.sleep(4000);
				
				String date=null;
				String month=null;
				String year=null;
				
				try {
					date= objWrkBookSheet.getRow(20).getCell(4).getRawValue();
				System.out.println(date);
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[3]/p[1]/input")).sendKeys(date);
				Thread.sleep(1000);
				}
				catch (Exception e){
					System.out.println("Error massage : Date is Empty");
				}							
				
				try {
					month= objWrkBookSheet.getRow(20).getCell(5).getRawValue();
				System.out.println(date);
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[3]/p[2]/input")).sendKeys(month);
				Thread.sleep(1000);
				}
				catch (Exception e){
					System.out.println("Error massage : Month is Empty");
				}
				
				try {
					year= objWrkBookSheet.getRow(20).getCell(6).getRawValue();
				System.out.println(year);
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[3]/p[3]/input")).sendKeys(year);
				Thread.sleep(1000);
				}
				catch (Exception e){
					System.out.println("Error massage : Month is Empty");
				}	
				
				driver.findElement(By.xpath("//*[@id=\"nextBtn\"]")).click();
				Thread.sleep(4000);
				
				String userName=null;
				String missingData=null;
				try {
					userName=objWrkBookSheet.getRow(20).getCell(7).getStringCellValue();
					if(userName.length()>15)
					{
						System.out.println("User name is exceding miximun character length");
					}else {
					System.out.println("Sucessful user name :" + userName);
					driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[4]/p[1]/input")).sendKeys(userName);
					}
			        }catch(Exception e) {
						missingData = "User Name is empty";
						System.out.println(missingData);
					}
				
				driver.close();
				objWrkBook.close();
	}
	
	@Test(priority=22)
	public void Q3_RegistrationForm_UserInfrorationPage_VerifyMaxLengthNotExcededUserName() throws Exception {
		//FileRead object creating
		FileInputStream objFileStram = new FileInputStream(objFile);
			    
		//Create a execl workbook object
		XSSFWorkbook objWrkBook = new XSSFWorkbook(objFileStram);
				
		//Select Sheet form execl
		XSSFSheet objWrkBookSheet = objWrkBook.getSheetAt(2);
		
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		driver = new ChromeDriver();
		driver.get(bassurl);
		Thread.sleep(4000);
		
		//Define variable
		
		String firstName = null;
		String lastName = null;		
				
		       
				firstName=objWrkBookSheet.getRow(21).getCell(0).getStringCellValue();
				System.out.println(firstName);
		     
				lastName=objWrkBookSheet.getRow(21).getCell(1).getStringCellValue();
				System.out.println(lastName);
		       
	
		        driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[1]/input")).sendKeys(firstName);
				Thread.sleep(1000);
			

				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[2]/input")).sendKeys(lastName);
				Thread.sleep(1000);

				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[3]/input[1]")).click();
				Thread.sleep(2000);
				
				driver.findElement(By.xpath("//*[@id=\"nextBtn\"]")).click();
				Thread.sleep(4000);
				
				//Validating email address format
				
				String email1 =null;
				try {
				email1= objWrkBookSheet.getRow(21).getCell(2).getStringCellValue();
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[2]/p[1]/input")).sendKeys(email1);
				Thread.sleep(1000);
				
				String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";			      
			      Boolean b = email1.matches(EMAIL_REGEX);
			      }
				catch (Exception e) {
					System.out.println("Error massage : Email address is Empty");
			     	}
				
					
				String mobile =null;
				
				try {
					mobile= objWrkBookSheet.getRow(21).getCell(3).getRawValue();
				System.out.println(mobile);
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[2]/p[2]/input")).sendKeys(mobile);
				Thread.sleep(1000);
				Boolean ph = mobile.matches("\\d{9}");
				}
				catch (Exception e){
					System.out.println("Error massage : Mobile nunber is Empty");
				}
			     	
				
				driver.findElement(By.xpath("//*[@id=\"nextBtn\"]")).click();
				Thread.sleep(4000);
				
				String date=null;
				String month=null;
				String year=null;
				
				try {
					date= objWrkBookSheet.getRow(21).getCell(4).getRawValue();
				System.out.println(date);
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[3]/p[1]/input")).sendKeys(date);
				Thread.sleep(1000);
				}
				catch (Exception e){
					System.out.println("Error massage : Date is Empty");
				}							
				
				try {
					month= objWrkBookSheet.getRow(21).getCell(5).getRawValue();
				System.out.println(date);
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[3]/p[2]/input")).sendKeys(month);
				Thread.sleep(1000);
				}
				catch (Exception e){
					System.out.println("Error massage : Month is Empty");
				}
				
				try {
					year= objWrkBookSheet.getRow(21).getCell(6).getRawValue();
				System.out.println(year);
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[3]/p[3]/input")).sendKeys(year);
				Thread.sleep(1000);
				}
				catch (Exception e){
					System.out.println("Error massage : Month is Empty");
				}	
				
				driver.findElement(By.xpath("//*[@id=\"nextBtn\"]")).click();
				Thread.sleep(4000);
				
				String userName=null;
				String missingData=null;
				try {
					userName=objWrkBookSheet.getRow(21).getCell(7).getStringCellValue();
					if(userName.length()>15)
					{
						System.out.println("User name is exceding miximun character length");
					}else {
					System.out.println("Sucessful user name :" + userName);
					driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[4]/p[1]/input")).sendKeys(userName);
					}
			        }catch(Exception e) {
						missingData = "User Name is empty";
						System.out.println(missingData);
					}
				
				driver.close();
				objWrkBook.close();
	}
	
	@Test(priority=23)
	public void Q3_RegistrationForm_UserInfrorationPage_ErrorValidationForInvaliedUserName() throws Exception {
		//FileRead object creating
		FileInputStream objFileStram = new FileInputStream(objFile);
			    
		//Create a execl workbook object
		XSSFWorkbook objWrkBook = new XSSFWorkbook(objFileStram);
				
		//Select Sheet form execl
		XSSFSheet objWrkBookSheet = objWrkBook.getSheetAt(2);
		
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		driver = new ChromeDriver();
		driver.get(bassurl);
		Thread.sleep(4000);
		
		//Define variable
		
		String firstName = null;
		String lastName = null;		
				
		       
				firstName=objWrkBookSheet.getRow(22).getCell(0).getStringCellValue();
				System.out.println(firstName);
		     
				lastName=objWrkBookSheet.getRow(22).getCell(1).getStringCellValue();
				System.out.println(lastName);
		       
	
		        driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[1]/input")).sendKeys(firstName);
				Thread.sleep(1000);
			

				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[2]/input")).sendKeys(lastName);
				Thread.sleep(1000);

				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[3]/input[1]")).click();
				Thread.sleep(2000);
				
				driver.findElement(By.xpath("//*[@id=\"nextBtn\"]")).click();
				Thread.sleep(4000);
				
				//Validating email address format
				
				String email1 =null;
				try {
				email1= objWrkBookSheet.getRow(22).getCell(2).getStringCellValue();
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[2]/p[1]/input")).sendKeys(email1);
				Thread.sleep(1000);
				
				String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";			      
			      Boolean b = email1.matches(EMAIL_REGEX);
			      }
				catch (Exception e) {
					System.out.println("Error massage : Email address is Empty");
			     	}
				
					
				String mobile =null;
				
				try {
					mobile= objWrkBookSheet.getRow(22).getCell(3).getRawValue();
				System.out.println(mobile);
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[2]/p[2]/input")).sendKeys(mobile);
				Thread.sleep(1000);
				Boolean ph = mobile.matches("\\d{9}");
				}
				catch (Exception e){
					System.out.println("Error massage : Mobile nunber is Empty");
				}
			     	
				
				driver.findElement(By.xpath("//*[@id=\"nextBtn\"]")).click();
				Thread.sleep(4000);
				
				String date=null;
				String month=null;
				String year=null;
				
				try {
					date= objWrkBookSheet.getRow(22).getCell(4).getRawValue();
				System.out.println(date);
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[3]/p[1]/input")).sendKeys(date);
				Thread.sleep(1000);
				}
				catch (Exception e){
					System.out.println("Error massage : Date is Empty");
				}							
				
				try {
					month= objWrkBookSheet.getRow(22).getCell(5).getRawValue();
				System.out.println(date);
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[3]/p[2]/input")).sendKeys(month);
				Thread.sleep(1000);
				}
				catch (Exception e){
					System.out.println("Error massage : Month is Empty");
				}
				
				try {
					year= objWrkBookSheet.getRow(22).getCell(6).getRawValue();
				System.out.println(year);
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[3]/p[3]/input")).sendKeys(year);
				Thread.sleep(1000);
				}
				catch (Exception e){
					System.out.println("Error massage : Month is Empty");
				}	
				
				driver.findElement(By.xpath("//*[@id=\"nextBtn\"]")).click();
				Thread.sleep(4000);
				
				String userName=null;
				String missingData=null;
				try {
					userName=objWrkBookSheet.getRow(22).getCell(7).getStringCellValue();
					System.out.println(userName);
					Pattern pattern = Pattern.compile("^[a-z0-9_-]{3,15}$");
					Matcher matcher = pattern.matcher(userName);
				    boolean result = matcher.matches();
				    System.out.println(result);
				    
				    if(result) {
				    	System.out.println("Valide User Name");
				    }else {
				    	System.out.println("InValide User Name");
				    }
					
					
			        }catch(Exception e) {
						missingData = "User Name is empty";
						System.out.println(missingData);
					}
				
				driver.close();
				objWrkBook.close();
	}
	
	@Test(priority=24)
	public void Q3_RegistrationForm_UserInfrorationPage_VerifyTheValiedUserName() throws Exception {
		//FileRead object creating
		FileInputStream objFileStram = new FileInputStream(objFile);
			    
		//Create a execl workbook object
		XSSFWorkbook objWrkBook = new XSSFWorkbook(objFileStram);
				
		//Select Sheet form execl
		XSSFSheet objWrkBookSheet = objWrkBook.getSheetAt(2);
		
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		driver = new ChromeDriver();
		driver.get(bassurl);
		Thread.sleep(4000);
		
		//Define variable
		
		String firstName = null;
		String lastName = null;		
				
		       
				firstName=objWrkBookSheet.getRow(23).getCell(0).getStringCellValue();
				System.out.println(firstName);
		     
				lastName=objWrkBookSheet.getRow(23).getCell(1).getStringCellValue();
				System.out.println(lastName);
		       
	
		        driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[1]/input")).sendKeys(firstName);
				Thread.sleep(1000);
			

				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[2]/input")).sendKeys(lastName);
				Thread.sleep(1000);

				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[3]/input[1]")).click();
				Thread.sleep(2000);
				
				driver.findElement(By.xpath("//*[@id=\"nextBtn\"]")).click();
				Thread.sleep(4000);
				
				//Validating email address format
				
				String email1 =null;
				try {
				email1= objWrkBookSheet.getRow(23).getCell(2).getStringCellValue();
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[2]/p[1]/input")).sendKeys(email1);
				Thread.sleep(1000);
				
				String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";			      
			      Boolean b = email1.matches(EMAIL_REGEX);
			      }
				catch (Exception e) {
					System.out.println("Error massage : Email address is Empty");
			     	}
				
					
				String mobile =null;
				
				try {
					mobile= objWrkBookSheet.getRow(23).getCell(3).getRawValue();
				System.out.println(mobile);
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[2]/p[2]/input")).sendKeys(mobile);
				Thread.sleep(1000);
				Boolean ph = mobile.matches("\\d{9}");
				}
				catch (Exception e){
					System.out.println("Error massage : Mobile nunber is Empty");
				}
			     	
				
				driver.findElement(By.xpath("//*[@id=\"nextBtn\"]")).click();
				Thread.sleep(4000);
				
				String date=null;
				String month=null;
				String year=null;
				
				try {
					date= objWrkBookSheet.getRow(23).getCell(4).getRawValue();
				System.out.println(date);
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[3]/p[1]/input")).sendKeys(date);
				Thread.sleep(1000);
				}
				catch (Exception e){
					System.out.println("Error massage : Date is Empty");
				}							
				
				try {
					month= objWrkBookSheet.getRow(23).getCell(5).getRawValue();
				System.out.println(date);
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[3]/p[2]/input")).sendKeys(month);
				Thread.sleep(1000);
				}
				catch (Exception e){
					System.out.println("Error massage : Month is Empty");
				}
				
				try {
					year= objWrkBookSheet.getRow(23).getCell(6).getRawValue();
				System.out.println(year);
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[3]/p[3]/input")).sendKeys(year);
				Thread.sleep(1000);
				}
				catch (Exception e){
					System.out.println("Error massage : Month is Empty");
				}	
				
				driver.findElement(By.xpath("//*[@id=\"nextBtn\"]")).click();
				Thread.sleep(4000);
				
				String userName=null;
				String missingData=null;
				try {
					userName=objWrkBookSheet.getRow(23).getCell(7).getStringCellValue();
					System.out.println(userName);
					Pattern pattern = Pattern.compile("^[a-z0-9_-]{3,16}$");
					Matcher matcher = pattern.matcher(userName);
				    boolean result = matcher.matches();
				    System.out.println(result);
				    
				    if(result) {
				    	System.out.println("Valide User Name");
				    	driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[4]/p[1]/input")).sendKeys(userName);
				    	Thread.sleep(3000);
				    	
				    }else {
				    	System.out.println("InValide User Name");
				    }
					
					
			        }catch(Exception e) {
						missingData = "User Name is empty";
						System.out.println(missingData);
					}
				
				driver.close();
				objWrkBook.close();
	}
	
	@Test(priority=25)
	public void Q3_RegistrationForm_UserInfrorationPage_ErrorValidationForEmptyPassword() throws Exception {
		//FileRead object creating
		FileInputStream objFileStram = new FileInputStream(objFile);
			    
		//Create a execl workbook object
		XSSFWorkbook objWrkBook = new XSSFWorkbook(objFileStram);
				
		//Select Sheet form execl
		XSSFSheet objWrkBookSheet = objWrkBook.getSheetAt(2);
		
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		driver = new ChromeDriver();
		driver.get(bassurl);
		Thread.sleep(4000);
		
		//Define variable
		
		String firstName = null;
		String lastName = null;		
				
		       
				firstName=objWrkBookSheet.getRow(24).getCell(0).getStringCellValue();
				System.out.println(firstName);
		     
				lastName=objWrkBookSheet.getRow(24).getCell(1).getStringCellValue();
				System.out.println(lastName);
		       
	
		        driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[1]/input")).sendKeys(firstName);
				Thread.sleep(1000);
			

				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[2]/input")).sendKeys(lastName);
				Thread.sleep(1000);

				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[3]/input[1]")).click();
				Thread.sleep(2000);
				
				driver.findElement(By.xpath("//*[@id=\"nextBtn\"]")).click();
				Thread.sleep(4000);
				
				//Validating email address format
				
				String email1 =null;
				try {
				email1= objWrkBookSheet.getRow(24).getCell(2).getStringCellValue();
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[2]/p[1]/input")).sendKeys(email1);
				Thread.sleep(1000);
				
				String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";			      
			      Boolean b = email1.matches(EMAIL_REGEX);
			      }
				catch (Exception e) {
					System.out.println("Error massage : Email address is Empty");
			     	}
				
					
				String mobile =null;
				
				try {
					mobile= objWrkBookSheet.getRow(24).getCell(3).getRawValue();
				System.out.println(mobile);
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[2]/p[2]/input")).sendKeys(mobile);
				Thread.sleep(1000);
				Boolean ph = mobile.matches("\\d{9}");
				}
				catch (Exception e){
					System.out.println("Error massage : Mobile nunber is Empty");
				}
			     	
				
				driver.findElement(By.xpath("//*[@id=\"nextBtn\"]")).click();
				Thread.sleep(4000);
				
				String date=null;
				String month=null;
				String year=null;
				
				try {
					date= objWrkBookSheet.getRow(24).getCell(4).getRawValue();
				System.out.println(date);
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[3]/p[1]/input")).sendKeys(date);
				Thread.sleep(1000);
				}
				catch (Exception e){
					System.out.println("Error massage : Date is Empty");
				}							
				
				try {
					month= objWrkBookSheet.getRow(24).getCell(5).getRawValue();
				System.out.println(date);
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[3]/p[2]/input")).sendKeys(month);
				Thread.sleep(1000);
				}
				catch (Exception e){
					System.out.println("Error massage : Month is Empty");
				}
				
				try {
					year= objWrkBookSheet.getRow(24).getCell(6).getRawValue();
				System.out.println(year);
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[3]/p[3]/input")).sendKeys(year);
				Thread.sleep(1000);
				}
				catch (Exception e){
					System.out.println("Error massage : Month is Empty");
				}	
				
				driver.findElement(By.xpath("//*[@id=\"nextBtn\"]")).click();
				Thread.sleep(4000);
				
				String userName=null;
				String missingData=null;
				try {
					userName=objWrkBookSheet.getRow(24).getCell(7).getStringCellValue();
					System.out.println(userName);
					Pattern pattern = Pattern.compile("^[a-z0-9_-]{3,16}$");
					Matcher matcher = pattern.matcher(userName);
				    boolean result = matcher.matches();
				    System.out.println(result);
				    
				    if(result) {
				    	System.out.println("Valide User Name");
				    	driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[4]/p[1]/input")).sendKeys(userName);
				    	Thread.sleep(3000);
				    	
				    }else {
				    	System.out.println("InValide User Name");
				    }
					
					
			        }catch(Exception e) {
						missingData = "User Name is empty";
						System.out.println(missingData);
					}
				
				
				String password=null;
				try {
					password=objWrkBookSheet.getRow(24).getCell(8).getStringCellValue();
					System.out.println(password);
					
			        }catch(Exception e) {
						missingData = "Password is empty";
						System.out.println(missingData);
					}
				driver.close();
				objWrkBook.close();
	}
	
	@Test(priority=26)
	public void Q3_RegistrationForm_UserInfrorationPage_VerifyPasswordValidation() throws Exception {
		//FileRead object creating
		FileInputStream objFileStram = new FileInputStream(objFile);
			    
		//Create a execl workbook object
		XSSFWorkbook objWrkBook = new XSSFWorkbook(objFileStram);
				
		//Select Sheet form execl
		XSSFSheet objWrkBookSheet = objWrkBook.getSheetAt(2);
		
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		driver = new ChromeDriver();
		driver.get(bassurl);
		Thread.sleep(4000);
		
		//Define variable
		
		String firstName = null;
		String lastName = null;		
				
		       
				firstName=objWrkBookSheet.getRow(24).getCell(0).getStringCellValue();
				System.out.println(firstName);
		     
				lastName=objWrkBookSheet.getRow(24).getCell(1).getStringCellValue();
				System.out.println(lastName);
		       
	
		        driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[1]/input")).sendKeys(firstName);
				Thread.sleep(1000);
			

				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[2]/input")).sendKeys(lastName);
				Thread.sleep(1000);

				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[3]/input[1]")).click();
				Thread.sleep(2000);
				
				driver.findElement(By.xpath("//*[@id=\"nextBtn\"]")).click();
				Thread.sleep(4000);
				
				//Validating email address format
				
				String email1 =null;
				try {
				email1= objWrkBookSheet.getRow(24).getCell(2).getStringCellValue();
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[2]/p[1]/input")).sendKeys(email1);
				Thread.sleep(1000);
				
				String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";			      
			      Boolean b = email1.matches(EMAIL_REGEX);
			      }
				catch (Exception e) {
					System.out.println("Error massage : Email address is Empty");
			     	}
				
					
				String mobile =null;
				
				try {
					mobile= objWrkBookSheet.getRow(24).getCell(3).getRawValue();
				System.out.println(mobile);
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[2]/p[2]/input")).sendKeys(mobile);
				Thread.sleep(1000);
				Boolean ph = mobile.matches("\\d{9}");
				}
				catch (Exception e){
					System.out.println("Error massage : Mobile nunber is Empty");
				}
			     	
				
				driver.findElement(By.xpath("//*[@id=\"nextBtn\"]")).click();
				Thread.sleep(4000);
				
				String date=null;
				String month=null;
				String year=null;
				
				try {
					date= objWrkBookSheet.getRow(24).getCell(4).getRawValue();
				System.out.println(date);
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[3]/p[1]/input")).sendKeys(date);
				Thread.sleep(1000);
				}
				catch (Exception e){
					System.out.println("Error massage : Date is Empty");
				}							
				
				try {
					month= objWrkBookSheet.getRow(24).getCell(5).getRawValue();
				System.out.println(date);
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[3]/p[2]/input")).sendKeys(month);
				Thread.sleep(1000);
				}
				catch (Exception e){
					System.out.println("Error massage : Month is Empty");
				}
				
				try {
					year= objWrkBookSheet.getRow(24).getCell(6).getRawValue();
				System.out.println(year);
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[3]/p[3]/input")).sendKeys(year);
				Thread.sleep(1000);
				}
				catch (Exception e){
					System.out.println("Error massage : Month is Empty");
				}	
				
				driver.findElement(By.xpath("//*[@id=\"nextBtn\"]")).click();
				Thread.sleep(4000);
				
				String userName=null;
				String missingData=null;
				try {
					userName=objWrkBookSheet.getRow(24).getCell(7).getStringCellValue();
					System.out.println(userName);
					Pattern pattern = Pattern.compile("^[a-z0-9_-]{3,16}$");
					Matcher matcher = pattern.matcher(userName);
				    boolean result = matcher.matches();
				    System.out.println(result);
				    
				    if(result) {
				    	System.out.println("Valide User Name");
				    	driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[4]/p[1]/input")).sendKeys(userName);
				    	Thread.sleep(3000);
				    	
				    }else {
				    	System.out.println("InValide User Name");
				    }
					
					
			        }catch(Exception e) {
						missingData = "User Name is empty";
						System.out.println(missingData);
					}
				
				
				String[] password= {"testata1A@","atATa12$","aT1A@","atestat12@","testAt12*","aatanG$$","AKILA12$"};
				String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
				Matcher matcher;
				
				Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
				
				for(int i=0;i<7;i++) {
					driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[4]/p[2]/input")).sendKeys(password[i]);
					Thread.sleep(1000);
					matcher = pattern.matcher(password[i]);
					boolean result= matcher.matches();
					System.out.println("Passowrd is :"+password[i] + " Validation : " + result);
					driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[4]/p[2]/input")).clear();
					Thread.sleep(1000);
				}
				driver.close();
				objWrkBook.close();
	}
	
	@Test(priority=27)
	public void Q3_RegistrationForm_UserInfrorationPage_SucessfulUserRegistration() throws Exception {
		//FileRead object creating
		FileInputStream objFileStram = new FileInputStream(objFile);
			    
		//Create a execl workbook object
		XSSFWorkbook objWrkBook = new XSSFWorkbook(objFileStram);
				
		//Select Sheet form execl
		XSSFSheet objWrkBookSheet = objWrkBook.getSheetAt(2);
		
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		driver = new ChromeDriver();
		driver.get(bassurl);
		Thread.sleep(4000);
		
		//Define variable
		
		String firstName = null;
		String lastName = null;		
				
		       
				firstName=objWrkBookSheet.getRow(24).getCell(0).getStringCellValue();
				System.out.println(firstName);
		     
				lastName=objWrkBookSheet.getRow(24).getCell(1).getStringCellValue();
				System.out.println(lastName);
		       
	
		        driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[1]/input")).sendKeys(firstName);
				Thread.sleep(1000);
			

				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[2]/input")).sendKeys(lastName);
				Thread.sleep(1000);

				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[1]/p[3]/input[1]")).click();
				Thread.sleep(2000);
				
				driver.findElement(By.xpath("//*[@id=\"nextBtn\"]")).click();
				Thread.sleep(4000);
				
				//Validating email address format
				
				String email1 =null;
				try {
				email1= objWrkBookSheet.getRow(24).getCell(2).getStringCellValue();
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[2]/p[1]/input")).sendKeys(email1);
				Thread.sleep(1000);
				
				String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";			      
			      Boolean b = email1.matches(EMAIL_REGEX);
			      }
				catch (Exception e) {
					System.out.println("Error massage : Email address is Empty");
			     	}
				
					
				String mobile =null;
				
				try {
					mobile= objWrkBookSheet.getRow(24).getCell(3).getRawValue();
				System.out.println(mobile);
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[2]/p[2]/input")).sendKeys(mobile);
				Thread.sleep(1000);
				Boolean ph = mobile.matches("\\d{9}");
				}
				catch (Exception e){
					System.out.println("Error massage : Mobile nunber is Empty");
				}
			     	
				
				driver.findElement(By.xpath("//*[@id=\"nextBtn\"]")).click();
				Thread.sleep(4000);
				
				String date=null;
				String month=null;
				String year=null;
				
				try {
					date= objWrkBookSheet.getRow(24).getCell(4).getRawValue();
				System.out.println(date);
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[3]/p[1]/input")).sendKeys(date);
				Thread.sleep(1000);
				}
				catch (Exception e){
					System.out.println("Error massage : Date is Empty");
				}							
				
				try {
					month= objWrkBookSheet.getRow(24).getCell(5).getRawValue();
				System.out.println(date);
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[3]/p[2]/input")).sendKeys(month);
				Thread.sleep(1000);
				}
				catch (Exception e){
					System.out.println("Error massage : Month is Empty");
				}
				
				try {
					year= objWrkBookSheet.getRow(24).getCell(6).getRawValue();
				System.out.println(year);
				driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[3]/p[3]/input")).sendKeys(year);
				Thread.sleep(1000);
				}
				catch (Exception e){
					System.out.println("Error massage : Month is Empty");
				}	
				
				driver.findElement(By.xpath("//*[@id=\"nextBtn\"]")).click();
				Thread.sleep(4000);
				
				String userName=null;
				String missingData=null;
				try {
					userName=objWrkBookSheet.getRow(24).getCell(7).getStringCellValue();
					System.out.println(userName);
					Pattern pattern = Pattern.compile("^[a-z0-9_-]{3,16}$");
					Matcher matcher = pattern.matcher(userName);
				    boolean result = matcher.matches();
				    System.out.println(result);
				    
				    if(result) {
				    	System.out.println("Valide User Name");
				    	driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[4]/p[1]/input")).sendKeys(userName);
				    	Thread.sleep(3000);
				    	
				    }else {
				    	System.out.println("InValide User Name");
				    }
					
					
			        }catch(Exception e) {
						missingData = "User Name is empty";
						System.out.println(missingData);
					}
				
				
				String password= "testata1A@";
				String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
				Matcher matcher;
				
				Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
				
				
					driver.findElement(By.xpath("//*[@id=\"regForm\"]/div[4]/p[2]/input")).sendKeys(password);
					Thread.sleep(1000);
					matcher = pattern.matcher(password);
					boolean result= matcher.matches();
					System.out.println("Passowrd is :"+password + " Validation : " + result);
					
					driver.findElement(By.xpath("//*[@id=\"nextBtn\"]")).click();
					System.out.println("User registration completed");
					Thread.sleep(1000);
	
				driver.close();
				objWrkBook.close();
	}
}
