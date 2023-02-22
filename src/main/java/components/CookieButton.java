package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CookieButton extends AbsBaseComponent{


    @FindBy(xpath = "//div[text()='OK']")
    private WebElement buttonCloseModalCokkie;

    public CookieButton(WebDriver driver) {
        super(driver);
    }



    public  CookieButton closeModalCokkie(){
        baseWaiter.waitForVisibile(buttonCloseModalCokkie);
        actionsMoveElement(buttonCloseModalCokkie);
        buttonCloseModalCokkie.click();
        return this;
    }
}
