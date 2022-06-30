import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;

public class Appointment extends Page {

    private final WebDriver driver;

    @FindBy(xpath = "//input[@data-testid='pet']")
    private WebElement petName;

    @FindBy(xpath = "//input[@data-testid='owner']")
    private WebElement ownerName;

    @FindBy(xpath = "//input[@data-testid='date']")
    private WebElement date;

    @FindBy(xpath = "//input[@data-testid='time']")
    private WebElement time;

    @FindBy(xpath = "//textarea[@data-testid='symptoms']")
    private WebElement symptoms;

    @FindBy(xpath = "//button[@data-testid='btn-submit']")
    private WebElement submitAppointment;

    @FindBy(xpath = "//button[@data-testid='btn-delete']")
    private WebElement deleteAppointment;

    public Appointment(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void add(String petName, String ownerName, String date, String time, String symptoms) {
        this.petName.sendKeys(petName);
        this.ownerName.sendKeys(ownerName);
        this.date.sendKeys(date);
        this.time.sendKeys(time);
        this.symptoms.sendKeys(symptoms);
        submitAppointment.click();
    }

    public boolean isAdded(String petName) {
        return driver.findElement(By.xpath("//div[@data-testid='appointment']/p[contains(text(),'" +
                "Pet')]/span[text()='" + petName + "']")).isDisplayed();
    }

    public void delete(){
        deleteAppointment.click();
    }

    public boolean isDeleted(){
       return new WebDriverWait(driver, Duration.ofSeconds(0)).until(invisibilityOf(deleteAppointment));
    }
}
