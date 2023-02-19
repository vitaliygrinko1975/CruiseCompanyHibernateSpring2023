package ua.nure.hrynko.db.dao.interfaces;


import ua.nure.hrynko.db.models.User;

import java.util.List;

public interface UserDAO extends AbstractDAO<User> {

    User findUserByLogin(String login);

    List<User> findAllUsers();
}
