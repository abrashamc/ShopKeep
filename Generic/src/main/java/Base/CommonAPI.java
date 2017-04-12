package Base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by abra on 4/12/17.
 */
public class CommonAPI {

    public static WebDriver driver = null;

    @Parameters({"userName","os","browserName","browserVersion","url"})

    @BeforeMethod
    public void setUp(@Optional("Abrasham_94") String userName, @Optional("Mac") String os, @Optional("chrome") String browserName, @Optional("50")        //Opens Browser And Navigates to URL
                              String browserVersion, @Optional("https://www.shopkeepapp.com/login") String url)throws IOException {

        System.setProperty("webdriver.chrome.driver", "/Users/abra/maven-projects/ShopKeepAutomation/Generic/src/driver/chrome/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(url);
    }


    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {            //Closes Browser After Test and Takes a Screenshot if Test Fails
        if (result.getStatus() == ITestResult.FAILURE) {
            captureScreenshot(driver, result.getName());
        }
        driver.quit();
    }


    public static void captureScreenshot(WebDriver driver, String screenshotName) throws Exception{                 //Captures Screenshot
        DateFormat df = new SimpleDateFormat("(MM.dd.yyyy-HH:mma)");
        Date date = new Date();
        df.format(date);

        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File(System.getProperty("user.dir")+ "/screenshots/"+screenshotName+" "+df.format(date)+".png"));
            System.out.println("Screenshot captured");
    }

}
