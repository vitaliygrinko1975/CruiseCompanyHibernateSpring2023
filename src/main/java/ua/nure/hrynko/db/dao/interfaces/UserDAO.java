package ua.nure.hrynko.db.dao.interfaces;


import ua.nure.hrynko.db.models.User;

import java.util.List;

public interface UserDAO extends AbstractDAO<User> {

//    void addClientToUsersDb(String login, String password, String firstName, String lastName, String email,
//                            String  phone, Integer accountsId);
//
//    void addAdminToUsersDb(String login, String password, String firstName, String lastName, String email,
//                           String  phone, Integer blocked, Integer accountsId);

    User findUserByLogin(String login);

    List<User> findAllUsers();
}
