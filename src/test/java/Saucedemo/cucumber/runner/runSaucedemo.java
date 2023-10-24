package Saucedemo.cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Saucedemo/cucumber/resources/features",
        glue = "Saucedemo.cucumber.stepDef",
        plugin = {"html:target/HTML_report.html"}

)
public class runSaucedemo {
}
