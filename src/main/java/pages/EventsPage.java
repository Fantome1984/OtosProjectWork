package pages;

import components.AbsBaseComponent;
import data.events.DateData;
import data.events.DropDownFilterData;
import data.events.TypeEventsData;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class EventsPage extends AbsBaseComponent {
    public EventsPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = ".dod_new-events__list.js-dod_new_events a")
    private List<WebElement> evenstListSelector;
    @FindBy(css = ".dod_new-event__time")
    private List<WebElement> eventsDateListtSelector;


    public EventsPage chekFilter(DropDownFilterData data){
        Assert.assertEquals(data.getName(), driver.findElement(By.cssSelector("[class='dod_new-events-dropdown__input-selected']")).getText());

        return this;

    }
    public EventsPage chekWebinarCards(TypeEventsData eventsData){
        List<WebElement> list = driver.findElements(By.cssSelector(".dod_new-events__list.js-dod_new_events a .dod_new-type__text"));
        for (WebElement element:list){
            Assert.assertEquals(eventsData.getName(),element.getText());
        }
        return this;

    }


   public EventsPage chekEvents(){
       for (WebElement element : evenstListSelector) {
           Assert.assertTrue(element.isDisplayed());
       }
       return this;
   }


   public EventsPage assertDateEvents(){
       List<WebElement> eventsDateListtSelector = new ArrayList<>();
     Assert.assertTrue(eventsDateListtSelector.stream()
                .map(WebElement::getText)
                .map((String dateStr)->{
               String dateMounts = dateStr.split("\\s")[1];
               dateStr = dateStr.replaceAll("[а-я]+", String.format("%d",DateData.getDateData(dateMounts).getNumber()));
               dateStr+= " " + LocalDate.now();
               if (dateStr=="Сейчас в эфире"){
                        return LocalDateTime.now();
                    }
                    return LocalDateTime.parse(dateStr, DateTimeFormatter.ofPattern("dd MM yyyy hh:mm"));
                })
              .allMatch((LocalDateTime localDatetime)->localDatetime.isAfter(LocalDateTime.now()) || localDatetime.isEqual(LocalDateTime.now())));
      return this;
    }

}
