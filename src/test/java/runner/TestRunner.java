package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)

@CucumberOptions(
        features = {"src/test/java/features"},
        glue = {"seleniumgluecode"},
        plugin = {"json:test/report/cucumber_report.json"}

)

public class TestRunner {
    private static final Logger log = Logger.getLogger(TestRunner.class);

    @AfterClass
    public static void finish() {

        try {
            String[] cmd = {"cmd.exe", "/c", "npm run report"};
            Runtime.getRuntime().exec(cmd);
            log.log(Level.INFO, "Reporte generado correctamente");
        } catch (Exception ex) {
            log.log(Level.ERROR, "No se pudo generar el reporte");
            ex.printStackTrace();
        }
    }
}
