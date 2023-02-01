package ua.nure.hrynko.db.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ua.nure.hrynko.db.dao.interfaces.UserDAO;
import ua.nure.hrynko.db.models.Account;
import ua.nure.hrynko.db.models.Role;
import ua.nure.hrynko.db.models.User;

import javax.persistence.Entity;
import java.util.List;


@Repository
public class MySqlUsersDAO extends MySqlAbstractDAO<User>  implements UserDAO {

    public MySqlUsersDAO() {
        aClass = User.class;
        tableName = User.class.getAnnotation(Entity.class).name();
    }

//    public void addClientToUsersDb(String login, String password, String firstName, String lastName, String email,
//                                   String  phone,Integer accountsId) {
//        User user = new User();
//        Role role = new Role();
//        role.setId(2);
//        Account account = new Account();
//        account.setId(accountsId);
//
//        user.setLogin(login);
//        user.setPassword(password);
//        user.setFirstName(firstName);
//        user.setLastName(lastName);
//        user.setEmail(email);
//        user.setPhone(phone);
//        user.setRole(role);
//        user.setAccount(account);
//
//        Session session = sessionFactory.getCurrentSession();
//        Transaction t = session.getTransaction();
//        t.begin();
//        try {
//            session.saveOrUpdate(user);
//            // LOG.trace("add client to SQL succesful--> ");
//        } catch (Exception e) {
//            //  LOG.trace("ERRor--> ");
//            t.rollback();
//
//        }
//        t.commit();
//    }
//
//    public void addAdminToUsersDb(String login, String password, String firstName, String lastName,String email,
//                                  String  phone, Integer accountsId) {
//        User user = new User();
//        Role role = new Role();
//        role.setId(1);
//        Account account = new Account();
//        account.setId(accountsId);
//
//        user.setLogin(login);
//        user.setPassword(password);
//        user.setFirstName(firstName);
//        user.setLastName(lastName);
//        user.setEmail(email);
//        user.setPhone(phone);
//        user.setRole(role);
//        user.setAccount(account);
//        Session session = sessionFactory.getCurrentSession();
//        Transaction t = session.getTransaction();
//        t.begin();
//        try {
//            session.saveOrUpdate(user);
////            LOG.trace("add admin to SQL succesful--> ");
//        } catch (Exception e) {
////            LOG.trace("ERRor--> ");
//            t.rollback();
//
//        }
//        t.commit();
//    }


//    @Override
//    public void addClientToUsersDb(String login, String password, String firstName, String lastName,
//                                   String email, String phone, Boolean blocked, Integer accountsId) {
//
//    }
//
//    @Override
//    public void addAdminToUsersDb(String login, String password, String firstName, String lastName,
//                                  String email, String phone, Boolean blocked, Integer accountsId) {

//    }

    public User findUserByLogin(String login) {
        try (Session session = sessionFactory.openSession()) {
            Criteria c = session.createCriteria(User.class);
            c.add(Restrictions.eq("login", login));
            return (User) c.uniqueResult();
        }
    }



    public List<User> findAllUsers() {
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("from " + tableName);
            return query.list();
        }

    }

}