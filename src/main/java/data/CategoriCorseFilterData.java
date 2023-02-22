package data;

public enum CategoriCorseFilterData {
    TESTING("Тестирование");
    private String name;

    CategoriCorseFilterData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
