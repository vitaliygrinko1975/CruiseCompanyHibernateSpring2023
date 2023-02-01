package ua.nure.hrynko.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.nure.hrynko.db.dao.MySqlUsersDAO;
import ua.nure.hrynko.db.models.User;
import ua.nure.hrynko.servise.interfaces.UserService;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private MySqlUsersDAO mySqlUsersDAO;


    @Transactional
    @Override
    public void save(User obj) {
        mySqlUsersDAO.save(obj);
    }

    @Transactional
    @Override
    public void update(User obj) {
        mySqlUsersDAO.update(obj);
    }

    @Transactional
    @Override
    public void delete(User obj) {mySqlUsersDAO.delete(obj);
    }

    @Override
    public User getById(int id) {return mySqlUsersDAO.getById(id);}

    @Transactional(readOnly = true)
    @Override
    public List<User> getAll() {
        return mySqlUsersDAO.getAll();
    }


    }
