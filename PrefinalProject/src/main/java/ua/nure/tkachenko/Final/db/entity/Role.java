package ua.nure.tkachenko.Final.db.entity;

import java.io.Serializable;

/**
 * class for 'role' table in database
 */
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    private int idRole;
    private String nameRole;

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idRole;
        result = prime * result + ((nameRole == null) ? 0 : nameRole.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Role other = (Role) obj;
        if (idRole != other.idRole)
            return false;
        if (nameRole == null) {
            if (other.nameRole != null)
                return false;
        } else if (!nameRole.equals(other.nameRole))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Role{" +
                "idRole=" + idRole +
                ", nameRole='" + nameRole + '\'' +
                '}';
    }

    public Role() {
    }
}
