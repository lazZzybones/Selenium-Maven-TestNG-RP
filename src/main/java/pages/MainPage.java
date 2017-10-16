package pages;

import static helper.Move.moveToMyElement;
import static helper.Waits.elementIsClickable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MainPage extends PageObject {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1")
    public WebElement titleH1;

    @FindBy(xpath = "//ol[@class='results']")
    public WebElement result;

    @FindBy(id = "ui-datepicker-div")
    public WebElement datepicker;

    @FindBy(xpath = "//div[@class='passengers']")
    public WebElement passengersClass;

    @FindBy(xpath = "//div[@class='price']")
    public WebElement priceClass;

    @FindBy(id = "routeSelection_DepartureStation-input")
    public WebElement fieldFrom;

    @FindBy(xpath = "//ol/li[1]")
    public WebElement firstValueFromListFrom;

    @FindBy(id = "routeSelection_ArrivalStation-input")
    public WebElement fieldTo;

    @FindBy(xpath = "//ol/li/ol/li[1]")
    public WebElement firstValueFromListTo;

    @FindBy(xpath = "//div[@data-date-picker='outbound']/div/span[@class='datepicker-trigger icon-font icon-calendar']")
    public WebElement datepickerDepart;

    @FindBy(id = "dateSelection_OutboundDate-datepicker")
    public WebElement fieldOtboundDate;

    @FindBy(xpath = "//label[@for='dateSelection_IsReturnFlight']")
    public WebElement labelReturnOn;

    @FindBy(id = "booking-passengers-input")
    public WebElement fieldBookingPassengers;

    @FindBy(id = "dateSelection_IsReturnFlight-datepicker")
    public WebElement fieldIsReturnDate;

    @FindBy(xpath = "//button[@class='button button-secondary close']")
    public WebElement buttonSavePassengers;

    @FindBy(xpath = "//*[@id='desktop']/section/div[3]/div/button")
    public WebElement searchButton;

    @FindBy(xpath = "//div[@class='togglepanel']//div[@class='passengers']//div[@class='selectfield adults']//button[2]")
    public WebElement buttonPlusAdults;

    @FindBy(xpath = "//div[@class='togglepanel']//div[@class='passengers']//div[@class='selectfield children']//button[2]")
    public WebElement buttonPlusChildren;

    @FindBy(xpath = "//div[@class='c-passengers-form-component']")
    public WebElement fieldPassenger;

    @FindBy(xpath = "//a[@href='/en-EU/my-transavia/booking/booking-overview/']")
    public WebElement manageYourBookinglink;

    @FindBy(xpath = "//*[@id='horizontal-sub-navigation-manageyourbooking']/div/div[2]/div/div[1]/div/ul/li[2]/a/div/span[2]")
    public WebElement viewYourBookinglink;

    public LoginPage goToLoginPage() {
        moveToMyElement(driver, manageYourBookinglink);
        manageYourBookinglink.click();
        moveToMyElement(driver, viewYourBookinglink);
        viewYourBookinglink.click();
        return new LoginPage(driver);
    }

    public void fillFromField(String from) {
        elementIsClickable(driver, fieldFrom, 20);
        fieldFrom.sendKeys(from);
        elementIsClickable(driver, firstValueFromListFrom, 20);
        firstValueFromListFrom.click();
    }

    public void fillToField(String to) {
        elementIsClickable(driver, fieldTo, 20);
        fieldTo.sendKeys(to);
        elementIsClickable(driver, firstValueFromListTo, 20);
        firstValueFromListTo.click();
    }

    public WebDriver runSearch() {
        elementIsClickable(driver, searchButton, 20);
        searchButton.click();
        return driver;
    }
}
