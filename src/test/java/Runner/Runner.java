package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//json:target/Destination/cucumber.json html:target/cucumber-reports
@RunWith(Cucumber.class)
@CucumberOptions(features = "Features", plugin = { "pretty", "json:target/Destination/cucumber.json" }, glue = { "StepDefinition" })

public class Runner {

}