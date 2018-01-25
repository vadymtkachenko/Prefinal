package ua.nure.tkachenko.Final.db.mysql;


import ua.nure.tkachenko.Final.db.Fields;
import ua.nure.tkachenko.Final.db.MySQLController;
import ua.nure.tkachenko.Final.db.Queries;
import ua.nure.tkachenko.Final.db.dao.CarDAO;
import ua.nure.tkachenko.Final.db.entity.Car;
import ua.nure.tkachenko.Final.db.exception.DataBaseException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLCarDAO implements CarDAO {

    Connection connection;

    public MySQLCarDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Car> getAllCars() throws DataBaseException {
        List<Car> cars = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(Queries.FIND_ALL_CARS);
            while (rs.next()) {
                Car car = extractCar(rs);
                cars.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataBaseException("Cannot get cars", e);
        }
        return cars;
    }

    @Override
    public boolean addCar(Car car) throws DataBaseException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(Queries.ADD_CAR, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, car.getNumber());
            preparedStatement.setString(2, car.getType());
            preparedStatement.setInt(3, car.getTrain().getIdTrain());
            if (preparedStatement.executeUpdate() > 0) {
                ResultSet rs = preparedStatement.getGeneratedKeys();
                if (rs.next()) {
                    car.setIdCar(rs.getInt(1));
                    return true;
                }
            }
        } catch (SQLException e) {
            throw new DataBaseException("Cannot create station ", e);
        }
        return false;
    }

    @Override
    public Car getCar(int idCar) throws DataBaseException {
        try (PreparedStatement statement = connection.prepareStatement(Queries.GET_CAR_BY_ID)) {
            ResultSet resultSet;
            statement.setInt(1, idCar);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return extractCar(resultSet);
            }
        } catch (SQLException e) {
            throw new DataBaseException("Cannot get route ", e);
        }
        return null;
    }

    @Override
    public List<Car> getCarOfTrain(int idTrain) throws DataBaseException {
        List<Car> cars = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(Queries.GET_CAR_BY_ID)) {
            statement.setInt(1, idTrain);
            ResultSet resultSet;
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Car car = extractCar(resultSet);
                cars.add(car);
            }
        } catch (SQLException e) {
            throw new DataBaseException("Cannot get cars ", e);
        }
        return cars;
    }

    @Override
    public boolean deleteCar(int idCar) throws DataBaseException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(Queries.DELETE_CAR)) {
            preparedStatement.setInt(1, idCar);
            int res = preparedStatement.executeUpdate();
            if (res == 1) {
                return true;
            }
        } catch (SQLException e) {
            throw new DataBaseException("Cannot delete station", e);
        }
        return false;
    }

    private Car extractCar(ResultSet rs) throws SQLException {
        Car car = new Car();
        car.setIdCar(rs.getInt(Fields.CAR_ID));
        car.setNumber(rs.getInt(Fields.CAR_NUMBER));
        car.setType(rs.getString(Fields.CAR_TYPE));
        return car;
    }
}
