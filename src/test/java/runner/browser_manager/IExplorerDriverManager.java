package runner.browser_manager;


import org.openqa.selenium.ie.InternetExplorerDriver;

public class IExplorerDriverManager extends DriverManager {
        @Override
        public void createDriver() {

            System.setProperty("webdriver.ie.driver",  "./src/test/resources/IEDriverServer/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
    }

