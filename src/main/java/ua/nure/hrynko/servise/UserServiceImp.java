package ua.nure.hrynko.servise;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.nure.hrynko.db.dao.MySqlAccountsDAO;
import ua.nure.hrynko.db.dao.MySqlUsersDAO;
import ua.nure.hrynko.db.models.Account;
import ua.nure.hrynko.db.models.Role;
import ua.nure.hrynko.db.models.User;
import ua.nure.hrynko.servise.interfaces.AccountService;
import ua.nure.hrynko.servise.interfaces.UserService;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private MySqlUsersDAO mySqlUsersDAO;
    @Autowired
    private MySqlAccountsDAO mySqlAccountsDAO;
    @Autowired
    private AccountService accountService;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    protected SessionFactory sessionFactory;


//    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SQLException.class})
    @Transactional
    @Override
    public void signUpUserAndAddItemAccount(String login, String password, String firstName, String lastName,
                                            String email, String phone) {
        Session session = sessionFactory.getCurrentSession();
        User user = new User();
        Role role = new Role();
        Account account = new Account();
        account.setBalance(0);
        account.setFileName("Пусто");
        session.save(account);
        role.setId(2);
        user.setLogin(login);
        if (!password.isEmpty()) {
            user.setPassword(encoder.encode(password));
        }
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPhone(phone);
        user.setRole(role);
        session.save(user);
    }
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
    public void delete(User obj) {
        mySqlUsersDAO.delete(obj);
    }

    @Override
    public User getById(int id) {
        return mySqlUsersDAO.getById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAll() {
        return mySqlUsersDAO.getAll();
    }

}
