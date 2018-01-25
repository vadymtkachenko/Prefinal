package ua.nure.tkachenko.Final.db.dao;


import ua.nure.tkachenko.Final.db.entity.Train;
import ua.nure.tkachenko.Final.db.exception.DataBaseException;

import java.util.List;

/**
 * Class to work with DB. With entity {@link Train}. Provides methods to:
 * create,read,update,delete items
 *
 * @author Vadym Tkachenko
 */
public interface TrainDAO {

    /**
     *
     * @return list of {@link Train} from 'train' table.
     * @throws DataBaseException
     */
    public List<Train> getAllTrains() throws DataBaseException;

    /**
     *
     * Adds train into database, sets fields from Train bean to DB.
     *
     * @param train
     * @return boolean
     * @throws DataBaseException
     */
    public boolean addTrain(Train train) throws DataBaseException;

    /**
     * Method returns train entity where identifier equals idTrain.
     *
     * @param idTrain
     * @return {@link Train}
     * @throws DataBaseException
     */
    public Train getTrain(int idTrain) throws DataBaseException;

    /**
     * Method deletes train with identifier equals idTrain.
     *
     * @param idTrain
     * @return boolean
     * @throws DataBaseException
     */
    public boolean deleteTrain(int idTrain) throws DataBaseException;
}
