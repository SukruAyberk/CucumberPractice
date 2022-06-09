package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HMCPage {

    public HMCPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//a[@class='nav-link'])[7]")
    public WebElement loginButton1;

    @FindBy(xpath = "//input[@id='UserName']")
    public WebElement username;

    @FindBy(xpath = "//input[@id='Password']")
    public WebElement password;

    @FindBy(xpath = "//input[@id='btnSubmit']")
    public WebElement loginButton2;

    @FindBy(xpath = "//span[@class='caption-subject font-green-sharp bold uppercase']")
    public WebElement listOfUsersText;

    @FindBy(xpath = "//*[text()='Try again please']")
    public WebElement tryAgainText;

    @FindBy(xpath = "//*[text()='Hotel Management']")
    public WebElement hotelManagementButton;

    @FindBy(xpath = "//a[@href='/admin/HotelAdmin']")
    public WebElement hotelListButton;

    @FindBy(xpath = "//input[@id='Code']")
    public WebElement codeTextBox;

    @FindBy(xpath = "//select[@name='IDGroup']")
    public WebElement ddm;

    @FindBy(xpath = "//span[@class='hidden-480']")
    public WebElement addHotelButton;

    @FindBy(xpath = "//button[@id='btnSubmit']")
    public WebElement saveButton;

    @FindBy(xpath = "//input[@id='Name']")
    public WebElement hotelName;

    @FindBy(xpath = "//input[@id='Address']")
    public WebElement hotelAddress;

    @FindBy(xpath = "//input[@id='Phone']")
    public WebElement hotelPhone;

    @FindBy(xpath = "//input[@id='Email']")
    public WebElement hotelEmail;

    @FindBy(xpath = "//*[text()='Hotel was inserted successfully']")
    public WebElement successfullText;

    @FindBy(xpath = "//*[text()='HotelRoom was inserted successfully']")
    public WebElement successfullText2;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement okButton;

    @FindBy(xpath = "//a[@href='/admin/HotelRoomAdmin']")
    public WebElement hotelRoomsButton;

    @FindBy(xpath = "//*[text()='Add Hotelroom ']")
    public WebElement addHotelRoomButton;

    @FindBy(xpath = "//select[@id='IDHotel']")
    public WebElement ddm2;

    @FindBy(xpath = "//input[@id='Location']")
    public WebElement location;

    @FindBy(xpath = "//textarea[@role='textbox']")
    public WebElement description;

    @FindBy(xpath = "//input[@name='Price']")
    public WebElement roomPrice;

    @FindBy(xpath = "//select[@name='IDGroupRoomType']")
    public WebElement ddm3;

    @FindBy(xpath = "//input[@name='MaxAdultCount']")
    public WebElement adultCount;

    @FindBy(xpath = "//input[@name='MaxChildCount']")
    public WebElement childrenCount;

    @FindBy(xpath = "(//input[@name='IsAvailable'])[1]")
    public WebElement approvedButton;
}
