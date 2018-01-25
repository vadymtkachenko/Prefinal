package ua.nure.tkachenko.Final.db.mysql;

import ua.nure.tkachenko.Final.db.dao.RoleDAO;
import ua.nure.tkachenko.Final.db.entity.Role;
import ua.nure.tkachenko.Final.db.exception.DataBaseException;

import java.util.List;


public class MySQLRoleDAO implements RoleDAO {

    @Override
    public List<Role> getAllRoles() throws DataBaseException {
        return null;
    }

    @Override
    public boolean addRole(Role role) throws DataBaseException {
        return false;
    }

    @Override
    public Role getRole(int idRole) throws DataBaseException {
        return null;
    }

    @Override
    public boolean deleteRole(int idRole) throws DataBaseException {
        return false;
    }
}
