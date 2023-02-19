package ua.nure.hrynko.db.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ua.nure.hrynko.db.dao.interfaces.UserDAO;
import ua.nure.hrynko.db.models.User;

import javax.persistence.Entity;
import java.util.List;


@Repository
public class MySqlUsersDAO extends MySqlAbstractDAO<User> implements UserDAO {
    public MySqlUsersDAO() {
        aClass = User.class;
        tableName = User.class.getAnnotation(Entity.class).name();
    }


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