package pageObject;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Login_object {

	public Login_object(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//id("android:id/text1")
	@AndroidFindBy(id="android:id/text1")
    public WebElement login_countrydropdown;
	
	//driver.findElement(By.xpath("//*[@text='Argentina']"))
	@AndroidFindBy(xpath="//*[@text='Argentina']")
	public WebElement login_selectcountry;
	
	//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	public WebElement login_namefield;	
	
	//driver.findElement(By.xpath("//*[@text='Female']"))
	@AndroidFindBy(xpath="//*[@text='Female']")
	public WebElement login_Female;
	
	//driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	public WebElement login_Selectbtn;

}
