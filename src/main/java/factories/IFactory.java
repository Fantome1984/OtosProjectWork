package factories;

import exeptions.BrowserNotSupportedExeption;
import org.openqa.selenium.WebDriver;

public interface IFactory {
    WebDriver createDriver () throws BrowserNotSupportedExeption;
}
