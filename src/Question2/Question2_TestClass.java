package Question2;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Question2_TestClass {

	String bassurl="D:\\Selenium Project\\AssignmentQuestion\\Assignment_Answers\\WebFile\\Question2.html";
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
		driver.close();
		
	}
	
	@Test(priority=2)
	public void VerifySilentText() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		driver = new ChromeDriver();
		driver.get(bassurl);
		Thread.sleep(3000);
		
		
		WebElement loginPG =driver.findElement(By.xpath("/html/body/button"));
		loginPG.click();
		
		String silentTextFirstName=driver.findElement(By.xpath("//*[@id=\"id01\"]/form/div[2]/input[1]")).getAttribute("placeholder");
		System.out.println("First Name field silent text : "+ silentTextFirstName);
		
		String silentTextPassword=driver.findElement(By.xpath("//*[@id=\"id01\"]/form/div[2]/input[2]")).getAttribute("placeholder");
		System.out.println("Password field silent text is : "+ silentTextPassword);
		Thread.sleep(3000);
		
		String ExpectedSilentTextFN = "Enter Username";
		String ExpectedSilentTextPW = "Enter Password";
		
		try {
		Assert.assertEquals(silentTextFirstName, ExpectedSilentTextFN);
		} catch (Throwable e) {
			System.out.println("Report Error : " + e);
		}
		
		try {
		Assert.assertEquals(silentTextPassword, ExpectedSilentTextPW);
		} catch (Throwable e) {
			System.out.println("Report Error : " + e);
		}
		
		driver.close();
		
	}
	
	@Test(priority=3)
	public void SucessfullyEnterdedAllData() throws Exception {
		//FileRead object creating
		FileInputStream objFileStram = new FileInputStream(objFile);
	    
		//Create a execl workbook object
		XSSFWorkbook objWrkBook = new XSSFWorkbook(objFileStram);
		
		//Select Sheet form execl
		XSSFSheet objWrkBookSheet = objWrkBook.getSheetAt(1);

		//Set properties for chrome drivers
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		driver = new ChromeDriver();
		driver.get(bassurl);
		Thread.sleep(3000);
		
		
		WebElement loginPG =driver.findElement(By.xpath("/html/body/button"));
		loginPG.click();
		Thread.sleep(3000);
		
		String userName = objWrkBookSheet.getRow(0).getCell(0).getStringCellValue();
		String password =objWrkBookSheet.getRow(0).getCell(1).getStringCellValue();
		System.out.println(userName +" "+ password); 
		//Fiil the data for fields 
		driver.findElement(By.xpath("//*[@id=\"id01\"]/form/div[2]/input[1]")).sendKeys(userName);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"id01\"]/form/div[2]/input[2]")).sendKeys(password);
		Thread.sleep(1000);
		
		//Check the field validation
		String missingData = "Empty";
		String ActualValue ="";
		

		if(driver.findElement(By.xpath("//*[@id=\"id01\"]/form/div[2]/input[1]")).getAttribute("value") == null || driver.findElement(By.xpath("//*[@id=\"id01\"]/form/div[2]/input[2]")).getAttribute("value") == null){
		  missingData = "Please fill out this fields";
		  ActualValue=missingData;
		}
		else {
			ActualValue ="Login Successfull";
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"id01\"]/form/div[2]/button")).click();
		}
		
		System.out.println("Final result : " +ActualValue);
		String ExpectedValue="Login Successfull";
		
		try {
			Assert.assertEquals(ActualValue, ExpectedValue);
			} catch (Throwable e) {
				System.out.println("Report Error : " + e);
			}
		driver.close();
		objWrkBook.close();
		
	}
	
	@Test(priority=4)
	public void InvalidUserName() throws Exception {
		//FileRead object creating
		FileInputStream objFileStram = new FileInputStream(objFile);
	    
		//Create a execl workbook object
		XSSFWorkbook objWrkBook = new XSSFWorkbook(objFileStram);
		
		//Select Sheet form execl
		XSSFSheet objWrkBookSheet = objWrkBook.getSheetAt(1);

		//Set properties for chrome drivers
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		driver = new ChromeDriver();
		driver.get(bassurl);
		Thread.sleep(3000);
		
		
		WebElement loginPG =driver.findElement(By.xpath("/html/body/button"));
		loginPG.click();
		Thread.sleep(3000);
		
		String userName = objWrkBookSheet.getRow(3).getCell(0).getStringCellValue();
		String password =objWrkBookSheet.getRow(3).getCell(1).getStringCellValue();
	
		//Fiil the data for fields 
		driver.findElement(By.xpath("//*[@id=\"id01\"]/form/div[2]/input[1]")).sendKeys(userName);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"id01\"]/form/div[2]/input[2]")).sendKeys(password);
		Thread.sleep(1000);
		
		//Check the field validation
	
		String ActualValue ="Corret user name and password is entered";
		
		String ExpectedUserName = "LocalUser1";
		String ExpectedPassword= "local123";
		Thread.sleep(1000);
		String ActualUserName = driver.findElement(By.xpath("//*[@id=\"id01\"]/form/div[2]/input[1]")).getAttribute("value");
		String ActualPassword = driver.findElement(By.xpath("//*[@id=\"id01\"]/form/div[2]/input[2]")).getAttribute("value");
		Thread.sleep(1000);
		

		if( ActualUserName.equals(ExpectedUserName) ){

		}
		else {
			ActualValue ="LOGIN FAIL :Incorrect user name entered";
			Thread.sleep(1000);	
		}
		
		if( ActualPassword.equals(ExpectedPassword) ){

			}
			else {
				ActualValue ="LOGIN FAIL :Incorrect password entered";
				Thread.sleep(1000);			
				System.out.println("Test4");
			}
		
		System.out.println("Final result : " +ActualValue);
		String ExpectedValue="LOGIN FAIL :Incorrect user name entered";
		
		try {
			Assert.assertEquals(ActualValue, ExpectedValue);
			} catch (Throwable e) {
				System.out.println("Report Error : " + e);
			}
		driver.close();
		objWrkBook.close();
		
	}
	
	
	@Test(priority=5)
	public void InvalidPassword() throws Exception {
		//FileRead object creating
		FileInputStream objFileStram = new FileInputStream(objFile);
	    
		//Create a execl workbook object
		XSSFWorkbook objWrkBook = new XSSFWorkbook(objFileStram);
		
		//Select Sheet form execl
		XSSFSheet objWrkBookSheet = objWrkBook.getSheetAt(1);

		//Set properties for chrome drivers
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		driver = new ChromeDriver();
		driver.get(bassurl);
		Thread.sleep(3000);
		
		
		WebElement loginPG =driver.findElement(By.xpath("/html/body/button"));
		loginPG.click();
		Thread.sleep(3000);
		
		String userName = objWrkBookSheet.getRow(4).getCell(0).getStringCellValue();
		String password =objWrkBookSheet.getRow(4).getCell(1).getStringCellValue();
	
		//Fiil the data for fields 
		driver.findElement(By.xpath("//*[@id=\"id01\"]/form/div[2]/input[1]")).sendKeys(userName);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"id01\"]/form/div[2]/input[2]")).sendKeys(password);
		Thread.sleep(1000);
		
		//Check the field validation
	
		String ActualValue ="Corret user name and password is entered";
		
		String ExpectedUserName = "LocalUser1";
		String ExpectedPassword= "local1234";
		Thread.sleep(1000);
		String ActualUserName = driver.findElement(By.xpath("//*[@id=\"id01\"]/form/div[2]/input[1]")).getAttribute("value");
		String ActualPassword = driver.findElement(By.xpath("//*[@id=\"id01\"]/form/div[2]/input[2]")).getAttribute("value");
		Thread.sleep(1000);
		

		if( ActualUserName.equals(ExpectedUserName) ){

		}
		else {
			ActualValue ="LOGIN FAIL :Incorrect user name entered";
			Thread.sleep(1000);	
		}
		
		if( ActualPassword.equals(ExpectedPassword) ){

			}
			else {
				ActualValue ="LOGIN FAIL :Incorrect password entered";
				Thread.sleep(1000);			
				
			}
		
		System.out.println("Final result : " +ActualValue);
		String ExpectedValue="LOGIN FAIL :Incorrect password entered";
		
		try {
			Assert.assertEquals(ActualValue, ExpectedValue);
			} catch (Throwable e) {
				System.out.println("Report Error : " + e);
			}
		driver.close();
		objWrkBook.close();
		
	}
	@Test(priority=6)
	public void VerifyEmptyUserName() throws Exception {
		//FileRead object creating
		FileInputStream objFileStram = new FileInputStream(objFile);
	    
		//Create a execl workbook object
		XSSFWorkbook objWrkBook = new XSSFWorkbook(objFileStram);
		
		//Select Sheet form execl
		XSSFSheet objWrkBookSheet = objWrkBook.getSheetAt(1);

		//Set properties for chrome drivers
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		driver = new ChromeDriver();
		driver.get(bassurl);
		Thread.sleep(3000);
		
		
		WebElement loginPG =driver.findElement(By.xpath("/html/body/button"));
		loginPG.click();
		Thread.sleep(3000);
		
		String missingData = "Empty";
		String ActualValue ="";
		String userName ="";
		String password="";
		
		try {
		userName = objWrkBookSheet.getRow(1).getCell(0).getStringCellValue();
		//Fiil the data for fields
		driver.findElement(By.xpath("//*[@id=\"id01\"]/form/div[2]/input[1]")).sendKeys(userName);
		Thread.sleep(1000);
		}catch(Exception e) {
			missingData = "User name : Please fill out this fields";
			ActualValue=missingData;
		}
		
		try {
		password =objWrkBookSheet.getRow(1).getCell(1).getStringCellValue();
		//Fiil the data for fields
		driver.findElement(By.xpath("//*[@id=\"id01\"]/form/div[2]/input[2]")).sendKeys(password);
		Thread.sleep(1000);
		}catch(Exception e) {
			missingData = "Password : Please fill out this fields";
			ActualValue=missingData;
		}

				
		System.out.println("Final result : " +ActualValue);
		String ExpectedValue="User name : Please fill out this fields";
		
		try {
			Assert.assertEquals(ActualValue, ExpectedValue);
			} catch (Throwable e) {
				System.out.println("Report Error : " + e);
			}
		driver.findElement(By.xpath("//*[@id=\"id01\"]/form/div[2]/button")).click();
		driver.close();
		objWrkBook.close();
		
	}
	
	@Test(priority=7)
	public void VerifyEmptyPassword() throws Exception {
		//FileRead object creating
		FileInputStream objFileStram = new FileInputStream(objFile);
	    
		//Create a execl workbook object
		XSSFWorkbook objWrkBook = new XSSFWorkbook(objFileStram);
		
		//Select Sheet form execl
		XSSFSheet objWrkBookSheet = objWrkBook.getSheetAt(1);

		//Set properties for chrome drivers
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		driver = new ChromeDriver();
		driver.get(bassurl);
		Thread.sleep(3000);
		
		
		WebElement loginPG =driver.findElement(By.xpath("/html/body/button"));
		loginPG.click();
		Thread.sleep(3000);
		
		String missingData = "Empty";
		String ActualValue ="";
		String userName ="";
		String password="";
		
		try {
		userName = objWrkBookSheet.getRow(2).getCell(0).getStringCellValue();
		//Fiil the data for fields
		driver.findElement(By.xpath("//*[@id=\"id01\"]/form/div[2]/input[1]")).sendKeys(userName);
		Thread.sleep(1000);
		}catch(Exception e) {
			missingData = "User Name : Please fill out this fields";
			ActualValue=missingData;
		}
		
		try {
		password =objWrkBookSheet.getRow(2).getCell(1).getStringCellValue();
		//Fiil the data for fields
		driver.findElement(By.xpath("//*[@id=\"id01\"]/form/div[2]/input[2]")).sendKeys(password);
		Thread.sleep(1000);
		}catch(Exception e) {
			missingData = "Password : Please fill out this fields";
			ActualValue=missingData;
		}

				
		System.out.println("Final result : " +ActualValue);
		String ExpectedValue="Password : Please fill out this fields";
		
		try {
			Assert.assertEquals(ActualValue, ExpectedValue);
			} catch (Throwable e) {
				System.out.println("Report Error : " + e);
			}
		driver.findElement(By.xpath("//*[@id=\"id01\"]/form/div[2]/button")).click();
		driver.close();
		objWrkBook.close();
		
	}
	
	@Test(priority=8)
	public void VerifyRememberMeIsChecked() throws Exception {

		//Set properties for chrome drivers
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		driver = new ChromeDriver();
		driver.get(bassurl);
		Thread.sleep(3000);
		
		
		WebElement loginPG =driver.findElement(By.xpath("/html/body/button"));
		loginPG.click();
		Thread.sleep(3000);
		
		boolean isChecked;
		
		isChecked= driver.findElement(By.xpath("//*[@id=\"id01\"]/form/div[2]/label[3]/input")).isSelected();
		
		if(isChecked==true) {
			System.out.println("Remember checkbox is selected");
		}
		else {
			System.out.println("Remember checkbox is not selected");
		}
		driver.close();
		
	}
	
	@Test(priority=9)
	public void VerifyRememberMeIsUnchecked() throws Exception {
		//FileRead object creating
		FileInputStream objFileStram = new FileInputStream(objFile);
	    
		//Create a execl workbook object
		XSSFWorkbook objWrkBook = new XSSFWorkbook(objFileStram);
		
		//Select Sheet form execl
		XSSFSheet objWrkBookSheet = objWrkBook.getSheetAt(1);

		//Set properties for chrome drivers
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		driver = new ChromeDriver();
		driver.get(bassurl);
		Thread.sleep(3000);
		
		
		WebElement loginPG =driver.findElement(By.xpath("/html/body/button"));
		loginPG.click();
		Thread.sleep(3000);
		
		boolean isChecked;
		
		isChecked= driver.findElement(By.xpath("//*[@id=\"id01\"]/form/div[2]/label[3]/input")).isSelected();
		
		if(isChecked==true) {
			driver.findElement(By.xpath("//*[@id=\"id01\"]/form/div[2]/label[3]/input")).click();
			System.out.println("Remember checkbox is unselected");
			
			Thread.sleep(4000);
		}
		else {
			System.out.println("Remember checkbox is already not selected");
		}
		driver.close();
		objWrkBook.close();		
	}
	@Test(priority=10)
	public void VerifyForgotPassword() throws Exception {
		//FileRead object creating
		FileInputStream objFileStram = new FileInputStream(objFile);
	    
		//Create a execl workbook object
		XSSFWorkbook objWrkBook = new XSSFWorkbook(objFileStram);
		
		//Select Sheet form execl
		XSSFSheet objWrkBookSheet = objWrkBook.getSheetAt(1);

		//Set properties for chrome drivers
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
		driver = new ChromeDriver();
		driver.get(bassurl);
		Thread.sleep(3000);
		
		WebElement loginPG =driver.findElement(By.xpath("/html/body/button"));
		loginPG.click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id=\"id01\"]/form/div[3]/span/a")).click(); 
		System.out.println("Forgot password is clicked");
		
		driver.close();
		objWrkBook.close();	
				
	}
		
  
}
