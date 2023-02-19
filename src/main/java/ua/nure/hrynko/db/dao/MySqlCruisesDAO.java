package ua.nure.hrynko.db.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ua.nure.hrynko.db.dao.interfaces.CruiseDAO;
import ua.nure.hrynko.db.models.Cruise;


import javax.persistence.Entity;
import java.util.List;


@Repository
public class MySqlCruisesDAO extends MySqlAbstractDAO<Cruise> implements CruiseDAO {

    public MySqlCruisesDAO() {
        aClass = Cruise.class;
        tableName = Cruise.class.getAnnotation(Entity.class).name();
    }


    public List<Cruise> findAllCruises() {
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("from " + tableName);
            return query.list();
        }

    }

}