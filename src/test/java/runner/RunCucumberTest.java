package runner;

import browser.BrowserManager;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.TestNG;
import org.testng.annotations.DataProvider;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "step_definitions",
//        tags = "@randomData and not @ignore",
//        tags = "@login and not @ignore",
//        tags = "@contact-us and not @ignore",
//        tags = "@regression and not @ignore",
        tags = "@smoke and not @ignore",
//        tags = "@button-clicks and @smoke and not @ignore",
//        tags = "@todo-list and not @ignore",
//        tags = "@page-object-model and not @ignore",
//        tags = "@accordion and not @ignore",
        plugin = {"pretty", "json:target/cucumber.json",
        "html:target/cucumber-report.html"}
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {

    private static final Properties properties = new Properties();
    private static final Logger logger = Logger.getLogger(RunCucumberTest.class.getName());

    //For parallelization
    static {
        try {
            Path configPath = Paths.get(System.getProperty("config.path",
                    Paths.get(System.getProperty("user.dir"), "src", "main", "resources",
                            "config.properties").toString()));
            try (InputStream in = Files.newInputStream(configPath)) {
                properties.load(in);
            } catch (IOException e) {
                logger.log(Level.SEVERE, "Error loading config file.", e);
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error loading config file.", e);
        }
    }

    public static void main(String[] args) {
        TestNG testNG = new TestNG(); // Create instance of TestNG
        XmlSuite suite = new XmlSuite(); // Creating new Test Suite
        int threadCount = getThreadCount(); // Getting thread count for enabling parallel execution
        System.out.println("Configured thread count is: " + threadCount);
        suite.setDataProviderThreadCount(threadCount); // Setting the thread count
        XmlTest test = new XmlTest(suite); // Creating a new TestNG test and adding it to the suite
        test.setName("Cucumber Test"); //Setting the name of the test
        test.setXmlClasses(Collections.singletonList(new XmlClass(RunCucumberTest.class))); //Add the test case to the class
        testNG.setUseDefaultListeners(false); // Disbale default listeners, will disbable TestNG reports to be generated
        testNG.setXmlSuites(Collections.singletonList(suite)); //Add the suite to testNG instance
        testNG.run(); // Run TestNG with the configured suite
    }

    public static int getThreadCount() {
        return Integer.parseInt(properties.getProperty("thread.count", "1"));
    }

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios(); //Provide data for the tests, enabling parallel execution
    }
}
