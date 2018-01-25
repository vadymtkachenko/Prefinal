package ua.nure.tkachenko.Final.services;


import ua.nure.tkachenko.Final.db.entity.User;
import ua.nure.tkachenko.Final.db.exception.DataBaseException;

import java.util.List;

public interface UserService {

    /**
     *
     * @return list of {@link User} from 'user' table.
     * @throws DataBaseException
     */
    public List<User> getAllUsers() throws DataBaseException;

    /**
     *
     * Adds user into database, sets fields from User bean to DB.
     *
     * @param user
     * @return boolean
     * @throws DataBaseException
     */
    public boolean addUser(User user) throws DataBaseException;

    /**
     * Method returns user entity where identifier equals idUser.
     *
     * @param idUser
     * @return {@link User}
     * @throws DataBaseException
     */
    public User getUser(int idUser) throws DataBaseException;
    /**
     * Method returns user entity with specific login.
     *
     * @param login
     * @return {@link User}
     * @throws DataBaseException
     */
    public User getUserBylogin(String login) throws DataBaseException;

    /**
     * Method deletes user with identifier equals idUser.
     *
     * @param idUser
     * @return boolean
     * @throws DataBaseException
     */
    public boolean deleteUser(int idUser) throws DataBaseException;

    /**
     * Method checks the presence of a user with this login.
     *
     * @param login
     * @return boolean
     * @throws DataBaseException
     */
    public boolean checkIfExists(String login) throws DataBaseException;
}
