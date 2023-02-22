package data.corses;

public enum SubTitileData {
    SUBTITILE("[class='course-header2__subtitle']");

   private String name;

    SubTitileData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
