package data.corses;

public enum DurationData {
    DURATION(".container__col_4 .course-header2-bottom__item-text");

    private String name;

    DurationData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
