package com.PreTestSteps;

import com.main.ApplicationStartup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginUser extends ApplicationStartup {

    @FindBy(xpath = "//div/input[@id='userInput']")
    private WebElement textBox ;
    @FindBy(id = "continueBtn")
    private WebElement continueBtn;
    @FindBy(xpath = "//div/input[@class='userInputBox no-err opera-disable']")
    private WebElement enterPass  ;
    @FindBy(xpath = "//div[@class='btn login-btn-uc btn-primary ripplelink opera-btn']")
    private WebElement login ;
    @FindBy(xpath = "//div[@id='PDPbuyBtn']")
    private WebElement pdpClick;

    public LoginUser(WebDriver driver) {

        this.driver = driver;
    }

    public LoginUser pageObject() {

        return PageFactory.initElements(driver, LoginUser.class);

    }


    public void loginwithCredential(String username,String password) throws Exception{
Thread.sleep(3000);
textBox.sendKeys(username);
continueBtn.click();
Thread.sleep(3000);
enterPass.sendKeys(password);
login.click();


}
public void clickPdpBuyButton(){
    pdpClick.click();
}

}

