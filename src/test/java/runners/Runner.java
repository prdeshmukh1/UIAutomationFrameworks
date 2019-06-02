import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import com.cucumber.listener.ExtentCucumberFormatter;
import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;

@CucumberOptions(
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:output/report.html"},
        features = "src/test/resources/FeatureFiles",
        glue = "steps",
        tags = {"@Book_Tikect"}        
        )
public class Runner extends AbstractTestNGCucumberTests{
	  @BeforeClass
	    public  static void setup() {
	        ExtentProperties extentProperties = ExtentProperties.INSTANCE;
//	        extentProperties.setExtentXServerUrl("http://localhost:1337");
//	        extentProperties.setProjectName("TestNGProject");
	        extentProperties.setReportPath("output/myreport.html");
	    }

	    @AfterClass
	    public static void teardown() {
	        Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
	        Reporter.setSystemInfo("user", System.getProperty("user.name"));
	        Reporter.setSystemInfo("os", "Mac OSX");
	        Reporter.setTestRunnerOutput("Sample test runner output message");
	    }

}
