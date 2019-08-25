package PageObject;

import Service.WebExtansion;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MainPage extends WebExtansion {

    @FindBy(xpath = "//div[@class='block-cookies__button']")
    private WebElement buttonCookies;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://reifen.pkwteile.de/");
        System.out.println("Page was opened.");
    }

    public void exit() {
        driver.quit();
    }

    public void cookiesButton() {
        waitLoadPageUsingScript();
        System.out.println("Click Cookies button.");
        try {
            waitAndClick(buttonCookies);
        }catch (Exception e){
            Assert.assertTrue(true);
        }
    }
}
