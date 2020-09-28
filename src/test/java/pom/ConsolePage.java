package pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;


public class ConsolePage extends BasePage {


    private String titleConsolePage = "Videojuegos";

    @FindBy(xpath = "//*[@class='jsx-3139645404 l1category']")
    private WebElement pageConsoleTitle;

    @FindBy(xpath = "//b[@class='jsx-287641535 title2 primary  jsx-185326735 bold    pod-subTitle']")
    private List<WebElement> productLocator;

    @FindBy(id = "buttonForCustomers")
    private WebElement btnAddBagLocator;

    @FindBy(xpath = "//button[contains(@class,'jsx-635184967 increment')]")
    private WebElement btnIncrementProductLocator;

    @FindBy(xpath = "//div[@class='jsx-1275113483 option pointer small  ']")
    private List<WebElement> btnGuaranteeLocator;

    @FindBy(id = "linkButton")
    private WebElement btnSeeShoppingBagLocator;

    @FindBy(id = "//div[contains(@class,'jsx-635184967 product-count-value')]")
    private WebElement btnProductSelectedLocator;


    public ConsolePage(WebDriver driver) {
        super(driver);

    }


    public boolean isvideosJuegosDisplayed() throws Exception {
        return this.isDisplayed(pageConsoleTitle) && this.getText(pageConsoleTitle).equals(titleConsolePage);
    }


    public void selectProduct(String stproduct) throws Exception {
        for (int i = 0; i < productLocator.size(); i++) {
            if (stproduct.contains(productLocator.get(i).getText())) {
                this.click(productLocator.get(i));
                break;
            }
        }
    }


    public void clickOnAddBag() throws Exception {
        if (isDisplayed(btnAddBagLocator)) {
            this.click(btnAddBagLocator);
        }
    }

    public WebElement getIncrementProduct(int i) {
        return btnIncrementProductLocator;
    }

    public void clickIncrementProduct() throws Exception {
        for (int i = 1; i <= 1; i++) {
            this.click(getIncrementProduct(i));
        }
    }


    public void selectGuarantee(String guarantee) throws Exception {
        for (int i = 0; i < btnGuaranteeLocator.size(); i++) {
            if (guarantee.contains(btnGuaranteeLocator.get(i).getText())) {
                this.click(btnGuaranteeLocator.get(i));
                break;
            }
        }
    }

    public void clickOnSeeShoppingBag() throws Exception {
        this.click(btnSeeShoppingBagLocator);
    }
}



