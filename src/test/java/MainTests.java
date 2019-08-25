import PageObject.MainPage;
import PageObject.MenuTypeVeicle;
import PageObject.SearchFormCar;
import Service.Core;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;

public class MainTests {
    public Core core = Core.getInstance();
    MainPage mainPage = PageFactory.initElements(core.driver, MainPage.class);
    MenuTypeVeicle menuTypeVeicle = PageFactory.initElements(core.driver, MenuTypeVeicle.class);
    SearchFormCar searchFormCar = PageFactory.initElements(core.driver, SearchFormCar.class);

    @AfterSuite
    public void dropDriver() {
        mainPage.exit();
    }
}
