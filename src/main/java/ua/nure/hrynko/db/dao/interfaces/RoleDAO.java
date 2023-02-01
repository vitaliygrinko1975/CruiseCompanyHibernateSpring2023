package ua.nure.hrynko.db.dao.interfaces;

import ua.nure.hrynko.db.models.Role;


public interface RoleDAO extends AbstractDAO<Role> {

    Role findRoleByName(String name);
}