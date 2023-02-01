package ua.nure.hrynko.servise.interfaces;

import ua.nure.hrynko.db.models.Role;


public interface RoleService extends Service<Role> {
    Role findRoleByName(String roleName);

    }
