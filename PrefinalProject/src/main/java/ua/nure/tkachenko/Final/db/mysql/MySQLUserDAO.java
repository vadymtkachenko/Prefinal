package ua.nure.tkachenko.Final.db.mysql;

import ua.nure.tkachenko.Final.db.Fields;
import ua.nure.tkachenko.Final.db.MySQLController;
import ua.nure.tkachenko.Final.db.Queries;
import ua.nure.tkachenko.Final.db.dao.UserDAO;
import ua.nure.tkachenko.Final.db.entity.Role;
import ua.nure.tkachenko.Final.db.entity.User;
import ua.nure.tkachenko.Final.db.exception.DataBaseException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MySQLUserDAO implements UserDAO {

    Connection connection;

    public MySQLUserDAO(Connection connection) {
        this.connection = connection;
    }


    @Override
    public List<User> getAllUsers() throws DataBaseException {
        List<User> users = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(Queries.FIND_ALL_USERS);
            while (rs.next()) {
                User user = extractUser(rs);
                Role role = extractRole(rs);
                user.setRole(role);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataBaseException("Cannot get Users", e);
        }
        return users;
    }

    @Override
    public boolean addUser(User user) throws DataBaseException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(Queries.ADD_USER, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getDocument());
            preparedStatement.setString(4, user.getLogin());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setString(6, user.getEmail());
            if (preparedStatement.executeUpdate() > 0) {
                ResultSet rs = preparedStatement.getGeneratedKeys();
                if (rs.next()) {
                    user.setIdUser(rs.getInt(1));
                    return true;
                }
            }
        } catch (SQLException e) {
            throw new DataBaseException("Cannot create user ", e);
        }
        return false;
    }

    @Override
    public User getUser(int idUser) throws DataBaseException {
        try (PreparedStatement statement = connection.prepareStatement(Queries.GET_USER_BY_ID)) {
            ResultSet resultSet;
            statement.setInt(1, idUser);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = extractUser(resultSet);
                Role role = extractRole(resultSet);
                user.setRole(role);
                return user;
            }
        } catch (SQLException e) {
            throw new DataBaseException("Cannot get user ", e);
        }
        return null;
    }

    @Override
    public User getUserBylogin(String login) throws DataBaseException {
        try (PreparedStatement statement = connection.prepareStatement(Queries.GET_USER_BY_LOGIN)) {
            ResultSet resultSet;
            statement.setString(1, login);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = extractUser(resultSet);
                Role role = extractRole(resultSet);
                user.setRole(role);
                return user;
            }
        } catch (SQLException e) {
            throw new DataBaseException("Cannot get user ", e);
        }
        return null;
    }

    @Override
    public boolean deleteUser(int idUser) throws DataBaseException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(Queries.DELETE_USER)) {
            preparedStatement.setInt(1, idUser);
            int res = preparedStatement.executeUpdate();
            if (res == 1) {
                return true;
            }
        } catch (SQLException e) {
            throw new DataBaseException("Cannot delete user", e);
        }
        return false;
    }

    @Override
    public boolean checkIfExists(String login) throws DataBaseException {
        try (PreparedStatement statement = connection.prepareStatement(Queries.GET_USER_BY_LOGIN)) {
            ResultSet resultSet;
            statement.setString(1, login);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            throw new DataBaseException("Cannot get user ", e);
        }
        return false;
    }

    private User extractUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setIdUser(rs.getInt(Fields.USER_ID));
        user.setName(rs.getString(Fields.USER_NAME));
        user.setSurname(rs.getString(Fields.USER_SURNAME));
        user.setEmail(rs.getString(Fields.E_MAIL));
        user.setLogin(rs.getString(Fields.LOGIN));
        user.setPassword(rs.getString(Fields.PASSWORD));
        user.setDocument(rs.getString(Fields.USER_DOCUMENT));
        return user;
    }

    private Role extractRole(ResultSet rs) throws SQLException {
        Role role = new Role();
        role.setIdRole(1);
        role.setNameRole("user");
        return role;
    }
}
