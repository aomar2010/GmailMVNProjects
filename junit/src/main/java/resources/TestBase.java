package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

abstract public class TestBase implements DesignInterface {

	public static WebDriver driver;
	public static Logger log = LogManager.getLogger(TestBase.class.getName());

	//
	String sender;
	String receiver;
	String browSerName;
	String targetUrl;
	String password;
	String implicitlyWait;
	String driverPath;
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
		this.driverPath = driverpath;
		
	}
	
	public String getChromedriverpath() {

		return this.driverPath;

	}

	public void setimplicitlyWait(String implicitlyWait) {
		this.implicitlyWait = implicitlyWait;
		
	}
	public String getimplicitlyWait() {

		return this.implicitlyWait;

	}

	private void seturl(String url) {
		this.targetUrl = url;
	}
	
	
	

	public String geturl() {

		return this.targetUrl;

	}

	public void setbrowser(String browser) {

		this.browSerName = browser;

	}

	public String getbrowser() {
		return this.browSerName;
	}

	public void setreceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getreciever() {
		return this.receiver;
	}

	public void setsender(String sender) {

		this.sender = sender;
	}

	public String getsender() {
		return this.sender;
	}

	public void setpassword(String Password) {

		this.password = Password;
	}

	public String getpasswotd() {
		return this.password;
	}

}
