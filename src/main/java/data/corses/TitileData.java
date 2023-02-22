package data.corses;

public enum TitileData {
    TITILE("[class='course-header2__title']");

  private String name;

    TitileData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
