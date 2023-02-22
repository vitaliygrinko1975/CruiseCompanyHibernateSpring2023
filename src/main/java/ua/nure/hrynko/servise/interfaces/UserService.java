package ua.nure.hrynko.servise.interfaces;

import org.springframework.transaction.annotation.Transactional;
import ua.nure.hrynko.db.models.User;

import java.util.List;


public interface UserService extends Service<User> {
    @Transactional
    void signUpUserAndAddItemAccount(String login, String password, String firstName, String lastName,
                                       String email, String phone);

    User getById(int id);
    List<User> getAll();

}



