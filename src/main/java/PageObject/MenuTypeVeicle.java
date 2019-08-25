package PageObject;

import Service.WebExtansion;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuTypeVeicle extends WebExtansion {

    @FindBy(xpath = "//span[text()='PKW']") private WebElement buttonPKW;

    @FindBy(xpath = "//a[text()='Offroad/SUV']") private WebElement buttonOffroad_SUV;
    //описать еще две кнопки и методы для нажатия на них

    public MenuTypeVeicle(WebDriver driver) {
        super(driver);
    }

    public void clickMenuButtonPKW(){
        waitLoadPageUsingScript();
        System.out.println("Choosed type 'PKW'");
        waitAndClick(buttonPKW);
    }
    public void clickMenuButtonOffroadSuv(){
        waitLoadPageUsingScript();
        System.out.println("Choosed type 'buttonOffroad_SUV'");
        waitAndClick(buttonOffroad_SUV);
    }
}
