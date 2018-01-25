package ua.nure.tkachenko.Final.db.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * class for 'schedule' table in database
 */
public class Schedule {
    private static final long serialVersionUID = 1L;

    private int id;
    private Date dateStart;
    private Date dateFinish;
    private Route idRoute;
    private Train idTrain;

    public Schedule() {
    }

    private static final SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(Date dateFinish) {
        this.dateFinish = dateFinish;
    }

    public Route getIdRoute() {
        return idRoute;
    }

    public void setIdRoute(Route idRoute) {
        this.idRoute = idRoute;
    }

    public Train getIdTrain() {
        return idTrain;
    }

    public void setIdTrain(Train idTrain) {
        this.idTrain = idTrain;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Schedule schedule = (Schedule) o;

        if (id != schedule.id) return false;
        if (dateStart != null ? !dateStart.equals(schedule.dateStart) : schedule.dateStart != null) return false;
        if (dateFinish != null ? !dateFinish.equals(schedule.dateFinish) : schedule.dateFinish != null) return false;
        return idRoute != null ? idRoute.equals(schedule.idRoute) : schedule.idRoute == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (dateStart != null ? dateStart.hashCode() : 0);
        result = 31 * result + (dateFinish != null ? dateFinish.hashCode() : 0);
        result = 31 * result + (idRoute != null ? idRoute.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", dateStart=" + format.format(dateStart) +
                ", dateFinish=" + format.format(dateFinish) +
                ", idRoute=" + idRoute +
                ", idTrain=" + idTrain +
                '}';
    }
}
