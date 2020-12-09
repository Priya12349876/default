package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

 //@RunWith(Cucumber.class)
 @CucumberOptions(
		features = "Feature"
		,glue={"stepDefinition"}
		,tags={"@LoginTest"}
		//,monochrome=true
		)

public class TestRunner extends AbstractTestNGCucumberTests {

}
