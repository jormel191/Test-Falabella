package seleniumgluecode;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class test extends TestBase {

    @Given("user is on the page falabella")
    public void UserIsOnPage() throws Exception {
        Assert.assertTrue(homePage.homePageIsDisplayed());
    }

    @When("user types name of a {string} in search")
    public void TypeProductSearch(String product) throws Exception {
        homePage.typeSearch(product);

    }

    @Then("is redirected to the videogames section")
    public void RedirectSection() throws Exception {
        consolePage.isvideosJuegosDisplayed();
    }

    @Then("user selects {string}")
    public void SelectProduct(String console) throws Exception {
        consolePage.selectProduct(console);
    }

    @Then("user selects add to bag and increases to two products")
    public void AggBagAndIncreases() throws Exception {
        consolePage.clickOnAddBag();
        consolePage.clickIncrementProduct();
    }

    @Then("user selects extended {string}")
    public void SelectsWarranty(String garantia) throws Exception {
        consolePage.selectGuarantee(garantia);
        consolePage.clickOnSeeShoppingBag();
    }

    @Then("is redirected to the summary of your order")
    public void RedirectSummary() throws Exception {
        purchasesPage.isShoppingBagDisplayed();
    }

    @Then("user selects go purchase")
    public void SelectsPurchase() throws Exception {
        purchasesPage.clickOnGoPurchase();
    }

    @Then("user chooses dispatch options {string} and {string}")
    public void SelectDispatch(String region, String comuna) throws Exception {
        purchasesPage.submitInformationDispatch(region, comuna);
    }

    @Then("user chooses option pick up purchase")
    public void SelectPickUpPurchase() throws Exception {
        purchasesPage.selectpickUpPurchase();
    }

    @Then("user selects store and continue")
    public void SelectStore() throws Exception {
        purchasesPage.selectStore();
        purchasesPage.clickOnButtonContinueGoPay();
    }

    @Then("user selects {string} method")
    public void SelectPaymentMethod(String pago) throws Exception {
        purchasesPage.selectPaymentMethod(pago);
        purchasesPage.clickOnContinueCash();
    }

    @Then("user completes information {string}{string}{string}{string}{string} and reserves the purchase")
    public void DoBooking(String name, String lasName, String email, String id, String phone) throws Exception {
        purchasesPage.submitInformationCustomer(name, lasName, email, id, phone);
    }
}



