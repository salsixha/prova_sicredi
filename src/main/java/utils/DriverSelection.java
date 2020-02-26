package utils;


import org.junit.BeforeClass;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class DriverSelection
{
    public static WebDriver driver = null;

    public static void setUpChrome()
    {
        System.setProperty("webdriver.chrome.driver","src\\main\\resources\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--no-sandbox");
        //options.addArguments("--disable-gpu");
        options.addArguments("start-maximized");
        //options.addArguments("enable-automation");
        //options.addArguments("--disable-infobars");
        //options.addArguments("--disable-dev-shm-usage");
        //options.addArguments("--disable-browser-side-navigation");
        //options.addArguments("--disable-gpu");
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        if (driver == null || !(driver instanceof ChromeDriver))
        {
            driver = new ChromeDriver(options);
        }
        driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
    }

    public static void setUpHeadless()
    {
        System.setProperty("webdriver.chrome.driver","src\\main\\resources\\chromedriver.exe");
        if (driver == null || !(driver instanceof ChromeDriver))
        {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
        }
        driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
    }

    public static void quit()
    {
        System.out.println("Encerrando o navegador");
        driver.quit();
    }
}
