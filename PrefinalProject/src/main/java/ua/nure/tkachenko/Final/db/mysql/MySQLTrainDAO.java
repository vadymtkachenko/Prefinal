package ua.nure.tkachenko.Final.db.mysql;


import ua.nure.tkachenko.Final.db.Fields;
import ua.nure.tkachenko.Final.db.dao.TrainDAO;
import ua.nure.tkachenko.Final.db.entity.Train;
import ua.nure.tkachenko.Final.db.entity.User;
import ua.nure.tkachenko.Final.db.exception.DataBaseException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MySQLTrainDAO implements TrainDAO {


    Connection connection;

    public MySQLTrainDAO(Connection connection) {
        this.connection = connection;
    }

    @Override

    public List<Train> getAllTrains() throws DataBaseException {
        return null;
    }

    @Override
    public boolean addTrain(Train train) throws DataBaseException {
        return false;
    }

    @Override
    public Train getTrain(int idTrain) throws DataBaseException {
        return null;
    }

    @Override
    public boolean deleteTrain(int idTrain) throws DataBaseException {
        return false;
    }

    private Train extractTrain(ResultSet rs) throws SQLException {
        Train train = new Train();
        train.setName(rs.getString(Fields.TRAIN_NAME));
        train.setNumber(rs.getInt(Fields.TRAIN_NUMBER));
        train.setType(rs.getString(Fields.TRAIN_TYPE));
        train.setIdTrain(rs.getInt(Fields.TRAIN_ID));
        return train;
    }
}
