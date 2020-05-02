import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SeleniumTest {

    public static void main (String[] args) {

        String pathToDriver = SeleniumTest.class
                .getClassLoader().getResource("chromedriver.exe").getPath();



        System.setProperty("webdriver.chrome.driver", pathToDriver);
        System.setProperty("webdriver.chrome.silentOutput", "true");
        WebDriver driver = new ChromeDriver();
        String baseUrl = "http://demo.guru99.com/test/newtours/";
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = "";

        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-features=NetworkService");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS) ;

        driver.get(baseUrl);


        actualTitle = driver.getTitle();
        String url = driver.getCurrentUrl();
        System.out.println(actualTitle);
        System.out.println(url);

        driver.navigate().to("https://www.selenium.dev/");
        driver.navigate().forward();
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().to("https://www.google.com/");
        driver.navigate().to("https://www.ya.ru/");
        driver.navigate().back();
        driver.navigate().refresh();

        driver.navigate().to("https://www.google.com/");
        WebElement el = driver.findElement(By.name("q"));
        el.sendKeys("Погода в Минске");
        el.submit();
        driver.findElement(By.xpath("//*[@id=\"wob_dp\"]/div[2]/div[2]/img")).click();
        WebElement pogoda= driver.findElement(By.xpath("//*[@id=\"wob_tm\"]"));
        System.out.println(pogoda.getText());



        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
        driver.close();
        driver.quit();


    }
}
