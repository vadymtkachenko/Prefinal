package ua.nure.tkachenko.Final.db.dao;

import ua.nure.tkachenko.Final.db.entity.Role;
import ua.nure.tkachenko.Final.db.exception.DataBaseException;

import java.util.List;

/**
 * Class to work with DB. With entity {@link Role}. Provides methods to:
 * create,read,update,delete items
 *
 * @author Vadym Tkachenko
 */
public interface RoleDAO {

    /**
     * @return list of {@link Role} from 'role' table.
     * @throws DataBaseException
     */
    public List<Role> getAllRoles() throws DataBaseException;

    /**
     * Adds role into database, sets fields from Role bean to DB.
     *
     * @param role
     * @return boolean
     * @throws DataBaseException
     */
    public boolean addRole(Role role) throws DataBaseException;

    /**
     * Method returns role entity where identifier equals idRole.
     *
     * @param idRole
     * @return {@link Role}
     * @throws DataBaseException
     */
    public Role getRole(int idRole) throws DataBaseException;

    /**
     * Method deletes role with identifier equals idRole.
     *
     * @param idRole
     * @return boolean
     * @throws DataBaseException
     */
    public boolean deleteRole(int idRole) throws DataBaseException;
}
