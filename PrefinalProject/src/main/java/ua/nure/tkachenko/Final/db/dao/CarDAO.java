package ua.nure.tkachenko.Final.db.dao;

import ua.nure.tkachenko.Final.db.entity.Car;
import ua.nure.tkachenko.Final.db.exception.DataBaseException;

import java.util.List;

/**
 * Class to work with DB. With entity {@link Car}. Provides methods to:
 * create,read,update,delete items
 *
 * @author Vadym Tkachenko
 */
public interface CarDAO {
    /**
     * @return list of {@link Car} from 'car' table.
     * @throws DataBaseException
     */
    public List<Car> getAllCars() throws DataBaseException;

    /**
     * Adds car into database, sets fields from Car bean to DB.
     *
     * @param car
     * @return boolean
     * @throws DataBaseException
     */
    public boolean addCar(Car car) throws DataBaseException;

    /**
     * Method returns car entity where identifier equals idCar.
     *
     * @param idCar
     * @return {@link Car}
     * @throws DataBaseException
     */
    public Car getCar(int idCar) throws DataBaseException;


    /**
     *
     * @param idTrain
     * @return list of {@link Car} from 'car' table
     * @throws DataBaseException
     */
    public List<Car> getCarOfTrain(int idTrain) throws DataBaseException;

    /**
     * Method deletes car with identifier equals idCar.
     *
     * @param idCar
     * @return boolean
     * @throws DataBaseException
     */
    public boolean deleteCar(int idCar) throws DataBaseException;
}
