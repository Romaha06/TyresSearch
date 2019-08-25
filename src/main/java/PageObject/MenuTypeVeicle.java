package PageObject;

import Service.WebExtansion;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuTypeVeicle extends WebExtansion {

    @FindBy(xpath = "//span[text()='PKW']") private WebElement buttonPKW;
    //описать еще три кнопки и методы для нажатия на них

    public MenuTypeVeicle(WebDriver driver) {
        super(driver);
    }

    public void clickMenuButtonPKW(){
        waitLoadPageUsingScript();
        System.out.println("Choosed type 'PKW'");
        waitAndClick(buttonPKW);
    }
}
