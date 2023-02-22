package components;

import data.hederMenu.CategoriesLearningData;
import data.hederMenu.HederMenuItemData;
import data.hederMenu.IMenu;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HederMenuComponent extends AbsBaseComponent implements IPopup{
    public HederMenuComponent(WebDriver driver) {
        super(driver);
    }

    private String hederMenuSelector ="[data-name='%s'].header3__nav-item";
    private String hedermenuPopupSelector ="[data-name='%s'].js-header3-popup";
    private String сategorieSelector ="[class='header3__nav-item-popup-content']>div>div>a[href='%s']";



    public HederMenuComponent moveToHeaderItem(HederMenuItemData hederMenuItemData){
        String selector = String.format(hederMenuSelector,hederMenuItemData.getName());
        actionsMoveElement(driver.findElement(By.cssSelector(selector)));
        return this;
    }


    @Override
    public void popupSholdBeNotVisible(HederMenuItemData itemData) {
        String selector = String.format(hedermenuPopupSelector,itemData.getName());
       Assert.assertTrue(baseWaiter.waitForCondition(ExpectedConditions.attributeContains(driver.findElement(By.cssSelector(selector)),
                "style","none")));

    }

    @Override
    public void popupSholdBeVisibal(HederMenuItemData itemData) {
        String selector = String.format(hedermenuPopupSelector,itemData.getName());
       Assert.assertTrue(baseWaiter.waitForCondition(ExpectedConditions.not((ExpectedConditions.attributeContains(driver.findElement(By.cssSelector(selector)),
                "style","none")))));
    }


    public  HederMenuComponent moveToLearningTesting(CategoriesLearningData learningData){
        String selector =String.format(сategorieSelector,learningData.getName());
        actionsMoveElement(driver.findElement(By.cssSelector(selector)));
        driver.findElement(By.cssSelector(selector)).click();
        return this;

    }




}
