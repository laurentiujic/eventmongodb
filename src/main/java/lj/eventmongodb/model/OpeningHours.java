package lj.eventmongodb.model;

public class OpeningHours {

    public DAY day;
    public Integer from;
    public Integer to;

    public enum DAY {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    public OpeningHours() {}

    public OpeningHours(DAY day, Integer from, Integer to) {
        this.day = day;
        this.from = from;
        this.to = to;
    }

    public DAY getDay() {
        return day;
    }

    public void setDay(DAY day) {
        this.day = day;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }
}


