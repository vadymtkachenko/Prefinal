package ua.nure.tkachenko.Final.db.entity;


import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

/**
 * class for 'route' table in database
 */
public class Route implements Serializable{

    private static final long serialVersionUID = 1L;

    private int idRoute;
    private int number;
    private Time timeOfRoute;

    public Route() {
    }

    public int getIdRoute() {
        return idRoute;
    }

    public void setIdRoute(int idRoute) {
        this.idRoute = idRoute;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getTimeOfRoute() {
        return timeOfRoute;
    }

    public void setTimeOfRoute(Time timeOfRoute) {
        this.timeOfRoute = timeOfRoute;
    }

    @Override
    public String toString() {
        return "Route{" +
                "idRoute=" + idRoute +
                ", number=" + number +
                ", timeOfRoute=" + timeOfRoute +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Route route = (Route) o;

        if (idRoute != route.idRoute)
            return false;
        if (number != route.number)
            return false;
        return timeOfRoute != null ? timeOfRoute.equals(route.timeOfRoute) : route.timeOfRoute == null;

    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (number != 0 ? number : 0);
        result = 31 * result + (timeOfRoute != null ? timeOfRoute.hashCode() : 0);
        return result;
    }
}
