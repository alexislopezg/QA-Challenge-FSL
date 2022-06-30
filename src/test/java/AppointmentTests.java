import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class AppointmentTests {

    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost:3000/");
    }

    @Test//Arrange, Act, Assert
    public void createAppointment_ValidData_AppointmentIsCreated() {
        Appointment appointment = new Appointment(driver);
        appointment.add("Perry", "Raquel Lopez", "07/07/2022", "12:00PM", "Fever, Cough");

        assertTrue(appointment.isAdded("Perry"));
    }

    @Test
    public void deleteAppoinment_ExistingAppointment_AppointmentIsDeleted() {
        Appointment appointment = new Appointment(driver);
        appointment.add("Perry", "Raquel Lopez", "07/07/2022", "12:00PM", "Fever, Cough");
        appointment.delete();

        assertTrue(appointment.isDeleted());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
