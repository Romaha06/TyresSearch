package Service;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public abstract class WebExtansion {
    protected WebDriver driver;
    private WebDriverWait wait;

    public WebExtansion(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void waitAndClick(WebElement webElement) {
        try{
            waitLoadPageUsingScript();
            System.err.println("Wait till element " + webElement.toString() + " will be visible");
            wait.until(ExpectedConditions.visibilityOf(webElement));
            System.err.println("Wait till element " + webElement.toString() + " will be clickable");
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            System.err.println("Click on element " + webElement.toString());
            webElement.click();
            System.err.println("Element was clicked " + webElement.toString());
        }
        catch (Exception e){
            e.printStackTrace();
            Assert.assertTrue(webElement.isEnabled(), "The element was not enabled!");
            Assert.assertTrue(webElement.isDisplayed(), "The element was not displayed!");
        }
    }

    /**
     * Scroll to element using JavaScript
     * @param webElement WebElement
     */
    private void scrollToElement(WebElement webElement){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", webElement);
    }
    /** Wait load page using JavaScript */
    public void waitLoadPageUsingScript() {
        System.err.println("Wait load page using javascript");
        ExpectedCondition<Boolean> expectation =
                driver -> ((JavascriptExecutor) driver)
                        .executeScript("return document.readyState").toString().equals("complete");
        try {
            Thread.sleep(500);
            // WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }
}

