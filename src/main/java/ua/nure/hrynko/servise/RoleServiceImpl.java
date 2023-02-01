package ua.nure.hrynko.servise;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nure.hrynko.db.dao.MySqlRolesDAO;
import ua.nure.hrynko.db.models.Role;
import ua.nure.hrynko.servise.interfaces.RoleService;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    MySqlRolesDAO mySqlRolesDAO;

    @Override
    public Role findRoleByName(String roleName) {
        return mySqlRolesDAO.findRoleByName(roleName);
    }


    @Override
    public void save(Role obj) {
        mySqlRolesDAO.save(obj);
    }

    @Override
    public void update(Role obj) {
        mySqlRolesDAO.update(obj);
    }

    @Override
    public void delete(Role obj) {
        mySqlRolesDAO.delete(obj);
    }


    @Override
    public Role getById(int id) {return mySqlRolesDAO.getById(id);}

    @Override
    public List<Role> getAll() {
        return mySqlRolesDAO.getAll();
    }
}
