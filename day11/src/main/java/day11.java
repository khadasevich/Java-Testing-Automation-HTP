import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Formatter;
import java.util.concurrent.TimeUnit;


public class day11 {

    public static void main (String[] args) throws InterruptedException {

        String pathToDriver = day11.class
                .getClassLoader().getResource("chromedriver.exe").getPath();
        System.setProperty("webdriver.chrome.driver", pathToDriver);
        System.setProperty("webdriver.chrome.silentOutput", "true");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Formatter form = new Formatter();
        Formatter form2 = new Formatter();
        String baseUrl = "https://www.booking.com/";

        driver.manage().window().maximize();

        String city = "Paris";
        String date = "//*[@id='frm']//descendant::td[@data-date='%s']";

        String searchXpath = "//*[@id='ss']";
        String checkInXpath = "//*[@id='frm']//descendant::div[@class='xp__dates xp__group']";
        String checkOutXpath = "//*[@id='frm']//descendant::span[contains(., 'Check-out month')]";
        String adultsList = "//*[@id='xp__guests__toggle']";
        String plusButtonAdults = "//*[@class='sb-group__field sb-group__field-adults']//descendant::button[@class='bui-button bui-button--secondary bui-stepper__add-button ']";
        String startDateXpath = form.format(date, generateStartDate()).toString();
        String endDateXpath = form2.format(date, generateEndDate()).toString();
        String searchButton = "//*[@id='frm']//descendant::button[@data-sb-id='main']";
        String adultsQuantity = "//*[@class='sb-group__field sb-group__field-adults']//descendant::span[@class='bui-stepper__display']";
        String roomsQuantity = "//*[@class='sb-group__field sb-group__field-rooms']//descendant::span[@class='bui-stepper__display']";
        String plusButtonRooms = "//*[@class='sb-group__field sb-group__field-rooms']//descendant::button[@class='bui-button bui-button--secondary bui-stepper__add-button ']";
        String maxPrice = "//*[@id='filter_price']//descendant::a[@data-id='pri-5']";
        String sortPrice = "//*[@id='sort_by']//descendant::a[contains(., 'owest')]";
        String firstElement = "//*[@id='hotellist_inner'][1]//descendant::div[@class='bui-price-display__value prco-inline-block-maker-helper']";


        driver.get(baseUrl);

        WebElement searchField = driver.findElement(By.xpath(searchXpath));
        WebElement checkIn = driver.findElement(By.xpath(checkInXpath));




        searchField.click();
        searchField.sendKeys(city);
        checkIn.click();


        WebElement startDate = driver.findElement(By.xpath(startDateXpath));
        startDate.click();
        WebElement endDate = driver.findElement(By.xpath(endDateXpath));
        endDate.click();

        WebElement adultsDropDown = driver.findElement(By.xpath(adultsList));
        adultsDropDown.click();

        WebElement plusAd = driver.findElement(By.xpath(plusButtonAdults));
        WebElement adults = driver.findElement(By.xpath(adultsQuantity));
        String quan = adults.getText();
        while (!quan.equals("4")) {
            plusAd.click();
            quan = adults.getText();

        }

        WebElement plusRoom = driver.findElement(By.xpath(plusButtonRooms));
        WebElement rooms = driver.findElement(By.xpath(roomsQuantity));
        quan = rooms.getText();
        while (!quan.equals("2")) {
            plusRoom.click();
            quan = rooms.getText();
        }


        WebElement searchHotelButton = driver.findElement(By.xpath(searchButton));

        searchHotelButton.click();

        WebElement maxPriceEl = driver.findElement(By.xpath(maxPrice));

        String maxPriceExpected = maxPriceEl.getText();
        maxPriceExpected = maxPriceExpected.replaceAll("[^\\d.]", "");
        maxPriceEl.click();

        WebElement sortPriceEl = driver.findElement(By.xpath(sortPrice));
        sortPriceEl.click();

        WebElement lowestPrice = driver.findElement(By.xpath(firstElement));
        String price = lowestPrice.getText();
        price = price.replaceAll("[^\\d.]", "");

        int priceDay = Integer.parseInt(price)/7;
        int intPriceExpected = Integer.parseInt(price);

        System.out.println(priceDay);
        System.out.println(maxPriceExpected);


        Thread.sleep(10000);


        driver.close();
        driver.quit();


    }

    static public LocalDate generateStartDate() {
        LocalDate today = LocalDate.now();
        LocalDate nextThreeDays = today.plus(3, ChronoUnit.DAYS);
        return nextThreeDays;
    }

    static public LocalDate generateEndDate() {
        LocalDate today = LocalDate.now();
        LocalDate nextTenDays = today.plus(10, ChronoUnit.DAYS);
        return nextTenDays;
    }
}
