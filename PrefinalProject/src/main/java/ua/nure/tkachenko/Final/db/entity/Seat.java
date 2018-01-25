package ua.nure.tkachenko.Final.db.entity;


import java.io.Serializable;

/**
 * class for 'seat' table in database
 */
public class Seat implements Serializable {

    private static final long serialVersionUID = 1L;

    private int idSeat;
    private int number;
    private String type;
    private Car car;
    private double price;

    public Seat() {
    }

    public int getIdSeat() {
        return idSeat;
    }

    public void setIdSeat(int idSeat) {
        this.idSeat = idSeat;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "idSeat=" + idSeat +
                ", number=" + number +
                ", type='" + type + '\'' +
                ", car=" + car +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Seat seat = (Seat) o;

        if (idSeat != seat.idSeat)
            return false;
        if (number != seat.number) return false;
        if (Double.compare(seat.price, price) != 0)
            return false;
        if (type == null) {
            if (seat.type == null)
                return false;
        } else if (!type.equals(seat.type))
            return false;
        if (car == null) {
            if (seat.car == null)
                return false;
        } else if (!car.equals(seat.car))
            return false;
        return true;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = 17;
        result = 31 * result + number;
        result = 31 * result + type.hashCode();
        result = 31 * result + car.hashCode();
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
