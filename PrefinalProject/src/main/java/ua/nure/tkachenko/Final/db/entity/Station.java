package ua.nure.tkachenko.Final.db.entity;


import java.io.Serializable;
import java.sql.Time;

/**
 * class for 'station' table in database
 */
public class Station implements Serializable {


    private static final long serialVersionUID = 1L;

    private int idStation;
    private String name;
    private int time;

    public int getIdStation() {
        return idStation;
    }

    public void setIdStation(int idStation) {
        this.idStation = idStation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Station() {

    }

    @Override
    public String toString() {
        return "Station{" +
                "idStation=" + idStation +
                ", name='" + name + '\'' +
                ", minutesOfStay=" + time +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Station station = (Station) o;

        if (idStation != station.idStation) return false;
        if (time != station.time) return false;
        return name != null ? name.equals(station.name) : station.name == null;

    }

    @Override
    public int hashCode() {
        int result = idStation;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + time;
        return result;
    }
}
