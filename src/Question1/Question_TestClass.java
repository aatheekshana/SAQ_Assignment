package Question1;

import org.testng.Assert;
import org.testng.annotations.Test;


import java.io.File;
import java.io.FileInputStream;
import java.util.regex.Pattern;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Question_TestClass {
 
	String bassurl="D:\\Selenium Project\\AssignmentQuestion\\Assignment_Answers\\WebFile\\Question1.html";
	String ChromeDriverPath = "D:\\Selenium Project\\AssignmentQuestion\\Assignment_Answers\\Lib\\Chrome\\chromedriver.exe";
	
	public WebDriver driver;
	
	//get file form location
	File objFile = new File("D:\\Selenium Project\\AssignmentQuestion\\Assignment_Answers\\ExternalData\\QuestionTestData.xlsx");
	
	
	@Test(priority=-1)
	public void loadLogin() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		driver = new ChromeDriver();
		driver.get(bassurl);
		driver.close();
	}
	
	@Test(priority=1)
	public void CheckDefaultCountryValue()throws Exception{
		//Set properties for chrome drivers
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		driver = new ChromeDriver();
		
		//Get the bass URL
		driver.get(bassurl);
		
		//Select value from  drop down
		Select drpCountry = new Select(driver.findElement(By.name("country")));
		drpCountry.selectByIndex(0);
		Thread.sleep(1000);
		
		String Country = driver.findElement(By.name("country")).getAttribute("value");
		String ExpectedValue="australia";
		
		System.out.println("Default value is " + Country);
		//Assert expected and actual values
		  Assert.assertEquals(Country,ExpectedValue);
		  driver.close();
	}
	
	@Test(priority=2)
	public void FillAllData()throws Exception {
		
		//FileRead object creating
				FileInputStream objFileStram = new FileInputStream(objFile);
			    
				//Create a execl workbook object
				XSSFWorkbook objWrkBook = new XSSFWorkbook(objFileStram);
				
				//Select Sheet form execl
				XSSFSheet objWrkBookSheet = objWrkBook.getSheetAt(0);
		
				//Set properties for chrome drivers
				System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
				driver = new ChromeDriver();
				
				//Get the bass URL
				driver.get(bassurl);
				
				//Get value from Excel
				String firstName = objWrkBookSheet.getRow(0).getCell(0).getStringCellValue();
				String lastName =objWrkBookSheet.getRow(0).getCell(1).getStringCellValue();
				String country =objWrkBookSheet.getRow(0).getCell(2).getStringCellValue();
				String subject =objWrkBookSheet.getRow(0).getCell(3).getStringCellValue();
				
				
				//Fiil the data for fields 
				driver.findElement(By.xpath("//*[@id=\"fname\"]")).sendKeys(firstName);
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id=\"lname\"]")).sendKeys(lastName);
				Thread.sleep(1000);
				
				//Select value from  drop down
				Select drpCountry = new Select(driver.findElement(By.name("country")));
				drpCountry.selectByVisibleText(country);
				Thread.sleep(1000);
				
				driver.findElement(By.xpath("//*[@id=\"subject\"]")).sendKeys(subject);
				Thread.sleep(1000);
				
				//Check the field validation
				String missingData = "Empty";
				String ActualValue ="";
				

				if(driver.findElement(By.name("firstname")).getAttribute("value") == null){
				  missingData = "First Name missing";
				  ActualValue=missingData;
				}
				if(driver.findElement(By.name("lastname")).getAttribute("value") == null){
					  missingData = "Last Name missing";
					  ActualValue=missingData;
				}
				if(driver.findElement(By.name("subject")).getAttribute("value") == null){
					  missingData = "Subject missing";
					  ActualValue=missingData;
					}
				
				if (missingData=="Empty") {
					System.out.println("All the data added sucessfully");
					ActualValue="All the data added sucessfully";
				}
				else {
					System.out.println(missingData);
				}
				
		
				String ExpectedValue ="All the data added sucessfully";
				
				//Assert expected and actual values
				  Assert.assertEquals(ActualValue,ExpectedValue);
				  driver.close();
				  objWrkBook.close();
	}
	
	@Test(priority=3)
	public void EmptyFirstName()throws Exception {
		
		//FileRead object creating
				FileInputStream objFileStram = new FileInputStream(objFile);
			    
				//Create a execl workbook object
				XSSFWorkbook objWrkBook = new XSSFWorkbook(objFileStram);
				
				//Select Sheet form execl
				XSSFSheet objWrkBookSheet = objWrkBook.getSheetAt(0);
		
				//Set properties for chrome drivers
				System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
				driver = new ChromeDriver();
				
				//Get the bass URL
				driver.get(bassurl);
				
			
				
				//Define variable
				String missingData = "Empty";
				String ActualValue ="Empyt";
				
				String firstName=null;
				String lastName=null;
				String country="Australia";
				String subject=null;
			
			//Get value from Excel
				
				//Get first name
				try {
				 firstName = objWrkBookSheet.getRow(1).getCell(0).getStringCellValue();
				}catch(Exception e) {
					missingData = "First Name is missing";
					ActualValue=missingData;
				}
				
				//Get Last Name
				try {
				 lastName =objWrkBookSheet.getRow(1).getCell(1).getStringCellValue();
				}catch(Exception e) {
					missingData = "Last Name is missing";
					ActualValue=missingData;
				}
				
				//Get country
				try {
				 country =objWrkBookSheet.getRow(1).getCell(2).getStringCellValue();
				}catch(Exception e) {
					missingData = "Invalid country";
					ActualValue=missingData;
				}
				//Get subject
				try {
				 subject =objWrkBookSheet.getRow(1).getCell(3).getStringCellValue();
				}catch(Exception e) {
					missingData = "Subject is missing";
					ActualValue=missingData;
				}
				
				
				
				System.out.println("Values are "+ lastName+ " " + country +" " + subject);
				
				
				//Fil the data for fields 
				
				
				driver.findElement(By.xpath("//*[@id=\"lname\"]")).sendKeys(lastName);
				Thread.sleep(1000);
				
				//Select value from  drop down
				Select drpCountry = new Select(driver.findElement(By.name("country")));
				drpCountry.selectByVisibleText(country);
				Thread.sleep(1000);
				
				driver.findElement(By.xpath("//*[@id=\"subject\"]")).sendKeys(subject);
				Thread.sleep(1000);
				
				//Check the field validation
								
				if (missingData=="Empty") {
					System.out.println("All the data added sucessfully");
					ActualValue="All the data added sucessfully";
				}
				else {
					System.out.println("Error Validation : " + missingData);
				}
				
		
				String ExpectedValue ="First Name is missing";
				
				//Assert expected and actual values
				  Assert.assertEquals(ActualValue,ExpectedValue);
				  driver.close();
				  objWrkBook.close();
	}
	
	@Test(priority=4)
	public void EmptyLastName()throws Exception {
		
		//FileRead object creating
				FileInputStream objFileStram = new FileInputStream(objFile);
			    
				//Create a execl workbook object
				XSSFWorkbook objWrkBook = new XSSFWorkbook(objFileStram);
				
				//Select Sheet form execl
				XSSFSheet objWrkBookSheet = objWrkBook.getSheetAt(0);
		
				//Set properties for chrome drivers
				System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
				driver = new ChromeDriver();
				
				//Get the bass URL
				driver.get(bassurl);
				
			
				
				//Define variable
				String missingData = "Empty";
				String ActualValue ="Empyt";
				
				String firstName=null;
				String lastName=null;
				String country="Australia";
				String subject=null;
			
			//Get value from Excel
				
				//Get first name
				try {
				 firstName = objWrkBookSheet.getRow(2).getCell(0).getStringCellValue();
				}catch(Exception e) {
					missingData = "First Name is missing";
					ActualValue=missingData;
				}
				
				//Get Last Name
				try {
				 lastName =objWrkBookSheet.getRow(2).getCell(1).getStringCellValue();
				}catch(Exception e) {
					missingData = "Last Name is missing";
					ActualValue=missingData;
				}
				
				//Get country
				try {
				 country =objWrkBookSheet.getRow(2).getCell(2).getStringCellValue();
				 
				}catch(Exception e) {
					missingData = "Incorrect country ";
					ActualValue=missingData;
				}
				//Get subject
				try {
				 subject =objWrkBookSheet.getRow(2).getCell(3).getStringCellValue();
				}catch(Exception e) {
					missingData = "Subject is missing";
					ActualValue=missingData;
				}
				
				
				
				System.out.println("Values are "+ firstName+ " " + country +" " + subject);
				
				
				//Fil the data for fields 
				
				
				driver.findElement(By.xpath("//*[@id=\"fname\"]")).sendKeys(firstName);
				Thread.sleep(1000);
				
				//Select value from  drop down
				Select drpCountry = new Select(driver.findElement(By.name("country")));
				drpCountry.selectByVisibleText(country);
				Thread.sleep(1000);
				
				driver.findElement(By.xpath("//*[@id=\"subject\"]")).sendKeys(subject);
				Thread.sleep(1000);
				
				//Check the field validation
								
				if (missingData=="Empty") {
					System.out.println("All the data added sucessfully");
					ActualValue="All the data added sucessfully";
				}
				else {
					System.out.println("Error Validation : " + missingData);
				}
				
		
				String ExpectedValue ="Last Name is missing";
				
				//Assert expected and actual values
				  Assert.assertEquals(ActualValue,ExpectedValue);
				  driver.close();
				  objWrkBook.close();
	}
	
	@Test(priority=5)
	public void EmptySubject()throws Exception {
		
		//FileRead object creating
				FileInputStream objFileStram = new FileInputStream(objFile);
			    
				//Create a execl workbook object
				XSSFWorkbook objWrkBook = new XSSFWorkbook(objFileStram);
				
				//Select Sheet form execl
				XSSFSheet objWrkBookSheet = objWrkBook.getSheetAt(0);
		
				//Set properties for chrome drivers
				System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
				driver = new ChromeDriver();
				
				//Get the bass URL
				driver.get(bassurl);
				
			
				
				//Define variable
				String missingData = "Empty";
				String ActualValue ="Empyt";
				
				String firstName=null;
				String lastName=null;
				String country="Australia";
				String subject=null;
			
			//Get value from Excel
				
				//Get first name
				try {
				 firstName = objWrkBookSheet.getRow(3).getCell(0).getStringCellValue();
				}catch(Exception e) {
					missingData = "First Name is missing";
					ActualValue=missingData;
				}
				
				//Get Last Name
				try {
				 lastName =objWrkBookSheet.getRow(3).getCell(1).getStringCellValue();
				}catch(Exception e) {
					missingData = "Last Name is missing";
					ActualValue=missingData;
				}
				
				//Get country
				try {
				 country =objWrkBookSheet.getRow(3).getCell(2).getStringCellValue();
				 
				 if(country=="Australia"||country=="Canada"||country=="USA"||country=="Sri Lanka") {
					 
				 }else {
					    missingData = "Invalid country";
						ActualValue=missingData; 
				 }
				}catch(Exception e) {
					missingData = "Incorrect country ";
					ActualValue=missingData;
				}
				//Get subject
				try {
				 subject =objWrkBookSheet.getRow(3).getCell(3).getStringCellValue();
				}catch(Exception e) {
					missingData = "Subject is missing";
					ActualValue=missingData;
				}
				
				
				
				System.out.println("Values are "+ firstName+ " "+ lastName+ " " + country);
				
				
				//Fil the data for fields 
				
				
				driver.findElement(By.xpath("//*[@id=\"fname\"]")).sendKeys(firstName);
				Thread.sleep(1000);
				
				driver.findElement(By.xpath("//*[@id=\"lname\"]")).sendKeys(lastName);
				Thread.sleep(1000);
				
				//Select value from  drop down
				Select drpCountry = new Select(driver.findElement(By.name("country")));
				drpCountry.selectByVisibleText(country);
				Thread.sleep(1000);
				
				
				//Check the field validation
								
				if (missingData=="Empty") {
					System.out.println("All the data added sucessfully");
					ActualValue="All the data added sucessfully";
				}
				else {
					System.out.println("Error Validation : " + missingData);
				}
				
		
				String ExpectedValue ="Subject is missing";
				
				//Assert expected and actual values
				  Assert.assertEquals(ActualValue,ExpectedValue);
				  driver.close();
				  objWrkBook.close();
	}
	
	@Test(priority=6)
	public void MaxLengthFirstName()throws Exception {
		
		//FileRead object creating
				FileInputStream objFileStram = new FileInputStream(objFile);
			    
				//Create a execl workbook object
				XSSFWorkbook objWrkBook = new XSSFWorkbook(objFileStram);
				
				//Select Sheet form execl
				XSSFSheet objWrkBookSheet = objWrkBook.getSheetAt(0);
		
				//Set properties for chrome drivers
				System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
				driver = new ChromeDriver();
				
				//Get the bass URL
				driver.get(bassurl);
				
				//Define variable
				String ActualValue ="Empyt";
				
				//Get value from Excel
				String firstName = objWrkBookSheet.getRow(4).getCell(0).getStringCellValue();
				String lastName =objWrkBookSheet.getRow(4).getCell(1).getStringCellValue();
				String country =objWrkBookSheet.getRow(4).getCell(2).getStringCellValue();
				String subject =objWrkBookSheet.getRow(4).getCell(3).getStringCellValue();
				
				if(firstName.length()>10) {
					ActualValue = "First Name length is exceding maximun character length";
					System.out.println("Error Validation : "+ ActualValue);
				}else {
				//Fiil the data for fields 
				driver.findElement(By.xpath("//*[@id=\"fname\"]")).sendKeys(firstName);
				Thread.sleep(1000);
				}
				driver.findElement(By.xpath("//*[@id=\"lname\"]")).sendKeys(lastName);
				Thread.sleep(1000);
				
				//Select value from  drop down
				Select drpCountry = new Select(driver.findElement(By.name("country")));
				drpCountry.selectByVisibleText(country);
				Thread.sleep(1000);
				
				driver.findElement(By.xpath("//*[@id=\"subject\"]")).sendKeys(subject);
				Thread.sleep(1000);
				
				String ExpectedValue="First Name length is exceding maximun character length";
				//Assert expected and actual values
				  Assert.assertEquals(ActualValue,ExpectedValue);
				  driver.close();
				  objWrkBook.close();
	}
	
	@Test(priority=7)
	public void MaxLengthLastName()throws Exception {
		
		//Purpose of this Testcase : Maximum length of last name is 20 and user should not be able to add more than 20 characters for last name. Verify the 
		//proper validation is given when user try to give the lengthy text for last name
		
		//FileRead object creating
				FileInputStream objFileStram = new FileInputStream(objFile);
			    
				//Create a execl workbook object
				XSSFWorkbook objWrkBook = new XSSFWorkbook(objFileStram);
				
				//Select Sheet form execl
				XSSFSheet objWrkBookSheet = objWrkBook.getSheetAt(0);
		
				//Set properties for chrome drivers
				System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
				driver = new ChromeDriver();
				
				//Get the bass URL
				driver.get(bassurl);
				
				//Define variable
				String ActualValue ="Empyt";
				
				//Get value from Excel
				String firstName = objWrkBookSheet.getRow(6).getCell(0).getStringCellValue();
				String lastName =objWrkBookSheet.getRow(6).getCell(1).getStringCellValue();
				String country =objWrkBookSheet.getRow(6).getCell(2).getStringCellValue();
				String subject =objWrkBookSheet.getRow(6).getCell(3).getStringCellValue();
				
				
				
				driver.findElement(By.xpath("//*[@id=\"fname\"]")).sendKeys(firstName);
				Thread.sleep(1000);
			
				
				if(lastName.length()>20) {
					ActualValue = "Last Name length is exceding maximun character length";
					System.out.println("Error Validation : "+ ActualValue);
				}
				else {
					//Fiil the data for fields 
				driver.findElement(By.xpath("//*[@id=\"lname\"]")).sendKeys(lastName);
				Thread.sleep(1000);
				ActualValue = "Last name length is within range";
				System.out.println(ActualValue);
				}
				
				//Select value from  drop down
				Select drpCountry = new Select(driver.findElement(By.name("country")));
				drpCountry.selectByVisibleText(country);
				Thread.sleep(1000);
				
				driver.findElement(By.xpath("//*[@id=\"subject\"]")).sendKeys(subject);
				Thread.sleep(1000);
				
				String ExpectedValue="Last Name length is exceding maximun character length";
				//Assert expected and actual values
				  Assert.assertEquals(ActualValue,ExpectedValue);
				  driver.close();
				  objWrkBook.close();
	}
	
	@Test(priority=8)
	public void MaxLengthBoundryWithFirstName()throws Exception {
		
		//Purpose of this Testcase : Maximum length of first name is 10 and maximum count (10) is validating in this test case
		
		//FileRead object creating
				FileInputStream objFileStram = new FileInputStream(objFile);
			    
				//Create a execl workbook object
				XSSFWorkbook objWrkBook = new XSSFWorkbook(objFileStram);
				
				//Select Sheet form execl
				XSSFSheet objWrkBookSheet = objWrkBook.getSheetAt(0);
		
				//Set properties for chrome drivers
				System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
				driver = new ChromeDriver();
				
				//Get the bass URL
				driver.get(bassurl);
				
				//Define variable
				String ActualValue ="Empyt";
				
				//Get value from Excel
				String firstName = objWrkBookSheet.getRow(5).getCell(0).getStringCellValue();
				String lastName =objWrkBookSheet.getRow(5).getCell(1).getStringCellValue();
				String country =objWrkBookSheet.getRow(5).getCell(2).getStringCellValue();
				String subject =objWrkBookSheet.getRow(5).getCell(3).getStringCellValue();
				
				if(firstName.length()>10) {
					ActualValue = "First Name length is exceding maximun character length";
					System.out.println("Error Validation : "+ ActualValue);
				}else {
				//Fiil the data for fields 
				driver.findElement(By.xpath("//*[@id=\"fname\"]")).sendKeys(firstName);
				ActualValue = "First name length is within range";
				System.out.println(ActualValue);
				Thread.sleep(1000);
				}
				driver.findElement(By.xpath("//*[@id=\"lname\"]")).sendKeys(lastName);
				Thread.sleep(1000);
				
				//Select value from  drop down
				Select drpCountry = new Select(driver.findElement(By.name("country")));
				drpCountry.selectByVisibleText(country);
				Thread.sleep(1000);
				
				driver.findElement(By.xpath("//*[@id=\"subject\"]")).sendKeys(subject);
				Thread.sleep(1000);
				
				String ExpectedValue="First name length is within range";
				//Assert expected and actual values
				  Assert.assertEquals(ActualValue,ExpectedValue);
				  driver.close();
				  objWrkBook.close();
	}
	
	@Test(priority=9)
	public void MaxLengthBoundryWithLastName()throws Exception {
		
		//Purpose of this Testcase : Maximum length of last name is 20 and user should be able to add 20 characters for last name. Verify the 
		//user able to add max count of characters in the last name field
		
		//FileRead object creating
				FileInputStream objFileStram = new FileInputStream(objFile);
			    
				//Create a execl workbook object
				XSSFWorkbook objWrkBook = new XSSFWorkbook(objFileStram);
				
				//Select Sheet form execl
				XSSFSheet objWrkBookSheet = objWrkBook.getSheetAt(0);
		
				//Set properties for chrome drivers
				System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
				driver = new ChromeDriver();
				
				//Get the bass URL
				driver.get(bassurl);
				
				//Define variable
				String ActualValue ="Empyt";
				
				//Get value from Excel
				String firstName = objWrkBookSheet.getRow(7).getCell(0).getStringCellValue();
				String lastName =objWrkBookSheet.getRow(7).getCell(1).getStringCellValue();
				String country =objWrkBookSheet.getRow(7).getCell(2).getStringCellValue();
				String subject =objWrkBookSheet.getRow(7).getCell(3).getStringCellValue();
				
				
				
				driver.findElement(By.xpath("//*[@id=\"fname\"]")).sendKeys(firstName);
				Thread.sleep(1000);
			
				
				if(lastName.length()>20) {
					ActualValue = "Last Name length is exceding maximun character length";
					System.out.println("Error Validation : "+ ActualValue);
				}
				else {
					//Fiil the data for fields 
				driver.findElement(By.xpath("//*[@id=\"lname\"]")).sendKeys(lastName);
				Thread.sleep(1000);
				ActualValue = "Last name length is within range";
				System.out.println(ActualValue);
				}
				
				//Select value from  drop down
				Select drpCountry = new Select(driver.findElement(By.name("country")));
				drpCountry.selectByVisibleText(country);
				Thread.sleep(1000);
				
				driver.findElement(By.xpath("//*[@id=\"subject\"]")).sendKeys(subject);
				Thread.sleep(1000);
				
				String ExpectedValue="Last name length is within range";
				//Assert expected and actual values
				  Assert.assertEquals(ActualValue,ExpectedValue);
				  driver.close();
				  objWrkBook.close();
	}
	
	
	@Test(priority=10)
	public void MaxLengthSubject()throws Exception {
		
		//FileRead object creating
				FileInputStream objFileStram = new FileInputStream(objFile);
			    
				//Create a execl workbook object
				XSSFWorkbook objWrkBook = new XSSFWorkbook(objFileStram);
				
				//Select Sheet form execl
				XSSFSheet objWrkBookSheet = objWrkBook.getSheetAt(0);
		
				//Set properties for chrome drivers
				System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
				driver = new ChromeDriver();
				
				//Get the bass URL
				driver.get(bassurl);
				
				//Define variable
				String ActualValue ="Empyt";
				
				//Get value from Excel
				String firstName = objWrkBookSheet.getRow(8).getCell(0).getStringCellValue();
				String lastName =objWrkBookSheet.getRow(8).getCell(1).getStringCellValue();
				String country =objWrkBookSheet.getRow(8).getCell(2).getStringCellValue();
				String subject =objWrkBookSheet.getRow(8).getCell(3).getStringCellValue();
				
				
				//Fiil the data for fields 
				driver.findElement(By.xpath("//*[@id=\"fname\"]")).sendKeys(firstName);
				Thread.sleep(1000);
			
				driver.findElement(By.xpath("//*[@id=\"lname\"]")).sendKeys(lastName);
				Thread.sleep(1000);
				
				//Select value from  drop down
				Select drpCountry = new Select(driver.findElement(By.name("country")));
				drpCountry.selectByVisibleText(country);
				Thread.sleep(1000);
				
				if(subject.length()>30) {
					ActualValue = "Subject length is exceding miximun character length";
					System.out.println("Error Validation : "+ ActualValue);
				}else {
				//Fiil the data for fields 
				driver.findElement(By.xpath("//*[@id=\"subject\"]")).sendKeys(subject);
				Thread.sleep(1000);
				ActualValue = "Subject length is within range";
				System.out.println(ActualValue);
				}
				
				String ExpectedValue="Subject length is exceding miximun character length";
				//Assert expected and actual values
				  Assert.assertEquals(ActualValue,ExpectedValue);
				  driver.close();
				  objWrkBook.close();
	}
	
	@Test(priority=10)
	public void MaxLengthBoundryWithSubject()throws Exception {
		
		//FileRead object creating
				FileInputStream objFileStram = new FileInputStream(objFile);
			    
				//Create a execl workbook object
				XSSFWorkbook objWrkBook = new XSSFWorkbook(objFileStram);
				
				//Select Sheet form execl
				XSSFSheet objWrkBookSheet = objWrkBook.getSheetAt(0);
		
				//Set properties for chrome drivers
				System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
				driver = new ChromeDriver();
				
				//Get the bass URL
				driver.get(bassurl);
				
				//Define variable
				String ActualValue ="Empyt";
				
				//Get value from Excel
				String firstName = objWrkBookSheet.getRow(9).getCell(0).getStringCellValue();
				String lastName =objWrkBookSheet.getRow(9).getCell(1).getStringCellValue();
				String country =objWrkBookSheet.getRow(9).getCell(2).getStringCellValue();
				String subject =objWrkBookSheet.getRow(9).getCell(3).getStringCellValue();
				
				
				//Fiil the data for fields 
				driver.findElement(By.xpath("//*[@id=\"fname\"]")).sendKeys(firstName);
				Thread.sleep(1000);
			
				driver.findElement(By.xpath("//*[@id=\"lname\"]")).sendKeys(lastName);
				Thread.sleep(1000);
				
				//Select value from  drop down
				Select drpCountry = new Select(driver.findElement(By.name("country")));
				drpCountry.selectByVisibleText(country);
				Thread.sleep(1000);
				
				if(subject.length()>30) {
					ActualValue = "Subject length is exceding miximun character length";
					System.out.println("Error Validation : "+ ActualValue);
				}else {
				//Fiil the data for fields 
				driver.findElement(By.xpath("//*[@id=\"subject\"]")).sendKeys(subject);
				Thread.sleep(1000);
				ActualValue = "Subject length is within range";
				System.out.println(ActualValue);
				}
				
				String ExpectedValue="Subject length is within range";
				//Assert expected and actual values
				  Assert.assertEquals(ActualValue,ExpectedValue);
				  driver.close();
				  objWrkBook.close();
	}
	
	@Test(priority=11)
	public void MultipleLineForSubject()throws Exception {
		
		//FileRead object creating
				FileInputStream objFileStram = new FileInputStream(objFile);
			    
				//Create a execl workbook object
				XSSFWorkbook objWrkBook = new XSSFWorkbook(objFileStram);
				
				//Select Sheet form execl
				XSSFSheet objWrkBookSheet = objWrkBook.getSheetAt(0);
		
				//Set properties for chrome drivers
				System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
				driver = new ChromeDriver();
				
				//Get the bass URL
				driver.get(bassurl);
				
				//Get value from Excel
				String firstName = objWrkBookSheet.getRow(10).getCell(0).getStringCellValue();
				String lastName =objWrkBookSheet.getRow(10).getCell(1).getStringCellValue();
				String country =objWrkBookSheet.getRow(10).getCell(2).getStringCellValue();
				String subject =objWrkBookSheet.getRow(10).getCell(3).getStringCellValue();
				
				
				//Fiil the data for fields 
				driver.findElement(By.xpath("//*[@id=\"fname\"]")).sendKeys(firstName);
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id=\"lname\"]")).sendKeys(lastName);
				Thread.sleep(1000);
				
				//Select value from  drop down
				Select drpCountry = new Select(driver.findElement(By.name("country")));
				drpCountry.selectByVisibleText(country);
				Thread.sleep(1000);
				
				driver.findElement(By.xpath("//*[@id=\"subject\"]")).sendKeys(subject);
				Thread.sleep(1000);
				
				//Check the field validation
				String missingData = "Empty";
				String ActualValue ="";
				

				if(driver.findElement(By.name("firstname")).getAttribute("value") == null){
				  missingData = "First Name missing";
				  ActualValue=missingData;
				}
				if(driver.findElement(By.name("lastname")).getAttribute("value") == null){
					  missingData = "Last Name missing";
					  ActualValue=missingData;
				}
				if(driver.findElement(By.name("subject")).getAttribute("value") == null){
					  missingData = "Subject missing";
					  ActualValue=missingData;
					}
				
				if (missingData=="Empty") {
					System.out.println("All the data added sucessfully");
					ActualValue="All the data added sucessfully";
				}
				else {
					System.out.println(missingData);
				}
				
		
				String ExpectedValue ="All the data added sucessfully";
				
				//Assert expected and actual values
				  Assert.assertEquals(ActualValue,ExpectedValue);
				  driver.close();
				  objWrkBook.close();
	}
	
	@Test(priority=12)
	public void IncorrectFormatOfFirstName()throws Exception {
		
		//FileRead object creating
				FileInputStream objFileStram = new FileInputStream(objFile);
			    
				//Create a execl workbook object
				XSSFWorkbook objWrkBook = new XSSFWorkbook(objFileStram);
				
				//Select Sheet form execl
				XSSFSheet objWrkBookSheet = objWrkBook.getSheetAt(0);
		
				//Set properties for chrome drivers
				System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
				driver = new ChromeDriver();
				
				//Get the bass URL
				driver.get(bassurl);
				
				//Define variable
				String ActualValue ="Empyt";
				
				//Get value from Excel
				String firstName = objWrkBookSheet.getRow(11).getCell(0).getStringCellValue();
				String lastName =objWrkBookSheet.getRow(11).getCell(1).getStringCellValue();
				String country =objWrkBookSheet.getRow(11).getCell(2).getStringCellValue();
				String subject =objWrkBookSheet.getRow(11).getCell(3).getStringCellValue();
				
				if(Pattern.compile( "[0-9]" ).matcher(firstName ).find()) {
					ActualValue = "First Name include invalidate characters";
					System.out.println("Error Validation : "+ ActualValue);
				}else {
				//Fiil the data for fields 
				driver.findElement(By.xpath("//*[@id=\"fname\"]")).sendKeys(firstName);
				Thread.sleep(1000);
				}
				driver.findElement(By.xpath("//*[@id=\"lname\"]")).sendKeys(lastName);
				Thread.sleep(1000);
				
				//Select value from  drop down
				Select drpCountry = new Select(driver.findElement(By.name("country")));
				drpCountry.selectByVisibleText(country);
				Thread.sleep(1000);
				
				driver.findElement(By.xpath("//*[@id=\"subject\"]")).sendKeys(subject);
				Thread.sleep(1000);
				
				String ExpectedValue="First Name include invalidate characters";
				//Assert expected and actual values
				  Assert.assertEquals(ActualValue,ExpectedValue);
				  driver.close();
				  objWrkBook.close();
	}
	
	@Test(priority=13)
	public void IncorrectFormatOfLastName()throws Exception {
		
		//FileRead object creating
				FileInputStream objFileStram = new FileInputStream(objFile);
			    
				//Create a execl workbook object
				XSSFWorkbook objWrkBook = new XSSFWorkbook(objFileStram);
				
				//Select Sheet form execl
				XSSFSheet objWrkBookSheet = objWrkBook.getSheetAt(0);
		
				//Set properties for chrome drivers
				System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
				driver = new ChromeDriver();
				
				//Get the bass URL
				driver.get(bassurl);
				
				//Define variable
				String ActualValue ="Empyt";
				
				//Get value from Excel
				String firstName = objWrkBookSheet.getRow(12).getCell(0).getStringCellValue();
				String lastName =objWrkBookSheet.getRow(12).getCell(1).getStringCellValue();
				String country =objWrkBookSheet.getRow(12).getCell(2).getStringCellValue();
				String subject =objWrkBookSheet.getRow(12).getCell(3).getStringCellValue();
				
				//Fiil the data for fields 
				driver.findElement(By.xpath("//*[@id=\"fname\"]")).sendKeys(firstName);
				Thread.sleep(1000);
				
	
				if(Pattern.compile( "[0-9]" ).matcher(lastName).find()) {
					ActualValue = "Last Name include invalidate characters";
					System.out.println("Error Validation : "+ ActualValue);
				}else {

				driver.findElement(By.xpath("//*[@id=\"lname\"]")).sendKeys(lastName);
				Thread.sleep(1000);
				}
				
				//Select value from  drop down
				Select drpCountry = new Select(driver.findElement(By.name("country")));
				drpCountry.selectByVisibleText(country);
				Thread.sleep(1000);
				
				driver.findElement(By.xpath("//*[@id=\"subject\"]")).sendKeys(subject);
				Thread.sleep(4000);
				
				String ExpectedValue="Last Name include invalidate characters";
				//Assert expected and actual values
				  Assert.assertEquals(ActualValue,ExpectedValue);
				  Thread.sleep(2000);
				  driver.close();
				  objWrkBook.close();
	}
	
	
}
