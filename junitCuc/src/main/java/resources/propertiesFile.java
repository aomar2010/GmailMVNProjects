package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class propertiesFile {

	//
	String sender;
	String receiver;
	String browSerName;
	String targetUrl;
	String password;
	String implicitlyWait;
	String driverPath;

	//
	public propertiesFile() {

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
