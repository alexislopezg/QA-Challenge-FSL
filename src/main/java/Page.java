import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Page {

    public Page(WebDriver driver){
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5), this);
    }
}
