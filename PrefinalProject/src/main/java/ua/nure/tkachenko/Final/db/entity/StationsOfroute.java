package ua.nure.tkachenko.Final.db.entity;


import java.util.Date;

public class StationsOfroute {

    private String name;
    private int minutesOfstay;
    private String dateIn;
    private String dateOut;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinutesOfstay() {
        return minutesOfstay;
    }

    public void setMinutesOfstay(int minutesOfstay) {
        this.minutesOfstay = minutesOfstay;
    }

    public String getDateIn() {
        return dateIn;
    }

    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    public String getDateOut() {
        return dateOut;
    }

    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }

    @Override
    public String toString() {
        return "StationsOfroute{" +
                "name='" + name + '\'' +
                ", minutesOfstay=" + minutesOfstay +
                ", dateIn=" + dateIn +
                ", dateOut=" + dateOut +
                '}';
    }
}
