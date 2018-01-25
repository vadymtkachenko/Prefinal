package ua.nure.tkachenko.Final.db.entity;


import java.io.Serializable;

/**
 * class for 'train' table in database
 */
public class Train implements Serializable {

    private static final long serialVersionUID = 1L;

    private int idTrain;
    private int number;
    private String name;
    private String type;

    public Train() {
    }

    public int getIdTrain() {

        return idTrain;
    }

    public void setIdTrain(int idTrain) {
        this.idTrain = idTrain;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "Train{" +
                "idTrain=" + idTrain +
                ", number=" + number +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Train train = (Train) o;
        if (idTrain != train.idTrain)
            return false;
        if (number != train.number)
            return false;
        if (name == null) {
            if (train.name != null)
                return false;
        } else if (!name.equals(train.name))
            return false;
        if (type == null) {
            if (train.type != null)
                return false;
        } else if (!type.equals(train.type))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + number;
        result = 31 * result + ((name == null) ? 0 : name.hashCode());
        result = 31 * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }
}
