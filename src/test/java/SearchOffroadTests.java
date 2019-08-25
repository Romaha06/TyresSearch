import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchOffroadTests extends MainTests {

    @Test(dataProvider = "dataForOffroadSuv")
    public void searchTyresOffroads(String season, String expectedURL) {
        mainPage.open();
        mainPage.cookiesButton();
        menuTypeVeicle.clickMenuButtonOffroadSuv();
        searchFormCar.formSeason(season);
        searchFormCar.width();
        searchFormCar.height();
        searchFormCar.size();
        searchFormCar.search();
        searchFormCar.checkPageURL(expectedURL);
    }
    @DataProvider(name = "dataForOffroadSuv")
    public Object[][] dataForPKW() {
        return new Object[][] {
                {"winter", "https://reifen.pkwteile.de/reifen-search?Season=winter&Width=255&CrossSections=65&Size=16&type=offroadreifen"},
                {"sommer", "https://reifen.pkwteile.de/reifen-search?Season=sommer&Width=255&CrossSections=65&Size=16&type=offroadreifen"},
        };
    }
}
