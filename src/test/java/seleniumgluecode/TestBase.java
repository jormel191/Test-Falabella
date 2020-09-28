package seleniumgluecode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pom.ConsolePage;
import pom.HomePage;
import pom.PurchasesPage;

public class TestBase {

    protected WebDriver driver = Hooks.getDriver();
    protected HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    protected ConsolePage consolePage = PageFactory.initElements(driver, ConsolePage.class);
    protected PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);

}
