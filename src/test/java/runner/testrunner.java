package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",  // Pastikan path ke fitur kamu benar
        glue = {"steps"},
        monochrome = true,
        plugin = {"json:target/cucumber.json"}  // Menyimpan hasil tes dalam format JSON
)
public class testrunner {
}
