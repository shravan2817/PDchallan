package TestP;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class selenium {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\TRAINING-4\\Downloads\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions co = new ChromeOptions();
		co.setBinary("C:\\Users\\TRAINING-4\\Downloads\\chrome-win64\\chrome.exe");

		WebDriver driver = new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.get("https://cfms.ap.gov.in/");// ---> Live URL
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());//1

		By Closebutton = By.xpath("//div[@id='alertmsgonload']//*[text()='Close']");
		By ReceiptsLink = By.xpath("//a[text()='Receipts Links']");
		By PdChallan = By.xpath("//a[@class='flat-links-bg']");
		By hyperlinkKYD = By.xpath("//a[text()='Know Your Department']");
		By DprtDropdownPDchallan=By.xpath("//div//span[@id='__component0---worklist--DEPT-vhi']");
		By SevicePDchallan = By.xpath("//div//span[@id='__component0---worklist--SERV-vhi']");
		By Clicksubmit=By.xpath("//span//bdi[text()='Submit']");
		By ClickOK=By.xpath("//div//span//bdi[@id='__mbox-btn-0-BDI-content']");
		By District=By.xpath("//div//span[@id='__component0---worklist--DIST-vhi']");
		By Treasury=By.xpath("//div[@id='__component0---worklist--TREAS']");
		By DDODropdown=By.xpath("//div//span[@id='__component0---worklist--ddocodeid-vhi']");

		driver.findElement(Closebutton).click();//clicking on close button in pop-up
		Thread.sleep(1000);
		driver.findElement(ReceiptsLink).click(); //clicking on reciepts link
		Thread.sleep(1000);
		driver.findElement(PdChallan).click();//clicking on Pd challan

		switchToPartialWindow(driver, "PD");//switchs to PD-challan 
		System.out.println(driver.getTitle());//2

		driver.findElement(hyperlinkKYD).click();//clicking on Know your department

		//		JavascriptExecutor executor = (JavascriptExecutor) driver;
		//		executor.executeScript("arguments[0].click();", KYD);

		//		
		//
		switchToPartialWindow(driver, "Details");//Switches to Table details tab and gets title of the Tab
		System.out.println(driver.getTitle());//3

		switchToPartialWindow(driver, "PD");//Switches to PD challan tab and gets the title of the tab
		System.out.println(driver.getTitle());//4

		//Clicks on Dept dropdown and selects the value and prints the value which is selected 
		driver.findElement(DprtDropdownPDchallan).click();
		WebElement Deptvalue=driver.findElement(By.xpath("//div[text()='AGC03']"));
		Deptvalue.click();
		System.out.println("Deptarment value="+" "+Deptvalue.getText());//5

		//Clicks on Service dropdown and selects the value and prints the value which is selected 
		driver.findElement(SevicePDchallan).click();
		WebElement Servicevalue=driver.findElement(By.xpath("//div[text()='ZP House Rent Recovery']"));
		Servicevalue.click();
		System.out.println("Service value="+" "+Servicevalue.getText());//6
		Thread.sleep(1000);
		//Gets the value of HOA feild according to the dpt and service which is selected 
		WebElement HOAValue=driver.findElement(By.xpath("//div//input[@id='__component0---worklist--hoaid-inner']"));
		if(HOAValue.isDisplayed())
		{
			System.out.println("HOA value="+""+(HOAValue).getAttribute("value"));//7
		}

		WebElement SubmitButton= driver.findElement(By.xpath("//button//span//bdi[text()='Submit']"));
		//clicks on Submit 
		//driver.findElement(Clicksubmit).click();
		SubmitButton.click();


		//gets the tex of the errorpop-up which is raised after clicking on the submit 
		WebElement ErrorPopupMsg=driver.findElement(By.xpath("//div//span[text()=' Select the mandatory Fields']"));
		System.out.println(ErrorPopupMsg.getText());

		//Clicks on OK in the Errorpop-up
		driver.findElement(ClickOK).click();
		Thread.sleep(2000);   

		//Clicks on District dropdown and selects the value and prints the value which is selected 
		driver.findElement(District).click();
		WebElement DistrictValue=driver.findElement(By.xpath("//div[text()='Srikakulam']"));
		System.out.println("DistrictValue ="+""+DistrictValue.getText());
		DistrictValue.click();
		Thread.sleep(2000);

		//Clicks on  Treasury dropdown and selects the value and prints the value which is selected
		driver.findElement(Treasury).click();
		WebElement TreasuryValue =driver.findElement(By.xpath("//div[text()='DTAO - Srikakulam(Treasury)']"));
		System.out.println("TreasuryValue ="+""+TreasuryValue.getText());
		TreasuryValue.click();		
		//Clicks on  DDODropdown dropdown and selects the value and prints the value which is selected
		driver.findElement(DDODropdown).click();
		WebElement DDOvalue=driver.findElement(By.xpath("//div[text()='ZILLA PARISHAD SRIKAKULAM']"));
		System.out.println("DDO value ="+""+DDOvalue.getText());
		DDOvalue.click();


		if(SubmitButton.isDisplayed()) {
			SubmitButton.click();
			System.out.println("Submit button is Clicked");
		}
		else {
			System.out.println("Submit button is not  Clicked");
		}
		//Second screen objects
		By PurposeFeild=By.xpath("//div//textarea[@id='__component0---object--idpurpose-inner']");
		driver.findElement(PurposeFeild).sendKeys("Test");
		
		By RemitterName=By.xpath("//div//input[@id='']");
		By RemitterID=By.xpath("//div//input[@id='']]");
		By Address=By.xpath("//div//input[@id='']");
		By Mobileno=By.xpath("//div//input[@id='']");
		By EmailID=By.xpath("//div//input[@id='']");
		By AmountinRS=By.xpath("//div//input[@id='']");
		









	}
	//method to switch to exact window by passing the text of the window name
	public static void switchToPartialWindow(WebDriver driver, String PartialWindowName) throws InterruptedException 
	{  
		Set<String> WindowIds = driver.getWindowHandles();
		Iterator ite = WindowIds.iterator();//iterator moves only forward 

		while (ite.hasNext()) {

			String store = (String) ite.next();
			String currentTitle = driver.switchTo().window(store).getTitle();
			if (currentTitle.contains(PartialWindowName)) {
				break;
			}
		}
	}
}

