package data.events;
public enum EventsData  {

    ОТКРЫТЫЙВЕБИНАР("/events/near/open_lesson/");

    private String name;

    EventsData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

