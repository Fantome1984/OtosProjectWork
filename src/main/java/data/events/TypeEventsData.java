package data.events;

public enum TypeEventsData {
    ОТКРЫТЫЙВЕБИНАР("Открытый вебинар");
    private String name;

    TypeEventsData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
