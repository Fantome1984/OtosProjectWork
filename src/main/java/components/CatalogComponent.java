package components;

import data.CatalogTestingCorseData;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageTestingCourses;

import static org.hamcrest.CoreMatchers.equalTo;

import java.util.List;

public class CatalogComponent extends AbsBaseComponent{
    public CatalogComponent(WebDriver driver) {
        super(driver);
    }
/*
    @FindBy(xpath = "//div[text()='OK']")
    private WebElement buttonCloseModalCokkie;*/
    @FindBy(css = "[class*='prqxfo-0 bXDQZW']")
    private WebElement showAllCoursesButton;

    private String lessonsSelector ="[href='/lessons/%s]";






    public CatalogComponent clickShowAllCoursesButton(){
        baseWaiter.waitForVisibile(showAllCoursesButton);
        actionsMoveElement(showAllCoursesButton);
        showAllCoursesButton.click();
        return this;
    }

    public CatalogComponent chekCorses(){
        List<WebElement> list = driver.findElements(By.xpath("//div[@class='sc-18q05a6-1 JPkui']/a"));
        Assert.assertThat(12,equalTo(list.size()));
        return this;
    }

    public PageTestingCourses clickCorse(CatalogTestingCorseData catalogTestingCourses){
        String selector = String.format(lessonsSelector,catalogTestingCourses.getName());
        baseWaiter.waitForVisibile(driver.findElement(By.cssSelector(selector)));
        driver.findElement(By.cssSelector(selector)).click();
        return new PageTestingCourses(driver);
    }




}
