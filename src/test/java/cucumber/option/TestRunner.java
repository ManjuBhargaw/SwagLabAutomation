package cucumber.option;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/feature",glue={"Stepdefination","helper"},tags="@Reg",
plugin="json:target/jsonReports/test.json")

public class TestRunner {
//dryRun=true
}

//"html:target/reports/test.html"