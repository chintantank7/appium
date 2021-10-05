package mvn.demo;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.testng.Assert;
//import org.testng.annotations.Test;

//import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObject.Loginobject;

//import static io.appium.java_client.touch.TapOptions.tapOptions;
//import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
//import static java.time.Duration.ofSeconds;
import java.io.IOException;

//import static io.appium.java_client.touch.offset.ElementOption.element;


public class Ecom_tc_3 extends Ecom_basic {


	@Test
	public void checkcart() throws InterruptedException, IOException 
	{
		
		AndroidDriver<AndroidElement> driver=ecomcap("Generalstorapp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     
// screen 1 login
		
		
		Loginobject l = new Loginobject(driver);
		
		l.login_namefield.sendKeys("HI");
		driver.hideKeyboard();
		l.login_Female.click();
		l.login_countrydropdown.click();
		
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
		Utilities util=new Utilities(driver);
		util.scrollto("Argentina");	
		
		l.login_selectcountry.click();
		
		l.login_Selectbtn.click();

	
/*		
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");
	    driver.findElement(By.xpath("//*[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		
		Utilities util=new Utilities(driver);
		util.scrollto("Argentina");	
		
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
         //driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText + "\").instance(0))"));             
		driver.findElement(By.xpath("//*[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
*/	  
		
		
		
		   
// Screen 2 add to cart  
	     driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
	     driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
	     driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

	     Thread.sleep(4000);

	     
	     
// Screen 3 cart
	          
	     int count=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
	     double sum=0;

	     for(int i=0;i<count;i++)

	     {

	    	 String amount1= driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText();

	    	 double amount=getAmount(amount1);

	    	 sum=sum+amount;//280.97+116.97

	     }
	     System.out.println(sum+"sum of products");



	     String total=driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
	     total= total.substring(1);

	     double totalValue=Double.parseDouble(total);

	     System.out.println(totalValue+"Total value of products");
	     AssertJUnit.assertEquals(sum, totalValue); 
	
	     
	     
//Mobile Gestures
	     /*
	     	WebElement checkbox=driver.findElement(By.className("android.widget.CheckBox"));

	     		TouchAction t=new TouchAction(driver);

	     		t.tap(tapOptions().withElement(element(checkbox))).perform();



	     	    WebElement tc=driver.findElement(By.xpath("//*[@text='Please read our terms of conditions']"));
	     		t.longPress(longPressOptions().withElement(element(tc)).withDuration(ofSeconds(2))).release().perform();
	     		driver.findElement(By.id("android:id/button1")).click();
	     		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
*/	
		}
	
	public static double getAmount(String value) 
	{
		value=value.substring(1);
		Double amountvalue = Double.parseDouble(value);
		return amountvalue;
	}

}
