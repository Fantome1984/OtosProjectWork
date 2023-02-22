package data.hederMenu;

public enum HederMenuItemData {
 LEARNING("learning");
 private String name;

    HederMenuItemData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
