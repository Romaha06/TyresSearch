package PageObject;

import Service.WebExtansion;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SearchFormCar extends WebExtansion {


    @FindBy(xpath = "//select[@id='form_Season']") private WebElement selectSeasons;
    private String SEASON_KIND = "//option[@value='%s']";

    @FindBy(xpath = "//select[@name='Width']") private WebElement selectWidth;

    @FindBy(xpath = "//select[@name='CrossSections']") private WebElement selectHeight;

    @FindBy(xpath = "//select[@name='Size']") private WebElement selectSize;


    public SearchFormCar(WebDriver driver) {
        super(driver);
    }

    public void formSeason(String season) {
        waitLoadPageUsingScript();
        System.out.println("Choose from Seasons");
        waitAndClick(selectSeasons);
        waitAndClick(driver.findElement(By.xpath(String.format(SEASON_KIND, season))));
    }

    public void width() {
        waitLoadPageUsingScript();
        System.out.println("Choose from Widht.");
        waitAndClick(selectWidth);
        driver.findElement(By.xpath("//option[@value='255']")).click();
    }

    public void height()  {
        waitLoadPageUsingScript();
        System.out.println("Choose from Height.");
        waitAndClick(selectHeight);
        driver.findElement(By.xpath("//option[@value='65']")).click();
    }

    public void size() {
        waitLoadPageUsingScript();
        System.out.println("Choose from Size.");
        waitAndClick(selectSize);
        driver.findElement(By.xpath("//option[@value='16']")).click();
    }

    public void search() {
        waitLoadPageUsingScript();
        System.out.println("Click button Search.");
        driver.findElement(By.id("tyres_search")).click();
    }

    public void checkPageURL(String expectedURL) {
        waitLoadPageUsingScript();
        Assert.assertEquals(driver.getCurrentUrl(),expectedURL);
    }
}

