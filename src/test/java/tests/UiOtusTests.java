package tests;

import components.CookieButton;
import components.CourseFilterComponent;
import components.EventsComponent;
import components.HederMenuComponent;
import data.*;
import data.events.DropDownFilterData;
import data.events.EventsData;
import data.events.TypeEventsData;
import data.hederMenu.CategoriesLearningData;
import data.hederMenu.HederMenuItemData;
import data.corses.DurationData;
import data.corses.FormatData;
import data.corses.SubTitileData;
import data.corses.TitileData;
import exeptions.BrowserNotSupportedExeption;
import factories.WebDriverFactory;
import helper.Logger;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.EventsPage;
import pages.MainPage;

public class UiOtusTests {
    public org.apache.logging.log4j.Logger logger = LogManager.getLogger(Logger.class);

    private WebDriver driver;

    @BeforeClass

    public static void setUpDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() throws BrowserNotSupportedExeption {
        driver = new WebDriverFactory().createDriver();
    }

    @After

    public void setDown(){
        if (driver !=null){
            driver.quit();
        }
    }

   private String titile ="Java QA Engineer. Basic";
   private   String subTitile ="Автоматизация тестирования на Java с нуля";
   private String duration ="4 месяца";
    private String format ="Online";

    @Test
    public void checkingTheNumberOfCourses()  {
        logger.info("Открыли главную страницу");
        new MainPage(driver).openPage();
        logger.info("Перешли в раздел тестирование");
        HederMenuComponent hederMenuComponent = new HederMenuComponent(driver);
        hederMenuComponent.popupSholdBeNotVisible(HederMenuItemData.LEARNING);
        hederMenuComponent.moveToHeaderItem(HederMenuItemData.LEARNING);
        hederMenuComponent.popupSholdBeVisibal(HederMenuItemData.LEARNING);
        hederMenuComponent.moveToLearningTesting(CategoriesLearningData.TESTING);
        logger.info("Проверили что карточек курса 12");
        new CookieButton(driver).closeModalCokkie();
        new CourseFilterComponent(driver).catalogComponent(CategoriCorseFilterData.TESTING,true)
                .clickShowAllCoursesButton()
                .chekCorses();
    }
    @Test

    public void сheckСourseСards()  {
        logger.info("Открыли главную страницу");
        new MainPage(driver).openPage();
        logger.info("Перешли в раздел тестирование");
        HederMenuComponent hederMenuComponent = new HederMenuComponent(driver);
        hederMenuComponent.popupSholdBeNotVisible(HederMenuItemData.LEARNING);
        hederMenuComponent.moveToHeaderItem(HederMenuItemData.LEARNING);
        hederMenuComponent.popupSholdBeVisibal(HederMenuItemData.LEARNING);
        hederMenuComponent.moveToLearningTesting(CategoriesLearningData.TESTING);
        new CookieButton(driver).closeModalCokkie();
        logger.info("Открыли карточку курса, и проверили что в  карточке указана информация о курсе");
        new CourseFilterComponent(driver).catalogComponent(CategoriCorseFilterData.TESTING,true)
                .clickCorse(CatalogTestingCorseData.JAVAQAENGINEERBASIK)
                .chekTitile(TitileData.TITILE,titile)
                .chekSubTitile(SubTitileData.SUBTITILE,subTitile)
                .chekDurationData(DurationData.DURATION,duration)
                .chekFormat(FormatData.FORMAT,format);

    }
    @Test
    public void eventSortingCheck() {
        logger.info("Открыли главную страницу");
        new MainPage(driver).openPage();
        logger.info("Перешли в раздел календарь мероприятий");
        HederMenuComponent hederMenuComponent = new HederMenuComponent(driver);
        hederMenuComponent.popupSholdBeNotVisible(HederMenuItemData.LEARNING);
        hederMenuComponent.moveToHeaderItem(HederMenuItemData.LEARNING);
        hederMenuComponent.popupSholdBeVisibal(HederMenuItemData.LEARNING);
        hederMenuComponent.moveToLearningTesting(CategoriesLearningData.EVENTSCALENRAR);
        logger.info("Отсортировали мероприятия по типу и проверили что отображаются отсортированные мероприятия");
        new EventsComponent(driver).cklickDropDown()
                .EventSorting(EventsData.ОТКРЫТЫЙВЕБИНАР)
                .chekFilter(DropDownFilterData.ОТКРЫТЫЕВЕБИНАРЫ)
                .chekWebinarCards(TypeEventsData.ОТКРЫТЫЙВЕБИНАР);
    }
    @Test
    public void eventDatesCheck(){
        logger.info("Открыли главную страницу");
        new MainPage(driver).openPage();
        logger.info("Перешли в раздел календарь мероприятий");
        HederMenuComponent hederMenuComponent = new HederMenuComponent(driver);
        hederMenuComponent.popupSholdBeNotVisible(HederMenuItemData.LEARNING);
        hederMenuComponent.moveToHeaderItem(HederMenuItemData.LEARNING);
        hederMenuComponent.popupSholdBeVisibal(HederMenuItemData.LEARNING);
        hederMenuComponent.moveToLearningTesting(CategoriesLearningData.EVENTSCALENRAR);
        logger.info("Проверили валидацию дат мероприятий и отображение мероприятий");
                new EventsPage(driver).chekEvents()
                        .assertDateEvents();

    }
}
