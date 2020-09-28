package pom;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {

    protected WebDriver driver;

    protected Actions action;
    protected Select selectList;
    protected WebDriverWait wait;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        action = new Actions(driver);
        wait = new WebDriverWait(driver, 20);

    }

    public void click(WebElement element) throws Exception {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        } catch (Exception e) {
            throw new Exception("No se pudo hacer click en el elemento " + element);
        }
    }


    public boolean isDisplayed(WebElement element) throws Exception {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.isDisplayed();
        } catch (Exception e) {
            throw new Exception("El elemento no esta disponible " + element);
        }
    }


    public String getText(WebElement element) throws Exception {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.getText();
        } catch (Exception e) {
            throw new Exception("No se pudo obtener el texto del elemento " + element);
        }
    }


    public String getTitle() throws Exception {
        try {

            return driver.getTitle();
        } catch (Exception e) {
            throw new Exception("No se pudo obtener el titulo del driver");
        }
    }

    public void sendKeys(String inputText, WebElement element) throws Exception {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.sendKeys(inputText);
        } catch (Exception e) {
            throw new Exception("No se pudo encontrar el elemento");
        }

    }

    public void select(String inputText, WebElement element) throws Exception {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            selectList = new Select(element);
            selectList.selectByVisibleText(inputText);
        } catch (Exception e) {
            throw new Exception("No se pudo seleccionar el elemento");
        }

    }

}
