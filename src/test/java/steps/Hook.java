package steps;

import Base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Karthik on 10/17/2016.
 */
public class Hook extends BaseUtil{


    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void InitializeTest() {

        System.out.println("Opening the browser : Chrome");

        /*System.setProperty("webdriver.firefox.marionette", "D:\\Libs\\geckodriver.exe");
        base.Driver = new FirefoxDriver();*/


        //Chrome driver
        //System.setProperty("webdriver.chrome.driver", "C:\\Libs\\chromedriver.exe");
        
        System.setProperty("webdriver.chrome.driver", "/usr/bin/google-chrome");
        //System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
       options.addArguments1("--no-sandbox"); // Bypass OS security model
       options.addArguments("--headless"); // open Browser in maximized mode
       options.addArguments("start-maximized"); // open Browser in maximized mode
       options.addArguments("disable-infobars"); // disabling infobars
       options.addArguments("--disable-extensions"); // disabling extensions       
       options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
      
        //base.Driver = new ChromeDriver();
        base.Driver = new ChromeDriver1(options);
    }


    @After
    public void TearDownTest(Scenario scenario) {
        if (scenario.isFailed()) {
            //Take screenshot logic goes here
            System.out.println(scenario.getName());
        }
        System.out.println("Closing the browser : Chrome");
    }

}
