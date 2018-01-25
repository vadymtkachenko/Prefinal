package ua.nure.tkachenko.Final.db.entity;

import java.io.Serializable;

/**
 * class for 'car' table in database
 */
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;

    private int idCar;
    private int number;
    private String type;
    private Train train;

    public Car() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getIdCar() {
        return idCar;
    }

    public void setIdCar(int idCar) {
        this.idCar = idCar;
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

    public Train getTrain() {
        return train;
    }

    public void setTrainId(Train train) {
        this.train = train;
    }

    @Override
    public String toString() {
        return "Car{" +
                "idCar=" + idCar +
                ", number=" + number +
                ", type='" + type + '\'' +
                ", trainId=" + train +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        if (idCar != car.idCar)
            return false;
        if (number != car.number)
            return false;
        if (type == null) {
            if (car.type == null)
                return false;
        } else if (!type.equals(car.type))
            return false;
        if (train == null) {
            if (car.train == null)
                return false;
        } else if (!train.equals(car.train))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + number;
        result = 31 * result + ((type == null) ? 0 : type.hashCode());
        result = 31 * result + ((train == null) ? 0 : train.hashCode());
        return result;
    }
}
