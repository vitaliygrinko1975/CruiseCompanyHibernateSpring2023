package ua.nure.hrynko.servise.interfaces;
import ua.nure.hrynko.db.models.Role;

import java.util.List;

public interface RoleService extends Service<Role> {
     Role findRoleByName(String roleName);
     Role getById(int id);
     List<Role> getAll();
    }
