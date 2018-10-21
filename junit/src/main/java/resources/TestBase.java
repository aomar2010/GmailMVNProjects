package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import bsh.This;

abstract public class TestBase implements DesignInterface {

	public static WebDriver driver;
	public static Logger log = LogManager.getLogger(TestBase.class.getName());

	//
	String Sender;
	String Receiver;
	String BrowserName;
	String TargetUrl;
	String Password;
	String implicitlyWait;
	String driverpath;
	//

	public WebDriver initializeDriver() throws IOException {

		PropertiesConfig();

		if (getbrowser().equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", getChromedriverpath());
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--start-maximized");
			driver = new ChromeDriver(chromeOptions);
			// execute in chrome driver

		} else if (getbrowser().equals("firefox")) {
			driver = new FirefoxDriver();
			// firefox code
		} else if (getbrowser().equals("IE")) {
			// IE code
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}

	public void getScreenshot(String result) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C://test//" + result + "screenshot.png"));

	}

	public Object PropertiesConfig() {
		// TODO Auto-generated constructor stub
		String ar[] = new String[5];
		Properties prop = new Properties();
		FileInputStream input = null;
		try {

			input = new FileInputStream(".\\resources\\config.properties");

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			setsender(prop.getProperty("SenderEmail"));
			setreceiver(prop.getProperty("ReceiverEmail"));
			setbrowser(prop.getProperty("browser"));
			seturl(prop.getProperty("url"));
			setpassword(prop.getProperty("Password"));
			setimplicitlyWait(prop.getProperty("implicitlyWait"));
			setChromedriverPath(prop.getProperty("driverPath"));

			

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;

	}

	public void setChromedriverPath(String driverpath) {
		this.driverpath = driverpath;
		
	}
	
	public String getChromedriverpath() {

		return this.driverpath;

	}

	public void setimplicitlyWait(String implicitlyWait) {
		this.implicitlyWait = implicitlyWait;
		
	}
	public String getimplicitlyWait() {

		return this.implicitlyWait;

	}

	private void seturl(String url) {
		this.TargetUrl = url;
	}
	
	
	

	public String geturl() {

		return this.TargetUrl;

	}

	public void setbrowser(String browser) {

		this.BrowserName = browser;

	}

	public String getbrowser() {
		return this.BrowserName;
	}

	public void setreceiver(String receiver) {
		this.Receiver = receiver;
	}

	public String getreciever() {
		return this.Receiver;
	}

	public void setsender(String sender) {

		this.Sender = sender;
	}

	public String getsender() {
		return this.Sender;
	}

	public void setpassword(String Password) {

		this.Password = Password;
	}

	public String getpasswotd() {
		return this.Password;
	}

}
