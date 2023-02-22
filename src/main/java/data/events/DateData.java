package data.events;

import java.util.Arrays;

public enum DateData {
    JANUARY("Января",1),
    FEBRUARY("Февраля",2),
    MARCH("Марта",3),
    APRIL("Апреля",4),
    MAY("Мая",5),
    JUNE("Июня",6),
    JULY("Июля",7),
    AUGUST("Августа",8),
    SEPTEMBER("Сентября",9),
    OCTOBER("Октября",10),
    NOVEMBER("Ноября",11),
    DECEMBER("Декабря",12);

    private String name;
    private int number;

    DateData(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public static DateData getDateData(String name){
        return Arrays.stream(DateData.values()).filter((DateData dateData)->dateData.getName().equals(name))
                .findFirst().get();
    }
}
