package data.hederMenu;

public enum CategoriesLearningData implements IMenu {
    TESTING("/categories/testing/",HederMenuItemData.LEARNING),

    EVENTSCALENRAR("/events/near/",HederMenuItemData.LEARNING);

    private String name;
    private HederMenuItemData hederMenuData;


    CategoriesLearningData(String name,HederMenuItemData hederMenuData) {
        this.hederMenuData = hederMenuData;
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public HederMenuItemData getHederMenuData() {
        return hederMenuData;
    }
}
