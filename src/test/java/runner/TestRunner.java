package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

 @RunWith(Cucumber.class)
 @CucumberOptions(
		features = "Feature"
		
		,glue={"stepDefinition"}
		,plugin = {"json:target/cucumber.json"}
		,tags={"@LoginTest"}
		//,monochrome=true
		)

public class TestRunner extends AbstractTestNGCucumberTests {

}
