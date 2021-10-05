package mvn.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.apache.commons.io.FileUtils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Ecom_basic {
	
	
	
	public static AndroidDriver<AndroidElement> driver;
	
	/*
	public AppiumDriverLocalService server;
	public void Startserver()
	{
		server=AppiumDriverLocalService.buildDefaultService();
		server.start();
	}
     */
	
		public static AndroidDriver<AndroidElement> ecomcap(String apkfile) throws IOException {
			
			// global properties file path
			FileInputStream Propfilepath= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\mvn\\demo\\global.properties");
			Properties prop=new Properties();
			prop.load(Propfilepath);
			String apk = (String) prop.get(apkfile);
			String device = (String) prop.get("device");
			//String udid = (String) prop.get("udid");
			
			
			// Set apk file path
			File fil = new File("src");
			File app = new File(fil, apk);
			
			
			//	DesiredCapabilities
			DesiredCapabilities cap = new DesiredCapabilities();
			
	        // device details
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
			//cap.setCapability(MobileCapabilityType.UDID, udid);
	        cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
	        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
	        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");

	        
	        AndroidDriver<AndroidElement> driver= new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	        
	        return driver;
	        //System.out.println("App Installed....");	

	}
		
		
		public static void getscreenshot(String s) throws Exception 
		{
			
			File ssfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    FileUtils.copyFile(ssfile, new File("C:\\Users\\chintan.tank\\Desktop\\Info\\appium\\"+s+".png"));
		    
		}
         
}
