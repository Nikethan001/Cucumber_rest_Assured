package Runnerfile;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@Outcome",
        features = "src/test/Feature/",
        //features = "src/test/Feature/website.feature" ,
        glue = "Cucumber_rest",
        plugin = {
                "pretty",
                "json:target/cucumber-report/cucumber.json",
                "html:target/cucumber-report/cucumber.html"}
)
public class Runner {
}
