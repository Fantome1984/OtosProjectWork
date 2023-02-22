package components;

import data.events.EventsData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.EventsPage;

public class EventsComponent extends AbsBaseComponent {
    public EventsComponent(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[class='dod_new-events-dropdown__input']")
    private WebElement listEvents;

    private String eventsSelector ="[class*='dod_new-events-dropdown_opened'] a[href='%s']";




    public EventsComponent cklickDropDown() {
        listEvents.click();
        return this;
    }
    public EventsPage EventSorting(EventsData eventsData){
        String locator = String.format(eventsSelector,eventsData.getName());
        driver.findElement(By.cssSelector(locator)).click();
        return new EventsPage(driver);


    }

}
