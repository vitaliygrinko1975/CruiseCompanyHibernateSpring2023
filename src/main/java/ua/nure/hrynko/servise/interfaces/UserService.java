package ua.nure.hrynko.servise.interfaces;

import ua.nure.hrynko.db.models.User;

import java.util.List;


public interface UserService extends Service<User> {
    User getById(int id);
    List<User> getAll();

}



