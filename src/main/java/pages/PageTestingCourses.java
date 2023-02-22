package pages;

import data.corses.DurationData;
import data.corses.FormatData;
import data.corses.SubTitileData;
import data.corses.TitileData;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageTestingCourses extends AbsBasePage{
    public PageTestingCourses(WebDriver driver) {
        super(driver, "/");
    }

    public PageTestingCourses chekTitile(TitileData titileData,String exp){
        baseWaiter.waitForVisibile(driver.findElement(By.cssSelector(titileData.getName())));
        Assert.assertEquals(exp,driver.findElement(By.cssSelector(titileData.getName())).getText());
        return this;

    }

    public PageTestingCourses chekSubTitile(SubTitileData subTitileData, String exp){
        baseWaiter.waitForVisibile(driver.findElement(By.cssSelector(subTitileData.getName())));
        Assert.assertEquals(exp,driver.findElement(By.cssSelector(subTitileData.getName())).getText());
        return this;
    }

    public PageTestingCourses chekFormat(FormatData formatData, String exp){
        baseWaiter.waitForVisibile(driver.findElement(By.cssSelector(formatData.getName())));
        Assert.assertEquals(exp,driver.findElement(By.cssSelector(formatData.getName())).getText());
        return this;
    }
    public PageTestingCourses chekDurationData(DurationData durationData, String exp){
        baseWaiter.waitForVisibile(driver.findElement(By.cssSelector(durationData.getName())));
        Assert.assertEquals(exp,driver.findElement(By.cssSelector(durationData.getName())).getText());
        return this;
    }



}
