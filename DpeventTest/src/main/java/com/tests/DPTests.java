package com.tests;

import com.PreTestSteps.LoginUser;
import com.enums.BandWidth;
import com.main.ApplicationStartup;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.util.Set;
import java.util.logging.Logger;

public class DPTests extends ApplicationStartup {

    public String BASEURL = "https://m.snapdeal.com";
    public String LOGINURL = BASEURL+"/signin";
    public String SLPURL = BASEURL+"/search?keyword=shoes&categoryXPath=ALL";
    public String PLPURL = BASEURL+"/products/computers-laptops?sort=plrty";
    public String PDPURL = BASEURL+"/product/dell-15-3568-notebook-intel/651817715182";

    LoginUser loginUser;
    String username="web.blast2@gmail.com";
    String password="aman1234";
   @BeforeClass

   public void beforeclass() throws MalformedURLException{
     //  ApplicationStartup.loadDriver();

       ApplicationStartup.loadDriverForBrowserStack();


   }

    @BeforeMethod
    public void beforemethod() throws Exception {

        loginUser = new LoginUser(driver).pageObject();


    }

@Test
    public void testForBandWidth() throws Exception {


        driver.get(BASEURL);
        Thread.sleep(4000);
        Cookie newtorkType = new Cookie("newtork_type", BandWidth.WIFI.toString());
        driver.manage().addCookie(newtorkType);
        Cookie speed = new Cookie("newtork_speed", String.valueOf(BandWidth.WIFI.getBandWidth()));
        driver.manage().addCookie(speed);
        driver.navigate().refresh();
        Thread.sleep(3000);
        Cookie getNetworkType = driver.manage().getCookieNamed("newtork_type");
        Cookie net_speed = driver.manage().getCookieNamed("newtork_speed");
        System.out.println("Network_type=" + getNetworkType + "----net_speed=" + net_speed);
        driver.get(SLPURL);
        Thread.sleep(5000);
        driver.get(PLPURL);
        Thread.sleep(5000);
        driver.get(PDPURL);
        Thread.sleep(5000);
        loginUser.clickPdpBuyButton();
        loginUser.loginwithCredential(username, password);
        Thread.sleep(5000);

        Set<Cookie> allcookie = driver.manage().getCookies();

        for (Cookie cookie : allcookie) {
            if (cookie.equals(net_speed))

                System.out.println(cookie);
            if (cookie.equals(getNetworkType))
                System.out.println(cookie);
        }
    }
      @AfterMethod
    public void aftermethod(){
       driver.quit();
      }


    @DataProvider(name = "testData",parallel = false)
    public static Object[][] getData(){
        Object data[][]=new Object[][]
                {
                        {
                                Platform.WIN8,"chrome","50"
                        },
                        {
                                Platform.MAC,"firefox","50"
                        },
                        {
                                Platform.WINDOWS,"firefox","57.0"
                        }
                }  ;

        return data;
    }


}
