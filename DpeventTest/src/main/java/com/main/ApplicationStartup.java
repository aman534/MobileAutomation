package com.main;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import java.net.MalformedURLException;
import java.net.URL;


public class ApplicationStartup {
    public static WebDriver driver;
  //  private WebDriverWait wait = new WebDriverWait(driver,10);
    public static String usrName="amanagrawal2";
    public static String Access_key ="q8aJVErqrLMt6mWRTNzE";
    public static String url ="https://"+usrName+":"+Access_key+"@hub.browserstack.com/wd/hub";


    public static void loadDriver(){
        //Chrome Options
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--user-agent=Mozilla/5.0 (Linux; Android 6.0; HTC One M9 Build/MRA58K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.98 Mobile Safari/537.36");
    options.addArguments("--start-maximized");
    driver = new ChromeDriver(options);
    //driver.get("https://m.snapdeal.com");
    /*try {

        driver.wait(2000);
    }
    catch(InterruptedException e) {
    System.out.print(e);
    }*/
    //driver.quit();
}


public static void loadDriverForBrowserStack() throws MalformedURLException{
   String useragent="--user-agent=Mozilla/5.0 (Linux; Android 6.0; HTC One M9 Build/MRA58K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.98 Mobile Safari/537.36";
    ChromeOptions options = new ChromeOptions();
    options.addArguments(useragent);
    options.addArguments("--start-maximized");

    DesiredCapabilities capabilities=new DesiredCapabilities();
    /*capabilities.setPlatform(Platform.ANDROID);
    capabilities.setBrowserName("firefox");
    capabilities.setVersion("50.0");*/
    capabilities.setCapability("browsename","chrome");
    capabilities.setCapability("device", "iPhone 7");
    capabilities.setCapability("realMobile", "true");
    capabilities.setCapability("os_version", "10.3");
    /*if(browserName.equals("chrome"))
    capabilities.setCapability(ChromeOptions.CAPABILITY,options);
    if(browserName.equals("firefox")){
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("general.useragent.override", useragent);
        capabilities.setCapability(FirefoxDriver.PROFILE, profile);
    }
*/
    URL browserStackurl=new URL(url);
    driver = new RemoteWebDriver(browserStackurl,capabilities);

}



}




