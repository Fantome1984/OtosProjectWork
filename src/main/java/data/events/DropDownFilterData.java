package data.events;

public enum DropDownFilterData {
    ОТКРЫТЫЕВЕБИНАРЫ("Открытые вебинары");
   private String name;

    DropDownFilterData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
