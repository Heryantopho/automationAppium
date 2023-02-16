package appiumtest;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


public class appiumTest {
	
	static AppiumDriver<MobileElement> driver;
	static TouchAction action;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			openAplication();
			Thread.sleep(3000);
			//parameternya taskName, tanggalTask, jamTask
			testcase1("Belanja",27,10);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			e.printStackTrace();
			System.out.println("Aplication cannot start");
		}

	}
	
	static void openAplication() throws Exception{
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		//device namenya diganti sesuai device name emulator, emulator device name aku "emulator-5544"
		cap.setCapability("deviceName", "emulator-5554");
		cap.setCapability("platformName", "Android");
		//appPackage diganti sesuai appPackage device
		cap.setCapability("appPackage",  "com.splendapps.splendo");
		//appActivity diganti sesuai appActivity device
		cap.setCapability("appActivity", "com.splendapps.splendo.MainActivity");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		
		driver = new AppiumDriver<MobileElement>(url, cap);
		
		System.out.println("Application Started");
		
	}

	static void testcase1(String task, int date, int hour) throws InterruptedException {

		action = new TouchAction(driver);
		driver.findElement(By.xpath("//*[contains(@resource-id, 'fabAddTask')]")).click();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		
		driver.findElement(By.xpath("//*[contains(@resource-id, 'edtTaskName')]")).sendKeys(task);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		
		driver.findElement(By.xpath("//*[contains(@resource-id, 'btnSetD')]")).click();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		
		String dateXpath = String.format("//*[contains(@content-desc, '%d')]", date);
		driver.findElement(By.xpath(dateXpath)).click();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		
		driver.findElement(By.xpath("//*[contains(@resource-id, 'button1')]")).click();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		
		driver.findElement(By.xpath("//*[contains(@resource-id, 'btnSetT')]")).click();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		
		String hourXpath = String.format("//*[contains(@content-desc, '%d')]", hour);
		driver.findElement(By.xpath(hourXpath)).click();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		
		driver.findElement(By.xpath("//*[contains(@resource-id, 'button1')]")).click();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		
		driver.findElement(By.xpath("//*[contains(@resource-id, 'spinnerRepeat')]")).click();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		
		driver.findElement(By.xpath("//*[contains(@text, 'Once a Day')]")).click();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		
		driver.findElement(By.xpath("//*[contains(@resource-id, 'spinnerLists')]")).click();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		
		driver.findElement(By.xpath("//*[contains(@text, 'Personal')]")).click();
		driver.manage().timeouts().implicitlyWait(7000, TimeUnit.MILLISECONDS);
		
		driver.findElement(By.xpath("//*[contains(@resource-id, 'fabSaveTask')]")).click();
		driver.manage().timeouts().implicitlyWait(7000, TimeUnit.SECONDS);
	}
}
