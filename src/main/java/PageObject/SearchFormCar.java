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

    public SearchFormCar(WebDriver driver) {
        super(driver);
    }

    public void formSeason(String season) throws InterruptedException {
        waitLoadPageUsingScript();
        System.out.println("Choose from Seasons");
        waitAndClick(selectSeasons);
        waitAndClick(driver.findElement(By.xpath(String.format(SEASON_KIND, season))));
    }

    public void width() throws InterruptedException {
        waitLoadPageUsingScript();
        System.out.println("Choose from Widht.");
        driver.findElement(By.xpath("//select[@name='Width']")).click();
        driver.findElement(By.xpath("//option[@value='255']")).click();
    }

    public void height() throws InterruptedException {
        waitLoadPageUsingScript();
        System.out.println("Choose from Height.");
        driver.findElement(By.xpath("//select[@name='CrossSections']")).click();
        driver.findElement(By.xpath("//option[@value='65']")).click();
    }

    public void size() throws InterruptedException {
        waitLoadPageUsingScript();
        System.out.println("Choose from Size.");
        driver.findElement(By.xpath("//select[@name='Size']")).click();
        driver.findElement(By.xpath("//option[@value='16']")).click();
    }

    public void search() throws InterruptedException {
        waitLoadPageUsingScript();
        System.out.println("Click button Search.");
        driver.findElement(By.id("tyres_search")).click();
    }

    public void checkPageURL(String expectedURL) {
        waitLoadPageUsingScript();
        Assert.assertEquals(driver.getCurrentUrl(),expectedURL);
    }
}

