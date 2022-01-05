package base;

import base.report.ExtentManager;
import base.report.ExtentTestManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class TestBase {
    public static WebDriver driver;
    public static ExtentReports extent;
    @BeforeMethod(alwaysRun = true)
    @Parameters({"os","browserName","url"})
    public WebDriver getDriver(String os,String browserName, String url) {
        if (browserName.equalsIgnoreCase("chrome")) {

            if(os.equalsIgnoreCase("mac")) {
                System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver");
            } else {
                System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
            }

            driver = new ChromeDriver();

        } else if (browserName.equalsIgnoreCase("firefox")) {
            if(os.equalsIgnoreCase("mac")) {
                System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver");
            } else {
                System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");
            }
            driver = new FirefoxDriver();
        }

        driver.get(url);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    @AfterMethod
    public void closeDriver() {
        driver.close();
    }



    //reporting starts
    @BeforeSuite
    public void extentSetup(ITestContext context) {
        ExtentManager.setOutputDirectory(context);
        extent = ExtentManager.getInstance();
    }

    @BeforeMethod
    public void startExtent(Method method) {
        String className = method.getDeclaringClass().getSimpleName();
        ExtentTestManager.startTest(method.getName());
        ExtentTestManager.getTest().assignCategory(className);
    }

    protected String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        return sw.toString();
    }

    @AfterMethod
    public void afterEachTestMethod(ITestResult result) {
        ExtentTestManager.getTest().getTest().setStartedTime(getTime(result.getStartMillis()));
        ExtentTestManager.getTest().getTest().setEndedTime(getTime(result.getEndMillis()));
        for (String group : result.getMethod().getGroups()) {
            ExtentTestManager.getTest().assignCategory(group);
        }

        if (result.getStatus() == 1) {
            ExtentTestManager.getTest().log(LogStatus.PASS, "Test Passed");
        } else if (result.getStatus() == 2) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, getStackTrace(result.getThrowable()));
        } else if (result.getStatus() == 3) {
            ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
        }

        ExtentTestManager.endTest();
        extent.flush();
        if (result.getStatus() == ITestResult.FAILURE) {
            captureScreenshot(driver, result.getName());
        }
    }

    public Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }

    //screenshot
    public static void captureScreenshot(WebDriver driver, String screenshotName) {
        DateFormat dateFormat = new SimpleDateFormat("HH_mm_ss");
        Date date = new Date();
        // --> dateFormat.format(date);
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "/screenshots/" + screenshotName + " " + dateFormat.format(date) + ".jpg"));
            System.out.println("Screenshot captured");
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot " + e.getMessage());
        }
    }

    //reporting finish

    @AfterSuite
    public void generateReport() {
        extent.close();
    }
}

int [][]seat = new int[N+1][10];
		int num = 0;
		char s = S.toCharArray();
		for(int i=0;i<S.length;i++){
			if(s[i]==' ')continue;
			else if(s[i]>='0'&&s[i]<='9')
				num = num*10+s[i]-'0';
			else{
				seat[num][s[i]-'A'] = 1;
				num = 0;
			}
		}
		int ret = 0;
		for(int i=1;i<=N;i++){
			if(seat[i][1]+seat[i][2]+seat[i][3]+seat[i][4]==0){
				seat[i][1] = seat[i][2] = seat[i][3] = seat[i][4] = 1;
				ret++;
			}
			if(seat[i][3]+seat[i][4]+seat[i][5]+seat[i][6]==0){
				seat[i][3] = seat[i][4] = seat[i][5] = seat[i][6] = 1;
				ret++;
			}
			if(seat[i][5]+seat[i][6]+seat[i][7]+seat[i][8]==0){
				seat[i][5] = seat[i][6] = seat[i][7] = seat[i][8] = 1;
				ret++;
			}
		}
		return ret;
    }
}
