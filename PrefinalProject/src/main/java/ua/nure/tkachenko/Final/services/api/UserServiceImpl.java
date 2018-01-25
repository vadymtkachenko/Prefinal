package ua.nure.tkachenko.Final.services.api;


import ua.nure.tkachenko.Final.db.MySQLController;
import ua.nure.tkachenko.Final.db.entity.User;
import ua.nure.tkachenko.Final.db.exception.DataBaseException;
import ua.nure.tkachenko.Final.db.mysql.MySQLDAOFactory;
import ua.nure.tkachenko.Final.services.UserService;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public List<User> getAllUsers() throws DataBaseException {
        List<User> users = new ArrayList<>();
        try (Connection connection = new MySQLController().getConnection()) {
            users = MySQLDAOFactory.getDAOFactory(1).getUserDAO(connection).getAllUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public boolean addUser(User user) throws DataBaseException {
        try (Connection connection = new MySQLController().getConnection()) {
            boolean res = MySQLDAOFactory.getDAOFactory(1).getUserDAO(connection).addUser(user);
            connection.commit();
            if (!res) {
                throw new DataBaseException("User is not created");
            } else return res;
        } catch (SQLException e) {
            throw new DataBaseException("", e);
        }
    }

    @Override
    public User getUser(int idUser) throws DataBaseException {
        try (Connection connection = new MySQLController().getConnection()) {
            User user = MySQLDAOFactory.getDAOFactory(1).getUserDAO(connection).getUser(idUser);
            return user;

        } catch (SQLException e) {
            throw new DataBaseException("", e);
        }
    }

    @Override
    public User getUserBylogin(String login) throws DataBaseException {
        try (Connection connection = new MySQLController().getConnection()) {

            User user = MySQLDAOFactory.getDAOFactory(1).getUserDAO(connection).getUserBylogin(login);
            return user;

        } catch (SQLException e) {
            throw new DataBaseException("", e);
        }
    }

    @Override
    public boolean deleteUser(int idUser) throws DataBaseException {
        return false;
    }

    @Override
    public boolean checkIfExists(String login) throws DataBaseException {
        try (Connection connection = new MySQLController().getConnection()) {

            boolean ifExists = MySQLDAOFactory.getDAOFactory(1).getUserDAO(connection).checkIfExists(login);
            return ifExists;

        } catch (SQLException e) {
            throw new DataBaseException("", e);
        }
    }
}
