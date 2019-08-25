import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchPKWTests extends MainTests {

    @DataProvider(name = "dataForPKW")
    public Object[][] dataForPKW() {
        return new Object[][] {
                {"winter", "https://reifen.pkwteile.de/reifen-search?Season=winter&Width=255&CrossSections=65&Size=16"},
                {"sommer", "https://reifen.pkwteile.de/reifen-search?Season=winter&Width=255&CrossSections=65&Size=16"},
        };
    }

    @Test(dataProvider = "dataForPKW")
    public void searchTyres(String season,String wight, String expectedURL) throws InterruptedException {
        mainPage.open();
        mainPage.cookiesButton();
        menuTypeVeicle.clickMenuButtonPKW();
        searchFormCar.formSeason(season);
        searchFormCar.width();
        searchFormCar.height();
        searchFormCar.size();
        searchFormCar.search();
        searchFormCar.checkPageURL(expectedURL);
    }


}
