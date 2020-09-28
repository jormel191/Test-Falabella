package pom;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {


    private String titleHomePage = "Lo encontré en Falabella.com";

    @FindBy(xpath = "//div[@class='flex-grow-1']//div[@class='d-none d-lg-flex w-100']//input[@placeholder='¿Qué buscas?']")
    private WebElement searchLocator;

    public HomePage(WebDriver driver) {
        super(driver);

    }

    public boolean homePageIsDisplayed() throws Exception {

        return this.getTitle().equals(titleHomePage);
    }

    public void typeSearch(String product) throws Exception {
        this.sendKeys(product, searchLocator);
        searchLocator.sendKeys(Keys.ENTER);
    }

}
