package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.util.List;

public class PurchasesPage extends BasePage {

    private String titlePurchasePage = "Bolsa de compras - Falabella.com";

    @FindBy(xpath = "//div[@class='fb-basket__order-container__details']//div[@class='headerContainer']")
    private WebElement pageTitle;

    @FindBy(xpath = "//button[@class='fb-btn fb-btn-primary fb-btn-icon fb-order-status__continue-purchase js-fb-continue-purchase']")
    private WebElement btnGoPurchase;

    @FindBy(id = "region")
    private WebElement btnRegionLocator;

    @FindBy(id = "comuna")
    private WebElement btnComunaLocator;

    @FindBy(xpath = "//button[@name='field04']")
    private WebElement btnContinueLocator;

    @FindBy(xpath = "//div[@class='fbra_tab fbra_deliveryGroupTab fbra_deliveryGroupTab--collect fbra_test_deliveryGroupTab fbra_test_deliveryGroupTab--collect fbra_tab--enabled fbra_tab--inactive']")
    private WebElement selecPickUpLocator;

    @FindBy(xpath = "//button[@class='fbra_button fbra_test_button fbra_locationResultsListItem__selectButton fbra_formItem__selectButton']")
    private List<WebElement> btnChooseLocator;

    @FindBy(xpath = "//button[@class='fbra_button fbra_checkoutComponentDeliveryActions__continueToSecurePaymentButton fbra_test_checkoutComponentDeliveryActions__continueToSecurePaymentButton']")
    private WebElement ButtonContinueGoPayLocator;

    @FindBy(xpath = "//div[@class='paymentOptionLeftCont']//span")
    private List<WebElement> paymentMethodLocator;

    @FindBy(xpath = "//button[contains(text(),'CONTINUAR CON PAGO EN EFECTIVO')]")
    private WebElement btnContinueCashLocator;

    @FindBy(id = "firstName")
    private WebElement txtFirstNameLocator;

    @FindBy(id = "lastName")
    private WebElement txtLastNameLocator;

    @FindBy(id = "emailAddress")
    private WebElement txtEmailLocator;

    @FindBy(id = "userIdNumber")
    private WebElement txtUserIdLocator;

    @FindBy(id = "phoneNumber")
    private WebElement txtPhoneNumbreLocator;


    public PurchasesPage(WebDriver driver) {
        super(driver);
    }

    public boolean isShoppingBagDisplayed() throws Exception {
        return this.isDisplayed(pageTitle) && this.getText(pageTitle).equals(titlePurchasePage);

    }

    public void clickOnGoPurchase() throws Exception {
        if (isDisplayed(btnGoPurchase)) {
            this.click(btnGoPurchase);
        }
    }

    public void selectRegion(String setRegion) throws Exception {
        this.select(setRegion, btnRegionLocator);
    }

    public void selectComuna(String setComuna) throws Exception {
        this.select(setComuna, btnComunaLocator);
    }

    public void clickOnContinue() throws Exception {
        if (isDisplayed(btnContinueLocator)) {
            this.click(btnContinueLocator);
        }
    }

    public void submitInformationDispatch(String region, String comuna) throws Exception {

        this.selectRegion(region);
        this.selectComuna(comuna);
        this.clickOnContinue();
    }

    public void selectpickUpPurchase() throws Exception {
        this.click(selecPickUpLocator);
    }

    public void selectStore() throws Exception {
        wait.until(ExpectedConditions.visibilityOfAllElements(btnChooseLocator));
        for (int i = 0; i < btnChooseLocator.size(); i++) {
            this.click(btnChooseLocator.get(0));
            break;
        }
    }

    public void clickOnButtonContinueGoPay() throws Exception {
        if (isDisplayed(ButtonContinueGoPayLocator)) {
            this.click(ButtonContinueGoPayLocator);
        }
    }

    public void selectPaymentMethod(String payment) throws Exception {
        wait.until(ExpectedConditions.visibilityOfAllElements(paymentMethodLocator));
        for (int i = 0; i < paymentMethodLocator.size(); i++) {
            if (payment.contains(paymentMethodLocator.get(i).getText())) {
                this.click(paymentMethodLocator.get(i));
                break;
            }
        }
    }

    public void clickOnContinueCash() throws Exception {
        if (isDisplayed(btnContinueCashLocator)) {
            this.click(btnContinueCashLocator);
        }
    }

    public void setName(String setName) throws Exception {
        if (isDisplayed(txtFirstNameLocator)) {
            this.sendKeys(setName, txtFirstNameLocator);
        }
    }

    public void setLastName(String setLastName) throws Exception {
        if (isDisplayed(txtLastNameLocator)) {
            this.sendKeys(setLastName, txtLastNameLocator);
        }
    }

    public void setEmail(String setEmail) throws Exception {

        this.sendKeys(setEmail, txtEmailLocator);
    }

    public void setIdDocumentation(String setId) throws Exception {
        this.sendKeys(setId, txtUserIdLocator);
    }

    public void setPhoneNumber(String setNumber) throws Exception {
        this.sendKeys(setNumber, txtPhoneNumbreLocator);
    }

    public void submitInformationCustomer(String name, String lastName, String email, String documentation, String numberPhone) throws Exception {
        this.setName(name);
        this.setLastName(lastName);
        this.setEmail(email);
        this.setIdDocumentation(documentation);
        this.setPhoneNumber(numberPhone);

    }
}
