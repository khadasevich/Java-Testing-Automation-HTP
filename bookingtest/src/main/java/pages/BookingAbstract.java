package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BookingAbstract {

    protected WebDriver driver;

    BookingAbstract(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
}
