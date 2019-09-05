package Question3;

import java.io.File;
import java.io.FileInputStream;
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
	public void loadLogin() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		driver = new ChromeDriver();
		driver.get(bassurl);
		Thread.sleep(4000);
		
		String ExpectedHeading = "Register Form: SQA Professional Program – Batch 13 – SLIIT";
		driver.close();
		
	}
	
	@Test(priority=2)
	public void emptyFirstNameValidation() throws Exception {
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
	public void emptyLastNameValidation() throws Exception {
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
	public void FirstNameLengthValidation() throws Exception {
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
	public void LastNameLengthValidation() throws Exception {
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
	public void invaliedFirstNameValidation() throws Exception {
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
	public void invaliedLastNameValidation() throws Exception {
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
	public void LoadContactDetailsPage() throws Exception {
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
	public void EmailAddressValidation_True() throws Exception {
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
	public void EmailAddressValidation_False() throws Exception {
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
	public void Empty_EmailAddress() throws Exception {
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
	public void MobileNumberValidation() throws Exception {
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
	public void MobileNumberValidation_False() throws Exception {
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
	public void Empty_MobileNumber() throws Exception {
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
	
	@Test(priority=14)
	public void AddAllContactData() throws Exception {
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
}
