package components;

import data.CategoriCorseFilterData;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CourseFilterComponent extends AbsBaseComponent{

    public CourseFilterComponent(WebDriver driver){super(driver);}


    private String categoriCorseLocator = "//div[./label[text()='%s']]//input";

    public CatalogComponent catalogComponent(CategoriCorseFilterData corseFilterData,boolean state){

        String locator = String.format(categoriCorseLocator,corseFilterData.getName());
        Assert.assertEquals(state,driver.findElement(By.xpath(locator)).isSelected());
        return new CatalogComponent(driver);

    }






}
