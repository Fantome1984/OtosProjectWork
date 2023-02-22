package data.corses;

public enum FormatData {
    FORMAT(".container__col_2 .course-header2-bottom__item-text");

    private String name;

    FormatData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
