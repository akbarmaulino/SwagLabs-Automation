package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/feature/addtochart.feature",
        glue = {"steps"},
        monochrome = true,
//        plugin = {"pretty", "html:target/HTMLReports.html"},
        plugin = {"json:target/addtochart.json"}
)

public class testrunner {
}



