package ua.nure.tkachenko.Final.db.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * class for 'ticket' table in database
 */
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private int idTicket;
    private Date dateStart;
    private Date dateFinish;
    private User user;
    private Train train;
    private Seat seat;
    private Station station;
    private Route route;
    private String status;

    public Ticket() {
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "idTicket=" + idTicket +
                ", dateStart=" + format.format(dateStart) +
                ", dateFinish=" + format.format(dateFinish) +
                ", user=" + user +
                ", train=" + train +
                ", seat=" + seat +
                ", station=" + station +
                ", route=" + route +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (idTicket != ticket.idTicket) return false;
        if (dateStart != null ? !dateStart.equals(ticket.dateStart) : ticket.dateStart != null) return false;
        if (dateFinish != null ? !dateFinish.equals(ticket.dateFinish) : ticket.dateFinish != null) return false;
        if (user != null ? !user.equals(ticket.user) : ticket.user != null) return false;
        if (train != null ? !train.equals(ticket.train) : ticket.train != null) return false;
        if (seat != null ? !seat.equals(ticket.seat) : ticket.seat != null) return false;
        if (station != null ? !station.equals(ticket.station) : ticket.station != null) return false;
        return route != null ? route.equals(ticket.route) : ticket.route == null;

    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (dateStart != null ? dateStart.hashCode() : 0);
        result = 31 * result + (dateFinish != null ? dateFinish.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (train != null ? train.hashCode() : 0);
        result = 31 * result + (seat != null ? seat.hashCode() : 0);
        result = 31 * result + (station != null ? station.hashCode() : 0);
        result = 31 * result + (route != null ? route.hashCode() : 0);
        return result;
    }
}
