package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions (
		features={"src/test/resources/appFeatures/"},
		glue={"stepDefinitions","hooks"},
		tags="@All",
		plugin={"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, ////,"json:target/MyReports/report.json","junit:target/MyReports/report.xml",	
		monochrome=true,
		dryRun=false
		)
public class MidtransRunner {


}
